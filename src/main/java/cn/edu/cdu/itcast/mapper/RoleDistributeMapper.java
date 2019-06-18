package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.RoleDistribute;
import cn.edu.cdu.itcast.po.RoleDistributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDistributeMapper {
    int countByExample(RoleDistributeExample example);

    int deleteByExample(RoleDistributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleDistribute record);

    int insertSelective(RoleDistribute record);

    List<RoleDistribute> selectByExample(RoleDistributeExample example);

    RoleDistribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleDistribute record, @Param("example") RoleDistributeExample example);

    int updateByExample(@Param("record") RoleDistribute record, @Param("example") RoleDistributeExample example);

    int updateByPrimaryKeySelective(RoleDistribute record);

    int updateByPrimaryKey(RoleDistribute record);
}