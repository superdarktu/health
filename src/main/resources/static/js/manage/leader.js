function del(id) {
	layer.msg('确定删除吗？', {
        time: 0 //不自动关闭
        , btn: ['确定删除', '还是算了吧']
        , yes: function (index) {
            $.post("../teacher/delete", {
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
function init(page, pageSize) {
    $.get("../teacher/list", {
        "name": $("#name").val(),
        "page":page,
        "pageSize":pageSize
    }, function (result) {
        if (result.status == true) {
            data = result.data;
            html = "";
            for (i = 0; i < data.length; i++) {
                html += "<tr>";
                html += "<td>" + data[i].no + "</td><td>" + data[i].name + "</td>";
                if (data.sex == "1") html += "<td>男</td>";
                else html += "<td>女</td>"
                html += "<td>" + data[i].birthday + "</td><td>" + data[i].sfid + "</td>";
                html += "<td>" + data[i].phone + "</td><td>" + data[i].email + "</td>";
                html += "<td>" + data[i].jg + "</td>";
                html += '<td><a onclick="oo('+data[i].id+')" class="change"><i class="fa fa-pencil text-navy"></i></a> ';
                html += '<a id="delete" onclick="del('+data[i].id+')"><i class="fa fa-close text-navy"></i></a></td>';
                html += "</tr>";
            }
            $("#leader_main").html(html);
        } else {
            alert(result.message);
        }
    });
};
function oo(id){
	layer.open({
        type: 2,
        title: '信息修改',
        area: ['600px', '360px'],
        shadeClose: true, //点击遮罩关闭
        content: 'leaded?id='+id

    });
}
$(document).ready(function () {

    var page = 0;
    var pageSize = 10;
    init(page,pageSize);
    $("#submit").click(function () {
        $.post("../teacher/add", {
            "name": $("#name").val(),
            "email": $("#email").val(),
            "birthday": $("#birthday").val(),
            "sfid": $("#sfid").val(),
            "jg": $("#jg").val(),
            "phone": $("#phone").val(),
            "sex": $("input[name='sex']:checked").val(),
            "password" : $("#password").val(),
        }, function (result) {
            if (result.status == true) {
                location.href = result.href;
            } else {
                alert(result.message);
            }
        });
    });

    $("#search").click(function () {
        page = 0;
        init(page, pageSize);
    });


    $("#change").click(function () {
        $.post("../teacher/admin_update", {
        	"id":$("#id").val(),
            "email": $("#email").val(),
            "birthday": $("#birthday").val(),
            "jg": $("#jg").val(),
            "phone": $("#phone").val(),
            "sex": $("input[name='sex']:checked").val(),
            "password" : $("#password").val(),
        }, function (result) {
            if (result.status == true) {
            	parent.location.reload();
            } else {
                alert(result.message);
            }
        });
    });
});