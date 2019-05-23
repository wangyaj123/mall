function loginUser(){
    var username = $('#username').val(),
        password = $('#password').val();
    var objJson = {
        "username":username,
        "password":password
    };
    var URL = "/api/view/login";
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
                console.log(data);
                //将用户名保存在session中
                localStorage.setItem("userLoginName",data.data.username);
                localStorage.setItem("userId",data.data.id);
                //页面跳转
                window.location.href = "/";
            }else{
                alert(data.message);
            }
        },
        error: function (){
            alert("访问失败，请检查网络、路径......");
        }
    });
}

function sendCode(){
        var phone = $('#phone').val();
        var URL = "/api/sendMsg";
        var objJson = {
            "phone": phone
        }
        $.ajax({
            type:"POST",
            url: "/api/sendMsg",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: JSON.stringify( objJson = {
                "phone": phone
            }),
            async:true,
            success: function (data) {
                console.log(data)
                if(data.code == 200 && data.data!=null){
                    localStorage.setItem("smsCode",data.data);
                }else if(data.code == 404){
                    alert(data.message)
                } else {
                    alert(data.message)
                }
            },
            error: function (){
                alert("访问失败，请检查网络、路径......");
            }
        });
}

function register() {
    var username = $('#username').val(),
        password = $('#password').val(),
        rePassword = $('#rePassword').val(),
        phone = $('#phone').val();

    var objJson = {
        "username":username,
        "password":password,
        "phone":phone,
    };
    alert(JSON.stringify(objJson))
    var URL = "/api/view/register";
    var code = localStorage.getItem("smsCode");
    if(password == rePassword){
        //alert(code)
        var smscode = $('#smscode').val();
        //alert(smscode);
        if(code == smscode){
            register_AJAX(URL, objJson);
        }else
        {
            alert("请重新获取短信验证码");
        }

    }else {
        alert("两次输入的密码不相同");
    }
}
function register_AJAX(URL, objJson) {
    $.ajax({
        type:"POST",
        url: URL,
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson),
        async:true,
        success: function (data) {
            if (data.code == 200 ) {
                console.log(data);
                alert("注册成功，请登录");
                window.location.href = "/login";
            } else {
                alert(data.message);
            }
        },
        error: function (){
            alert("访问失败，请检查网络、路径......");
        }
    });
}

