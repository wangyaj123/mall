function addToCart(id,num){
    var url = location.search;//获取
    if (url.indexOf("?") != -1) {    //判断是否有参数
        var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
        strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
        var id = strs[1];
    }
    var userId = localStorage.getItem("userId");
    if(userId != null){
        $.ajax({
            url:"/cart/add",
            type: 'POST',
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data:JSON.stringify(objJson = {
                "userId":userId,
                "productId": id,
                "num":num,
            }),
            processData: false,       //必不可缺
            async:true,
            cache: false,
            success:function(data){
                if(data.code==200){
                    alert("添加成功")
                    window.location.href = "/cart";
                }
            },
            error() {
                alert("服务器异常");
            }
        })
    }else{alert("请先登录");
        window.location.href = "/login";}
}
function findCartList() {
    $.ajax({
        url:"/cart/showCartList",
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
                $("#cartList").html('');
                $.each(data.data.list, function (i, obj) {
                    $("#cartList").append("<ul class='goods-list yui3-g'> <li class='yui3-u-1-24'>"+
                        "<input type='checkbox' name='selProduct' id='selProduct' value='' /></li>"+
                        "<li class='yui3-u-11-24'><div class='good-item'><div class='item-img'>"+
                        "<img src='"+obj.product.pic+"' /></div>" +
                        "<div class='item-msg'>"+obj.product.subTitle+ "</div></div></li>" +
                        "<li class='yui3-u-1-8'>" +
                        "<span class='price'>"+obj.product.price+ "</span></li>" +
                        "<li class='yui3-u-1-8'>" +
                        "<input autocomplete='off' type='text' value='"+obj.num+"' minnum='1' class='itxt' id='num' name='num' />"+
                        "</li><li class='yui3-u-1-8'><span class='sum'>"+(obj.product.price)*obj.num+"</span></li><li class='yui3-u-1-8'>"+
                        "<a href='#none' onclick='removeProduct("+ obj.id +")'>删除</a><br /><a href='#none'>移到我的关注</a></li></ul>"
                )})
            }
        },
        error() {
            alert("服务器异常");
        }
    })
}
function removeProduct(id) {
    alert(id)
    $.ajax({
        url:"/cart/remove",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:JSON.stringify(objJson = {
            "id":id,
        }),
        processData: false,       //必不可缺
        async:true,
        cache: false,
        success:function(data){
            if(data.data.result == 1){
                alert("删除成功")
                window.location.href = "/cart";
            }
        },
        error() {
            alert("服务器异常");
        }
    })

}