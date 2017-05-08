function del(id){
    $.post("delete",{
        "id": id,
    },function(result){
        if(result.status == true){
            location.href= result.href;
        }else{
            alert(result.message);
        }
    });
}
function init(page,pageSise){
    $.get("list",{
        "name": $("#name").val(),
    },function(result){
        if(result.status == true){
        	data = result.data;
        	html = "<tr>";
        	for(i=0;i<data.length;i++){
                html += "<td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].part+"</td>";
                html += "<td>"+data[i].useway+"</td><td>"+data[i].useattention+"</td>";
                html += '<td><a id="add"><i class="fa fa-pencil text-navy"></i></a> ';
                html += '<a id="delete"><i class="fa fa-close text-navy"></i></a></td>';
			}
			html += "</tr>";
			$("#equipment_list").html(html);
        }else{
            alert(result.message);
        }
    });
};

$(document).ready(function(){

	var page = 0;
	var pageSize = 10;
    $("#submit").click(function(){
        $.post("add",{
            "name": $("#name").val(),
            "part" : $("#part").val(),
            "useway" : $("#useway").val(),
            "useattention" : $("#useattention").val(),
        },function(result){
            if(result.status == true){
                location.href= result.href;
            }else{
                alert(result.message);
            }
        });
    });

    $("#search").click(function(){
        page = 0;
        init(page,pageSize);
	});

});