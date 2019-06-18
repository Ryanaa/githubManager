package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.UserInf;
import cn.edu.cdu.itcast.po.UserInfExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfMapper {
    int countByExample(UserInfExample example);

    int deleteByExample(UserInfExample example);

    int deleteByPrimaryKey(Integer userInfoId);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    List<UserInf> selectByExample(UserInfExample example);

    UserInf selectByPrimaryKey(Integer userInfoId);

    int updateByExampleSelective(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByExample(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);
//通过courseId查询teacher      <select id="getTeacherByCourseId" parameterType="int">
    UserInf getTeacherByCourseId(int courseId);
}

