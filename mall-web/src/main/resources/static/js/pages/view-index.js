function load() {
    var username = localStorage.getItem("userLoginName");
    if(username!= null){
        document.getElementById("loginUser").innerHTML = username.toString();
    }
     search();
}
function search(){
    var keywords = $("#keywords").val();
    var objJson = {
        "keywords":keywords
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
                $("#picLBxxl").html('');
                $.each(data.data.list, function (i, obj) {
                    if(obj.verifyStatus == 1){
                    $("#picLBxxl").append(
                        "<li class='yui3-u-1-6'><dl class='picDl huozhe'><dd>" +
                        "<a href='/productInfo?id="+obj.id+"'class='pic'><img src='"+obj.pic+ "' alt='' /></a>" +
                        "<div class='like-text'>" +
                        "<p>"+obj.name+"</p>" +
                        "<h3>"+obj.price+"</h3>" +
                        "</div></dd></dl></li>")
                    }
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
