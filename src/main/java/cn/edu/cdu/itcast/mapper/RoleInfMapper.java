package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.RoleInf;
import cn.edu.cdu.itcast.po.RoleInfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleInfMapper {
    int countByExample(RoleInfExample example);

    int deleteByExample(RoleInfExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(RoleInf record);

    int insertSelective(RoleInf record);

    List<RoleInf> selectByExample(RoleInfExample example);

    RoleInf selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") RoleInf record, @Param("example") RoleInfExample example);

    int updateByExample(@Param("record") RoleInf record, @Param("example") RoleInfExample example);

    int updateByPrimaryKeySelective(RoleInf record);

    int updateByPrimaryKey(RoleInf record);
}