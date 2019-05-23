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
            for (var i = 0; i < 3; i++) {
                $('#imgList').append("<li><img src='" + obj.pic + "'  /></li>");
            }
            document.getElementById("title").innerHTML = obj.subTitle;
            document.getElementById("price").innerHTML = obj.price;
            $("#addshopcar").html('');
            $("#addshopcar").append("<li>" +
                "<a  class='sui-btn  btn-danger addshopcar' onclick='addToCart("+obj.id+")'>加入购物车</a>" +
                "</li>");
        },
        error() {
            alert("服务器异常");
        }
    })
}
    function addToCart(id){
        alert(id)
        var userId = localStorage.getItem("userId");
        if(userId == null){
            alert("请先登录");
            window.location.href = "/login";
        }
        alert(id)
        $.ajax({
            url:"/product/addToCart",
            type: 'POST',
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data:JSON.stringify(objJson = {
                "userId":userId,
                "productId": id,
            }),
            processData: false,       //必不可缺
            async:true,
            cache: false,
            success:function(data){
                if(data.code==200){
                    alert("添加成功")
                    window.location.href = "/cart";
                    findCartList()
                }
            },
            error() {
                alert("服务器异常");
            }
        })

    }
    function findCartList() {
        $.ajax({
            url:"/product/showCartList",
            type: 'POST',
            processData: false,       //必不可缺
            async:true,
            cache: false,
            success:function(data){
                console.log(data.data.list)
                if(data.code==404){
                    $("#cart-body").html = '';
                    $("#cart-body").append("<span>购物车空空如也，先去逛逛~</span>")
                }if(data.code == 200){
                    $.each(data.data.list, function (i, obj) {
                        $("#goods-list").append("<ul class='goods-list yui3-g'> <li class='yui3-u-11-24'> <div class='good-item'><div class='item-img'>"+
                            "<img src='"+obj.pic+"' /></div><div class='item-msg'>"+obj.title+"</div> </div> </li>"+

                        "<li class='yui3-u-1-8'><span class='price'>"+obj.price+"</span></li> <li class='yui3-u-1-8'>" +
                        "<input autocomplete='off' th:type='text' value='1' minnum='1' class='itxt' id='num' /></li> "+
                            "<li class='yui3-u-1-8'><span class='sum'>"+
                            obj.price*$('#num').val+"</span></li><li class='yui3-u-1-8'>"+
                            "<a href='#none' onclick='removeCart("+obj.id+")'>删除</a><br />"+
                            "<a href='#none'>移到我的关注</a></li></ul>")
                    })
                }
            },
            error() {
                alert("服务器异常");
            }
        })
    }
    function getGoods() {
       var verifyStatus = $('input:radio[name="scope"]:checked').val();
        var objJson ={
            "verifyStatus":verifyStatus
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
                    $.each(data.data.list, function (i, obj) {
                        var sta = obj.verifyStatus == 0 ?"未审核":(obj.verifyStatus == 1 ? "已通过":(obj.verifyStatus == 2 ?"审核未通过":"已关闭"));
                        $("#goods").append(
                           "<tr ng-repeat=\"entity in list\">" +
                            "<td><input  type=\"checkbox\"></td>" +
                            "<td>"+i+"</td>" +
                            "<td>"+obj.name+"</td>" +
                            "<td>"+obj.price+"</td>" +
                            "<td>"+obj.productCategoryId+"</td><td><span>" + sta+
                            "</span>" +
                            "</td>" +
                            "<td class='text-center'>" +
                            "<a class='btn bg-olive btn-xs' th:href='@{/shop/goodsEdit}' onclick='getGoodsById("+obj.id+")'>修改</a></td>" +
                            "</tr>")});
                }else{
                    alert(data.message);
                }
            },
            error: function (){
                alert("访问失败，请检查网络、路径......");
            }
        });

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
                console(data)
                document.getElementById("productName").innerHTML = obj.name;
                document.getElementById("brandId").innerHTML = obj.brandId;
                document.getElementById("subTitle").innerHTML = obj.subTitle;
                document.getElementById("price").innerHTML = obj.price;
                document.getElementById("detailTitle").innerHTML = obj.detailTitle.toString();
                $("#picList").html('');
                $("#picList").append("<tr >" +
                   "<td >" +
                   "<img  src='"+obj.pic+"' width=\"100px\" height=\"100px\">\n" +
                   "</td>\n" +
                   "<td> <button type=\"button\" onclick=\"removeImg($index)\" class=\"btn btn-default\" title=\"删除\" ><i class=\"fa fa-trash-o\"></i> 删除</button></td>\n" +
                   "</tr>");
                document.getElementById("productSpecificationsId").innerHTML = obj.productSpecificationsId;
                $("#modal-footer").html('');
                $("#modal-footer").append("<button class='btn btn-primary' onclick='updateProduct()'><i class='fa fa-save'></i>保存商品</button>"+
                +"<button class='btn btn-default' >返回列表</button>");
            },
            error() {
                alert("服务器异常");
            }
        })

    }
function updateProduct(){
    var name = $('#productName').val(),
        brandId = $('brandId').val(),
        subTitle = $('subTitle').val(),
        price = $('price').val(),
        detailTitle = $('detailTitle').val(),
        productSpecificationsId = $('productSpecificationsId').val(),
        pic = $('addImg').val();
    var objJson = {
        "name" :productName,
        "brandId" : brandId,
        "subTitle":subTitle,
        "price":price,
        "detailTitle" :detailTitle,
        "productSpecificationsId":productSpecificationsId,
        "pic" :pic
    }
    alert(JSON.stringify(objJson))
    $.ajax({
        url: "/product/addProduct",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            if(data.code == 200){
            alert("添加成功")
            }
        },
        error() {
            alert("请重新添加")
        }

    })
}
function uploadFile() {
    var goodsFile = document.getElementById('file');
    alert(goodsFile)

    var fileNameArr = goodsFile.value.toLowerCase().split('.');

    var suffix = fileNameArr[fileNameArr.length-1];
    //如果后缀为空
    if(suffix != ""){

        if(suffix=='gif'||suffix=='jpg'||suffix=='bmp'||suffix=='png'||suffix=='jpeg'){
            var imgSize = goodsFile.files[0].size;
            //alert("图片大小："+imgSize+"B");
            if(imgSize>1024*1024*3){
                alert("注册失败，图片大于3M");
                return false;
            }
        }else{
            alert("请选择格式为*.jpg、*.gif、*.bmp、*.png、*.jpeg 的图片");
            return false;
        }
        var inputJ = $("#file");
        alert(inputJ)
        inputJ.change(function(e){
            var file     = e.target.files[0],//拿到原始对象
                thisType = file.type,//获取到表面的名称，可判断文件类型
                thisSize = file.size,//文件的大小
                reader   = new FileReader();

            // readAsDataURL(file),//读取文件，将文件以数据URL的形式保存在result的属性中
                reader.readAsDataURL(file);

            //文件加载成功以后，渲染到页面
            reader.onload = function(e) {
                //获取图片dom
                var img = document.getElementById("copyImg");
                //图片路径设置为读取的图片
                img.src = e.target.result;
                alert(e.target.result)
            };
        });

    }


}
