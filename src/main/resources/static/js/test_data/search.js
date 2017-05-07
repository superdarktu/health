function aaa(page,pageSize){
	$.get("list",{
		"page" : page,
		"pageSize" : pageSize,
	},function(result){
		if(result.status == true){
			var html = "";
			data = result.data;
			for(i=0;i<data.length;i++){
				date = new Date(data[i].testDate);
				html += "<tr>";
				html += "<td>"+date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate()+"</td>";
				html += "<td>"+data[i].height+"</td>";
				html += "<td>"+data[i].weight+"</td>";
				html += "<td>"+data[i].waist+"</td>";
				html += "<td>"+data[i].hip+"</td>";	
				html += "<td>"+data[i].pulmonary+"</td>";
				html += "<td>"+data[i].tjsy+"</td>";
				html += "<td>"+data[i].wl+"</td>";
				html += "<td>"+data[i].ywqz+"</td>";
				html += "<td>"+data[i].fwc+"</td>";
				html += "<td>"+data[i].zwtqq+"</td>";
				html += "<td>"+data[i].bmr+"</td>";
				html += "<td>"+data[i].ytb+"</td>";
				html += "<td>"+data[i].bmi+"</td>";
				html += "<td>"+data[i].sjfxjy+"</td>";
				html += "</tr>";
			}
			$("#content").html(html);
		}else{
			alert(result.message);
		}
	});
};
$(document).ready(function(){
	
	var pages = 1;
	var pageSizes = 10;
	aaa(1,10);
	
	$("#up").click(function(){
		
	});
});