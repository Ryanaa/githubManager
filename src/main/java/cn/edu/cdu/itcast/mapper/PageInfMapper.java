package cn.edu.cdu.itcast.mapper;

import cn.edu.cdu.itcast.po.PageInf;
import cn.edu.cdu.itcast.po.PageInfExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PageInfMapper {
    int countByExample(PageInfExample example);

    int deleteByExample(PageInfExample example);

    int deleteByPrimaryKey(Integer pageid);

    int insert(PageInf record);

    int insertSelective(PageInf record);

    List<PageInf> selectByExample(PageInfExample example);

    PageInf selectByPrimaryKey(Integer pageid);

    int updateByExampleSelective(@Param("record") PageInf record, @Param("example") PageInfExample example);

    int updateByExample(@Param("record") PageInf record, @Param("example") PageInfExample example);

    int updateByPrimaryKeySelective(PageInf record);

    int updateByPrimaryKey(PageInf record);

    //     <select id="queryIdByUserId" resultType="int" parameterType="String">
    int queryIdByUserId(String userid);
//    <select id="queryAllPerms" resultType="String" parameterType="String">
    List<String> queryAllPerms(int userInfoId);
//  <select id="queryAllRoles" resultType="String" parameterType="int">
    List<String> queryAllRoles(int userInfoId);
//<select id="getAllPageIds" resultType="int" parameterType="int">
    List<Integer> getAllPageIds(int userInfoId);
//      <select id="getPagesByParentId" resultType="cn.edu.cdu.itcast.po.PageInf" parameterType="int">
    List<PageInf> getPagesByParentId(int parentId);
}