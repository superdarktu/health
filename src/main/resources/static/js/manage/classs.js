function del(id) {
    layer.msg('确定删除吗？', {
        time: 0 //不自动关闭
        , btn: ['确定删除', '还是算了吧']
        , yes: function (index) {
            $.post("../classs/delete", {
                "id": id,
            }, function (result) {
                if (result.status == true) {
                    location.href = result.href;
                } else {
                    alert(result.message);
                    layer.close(index);
                }
            });
        }
    });
}
function init(page, pageSise) {
    $.get("../classs/list", {
        "name": $("#name").val(),
        "page":page,
        "pageSize":pageSise,
    }, function (result) {
        if (result.status == true) {
            data = result.data;
            html = "";
            for (i = 0; i < data.length; i++) {
                html += "<tr>";
                html += "<td>" + data[i].id + "</td><td>" + data[i].name + "</td>";
                html += "<td>" + data[i].daytime + "</td><td>" + data[i].teacherName + "</td>";
                html += "<td>" + data[i].classTime + "</td><td>" + data[i].place + "</td>";
                html += "<td>" + data[i].longTime + "</td>";
                html += '<td><a id="add"><i class="fa fa-pencil text-navy"></i></a> ';
                html += '<a id="delete" onclick="del('+data[i].id+')"><i class="fa fa-close text-navy"></i></a></td>';
            }
            html += "</tr>";
            $("#class_list").html(html);
        } else {
            alert(result.message);
        }
    });
};

$(document).ready(function () {

    var page = 0;
    var pageSize = 10;
    init(page,pageSize);
    $("#submit").click(function () {
    	if($("#name").val() == ""){
    		alert("请填写所有的数据");
    		return;
    	}
        $.post("../classs/save", {
            "name": $("#name").val(),
            "daytime": $("#daytime").val(),
            "longTime": $("#longTime").val(),
            "teacherName": $("#teacherName").val(),
            "classTime": $("#classTime").val(),
            "place": $("#place").val(),
        }, function (result) {
            if (result.status == true) {
                location.href = result.href;
            } else {
                alert(result.message);
                layer.close(index);
            }
        });
    });

    $("#search").click(function () {
        page = 0;
        init(page, pageSize);
    });


});