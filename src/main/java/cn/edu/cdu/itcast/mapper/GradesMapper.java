package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.CheckScores;
import cn.edu.cdu.itcast.po.Grades;
import cn.edu.cdu.itcast.po.GradesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GradesMapper {
    int countByExample(GradesExample example);

    int deleteByExample(GradesExample example);

    int deleteByPrimaryKey(Integer gradeId);

    int insert(Grades record);

    int insertSelective(Grades record);

    List<Grades> selectByExample(GradesExample example);

    Grades selectByPrimaryKey(Integer gradeId);

    int updateByExampleSelective(@Param("record") Grades record, @Param("example") GradesExample example);

    int updateByExample(@Param("record") Grades record, @Param("example") GradesExample example);

    int updateByPrimaryKeySelective(Grades record);

    int updateByPrimaryKey(Grades record);
//       <select id="getSmallScores" parameterType="Map" resultMap="checkScoreResultMap">
    List<CheckScores> getSmallScores(Map<String,Object> map);

}