$(document).ready(function () {
    $("#submit").click(function () {
        $.post("create", {
            "height": $("#height").val(),
            "weight": $("#weight").val(),
            "waist": $("#waist").val(),
            "hip": $("#hip").val(),
            "pulmonary": $("#pulmonary").val(),
            "wl": $("#wl").val(),
            "tjsy": $("#tjsy").val(),
            "ywqz": $("#ywqz").val(),
            "fwc": $("#fwc").val(),
            "zwtqq": $("#zwtqq").val(),
            "studentNo":$("#studentNo").val(),
        }, function (result) {
            if (result.status == true) {
            	$("#height").val("");
            	$("#weight").val("");
            	$("#waist").val("");
            	$("#hip").val("");
            	$("#pulmonary").val("");
            	$("#wl").val("");
            	$("#tjsy").val("");
            	$("#ywqz").val("");
            	$("#fwc").val("");
            	$("#zwtqq").val("");
            	$("#studentNo").val("");
                alert("添加成功");
            } else {
                alert(result.message);
            }
        });
    });
});