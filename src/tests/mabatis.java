import cn.edu.cdu.itcast.mapper.*;
import cn.edu.cdu.itcast.po.CheckScores;
import cn.edu.cdu.itcast.po.PageInf;
import cn.edu.cdu.itcast.service.PageInfService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mabatis {
    ApplicationContext context=new ClassPathXmlApplicationContext
            ("classpath:spring/applicationContext*.xml");



    @Test
    public void test(){
     PageInfMapper pageInfMapper= (PageInfMapper) context.getBean("pageInfMapper");
     pageInfMapper.getAllPageIds(1);
        System.out.println(pageInfMapper.selectByPrimaryKey(1).getDetail());
        UserInfMapper userInfMapper= (UserInfMapper) context.getBean("userInfMapper");
        System.out.println(userInfMapper.selectByPrimaryKey(1).getGithuburl());;
    }

    @Test
    public void testService(){
       PageInfService pageInfService = (PageInfService) context.getBean("PageInfServiceImpl");
//        List<Integer> havePageId= pageInfService.getUserPageIds("admin");
//        //能够通过parentid，和拥有的权限查出此级菜单所拥有的所有页面
//        List<PageInf> havePages = pageInfService.getPagesByParentId(0, havePageId);
//        pageInfService.getPageTreeList(havePages,havePageId);
//        List<PageInf> allPageList = pageInfService.getAllPageList(havePageId);
        List<PageInf> admin = pageInfService.getUserMenuList("teacher");
    }

@Test
    public void testPageInfoMapper(){
//        UserInfoService userInfoService= (UserInfoService) context.getBean("pageInfServiceImpl");

 CoursesMapper coursesMapper= (CoursesMapper) context.getBean("coursesMapper");
    TestsMapper testsMapper = (TestsMapper) context.getBean("testsMapper");
  StudentDoTestMapper studentDoTestMapper=(StudentDoTestMapper) context.getBean("studentDoTestMapper");
 GradesMapper gradesMapper= (GradesMapper) context.getBean("gradesMapper");
//    List<Courses> selectedCourses = coursesMapper.getSelectedCourses(0);
//    List<Courses> unSelectedCourses = coursesMapper.getUnSelectedCourses(2);
//    System.out.println(unSelectedCourses.get(0).getCourseName());
//    int[] ids={8,6};
//    int i = coursesMapper.deleteBatch(ids);
//    List<Tests> testsByCourseId = testsMapper.getTestsByCourseId(1);
//   List<Courses> courses= (List<Courses>) coursesMapper.querySelectedCourses();
Map<String,Object> map= new HashMap<>();
map.put("studentId",1);
map.put("courseId",5);
List<CheckScores> smallScores = gradesMapper.getSmallScores(map);

}}
