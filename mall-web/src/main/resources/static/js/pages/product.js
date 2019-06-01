function pro_detail() {
    var url = location.search;//获取
    if (url.indexOf("?") != -1) {    //判断是否有参数
        var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
        strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
        var id = strs[1];
    }
    $.ajax({
        url: "/product/getById",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson = {
            "id": id
        }),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            var obj = data.data;

            document.getElementById("imgId").src = obj.pic;
            for (var i = 0; i < 4; i++) {
                $('#imgList').append("<li><img src='" + obj.pic + "'  /></li>");
            }
            document.getElementById("title").innerHTML = obj.subTitle;
            document.getElementById("price").innerHTML = obj.price;
        },
        error() {
            alert("服务器异常");
        }
    })
}
function getProductList() {
    var options=$("#select option:selected");
    productName = $('#productName').val();
    var objJson ={
        "name":productName,
        "verifyStatus":options.val(),
    }
    $.ajax({
    type:"POST",
    url: "/product/query/list",
    contentType: "application/json;charset=utf-8",
    dataType: "json",
    data: JSON.stringify(objJson),
    async:true,
    success: function (data) {
        if(data.code==200){
            console.log(data);
            $("#goods").html('');
            $("#adminGoods").html('');
            $.each(data.data.list, function (i, obj) {
                var sta = obj.verifyStatus == 0 ?"未审核":(obj.verifyStatus == 1 ? "已通过":(obj.verifyStatus == 2 ?"审核未通过":"已关闭"));
                $("#goods").append(
                   "<tr ng-repeat='entity in list'>" +
                    "<td><input  type='checkbox'></td>" +
                    "<td>"+(++i)+"</td>" +
                    "<td>"+obj.name+"</td>" +
                    "<td>"+obj.price+"</td>" +
                    "<td>"+obj.productCategoryId+"</td><td><span>" + sta+
                    "</span>" +
                    "</td>" +
                    "<td class='text-center'>" +
                    "<a class='btn bg-olive btn-xs' onclick='getGoodsById("+obj.id+")'>修改</a></td>" +
                    "</tr>")
                $("#adminGoods").append(
                    "<tr ng-repeat='entity in list'>" +
                    "<td><input  type='checkbox'></td>" +
                    "<td>"+i+"</td>" +
                    "<td>"+obj.name+"</td>" +
                    "<td>"+obj.price+"</td>" +
                    "<td>"+obj.productCategoryId+"</td><td><span>" + sta+
                    "</span>" +
                    "</td>" +
                    "<td class='text-center'>" +
                    "<button type='button' class='btn bg-olive btn-xs'data-toggle='modal' data-target='#goodModal' onclick='getGoodsDetail("+obj.id+","+obj.shopId+","+obj.brandId+")' >详情</button></td>"+
                    "</tr>")
            });

        }else{
            alert(data.message);
        }
    },
    error: function (){
        alert("访问失败，请检查网络、路径......");
    }
    });

    }
function getGoodsDetail(id,shopId,brandId) {
    $.ajax({
        url: "/product/getById",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson = {
            "id": id,
            "shopId":shopId,
            "brandId":brandId,
        }),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            var obj = data.data;
            document.getElementById("productName").innerHTML = obj.name;
            document.getElementById("shopName").innerHTML = obj.shopName;
            // document.getElementById("category").innerHTML = obj.catName;
            document.getElementById("brand").innerHTML = obj.brandName;
            document.getElementById("subTitle").innerHTML = obj.subTitle;
            document.getElementById("price").innerHTML = obj.price;
            $("#proImg").html('');
            $("#proImg").append("<img src='"+obj.pic+"' width='40px' height='50px'>")
            $("#modal").html('');
            $("#modal").append("<button  class='btn btn-success' data-dismiss='modal' aria-hidden='true' onclick='updateProStatus("+obj.id+","+1+")'>通过</button>" +
                "<button  class='btn btn-danger' data-dismiss='modal' aria-hidden='true' onclick='updateProStatus("+obj.id+","+2+")'>退回</button>" +
                "<button class='btn btn-default' data-dismiss='modal' aria-hidden='true'>关闭</button>");
            }, error() {
            alert("服务器异常");
        }
    })

}
function updateProStatus(id,status){
    objJson = {
        "id":id,
        "verifyStatus":status,
    }
    $.ajax({
        url: "/product/changeStatus",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            alert(data.message)
            window.location.reload();
        },error(){
            alert("服务器异常");
            }
            })
    }
