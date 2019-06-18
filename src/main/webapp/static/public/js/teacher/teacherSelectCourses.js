
$(function(){
    $('#selectedCoursesTable').bootstrapTable({
        url: '/teacher/getSelectedCourses',
        method: 'post',
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
                field: 'courseId',
                title: '课程编号'
            }, {
                field: 'courseName',
                title: '课程名'
            },{
                field: 'name',
                title: '教师名'
            },{
                field: 'semesterId',
                title: '学期'
            }]
    });
});

var vm = new Vue({
    el:'#teacherSelectCourse',
    data:{
        showList:1,
        title:'',
        //选课弹窗需要字段
        teacherName:'',
        //tests表需要展示字段
        tests:{courseId:'',title:'',testDesc:''}

    },
    methods: {
        //***start选课的方法***
        //选课按钮
        add: function () {
            // 弹出选课对话框
            $('#selectCourseDialog').modal("show");
            //回显回显下拉框
            $("#courseName").empty();
            $.ajax({
                type: "POST",
                url: "/teacher/getUnSelectedCourses",
                success: function (result) {
                    var data = result.unSelectedCourses;
                    if (result.code == 0) {
                        for (var i = 0; i < data.length; i++) {
                            $("#courseName").append("<option value=" + data[i]['courseId'] + ">" + data[i]['courseName'] + "</option>")
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

                        vm.teacherName = result.userInf.name;

                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
        },
        // 选课提交按钮
        submit: function () {
            //获取下拉列表所选的value
            var courseId = $("#courseName option:selected").val();
            $.ajax({
                type: "POST",//post方法默认是表单数据提交，用requestParameter接收，如果要用jason需要配置在conmmon.js中的第一行有配置
                url: '/teacher/submitChoose',//请求的controller
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

        //***start实验的方法***
        //查询所有实验
        testManage: function () {
            var row = $("#selectedCoursesTable").bootstrapTable('getSelections');
            if (row.length == 0) {
                layer.alert('请选择一条记录');
                return;
            }else if(row.length > 1){
                layer.alert("只能选择一条记录");
                return ;
            }else {
                $('#testManageTable').bootstrapTable('destroy');//先销毁表格，不然不会刷信
                var selectedId= row[0].courseId;
                //通过所选的id去查询出当前已经添加的实验
                $(function(){
                    $('#testManageTable').bootstrapTable({
                        url: '/tests/getTestByCourseId',
                        method:'get',
                        queryParams:function(params) {
                            return {
                                courseId:selectedId
                            };

                        },
                        showRefresh: true,  //显示刷新按钮
                        search: true,
                        toolbar:'#toolbar2',
                        striped : true,     //设置为true会有隔行变色效果
                        //sidePagination:'server',//服务器端分页默认接受rows和total
                        pagination:true,//客户端分页
                        sidePagination:'client',
                        pageNumber:1,
                        pageSize:10,
                        columns: [
                            {
                                field: 'checkId',
                                checkbox:true,
                                clickToSelect:true,
                            }, {
                                field: 'courseId',
                                title: '课程编号'
                            }, {
                                field: 'courseName',
                                title: '课程名'
                            },{
                                field: 'testId',
                                title: '实验编号'
                            },{
                                field: 'title',
                                title: '名称'
                            },{
                                field: 'testDesc',
                                title: '实验内容'
                            }]
                    });
                });
            }
            vm.showList=2;
        },
        //新增实验
        addTest: function () {
            // 弹出新增实验弹窗
            $('#addTestDialog').modal("show");
            //得到上层选课程时候的courseId
            var row = $("#selectedCoursesTable").bootstrapTable('getSelections');
            vm.tests.courseId= row[0].courseId;
        },
        //提交新增实验按钮
        submitAddTest: function(){
            $.ajax({
                type: "POST",//post方法默认是表单数据提交，用requestParameter接收，如果要用jason需要配置在conmmon.js中的第一行有配置
                url: '/tests/insertTest',//请求的controller
                data: JSON.stringify(vm.tests),//参数
                success: function (r) {
                    if (r.code === 0) {
                        layer.alert('添加成功')
                        //更新表格
                        $('#testManageTable').bootstrapTable('refresh');
                    }
                },
                error: function () {
                    layer.alert('服务器没有返回数据，可能服务器忙，请重试');
                }
            });
        },
        //删除实验
        delTest:function () {
            var rows = $("#testManageTable").bootstrapTable('getSelections');

            if (rows.length == 0) {
                layer.alert('请选择至少一条记录');
                return;
            } else {
                layer.confirm('您确定要删除所选实验吗？', {
                    btn: ['确定', '取消'] //可以无限个按钮
                }, function(index, layero){
                    var ids = new Array();
                    //遍历所有选择的行数据，取每条数据对应的ID
                    $.each(rows, function(i, row) {
                        ids[i] = row['testId'];
                    });

                    $.ajax({
                        type: "POST",
                        url: "/tests/deleteTests",
                        data: JSON.stringify(ids),
                        success : function(r) {
                            if(r.code === 0){
                                layer.alert('删除成功');
                                $('#testManageTable').bootstrapTable('refresh');
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
    //返回课程表
        backToCourse:function () {
            vm.showList=1
        },
}
        //***end实验的方法***

})

