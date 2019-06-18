package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.StudentSelectCourse;
import cn.edu.cdu.itcast.po.StudentSelectCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentSelectCourseMapper {
    int countByExample(StudentSelectCourseExample example);

    int deleteByExample(StudentSelectCourseExample example);

    int deleteByPrimaryKey(Integer studentSelectCourseId);

    int insert(StudentSelectCourse record);

    int insertSelective(StudentSelectCourse record);

    List<StudentSelectCourse> selectByExample(StudentSelectCourseExample example);

    StudentSelectCourse selectByPrimaryKey(Integer studentSelectCourseId);

    int updateByExampleSelective(@Param("record") StudentSelectCourse record, @Param("example") StudentSelectCourseExample example);

    int updateByExample(@Param("record") StudentSelectCourse record, @Param("example") StudentSelectCourseExample example);

    int updateByPrimaryKeySelective(StudentSelectCourse record);

    int updateByPrimaryKey(StudentSelectCourse record);
}