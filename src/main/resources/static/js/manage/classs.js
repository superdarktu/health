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
                html += "<td>"+data[i].no+"</td><td>"+data[i].name+"</td>";
                html += "<td>"+data[i].daytime+"</td><td>"+data[i].teacherName+"</td>";
                html += "<td>"+data[i].classTime+"</td><td>"+data[i].place+"</td>";
                html += "<td>"+data[i].longTime+"</td>";
                html += '<td><a id="add"><i class="fa fa-pencil text-navy"></i></a> ';
                html += '<a id="delete"><i class="fa fa-close text-navy"></i></a></td>';
			}
			html += "</tr>";
			$("#class_list").html(html);
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
            "daytime" : $("#daytime").val(),
            "longTime" : $("#longTime").val(),
            "teacherName" : $("#teacherName").val(),
            "classTime" : $("#classTime").val(),
            "place" : $("#place").val(),
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