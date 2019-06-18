
$(function(){
    $('#selectedCoursesTable').bootstrapTable({
        url: '/student/querySelectedCourses',
        method: 'post',
        showRefresh: true,  //显示刷新按钮
        search: true,
        toolbar:'#toolbar',
        striped : true,     //设置为true会有隔行变色效果
        //sidePagination:'server',//服务器端分页默认接受rows和total
        pagination:true,//客户端分页
        sidePagination:'client',
        idFiled:'studentSelectCourseId',
        pageNumber:1,
        pageSize:10,
        columns: [
            {
                field: 'checkId',
                checkbox:true,
                clickToSelect:true,
            }, {
                field: 'studentSelectCourseId',
                title: '选课编号',
                visible:false

            },{
                field: 'courseId',
                title: '课程编号'
            }
            , {
                field: 'courseName',
                title: '课程名'
            },{
                field: 'name',
                title: '教师名'
            }]
    });
});

var vm = new Vue({
    el:'#studentSelectCourse',
    data:{
        showList:1,
        title:'',
        //选课弹窗需要字段
        teacherName:'',


    },
    methods: {
        //***start选课的方法***
        //选课按钮
        add: function () {
            // 弹出选课对话框
            $('#selectCourseDialog').modal("show");
            //回显回显下拉框
            $("#courseName").empty();
            var optionName="请点击选择课程";
            $.ajax({
                type: "POST",
                url: "/student/CoursesSelectedByAnyTeacher",
                success: function (result) {
                    var data = result.coursesSelected;
                    if (result.code == 0) {
                        $("#courseName").append("<option value=" + "prompt" + ">" + optionName + "</option>")

                        for (var i = 0; i < data.length; i++) {
                            $("#courseName").append("<option value=" + data[i]['courseId'] + ">" + data[i]['courseName'] + "</option>")
                        }

                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
            var courseId;
            //回显教师姓名
            //下拉框点击事件
            $("#courseName").change(function(){
              courseId = $("#courseName option:selected").val();
              if (courseId=="prompt"){//选中了提示的option
                  vm.teacherName=null
                  return
              }
            $.ajax({
                type: "POST",//post方法默认是表单数据提交，用requestParameter接收，如果要用jason需要配置在conmmon.js中的第一行有配置
                url: "/sys/getTeacherByCourseId",
                data: JSON.stringify(courseId),//参数

                success: function (result) {

                    if (result.code == 0) {

                        vm.teacherName = result.userInf.name;

                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
            })},
        // 选课提交按钮
        submit: function () {
            //获取下拉列表所选的value
            var courseId = $("#courseName option:selected").val();
            if (courseId=="prompt") {//选中了提示的option
                layer.alert('请至少选择一项课程');
                vm.teacherName=null
                return
            }
            $.ajax({
                type: "POST",//post方法默认是表单数据提交，用requestParameter接收，如果要用jason需要配置在conmmon.js中的第一行有配置
                url: '/student/studentSelectCourseSubmit',//请求的controller
                data: JSON.stringify(courseId),//参数
                success: function (r) {
                    if (r.code === 0) {
                        layer.alert('选课成功');
                        //删除下拉框中当前选中的元素
                        $("#courseName option:selected").remove();
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
                        ids[i] = row['studentSelectCourseId'];
                    });
console.log(ids);
                    $.ajax({
                        type: "POST",
                        url: "/student/stuDeleteCourse",
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

