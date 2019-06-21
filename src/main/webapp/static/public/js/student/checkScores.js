var courseId;
var studentId;
// async: false,同步
$.ajax({
    type: "POST",
    url: "/student/querySelectedCourses",
    async: false,
    success: function (result) {

        var data = result;
        if (true) {
            for (var i = 0; i < data.length; i++) {
                $("#myCourseName").append("<option value=" + data[i]['courseId'] + ">" + data[i]['courseName'] + "</option>")
            }
            studentId=data[0]['studentId'];
            courseId = $("#myCourseName option:selected").val();


        } else {
            layer.alert(result.msg);
        }
        $("#myCourseName").change(function(){
            $('#selectedCoursesTable').bootstrapTable('destroy');//先销毁表格，不然不会刷信

            courseId = $("#myCourseName option:selected").val();

        });
    }
});
$("#myCourseName").change(function(){
    $('#createTable').empty();//先清除表格，不然会重叠
    courseId = $("#myCourseName option:selected").val();
    $.ajax({
        type: "POST",
        url: "/grades/getSmallScores",
        data: JSON.stringify({"courseId":courseId,"studentId":studentId}),//参数
        success: function (result) {

            drawScoreTable(result);
        }
    });
});
$.ajax({
    type: "POST",
    url: "/grades/getSmallScores",
    data: JSON.stringify({"courseId":courseId,"studentId":studentId}),//参数
    success: function (result) {

        drawScoreTable(result);
    }
});
function drawScoreTable(result) {
    var table=$("#createTable");
    for (var i = 0; i <result.length; i++) {
        // 算总分
        var totalScore=0;
        for (var j = 0; j < result[i]['grades'].length; j++) {
          totalScore=totalScore + result[i]['grades'][j]['result'];
        }
        var tr=$("<tr></tr>");
        tr.appendTo(table)
        // var td=$("<td></td>");
        // td.appendTo(tr);
        var trcontent=" <h4>\n" +
            "\n" +
            "                    <a href=\"https://github.com/zwdcdu/is_analysis/blob/master/test1.md\" target=\"_blank\" >\n" +
            "                        <span class=\"label label-success\">"+result[i]['title']+"</span> </a>\n" +
            "                    <a href=\"https://github.com/Ryanaa/is_analysis/tree/master/test1\" target=\"_blank\" > >> </a>\n" +
            "\n" +
            "\n" +
            "\n" +
            "                </h4>\n" +
            "                <div class=\"input-group\">\n" +
            "                    <span class=\"input-group-addon\">总分:</span>\n" +
            "                    <span class=\"input-group-addon\" style=\"width: 300px\"><input type=\"text\" id=\"result22\"class=\"form-control\" placeholder=\"输入分数\" value="+totalScore+"></span>\n" +
            "                    <span class=\"input-group-addon\">批改日期:"+Date(result[i]['grades'][0]['updateDate'])+"</span>\n" +
            "                    <span class=\"input-group-addon\">  <button onclick='' type=\"button\" class=\"btn btn-primary\" >\n" +
            "                        评分细则\n" +
            "                    </button></span>\n" +
            "\n" +
            "                </div> ";



      var smallScores="  \n" +
          "                <div class=\"input-group\">\n" +
          "                    <span class=\"input-group-addon\">实验创新性</span>\n" +
          "                    <span class=\"input-group-addon\" >"+result[i]['grades'][0]['result']+"</span>\n" +
          "\n" +
          "                    <textarea id=\"memo2\" rows=\"4\" class=\"form-control\" placeholder=\"输入评价\">"+result[i]['grades'][0]['memo']+"</textarea>\n" +
          "                </div>\n" +
          "                <div class=\"input-group\">\n" +
          "                    <span class=\"input-group-addon\">实验准确度</span>\n" +
          "                    <span class=\"input-group-addon\" >"+result[i]['grades'][1]['result']+"</span>\n" +
          "\n" +
          "                    <textarea id=\"memo3\" rows=\"4\" class=\"form-control\" placeholder=\"输入评价\">"+result[i]['grades'][0]['memo']+"</textarea>\n" +
          "                </div>\n" +
          "                <div class=\"input-group\">\n" +
          "                    <span class=\"input-group-addon\">实验完整性</span>\n" +
          "                    <span class=\"input-group-addon\" >"+result[i]['grades'][2]['result']+"</span>\n" +
          "\n" +
          "                    <textarea id=\"memo4\" rows=\"4\" class=\"form-control\" placeholder=\"输入评价\">"+result[i]['grades'][0]['memo']+"</textarea>\n" +
          "                </div>";

         trcontent=trcontent+smallScores;

         var Jtrcontent=$(trcontent);
        Jtrcontent.appendTo(tr);

    }
}

