function search(page,pageSize){
	var option  = $("input[name='options']:checked").val();
	
	if(option == "food"){
		$.get("../food/list",{
			"name" : $("#name").val(),
			"page" : page,
			"pageSize" : pageSize
		},function(result){
			if(result.status == true){
				
				data = result.data;
				html = "<tr>";
				for(i=0;i<data.length;i++){
					html += "<td>"+data[i].name+"</td>";
					html += "<td>"+data[i].sort+"</td>";
					html += "<td>"+data[i].number+"</td>";
				}
				html += "</tr>"
				$("#food_main").html(html);
				$(".content").css("display","none");
				$("#food").css("display","block");
			}else{
				alert(result.message);
			}
		});
	}else if(option == "classs"){
		$.get("../classs/list",{
			"name" : $("#name").val(),
			"page" : page,
			"pageSize" : pageSize
		},function(result){
			if(result.status == true){

				data = result.data;
				html = "<tr>";
				for(i=0;i<data.length;i++){
					html += "<td>"+data[i].id+"</td>";
					html += "<td>"+data[i].name+"</td>";
					html += "<td>"+data[i].teacherName+"</td>";
					html += "<td>"+data[i].daytime+"</td>";
					html += "<td>"+data[i].startTime+"</td>";
					html += "<td>"+data[i].place+"</td>";
					html += "<td>"+data[i].longTime+"</td>";
				}
				html += "</tr>"
				$("#classs_main").html(html);
				$(".content").css("display","none");
				$("#classs").css("display","block");
			}else{
				alert(result.message);
			}
		});
	}else{
		$.get("../equipment/list",{
			"name" : $("#name").val(),
			"page" : page,
			"pageSize" : pageSize
		},function(result){
			if(result.status == true){

				data = result.data;
				html = "<tr>";
				for(i=0;i<data.length;i++){
					html += "<td>"+data[i].id+"</td>";
					html += "<td>"+data[i].name+"</td>";
					html += "<td>"+data[i].part+"</td>";
					html += "<td>"+data[i].useway+"</td>";
					html += "<td>"+data[i].useattention+"</td>";
				}
				html += "</tr>"
				$("#equipment_main").html(html);
				$(".content").css("display","none");
				$("#equipment").css("display","block");
			}else{
				alert(result.message);
			}
		});
	}
}
$(document).ready(function(){
	var page = 1;
	var pageSize = 10;
	$("#search").click(function(){
		page = 1;
		search(page,pageSize);
	});
});