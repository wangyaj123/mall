function findBrandList(){
    var name = $('#brandName').val(),
        firstLetter = $('#firstChar').val();
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
            $("#brandList").html('');
            $.each(data.data.list, function (i, obj) {
                $("#brandList").append("<tr ng-repeat=\"entity in list\">\n" +
                    "<td><input name='brand'  type='checkbox'></td>" +
                    "<td>"+obj.id+"</td>" +
                    "<td>"+obj.name+"</td>" +
                    "<td>"+obj.firstLetter+"</td>" +
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
function findById(id){
    $.ajax({
        url: "/brand/getById",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson = {
            "id": id,
        }),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            var obj = data.data

                $("#modal-footer").html('');
               $("#modal-footer").append("<button class='btn btn-success' data-dismiss='modal' aria-hidden=\"true\" onclick='updateBrand("+obj.id+")'>修改</button>\n" +
                   "<button class=\"btn btn-default\" data-dismiss=\"modal\" aria-hidden=\"true\">关闭</button>")
        }, error() {
            alert("服务器异常");
        }
    })
}
function saveBrand() {
    var name = $('#newBrandName').val(),
        firstLetter = $('#newFirstChar').val();
    $.ajax({
        url: "/brand/save",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson = {
            "name": name,
            "firstLetter": firstLetter
        }),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            if(data.data.result == 1){
                alert("添加成功")
                window.location.reload();
            }
        }, error() {
            alert("服务器异常");
        }
    })
}
function updateBrand() {
    var name = $('#newBrandName').val(),
        firstLetter = $('#newFirstChar').val();
    $.ajax({
        url: "/brand/updateById",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: JSON.stringify(objJson = {
            "id":id,
            "name": name,
            "firstLetter": firstLetter
        }),
        processData: false,       //必不可缺
        async: true,
        cache: false,
        success: function (data) {
            if(data.data.result == 1){
                alert("修改成功")
                window.location.reload();
            }
        }, error() {
            alert("服务器异常");
        }
    })
}
function removeBrand(){
    $('input:checkbox').each(function() {
        if ($(this).attr('checked') ==true) {
            alert($(this).val());
        }
    });
}