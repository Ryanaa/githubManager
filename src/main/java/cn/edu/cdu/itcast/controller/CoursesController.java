package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.po.Courses;
import cn.edu.cdu.itcast.service.CoursesService;
import cn.edu.cdu.itcast.utils.R;
import cn.edu.cdu.itcast.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CoursesController {
    @Autowired
    private CoursesService coursesService;
    //选课start
    @ResponseBody
    @PostMapping("/teacher/getSelectedCourses")
    public Object getSelectedCourse(){
    List<Courses> selectedCourses = coursesService.getSelectedCourses(ShiroUtils.getUserId());
        System.out.println(ShiroUtils.getUserId());

     return selectedCourses;
}
    @ResponseBody
    @PostMapping("/teacher/getUnSelectedCourses")
    public R getUnSelectedCourses(){
        List<Courses> unSelectedCourses = coursesService.getUnSelectedCourses(ShiroUtils.getUserId());
        return  R.ok().put("unSelectedCourses",unSelectedCourses);
    }
    @ResponseBody
    @PostMapping("/teacher/submitChoose")
    public R submitChoose(@RequestBody int courseId){
     return   coursesService.submitChoose(courseId,ShiroUtils.getUserId());
    }
    @ResponseBody
    @PostMapping("/teacher/deleteCourses")
    public R deleteCorses(@RequestBody int[] courseIds){
        return coursesService.deleteCourses(courseIds);
    }
//当前学生所选课程
    @ResponseBody
    @PostMapping("/student/querySelectedCourses")
    public List<Courses> querySelectedCourses(){
    return coursesService.querySelectedCourses(ShiroUtils.getUserId());
   }
   //已经被老师选的课程
    @ResponseBody
    @PostMapping("/student/CoursesSelectedByAnyTeacher")
    public R coursesSelectedByAnyTeacher(){
        List<Courses> selectedCourses = coursesService.getSelectedCourses(0);
     return    R.ok().put("coursesSelected",selectedCourses);
    }
    //学生选课提交按钮
    @ResponseBody
    @PostMapping("/student/studentSelectCourseSubmit")
    public R studentSelectCourseSubmit(@RequestBody int courseId){
        return coursesService.studentSelectCourseSubmit(ShiroUtils.getUserId(),courseId);
    }
    @ResponseBody
    @PostMapping("/student/stuDeleteCourse")
    public R stuDeleteCourse(@RequestBody int[] stuSelectedCourseId){
        return coursesService.stuDeleteCourses(stuSelectedCourseId);
    }
    //选课end
    //打分start
    @ResponseBody
    @GetMapping("/teacher/getStudentSelected")
    public List<Courses> getStudentSelected(int courseId){
        return coursesService.getStudentSelected(courseId);
    }
    //打分end
}