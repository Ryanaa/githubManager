package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.PageDistribute;
import cn.edu.cdu.itcast.po.PageDistributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageDistributeMapper {
    int countByExample(PageDistributeExample example);

    int deleteByExample(PageDistributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageDistribute record);

    int insertSelective(PageDistribute record);

    List<PageDistribute> selectByExample(PageDistributeExample example);

    PageDistribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageDistribute record, @Param("example") PageDistributeExample example);

    int updateByExample(@Param("record") PageDistribute record, @Param("example") PageDistributeExample example);

    int updateByPrimaryKeySelective(PageDistribute record);

    int updateByPrimaryKey(PageDistribute record);
}