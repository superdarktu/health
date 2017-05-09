$(document).ready(function(){
	$("#change").click(function(){
		$.post("admin_update",{
			"jg": $("#jg").val(),
			"phone" : $("#phone").val(),
			"email" : $("#email").val(),
			"job" : $("#job").val(),
			"birthday" : $("#birthday").val(),
			"sex" : $("input[name='sex']:checked").val(),
		},function(result){
			if(result.status == true){
				location.href= result.href;
			}else{
				alert(result.message);
			}
		});
	});
});