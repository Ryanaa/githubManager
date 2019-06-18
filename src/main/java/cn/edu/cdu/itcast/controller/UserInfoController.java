package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.service.UserInfoService;
import cn.edu.cdu.itcast.utils.R;
import cn.edu.cdu.itcast.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController {
    @ResponseBody
    @GetMapping ("/sys/getUser")
    public R getUser(){
     return R.ok().put("userInf",ShiroUtils.getUserEntity());
    }
    @Autowired
    private UserInfoService userInfoService;
    @ResponseBody
    @PostMapping("/sys/getTeacherByCourseId")
    public R getTeacherByCourseId(@RequestBody Integer courseId){
        return R.ok().put("userInf",userInfoService.getTeacherByCourseId(courseId));
    }
}
