function del(no)
{
    layer.msg('确定删除吗？', {
        time: 0 //不自动关闭
        , btn: ['确定删除', '还是算了吧']
        , yes: function (index) {
            $.post("delete", {
                "no": no,
            }, function (result) {
                if (result.status == true) {
                    location.reload();
                } else {
                    alert(result.message);
                }
            });
        }
    });

}
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

function init(page, pageSise) {
    $.get("../program/list", {
      //  "name": $("#name").val(),
        "page":page,
        "pageSize":pageSise,
    }, function (result) {
        if (result.status == true) {
            data = result.data;
            html = "";
            for (i = 0; i < data.length; i++) {
                
                html += "<tr>";
                html += "<td>"+data[i].no+"</td><td>"+data[i].cfmd+"</td><td>"+data[i].teacherNo+"</td>";
                html += '<td><a id="add"><i class="fa fa-pencil text-navy"></i></a>';
                html += '<a onclick="del('+data[i].no+')" class="delete"><i class="fa fa-close text-navy"></i></a></td>';
                html += "</tr>";
            }
            $("#listmain").html(html);
        } else {
            alert(result.message);
        }
    });
};
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
			item['name'] = $(itemtr[u]).find(".name").val();
			item['load'] = $(itemtr[u]).find(".load").val();
			item['interval'] = $(itemtr[u]).find(".interval").val();
			item['number'] = $(itemtr[u]).find(".number").val();
			item['points'] = $(itemtr[u]).find(".points").val();
			item['matter'] = $(itemtr[u]).find(".matter").val();
			items.push(item);
		}
		itemlist.push(items);
	}
	
	for(i=0;i<foodmains.length;i++){
		foods = [];
		foodtr = $(foodmains[i]).find(".foodtr");
		for(u=0;u<foodtr.length;u++){
			food = {};
			food['name1'] = $(foodtr[u]).find(".name1").val();
			food['num1'] = $(foodtr[u]).find(".num1").val();
			food['name2'] = $(foodtr[u]).find(".name2").val();
			food['num2'] = $(foodtr[u]).find(".num2").val();
			food['name3'] = $(foodtr[u]).find(".name3").val();
			food['num3'] = $(foodtr[u]).find(".num3").val();
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
	console.log(json);
	$.post("../program/add", {
        "json":JSON.stringify(json),
    }, function (result) {
        if (result.status == true) {
        	location.href = result.href;
        } else {
            alert(result.message);
        }
    });
}
$(document).ready(function () {
	var page = 0;
    var pageSize = 10;
    init(page,pageSize);
	foodadd();
	foodadd1();
	itemadd();
	itemadd1();
})