package cn.edu.cdu.itcast.service.impl;

import cn.edu.cdu.itcast.mapper.PageInfMapper;
import cn.edu.cdu.itcast.po.PageInf;
import cn.edu.cdu.itcast.service.PageInfService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PageInfServiceImpl implements PageInfService {

    @Autowired
    private PageInfMapper pageInfMapper;

    /**
     * 获得所有controller，并且用集合装起来
     * @param userid
     * @return
     */
    @Override
    public Set<String> getUserPermissions(String userid) {
        Set<String> permsSet=new HashSet<String>();
        List<String> permsList;
        //查出关联的id

     int userInfoId=   pageInfMapper.queryIdByUserId(userid);

        //超级用户授权userInfoId=1的用户为超级管理员
        if(userInfoId==1){
            permsList =  pageInfMapper.queryAllPerms(1);

        }else {
            //普通用户授权
            permsList= pageInfMapper.queryAllPerms(userInfoId);
        }


        for (String perm :permsList){
            if (StringUtils.isBlank(perm)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public Set<String> getUserRoles(String userid) {
        Set<String> rolesSet=new HashSet<String>();
        List<String>rolesList;
        //查出关联的id

        int userInfoId=   pageInfMapper.queryIdByUserId(userid);

        //超级用户授权userInfoId=1的用户为超级管理员
       rolesList= pageInfMapper.queryAllRoles(userInfoId);


        for (String role :rolesList){
            if (StringUtils.isBlank(role)){
                continue;
            }
            rolesSet.addAll(Arrays.asList(role.trim().split(",")));
        }
        return rolesSet;
    }

    @Override
    public List<Integer> getUserPageIds(String userid) {
        int userInfoId=   pageInfMapper.queryIdByUserId(userid);
        return  pageInfMapper.getAllPageIds(userInfoId);

    }

    @Override
    public List<PageInf> getPagesByParentId(int parentId,List<Integer> pageIdList) {
        List<PageInf> pageInfList = pageInfMapper.getPagesByParentId(parentId);
        if (pageIdList==null){//递归退出条件
            //没传用户所拥有的权限id，说明拥有此菜单的所有子菜单
            return  pageInfList;
        }
        //过滤的到用户当前的拥有的子菜单
        List<PageInf> authorityPage=new ArrayList<>();
        for (PageInf pageInf: pageInfList){
            //传过来的权限id里面包含了当前子菜单
            if (pageIdList.contains(pageInf.getPageid())){
                authorityPage.add(pageInf);
            }
        }
        return authorityPage;
    }

    @Override
    public void getPageTreeList(List<PageInf> pageInfs, List<Integer> pageIdList) {
        for(PageInf pageInf:pageInfs){
            List<PageInf> subPageList = getPagesByParentId(pageInf.getPageid(), pageIdList);
            getPageTreeList(subPageList,pageIdList);
            pageInf.setPageInfList(subPageList);
        }
    }
    @Override
    public List<PageInf> getAllPageList(List<Integer> pageIdList){
        List<PageInf> pageList = getPagesByParentId(0, pageIdList);//顶层菜单
        getPageTreeList(pageList,pageIdList);
        return pageList;

    }
    @Override
    public List<PageInf> getUserMenuList(String userid){//当前用户有权限的菜单列表
        int userInfoId=   pageInfMapper.queryIdByUserId(userid);
        if (userInfoId==1){
            return getAllPageList(null);
        }
        List<Integer> userPageIds = getUserPageIds(userid);
        return getAllPageList(userPageIds);
    }
}
