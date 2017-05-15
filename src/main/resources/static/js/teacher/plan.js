function foodadd(){
	$(".foodadd").unbind();
	$(".foodadd").click(function(){
		$(this).parent().parent().before($("#food1").html());
	});
}
function foodadd1(){
	$(".foodadd1").unbind();
	$(".foodadd1").click(function(){
		temp = $(this).parent().parent().prev(".foodday").find(".day");
		console.log($(this).parent().parent().prev(".foodday").html());
		temp.attr("rowspan",parseInt(temp.attr("rowspan"))+1);
		$(this).parent().parent().before($("#food2").html());
	});
}
$(document).ready(function () {
	foodadd();
	foodadd1();
})