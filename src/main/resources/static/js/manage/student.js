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
                if(data.sex == "1") html +="<td>男</td>";
                else html += "<td>女</td>"
                html += "<td>"+data[i].birthday+"</td><td>"+data[i].sfid+"</td>";
                html += "<td>"+data[i].phone+"</td><td>"+data[i].job+"</td><td>"+data[i].email+"</td>";
                html += "<td>"+data[i].jg+"</td><td>"+data[i].jsfaid+"</td>";
                html += '<td><a id="add"><i class="fa fa-pencil text-navy"></i></a> ';
                html += '<a id="delete"><i class="fa fa-close text-navy"></i></a></td>';
			}
			html += "</tr>";
			$("#student_list").html(html);
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
            "email" : $("#email").val(),
            "job" : $("#job").val(),
            "birthday" : $("#birthday").val(),
            "sfid" : $("#sfid").val(),
            "age" : $("#age").val(),
            "jg" : $("#jg").val(),
            "phone" : $("#phone").val(),
            "sex" : $("input[name='sex']:checked").val(),
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


    $("#change").click(function(){
        $.post("update",{
            "email" : $("#email").val(),
            "job" : $("#job").val(),
            "birthday" : $("#birthday").val(),
            "jg" : $("#jg").val(),
            "phone" : $("#phone").val(),
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