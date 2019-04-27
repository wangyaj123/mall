function getName(){
    var username = localStorage.getItem("username")
    alert(username);
    document.getElementById("showName").innerHTML=username.toString();
    document.getElementById("showusername").innerHTML=username.toString();
}


 