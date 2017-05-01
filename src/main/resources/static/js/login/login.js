$(document).ready(function(){
	$("#submit").click(function(){
		$.post("login_in",{
			"username": $("#username").val(),
			"password" : $("#password").val(),
		},function(result){
			if(result.status == true){
				location.href= result.href;
			}else{
				alert(result.message);
			}
		});
	});
});