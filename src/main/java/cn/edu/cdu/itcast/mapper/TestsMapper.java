package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.Tests;
import cn.edu.cdu.itcast.po.TestsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestsMapper {
    int countByExample(TestsExample example);

    int deleteByExample(TestsExample example);

    int deleteByPrimaryKey(Integer testId);

    int insert(Tests record);

    int insertSelective(Tests record);

    List<Tests> selectByExample(TestsExample example);

    Tests selectByPrimaryKey(Integer testId);

    int updateByExampleSelective(@Param("record") Tests record, @Param("example") TestsExample example);

    int updateByExample(@Param("record") Tests record, @Param("example") TestsExample example);

    int updateByPrimaryKeySelective(Tests record);

    int updateByPrimaryKey(Tests record);
    // <select id="getTestsByCourseId" parameterType="int" resultType="cn.edu.cdu.itcast.po.Tests">
    List<Tests> getTestsByCourseId(int courseId);
//      <delete id="deleteTests">
    int deleteTests(int[] testId);
//      <select id="selectTestByCourseId" parameterType="int" resultType="cn.edu.cdu.itcast.po.Tests">
    List<Tests> selectTestByCourseId(int courseId);
}