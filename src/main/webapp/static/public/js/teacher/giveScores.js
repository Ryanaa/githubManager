var courseId;
$.ajax({
    type: "POST",
    url: "/teacher/getSelectedCourses",
    success: function (result) {

        var data = result;
        if (true) {
            for (var i = 0; i < data.length; i++) {
                $("#myCourseName").append("<option value=" + data[i]['courseId'] + ">" + data[i]['courseName'] + "</option>")
            }
           courseId = $("#myCourseName option:selected").val();
            drawTable(courseId);
        } else {
            layer.alert(result.msg);
        }
        $("#myCourseName").change(function(){
            $('#selectedCoursesTable').bootstrapTable('destroy');//先销毁表格，不然不会刷信

            courseId = $("#myCourseName option:selected").val();
            drawTable(courseId);
        });
    }
});
console.log()
var vm = new Vue({
    el:'#teacherSelectCourse',
    data:{
        showList:1,
        title:'',
        //打分弹窗需要字段

        scores:{
            testId:'',
            studentSelectCourseId:'',
            studentDoTestId:'',
            teacherName:'',
            studentName:'',
            smallScore1:'',
            memo1:'',
            smallScore2:'',
            memo2:'',
            smallScore3:'',
            memo3:'',},


    },
    methods: {
        //***start打分方法***
        //选课按钮
        add: function () {
            var row = $("#selectedCoursesTable").bootstrapTable('getSelections');

            if (row.length == 0) {
                layer.alert('请选择一条记录');
                return;
            }else if(row.length > 1){
                layer.alert("只能选择一条记录");
                return ;
            }else {
            // 弹出打分对话框
            $('#selectCourseDialog').modal("show");
            //回显实验下拉框
            $("#testName").empty();
            $.ajax({
                type: "GET",
                url: "/tests/getTestByCourseId",
                data: 'courseId='+courseId,//参数
                success: function (result) {
                    var data = result;
                    if (true) {
                        for (var i = 0; i < data.length; i++) {
                            $("#testName").append("<option value=" + data[i]['testId'] + ">" + data[i]['title'] + "</option>")
                        }

                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
            //回显教师姓名
            $.ajax({
                type: "GET",
                url: "/sys/getUser",
                success: function (result) {

                    if (result.code == 0) {

                        vm.scores.teacherName = result.userInf.name;

                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
            //回显学生名
              vm.scores.studentName=row[0].name;
        }},
        // 选课提交按钮
        submit: function () {
            //获取下拉列表所选的value(插入做实验表)
            vm.scores.testId = $("#testName option:selected").val();
            //选课id(插入作实验表)
            var row = $("#selectedCoursesTable").bootstrapTable('getSelections');
            vm.scores.studentSelectCourseId=row[0].studentSelectCourseId;

            if(vm.scores.smallScore1==""||vm.scores.smallScore2==""||vm.scores.smallScore3==""){
                layer.alert("分数不能为空");
                return;
            }
            //（插入分数表）

            $.ajax({
                type: "POST",//post方法默认是表单数据提交，用requestParameter接收，如果要用jason需要配置在conmmon.js中的第一行有配置
                url: '/grades/insertScores',//请求的controller
                data: JSON.stringify(vm.scores),//参数
                success: function (r) {
                    if (r.code === 0) {
                        layer.alert('提交成功');
                        //删除下拉框中当前选中的元素
                        $("#testName option:selected").remove();
                        //更新表格
                        $('#selectedCoursesTable').bootstrapTable('refresh');
                    }
                },
                error: function () {
                    layer.alert('服务器没有返回数据，可能服务器忙，请重试');
                }
            });
        },
        //退选
        del: function () {
            var rows = $("#selectedCoursesTable").bootstrapTable('getSelections');

            if (rows.length == 0) {
                layer.alert('请选择至少一条记录');
                return;
             } else {
                layer.confirm('您确定退选所选的课吗？', {
                    btn: ['确定', '取消'] //可以无限个按钮
                }, function(index, layero){
                    var ids = new Array();
                    //遍历所有选择的行数据，取每条数据对应的ID
                    $.each(rows, function(i, row) {
                        ids[i] = row['courseId'];
                    });

                    $.ajax({
                        type: "POST",
                        url: "/teacher/deleteCourses",
                        data: JSON.stringify(ids),
                        success : function(r) {
                            if(r.code === 0){
                                layer.alert('退选成功');
                                $('#selectedCoursesTable').bootstrapTable('refresh');
                            }else{
                                layer.alert(r.msg);
                            }
                        },
                        error : function() {
                            layer.alert('服务器没有返回数据，可能服务器忙，请重试');
                        }
                    });
                });
            }
        },
        //***end选课的方法***


}
        //***end实验的方法***

})

function drawTable(courseId) {
console.log(courseId);
    $(function(){
        $('#selectedCoursesTable').bootstrapTable({
            url: '/teacher/getStudentSelected',
            method: 'get',
            queryParams:function(params) {
                return {
                    courseId:courseId
                };

            },
            showRefresh: true,  //显示刷新按钮
            search: true,
            toolbar:'#toolbar',
            striped : true,     //设置为true会有隔行变色效果
            //sidePagination:'server',//服务器端分页默认接受rows和total
            pagination:true,//客户端分页
            sidePagination:'client',
            idField: 'courseId',
            pageNumber:1,
            pageSize:10,
            columns: [
                {
                    field: 'checkId',
                    checkbox:true,
                    clickToSelect:true,
                }, {
                    field: 'studentId',
                    title: '学生编号'
                }, {
                    field: 'courseName',
                    title: '课程名'
                },{
                    field: 'name',
                    title: '学生名'
                }
                ,{
                    field: 'studentSelectCourseId',
                    title: '选课Id',
                    visible:false
                }
                ]
        });
    });
}

