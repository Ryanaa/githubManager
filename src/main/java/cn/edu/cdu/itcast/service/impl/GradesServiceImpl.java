package cn.edu.cdu.itcast.service.impl;

import cn.edu.cdu.itcast.mapper.GradesMapper;
import cn.edu.cdu.itcast.mapper.StudentDoTestMapper;
import cn.edu.cdu.itcast.po.CheckScores;
import cn.edu.cdu.itcast.po.Grades;
import cn.edu.cdu.itcast.po.StudentDoTest;
import cn.edu.cdu.itcast.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradesServiceImpl implements GradesService {
    @Autowired
    private GradesMapper gradesMapper;
    @Autowired
    private StudentDoTestMapper studentDoTestMapper;
    @Override
    public int insertIntoStuDoTest(StudentDoTest studentDoTest) {
        //插入做实验表
        studentDoTestMapper.insertDoTest(studentDoTest);
        System.out.println("444"+studentDoTest.getStudentDoTestId());
        return studentDoTest.getStudentDoTestId();
    }

    @Override
    public void insertIntoGrades(List<Grades> gradesList) {
        //插入分数表
        for (Grades grade: gradesList) {
            gradesMapper.insert(grade);
        }
    }

    @Override
    public List<CheckScores> getSmallScores(Map<String, Object> map) {
        return gradesMapper.getSmallScores(map);

    }

}
