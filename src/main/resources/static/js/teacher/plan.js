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

function submit(){
	
	var foodmains = $(".foodmain");
	var itemmains  = $(".itemmain");
	
	foodlength = foodmains.length;
	itemlength = itemmains.length;
	length = foodlength >= itemlength ? foodlength : itemlength;
	if(length == 0){ alert('请填入数据'); return;}
	var itemlist = [];
	var foodlist = [];
	for(i=0;i<itemmains.length;i++){
		items = [];
		itemtr = $(itemmains[i]).find(".itemtr");
		for(u=0;u<itemtr.length;u++){
			item = {};
			item['name'] = $(itemtr[i]).find(".name").val();
			item['load'] = $(itemtr[i]).find(".load").val();
			item['interval'] = $(itemtr[i]).find(".interval").val();
			item['number'] = $(itemtr[i]).find(".number").val();
			item['points'] = $(itemtr[i]).find(".points").val();
			item['matter'] = $(itemtr[i]).find(".matter").val();
			items.push(item);
		}
		itemlist.push(items);
	}
	
	for(i=0;i<foodmains.length;i++){
		foods = [];
		foodtr = $(foodmains[i]).find(".foodtr");
		for(u=0;u<itemtr.length;u++){
			food = {};
			food['name1'] = $(foodtr[i]).find(".name1").val();
			food['num1'] = $(foodtr[i]).find(".num1").val();
			food['name2'] = $(foodtr[i]).find(".name2").val();
			food['num2'] = $(foodtr[i]).find(".num2").val();
			food['name3'] = $(foodtr[i]).find(".name3").val();
			food['num3'] = $(foodtr[i]).find(".num3").val();
			foods.push(food);
		}
		foodlist.push(foods);
	}
	var json = {};
	if($("#cfmd").val() == ''){
		alert("请填写处方目的");return;
	}
		
	if($("#no").val() == ''){
		alert("请填写编号");return;
	}
	json['cfmd'] = $("#cfmd").val();
	json['no'] = $("#no").val();
	json['jszyd'] = $("#jszyd").val();
	json['items'] = itemlist;
	json['foods'] = foodlist;
	console.log(JSON.stringify(json));
	$.post("../program/add", {
        "json":JSON.stringify(json),
    }, function (result) {
        if (result.status == true) {
            layer.msg("保存成功",{icon:1});
        } else {
            alert(result.message);
        }
    });
}
$(document).ready(function () {
	foodadd();
	foodadd1();
	itemadd();
	itemadd1();
})