package cn.edu.cdu.itcast.service;

import cn.edu.cdu.itcast.po.UserInf;


public interface UserInfoService {
    public UserInf getUserById(String userid);
            UserInf getTeacherByCourseId(int courseId);
}
