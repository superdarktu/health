function del(id)
{
    layer.msg('确定删除吗？', {
        time: 0 //不自动关闭
        , btn: ['确定删除', '还是算了吧']
        , yes: function (index) {
            $.post("delete", {
                "id": id,
            }, function (result) {
                if (result.status == true) {
                    location.href = result.href;
                } else {
                    alert(result.message);
                }
            });
        }
    });

}
;
$(document).ready(function () {
    $("#change").click(function () {
        $.post("admin_update", {
            "jg": $("#jg").val(),
            "phone": $("#phone").val(),
            "email": $("#email").val(),
            "job": $("#job").val(),
            "birthday": $("#birthday").val(),
            "sex": $("input[name='sex']:checked").val(),
        }, function (result) {
            if (result.status == true) {
                location.href = result.href;
            } else {
                alert(result.message);
            }
        });
    });
});