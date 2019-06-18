package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.po.PageInf;
import cn.edu.cdu.itcast.service.PageInfService;
import cn.edu.cdu.itcast.utils.R;
import cn.edu.cdu.itcast.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysPageController{
@Autowired
private PageInfService pageInfService;
@GetMapping("/getPageList")
    public R user(){
    String username= ShiroUtils.getUserEntity().getUserid();
    List<PageInf> userMenuList = pageInfService.getUserMenuList(username);
    return R.ok().put("menuList", userMenuList).put("permissions", userMenuList);
}
}
