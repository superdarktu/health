function foodadd(){
//	$("#foodadd2").unbind();
    $("#foodadd2").click(function(){
        temp = '<div class="food"><td rowspan="2">第'+($(".food").length+1)+'天</td>';
        $(this).before(temp+$("#food2").html());
        foodadd1();
    });
}
function foodadd1(){
    $(".foodadd1").unbind();
    $(".foodadd1").click(function(){
        $(this).parent().parent().before($("#food1").html());
    });
}
function itemadd(){
//	$("#foodadd2").unbind();
    $("#itemadd2").click(function(){
        temp = '<div class="item"><td rowspan="2">第'+($(".item").length+1)+'天</td>';
        $(this).before(temp+$("#item2").html());
        itemadd1();
    });
}
function itemadd1(){
    $(".itemadd1").unbind();
    $(".itemadd1").click(function(){
        $(this).parent().parent().before($("#item1").html());
    });
}
$(document).ready(function () {
	foodadd();
	foodadd1();
	itemadd();
	itemadd1();
})