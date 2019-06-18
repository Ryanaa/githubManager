package cn.edu.cdu.itcast.controller;

import cn.edu.cdu.itcast.utils.R;
import cn.edu.cdu.itcast.utils.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private Producer producer;
    //验证码
    @RequestMapping("/sys/captcha.jpg")
    public void kaptcha(HttpServletResponse response) throws IOException {

        response.setHeader("Cache-Control","no-store,no-cache" );
        //设置图片文件类型为jpeg
        response.setContentType("image/jpeg");
        //文字
        String text=producer.createText();
        System.out.println(text);
        //图片
        BufferedImage bufferedImage= producer.createImage(text);
        //保存session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY,text);

//响应客户
        ServletOutputStream out =response.getOutputStream();
       // ImageIO.setUseCache(false);
//        在使用ImageIO进行图片写操作时，默认会使用缓存目录:${tomcat}/temp，在此缓存目录会生成缓存文件.tmp
//                (这一串数字应该是当前时间戳，临时文件名)
       ImageIO.write(bufferedImage,"jpg",out);
        out.flush();//清空缓冲区
    }

    //登陆
    @ResponseBody
    @PostMapping (value = "/sys/login")
    public R login(@RequestBody Map<String, Object> map){
        //获得之前存入session的验证码
        String kaptcha=ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        String username= (String) map.get("username");
        String password= (String) map.get("password");
        System.out.println(username);
        String captcha= (String) map.get("captcha");
        if(!captcha.equalsIgnoreCase(kaptcha)){
            return R.error("验证码不正确");
        }

       Subject subject=ShiroUtils.getSubject();

        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            password = new Md5Hash(password, username, 1024).toHex();
            System.out.println(password);
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            //usernamePasswordToken.setRememberMe(remember);//设置记住我
            subject.login(usernamePasswordToken);
//            subject.isPermitted("perms1");
        }catch (UnknownAccountException e){
            return R.error("账号错误");
        }catch (IncorrectCredentialsException e){
            return R.error("密码错误");
        }catch (LockedAccountException e){
            return R.error("账号已经被注销");
        }catch (AuthenticationException e){
            return R.error("账户验证失败");
        }

        return R.ok();
    }

    @GetMapping("/logout")
    public String logout(){

        ShiroUtils.logout();
        return "redirect:/static/login.html";
    }
}
