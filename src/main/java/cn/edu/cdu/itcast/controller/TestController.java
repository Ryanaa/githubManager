package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController{
    @Autowired
    private UserInfoService userInfoService;
@RequestMapping("/getTest/{userTypeId}")
public void getTest(@PathVariable("userTypeId") int userTypeId){

    System.out.println(userInfoService.getUserById("1"));
}

}
