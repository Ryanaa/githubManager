package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.po.CheckScores;
import cn.edu.cdu.itcast.po.Grades;
import cn.edu.cdu.itcast.po.StudentDoTest;
import cn.edu.cdu.itcast.service.GradesService;
import cn.edu.cdu.itcast.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GradesController {
@Autowired
   private GradesService gradesService;
    @ResponseBody
    @PostMapping("/grades/insertScores")
    R insertScores(@RequestBody Map<String,String> scores){

        StudentDoTest studentDoTest=new StudentDoTest();
        Grades grades=new Grades();
        studentDoTest.setStudentSelectCourseId(Integer.valueOf(scores.get("studentSelectCourseId")));
        studentDoTest.setTestId(Integer.valueOf(scores.get("testId")));
      int studentDoTestId =gradesService.insertIntoStuDoTest(studentDoTest);
        List<Grades> gradesList=new ArrayList<>();
        Grades grade1=new Grades();
        grade1.setResult(Integer.valueOf(scores.get("smallScore1")));
        grade1.setMemo(scores.get("memo1"));
        grade1.setStudentDoTestId(studentDoTestId);
        gradesList.add(grade1);

        Grades grade2=new Grades();
        grade2.setResult(Integer.valueOf(scores.get("smallScore2")));
        grade2.setMemo(scores.get("memo2"));

         grade2.setStudentDoTestId(studentDoTestId);

        gradesList.add(grade2);
        Grades grade3=new Grades();
        grade3.setResult(Integer.valueOf(scores.get("smallScore3")));
        grade3.setMemo(scores.get("memo3"));

         grade3.setStudentDoTestId(studentDoTestId);
        gradesList.add(grade3);
          gradesService.insertIntoGrades(gradesList);
        return R.ok();
   }
    @ResponseBody
    @PostMapping("/grades/getSmallScores")
        List<CheckScores> getSmallScores(@RequestBody Map<String,Object> map){
         int courseId=  Integer.parseInt(String.valueOf(map.get("courseId")));
            map.put("courseId",courseId);
        return gradesService.getSmallScores(map);

    }

}
