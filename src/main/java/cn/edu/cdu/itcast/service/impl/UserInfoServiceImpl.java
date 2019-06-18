package cn.edu.cdu.itcast.service.impl;

import cn.edu.cdu.itcast.mapper.UserInfMapper;
import cn.edu.cdu.itcast.po.UserInf;
import cn.edu.cdu.itcast.po.UserInfExample;
import cn.edu.cdu.itcast.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfMapper userInfMapper;

    /**
     * 通过userid查出整条用户信息
     * @param userid
     * @return 整条用户信息
     */
    @Override
    public UserInf getUserById(String userid) {
        UserInfExample userInfExample=new UserInfExample();
        UserInfExample.Criteria criteria=   userInfExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        UserInf userInf=   userInfMapper.selectByExample(userInfExample).get(0);
        return userInf;
    }

    @Override
    public UserInf getTeacherByCourseId(int courseId) {

        return userInfMapper.getTeacherByCourseId(courseId);
    }
}
