function findSpecList(){
    var name = $('#specName').val();
    $.ajax({
        url:"/brand/query/list",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:JSON.stringify(objJson = {
            "name":name,
            "firstLetter":firstLetter
        }),
        processData: false,       //必不可缺
        async:true,
        cache: false,
        success:function(data){
            $("#specList").html('');
            $.each(data.data.list, function (i, obj) {
                $("#specList").append("<tr ng-repeat=\"entity in list\">\n" +
                    "<td><input name='brand'  type='checkbox'></td>" +
                    "<td>"+obj.id+"</td>" +
                    "<td>"+obj.name+"</td>" +
                    "<td class='text-center'>" +
                    "<button type='button' class='btn bg-olive btn-xs'onclick='findById("+obj.id+")' data-toggle='modal' data-target='#editModal' >修改</button>" +
                    "</td>" +
                    "</tr>")
            })
        },
        error() {
            alert("服务器异常");
        }
    })
}