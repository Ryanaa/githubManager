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
    var tr=$("<tr></tr>");
    tr.appendTo(table);
    var td=$("<td></td>");
    td.appendTo(tr);
    var tdcontent=$(" <h4>\n" +
        "\n" +
        "                    <a href=\"https://github.com/zwdcdu/is_analysis/blob/master/test1.md\" target=\"_blank\" >\n" +
        "                        <span class=\"label label-success\">实验1:业务流程建模</span> </a>\n" +
        "                    <a href=\"https://github.com/Ryanaa/is_analysis/tree/master/test1\" target=\"_blank\" > >> </a>\n" +
        "\n" +
        "\n" +
        "\n" +
        "                </h4>\n" +
        "                <div class=\"input-group\">\n" +
        "                    <span class=\"input-group-addon\">总分:</span>\n" +
        "                    <span class=\"input-group-addon\" style=\"width: 300px\"><input type=\"text\" id=\"result22\"class=\"form-control\" placeholder=\"输入分数\" value=64></span>\n" +
        "                    <span class=\"input-group-addon\">批改日期:2019-03-27 22:52:55</span>\n" +
        "                    <span class=\"input-group-addon\">  <button type=\"button\" class=\"btn btn-primary\" >\n" +
        "                        评分细则\n" +
        "                    </button></span>\n" +
        "\n" +
        "                </div>\n" +
        "                <div class=\"input-group\">\n" +
        "                    <span class=\"input-group-addon\">实验创新性</span>\n" +
        "                    <span class=\"input-group-addon\" >64</span>\n" +
        "\n" +
        "                    <textarea id=\"memo22\" rows=\"4\" class=\"form-control\" placeholder=\"输入评价\">1. 考试及成绩管理流程图源码正确，图片不清晰，\n" +
        "流程说明太简单。32分。\n" +
        "2. 客户维修服务流程图源码正确，图片不清晰，\n" +
        "流程说明太简单。32分。</textarea>\n" +
        "                </div>\n" +
        "                <div class=\"input-group\">\n" +
        "                    <span class=\"input-group-addon\">实验准确度</span>\n" +
        "                    <span class=\"input-group-addon\" >64</span>\n" +
        "\n" +
        "                    <textarea id=\"memo32\" rows=\"4\" class=\"form-control\" placeholder=\"输入评价\">1. 考试及成绩管理流程图源码正确，图片不清晰，\n" +
        "流程说明太简单。32分。\n" +
        "2. 客户维修服务流程图源码正确，图片不清晰，\n" +
        "流程说明太简单。32分。</textarea>\n" +
        "                </div>\n" +
        "                <div class=\"input-group\">\n" +
        "                    <span class=\"input-group-addon\">实验完整性</span>\n" +
        "                    <span class=\"input-group-addon\" >64</span>\n" +
        "\n" +
        "                    <textarea id=\"memo42\" rows=\"4\" class=\"form-control\" placeholder=\"输入评价\">1. 考试及成绩管理流程图源码正确，图片不清晰，\n" +
        "流程说明太简单。32分。\n" +
        "2. 客户维修服务流程图源码正确，图片不清晰，\n" +
        "流程说明太简单。32分。</textarea>\n" +
        "                </div>");
    tdcontent.appendTo(td);
}

