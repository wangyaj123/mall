function loginUser(){
    var username = $('#username').val(),
        password = $('#password').val();
    var objJson = {
        "username":username,
        "password":password
    };
    var URL = "api/view/login";
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
                localStorage.setItem("username",data.data.username);
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
function register() {


}