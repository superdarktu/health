$(document).ready(function () {
    $("#name").change(function(){
        $(".value").val("");
        $.post("../standard/list", {
            "name":$("#name").val(),
        }, function (result) {
            if (result.status == true) {
                data = result.data;
                for(i=0;i<data.length;i++){
                    if(data[i].sex == '1'){
                        $($(".boy")[data[i].startAge-1]).find(".one").val(data[i].one);
                        $($(".boy")[data[i].startAge-1]).find(".two").val(data[i].two);
                        $($(".boy")[data[i].startAge-1]).find(".three").val(data[i].three);
                        $($(".boy")[data[i].startAge-1]).find(".four").val(data[i].four);
                        $($(".boy")[data[i].startAge-1]).find(".five").val(data[i].five);
                    }else{
                        $($(".girl")[data[i].startAge-1]).find(".one").val(data[i].one);
                        $($(".girl")[data[i].startAge-1]).find(".two").val(data[i].two);
                        $($(".girl")[data[i].startAge-1]).find(".three").val(data[i].three);
                        $($(".girl")[data[i].startAge-1]).find(".four").val(data[i].four);
                        $($(".girl")[data[i].startAge-1]).find(".five").val(data[i].five);
                    }
                }
            }
        });
    });


    $("#save").click(function(){

        var json = [];
        boys = $(".boy");
        girls = $(".girl");
        name = $("#name").val();
        var main;
        for(i=0;i<boys.length;i++){
            main = {};
            main['name'] = name;
            main['startAge'] = $(boys[i]).find(".age").val();
            main['sex'] = '1';
            main['one'] = $(boys[i]).find(".one").val();
            main['two'] = $(boys[i]).find(".two").val();
            main['three'] = $(boys[i]).find(".three").val();
            main['four'] = $(boys[i]).find(".four").val();
            main['five'] = $(boys[i]).find(".five").val();
            json.push(main)
        }
        for(i=0;i<girls.length;i++){
            main = {};
            main['name'] = name;
            main['startAge'] = $(girls[i]).find(".age").val();
            main['sex'] = '2';
            main['one'] = $(girls[i]).find(".one").val();
            main['two'] = $(girls[i]).find(".two").val();
            main['three'] = $(girls[i]).find(".three").val();
            main['four'] = $(girls[i]).find(".four").val();
            main['five'] = $(girls[i]).find(".five").val();
            json.push(main)
        }
        console.log(json);
        $.post("../standard/add", {
            "json":JSON.stringify(json),
        }, function (result) {
            if (result.status == true) {
                alert("保存成功");
            } else {
                alert(result.message);
            }
        });
    });
});