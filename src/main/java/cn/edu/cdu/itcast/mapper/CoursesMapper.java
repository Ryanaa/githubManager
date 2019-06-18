package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.Courses;
import cn.edu.cdu.itcast.po.CoursesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursesMapper {
    int countByExample(CoursesExample example);

    int deleteByExample(CoursesExample example);

    int deleteByPrimaryKey(Integer courseId);

    int insert(Courses record);

    int insertSelective(Courses record);

    List<Courses> selectByExample(CoursesExample example);

    Courses selectByPrimaryKey(Integer courseId);

    int updateByExampleSelective(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByExample(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByPrimaryKeySelective(Courses record);

    int updateByPrimaryKey(Courses record);
//      <select id="getSelectedCourses" parameterType="int" resultType="cn.edu.cdu.itcast.po.Courses" >
    List<Courses> getSelectedCourses(@Param(value = "userInfoId")int userInfoId);
//    <select id="getUnSelectedCourses" parameterType="int" resultType="string" >
    List<Courses> getUnSelectedCourses(int teacherId);
//     <delete id="deleteBatch">
    int deleteBatch(int[] courseId);
//     <select id="querySelectedCourses" resultType="cn.edu.cdu.itcast.po.Courses" >
    List<Courses> querySelectedCourses( int studentId);
//  <delete id="stuDeleteCourses">
    int stuDeleteCourses(int student_select_course_id[]);
// <select id="getStudentSelected" parameterType="int" resultType="cn.edu.cdu.itcast.po.Courses">
    List<Courses> getStudentSelected(int courseId);

}