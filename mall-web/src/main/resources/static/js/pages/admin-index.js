function getName(){
    var username = localStorage.getItem("username")
    if(username==null){
        alert("登录异常，请重新登录")
        window.location.href = "/admin";
        console.log("登录异常")
    }
    document.getElementById("showName").innerHTML=username.toString();
    document.getElementById("showusername").innerHTML = username.toString();
}
 //获取商家信息
function searchShop(){
    var shopName = $('#shopName').val(),
        companyNme = $('#companyNme').val(),
        status = $('#status').val();
    var objJson = {
        'shopName' : shopName,
        'commpanyName':companyNme,
        'status':status
    };
   $.ajax({
       url:"/api/shop/query",
       type: 'POST',
       contentType: "application/json;charset=utf-8",
       dataType: "json",
       data: JSON.stringify(objJson),
       processData: false,       //必不可缺
  //     contentType: false,       //必不可缺
       async:true,
       cache: false,
       success:function(data){
           //清空数据
           $("#tbody").html('');
            console.log(JSON.stringify(data.data))
           //追加数据
           $.each(data.data.list, function (i, obj) {
               //一个dom就是一个新闻对象
               $("#tbody").append("<tr ng-repeat='entity in list'>" +
                   "<td><input  type='checkbox'></td>"+
                   "<td>" +(++i)+"</td>" +
                   "<td>" + obj.companyName + "</td>" +
                   "<td>" + obj.shopName + "</td>" +
                   "<td>" + obj.linkmanName + "</td>" +
                   "<td>" + obj.linkmanPhone + "</td>" +
                   "<td class='text-center'>"+
                   "<button type='button' onclick='getDetail("+obj.shopId+")' class='btn bg-olive btn-xs' data-toggle='modal' data-target='#sellerModal'>详情</button>"+
                   "</td>"+
                 "</tr>");
               });
       },
       error(){
           alert("服务器异常");
       }
   });

}
function searchShopBy(){
    var shopName = $('#shopName').val(),
        companyNme = $('#companyNme').val(),
        statu= $('input:radio[name="scope"]:checked').val();
        if(statu==3){
            statu="";
        }
    alert(statu);
    var objJson = {
        'shopName' : shopName,
        'commpanyName':companyNme,
        'status':statu,
    };
    $.ajax({
        url:"/api/shop/query",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        processData: false,       //必不可缺
        //     contentType: false,       //必不可缺
        async:true,
        cache: false,
        success:function(data){
            //清空数据
            $("#tbody").html('');
            console.log(JSON.stringify(data.data))
            //追加数据
            var s;
            $.each(data.data.list, function (i, obj) {
                var sta = obj.status == 0 ?"未审核":(obj.status == 1 ? "已通过":(obj.status == 2 ?"审核未通过":"已关闭"));
                $("#tbody").append("<tr ng-repeat='entity in list'>" +
                    "<td><input  type='checkbox'></td>"+
                    "<td>" +(++i)+"</td>" +
                    "<td>" + obj.companyName + "</td>" +
                    "<td>" + obj.shopName + "</td>" +
                    "<td>" + obj.linkmanName + "</td>" +
                    "<td>" + obj.linkmanPhone + "</td>" +
                    "<td><span>"+sta+
                    "</span></td>"+
                    "<td class='text-center'>"+
                    "<button type='button' onclick='getDetail("+obj.shopId+")' class='btn bg-olive btn-xs' data-toggle='modal' data-target='#sellerModal'>详情</button>"+
                    "</td>"+
                    "</tr>"
            );
            });
        },
        error(){
            alert("服务器异常");
        }
    });

}
function getDetail(shopId){
    $.ajax({
        url:"/api/shop/query/detail?shopId="+shopId,
        type: 'GET',
        processData: false,       //必不可缺
        async:true,
        cache: false,
        success:function(data){
            var obj = data.data;
            $("#bank").val(obj);
            document.getElementById("companyName").innerHTML = obj.companyName;
            document.getElementById("linkmanPhone").innerHTML = obj.linkmanPhone;
            document.getElementById("linkmanName").innerHTML = obj.linkmanName;
            document.getElementById("description").innerHTML = obj.description.toString();
            document.getElementById("companyAddress").innerHTML = obj.companyAddress;
            document.getElementById("linkmanName").innerHTML = obj.linkmanName;
            document.getElementById("licenseNumber").innerHTML = obj.licenseNumber;
            document.getElementById("legalman").innerHTML = obj.legalman;
            document.getElementById("legalmanId").innerHTML = obj.legalmanId;
            document.getElementById("bankName").innerHTML = obj.bankName;
            document.getElementById("bankCount").innerHTML = obj.bankCount;
            $('.modal-footer').html("");
            $('.modal-footer').append("<button  class='btn btn-success' data-dismiss='modal' aria-hidden='true' onclick='updateStatus("+shopId+","+1+")'>通过</button>" +
                "<button  class='btn btn-danger' data-dismiss='modal' aria-hidden='true' onclick='updateStatus("+shopId+","+2+")'>拒绝通过</button>" +
                "<button class='btn btn-default' data-dismiss='modal' aria-hidden='true'>关闭</button>");
            $('#seller').html("");
            $('#seller').append("<button  class='btn btn-danger' data-dismiss='modal' aria-hidden='true' onclick='updateStatus(\"+shopId+\",\"+0+\")'>退回审核</button>"+
                " <button  class='btn btn-danger' data-dismiss='modal' aria-hidden='true'onclick='updateStatus("+shopId+","+3+")'>关闭商家</button>" +
                "<button class='btn btn-default' data-dismiss='modal' aria-hidden='true'>关闭</button>");
        },
        error() {
            alert("服务器异常");
        }
    })

}
function updateStatus(shopId,status){
    var objJson = {
        "shopId":shopId,
        "status":status
    };
    $.ajax({
        url:"/api/shop/changeStatus",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:JSON.stringify(objJson),
        processData: false,       //必不可缺
        async:true,
        cache: false,
        success:function(data){
            if(data.code==200&&data.data==1){
                alert("审核成功");
                searchShopBy();
            }else{
                alert("操作失败")
            }
        },
        error() {
            alert("服务器异常")
        }
    })
}

 