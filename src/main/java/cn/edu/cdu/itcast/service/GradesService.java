package cn.edu.cdu.itcast.service;

import cn.edu.cdu.itcast.po.CheckScores;
import cn.edu.cdu.itcast.po.Grades;
import cn.edu.cdu.itcast.po.StudentDoTest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GradesService {
    int  insertIntoStuDoTest(StudentDoTest studentDoTest);
    void insertIntoGrades(List<Grades> gradesList);
    List<CheckScores> getSmallScores(Map<String,Object> map);
}
