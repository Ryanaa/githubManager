package cn.edu.cdu.itcast.service.impl;

import cn.edu.cdu.itcast.mapper.TestsMapper;
import cn.edu.cdu.itcast.po.Tests;
import cn.edu.cdu.itcast.service.TestsService;
import cn.edu.cdu.itcast.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestsServiceImpl implements TestsService {
    @Autowired
    private TestsMapper testsMapper;
    @Override
    public List<Tests> getTestsByCourseId(int courseId) {

        return testsMapper.getTestsByCourseId(courseId);
    }

    @Override
    public R insertTest(Tests test) {
        testsMapper.insert(test);
        return R.ok();
    }

    @Override
    public R deleteTests( int[] testId) {
        testsMapper.deleteTests(testId);
        return R.ok();
    }
}
