package cn.edu.cdu.itcast.service;

import cn.edu.cdu.itcast.po.Tests;
import cn.edu.cdu.itcast.utils.R;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsService {
    //通过课程id查询实验
List<Tests> getTestsByCourseId(int courseId);
R insertTest(Tests test);
R deleteTests(int[] testId);

}
