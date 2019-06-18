package cn.edu.cdu.itcast.service;

import cn.edu.cdu.itcast.po.PageInf;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface PageInfService {
    public Set<String> getUserPermissions(String userid);//通过userid获取当前所有的权限
    public Set<String> getUserRoles(String userid);//通过userid获取当前所有的角色
    List<Integer> getUserPageIds(String userid);//通过userid获取当前所有的页面
    List<PageInf> getPagesByParentId(int parentId,List<Integer> pageIdList );//通过parentId获取当前所有的页面
    void getPageTreeList(List<PageInf> pageInfs,List<Integer> pageIdList);
    List<PageInf> getAllPageList(List<Integer> pageIdList);
    List<PageInf> getUserMenuList(String userid);
}
