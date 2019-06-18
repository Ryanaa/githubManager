package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.po.Tests;
import cn.edu.cdu.itcast.service.TestsService;
import cn.edu.cdu.itcast.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestsController {
    @Autowired
    private TestsService testsService;
    @ResponseBody
    @GetMapping("/tests/getTestByCourseId")
        public List<Tests> getTestByCourseId(int courseId){
        List<Tests> testsByCourseId = testsService.getTestsByCourseId(courseId);
        return testsByCourseId;
}
    @ResponseBody
    @PostMapping("/tests/insertTest")
    public R insertTest(@RequestBody Tests test){
        return testsService.insertTest(test);
    }
    @ResponseBody
    @PostMapping("/tests/deleteTests")
    public R insertTest(@RequestBody int[] testId){
        return testsService.deleteTests(testId);
    }
}
