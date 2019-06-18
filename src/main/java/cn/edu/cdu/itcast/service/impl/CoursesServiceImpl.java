package cn.edu.cdu.itcast.service.impl;

import cn.edu.cdu.itcast.mapper.CoursesMapper;
import cn.edu.cdu.itcast.mapper.PageInfMapper;
import cn.edu.cdu.itcast.mapper.StudentSelectCourseMapper;
import cn.edu.cdu.itcast.po.Courses;
import cn.edu.cdu.itcast.po.StudentSelectCourse;
import cn.edu.cdu.itcast.service.CoursesService;
import cn.edu.cdu.itcast.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private CoursesMapper coursesMapper;
    @Autowired
    private PageInfMapper pageInfMapper;
    @Override
    public List<Courses> getSelectedCourses(int userInfoId) {

        return coursesMapper.getSelectedCourses(userInfoId);

    }

    @Override
    public List<Courses> getUnSelectedCourses(int teacherId) {
       return coursesMapper.getUnSelectedCourses(teacherId);
    }

    @Override
    public R submitChoose(int courseId,int teacherId) {
            Courses courses=new Courses();
            courses.setCourseId(courseId);
            courses.setTeacherId(teacherId);
            coursesMapper.updateByPrimaryKeySelective(courses);
            return R.ok();
    }

    @Override
    public R deleteCourses(int[] courseIds) {
        coursesMapper.deleteBatch(courseIds);
        return R.ok();
    }

    @Override
    public List<Courses> querySelectedCourses(int studentId) {
        return coursesMapper.querySelectedCourses(studentId);
    }
@Autowired
private StudentSelectCourseMapper studentSelectCourseMapper;
    @Override
    public R studentSelectCourseSubmit(int studentId, int courseId) {
        StudentSelectCourse studentSelectCourse=new StudentSelectCourse();
        studentSelectCourse.setCourseId(courseId);
        studentSelectCourse.setStudentId(studentId);
        studentSelectCourseMapper.insertSelective(studentSelectCourse);
        return R.ok();
    }

    @Override
    public R stuDeleteCourses(int[] stuSelectedCourseIds) {
        coursesMapper.stuDeleteCourses(stuSelectedCourseIds);
        return R.ok();
    }

    @Override
    public List<Courses> getStudentSelected(int courseId) {
        return coursesMapper.getStudentSelected(courseId);
    }


}