function getGoodsById(id) {
    window.location.href = "/shop/goodsEdit";
    $.ajax({
        url: "/product/getById",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson = {
            "id": id
        }),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            var obj = data.data;
            console.log(data)
            document.getElementById("productName").value=obj.name;
            $("#subTitle").val(obj.subTitle);
            $("#price").val(obj.price);
            $("#detailTitle").val(obj.detailTitle);
            $("#picList").html('');
            $("#picList").append("<tr ><td >" +
               "<img  src='"+obj.pic+"' width='100px' height='100px'></td><td> " +
                "<button type='button' onclick='removeImg("+obj.id+")' class='btn btn-default' title='删除' ><i class='fa fa-trash-o'></i> 删除</button></td>" +
               "</tr>");
            $("#modal-footer").html('');
            $("#modal-footer").append("<button class='btn btn-primary' onclick='updateProduct("+obj.id+")'><i class='fa fa-save'></i>保存商品</button>"+
            +"<button class='btn btn-default' >返回列表</button>");
        },
        error() {
            alert("服务器异常");
        }
    })

}
function updateProduct(id){
    var name = $('#productName').val(),
        brandId = $('#brandId').val(),
        subTitle = $('#subTitle').val(),
        price = $('#price').val(),
        detailTitle = $('#detailTitle').val();
    var objJson = {
        "name" :productName,
        "brandId" : brandId,
        "subTitle":subTitle,
        "price":price,
        "detailTitle" :detailTitle,
        "pic" :pic
    }
    alert(JSON.stringify(objJson))
    $.ajax({
        url: "/product/update",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            alert(data.message);
            window.location.reload();

        },
        error() {
            alert("请重新添加")
        }

    })
}

function saveProduct() {
    var shopId = localStorage.getItem("shopId");
    if(shopId == null){
        alert("登录异常，请重新登录...")
        window.location.href = "/shop/login";
    }
    var formData = new FormData();
    formData.append('files', $('input[type=file]')[0].files[0]);
    var name = $('#goodsName').val(),
        brandId = $('#brandId').val(),
        subTitle = $('#subTitle').val(),
        price = $('#price').val(),
        detailTitle = $('#detailTitle').val();
    var objJson = {
        "name": name,
        "shopId":shopId,
        "brandId": brandId,
        "subTitle": subTitle,
        "price": price,
        "detailTitle": detailTitle,
    }
    alert(JSON.stringify(objJson))
    $.ajax({
        url: "/product/save",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
           alert(data.message);
           window.location.reload();
        },
        error() {
            alert("请重新添加")
        }

    })
}
function selectImage(file) {
    if(!file.files || !file.files[0]){
        alert("请选择图片");
    }
    var reader = new FileReader();
    reader.onload = function(evt){
        document.getElementById('addImg').src = evt.target.result;
        image = evt.target.result;
    }
    reader.readAsDataURL(file.files[0]);
}

function uploadImg(){

    var formData = new FormData();
    formData.append('files', $('input[type=file]')[0].files[0]);
    debugger
    $.ajax({
        type:'POST',
        url:"/product/addImg",
        contentType:false,
        processData:false,//这个很有必要，不然不行
        mimeType:"multipart/form-data",
        data:formData,
        success:function(data){
            console.log(data);
            var img = JSON.parse(data);
            alert(img)
            $("#picList").html('');
            $("#picList").append("<tr ng-repeat='entity in list'>" +
                "<td><input  type='checkbox'></td>" +
                "<td><img src='../../../static/workingPic/20190528141013.jpg'width='300px' height='200px'/></td>" +
                "</span>" +
                "</td>" +
                "</tr>")
        },error(){
            alert("服务器异常")
        }
    });

}