package cn.edu.cdu.itcast.service;

import cn.edu.cdu.itcast.po.Courses;
import cn.edu.cdu.itcast.utils.R;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoursesService {
    List<Courses> getSelectedCourses(int userInfoId);
    List<Courses> getUnSelectedCourses(int teacherId);
    R submitChoose(int courseId,int teacherId);
    R deleteCourses(int[] courseIds);
    List<Courses> querySelectedCourses(int studentId);
    R studentSelectCourseSubmit(int studentId,int courseId);
    R stuDeleteCourses(int[] stuSelectedCourseIds);
    List<Courses> getStudentSelected(int courseId);
}
