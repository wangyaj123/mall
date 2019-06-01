function loginUser(){
    var username = $('#shopName').val(),
        password = $('#password').val();
    var objJson = {
        "account":username,
        "password":password
    };
    $.ajax({
        type:"POST",
        url: "/api/shop/login",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        async:true,
        success: function (data) {
            if(data.code==200){
                alert("登录成功");
                console.log(data);
                //将用户名保存在session中
                localStorage.setItem("shopAccount",data.data.account);
                localStorage.setItem("shopId",data.data.id);
                //页面跳转
                window.location.href = "/shop";
            }else{
                alert(data.message);
            }
        },
        error: function (){
            alert("访问失败，请检查网络、路径......");
        }
    });


}
