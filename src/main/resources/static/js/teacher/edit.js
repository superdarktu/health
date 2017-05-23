$(document).ready(function () {
    $("#change").click(function () {
        $.post("admin_update", {
        	"id":$("#id").val(),
            "jg": $("#jg").val(),
            "phone": $("#phone").val(),
            "email": $("#email").val(),
            "job": $("#job").val(),
            "birthday": $("#birthday").val(),
            "sex": $("input[name='sex']:checked").val(),
        }, function (result) {
            if (result.status == true) {
                location.href = "../teacher_about";
            } else {
                alert(result.message);
            }
        });
    });
});