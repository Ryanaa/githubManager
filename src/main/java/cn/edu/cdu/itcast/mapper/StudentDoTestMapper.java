package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.StudentDoTest;
import cn.edu.cdu.itcast.po.StudentDoTestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDoTestMapper {
    int countByExample(StudentDoTestExample example);

    int deleteByExample(StudentDoTestExample example);

    int deleteByPrimaryKey(Integer studentDoTestId);

    int insert(StudentDoTest record);

    int insertSelective(StudentDoTest record);

    List<StudentDoTest> selectByExample(StudentDoTestExample example);

    StudentDoTest selectByPrimaryKey(Integer studentDoTestId);

    int updateByExampleSelective(@Param("record") StudentDoTest record, @Param("example") StudentDoTestExample example);

    int updateByExample(@Param("record") StudentDoTest record, @Param("example") StudentDoTestExample example);

    int updateByPrimaryKeySelective(StudentDoTest record);

    int updateByPrimaryKey(StudentDoTest record);
//      <insert id="insertDoTest" parameterType="cn.edu.cdu.itcast.po.StudentDoTest">
    int insertDoTest( StudentDoTest record);
}