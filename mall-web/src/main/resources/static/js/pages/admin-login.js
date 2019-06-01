function loginUser(){
    var username = $('#username').val(),
        password = $('#password').val();
    var objJson = {
        "username":username,
        "password":password
    };
    var URL = "/api/admin/login";
    Login_AJAXFunction(objJson,URL);


}

function Login_AJAXFunction(objJson,URL) {

    $.ajax({
        type:"POST",
        url: URL,
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        async:true,
        success: function (data) {
            if(data.code==200){
                alert("登录成功");
                console.log(data);
                //将用户名保存在session中
                localStorage.setItem("username",data.data.username);
                localStorage.setItem("adminId",data.data.id);
                //页面跳转
                window.location.href = "/admin/page";
            }else{
                alert("用户名密码错误或用户不存在");
            }
        },
        error: function (){
            alert("访问失败，请检查网络、路径......");
        }
    });
}
