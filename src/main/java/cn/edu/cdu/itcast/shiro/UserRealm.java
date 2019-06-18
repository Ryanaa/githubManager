package cn.edu.cdu.itcast.shiro;

import cn.edu.cdu.itcast.po.UserInf;
import cn.edu.cdu.itcast.service.PageInfService;
import cn.edu.cdu.itcast.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserRealm extends AuthorizingRealm {
@Autowired
private UserInfoService userInfoService;
@Autowired
private PageInfService pageInfService;


    /**
     * 得到登陆的信息并判断登陆，登陆成功后返回用户信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //用户输入,从登陆框中获取
        String userName= (String) authenticationToken.getPrincipal();
        String password=new String((char[]) authenticationToken.getCredentials());

        //调数据库查
        UserInf userInf= userInfoService.getUserById(userName);
        System.out.println(userInf.getUserid()+userInf.getPassword());
        if (userInf==null){
            throw new UnknownAccountException("账号密码不正确");
        }

                 //自定义判断可不用此步。
        if (!password.equals(userInf.getPassword())){
            throw new IncorrectCredentialsException("密码错误");
        }
        //判断用户是否被锁定0被锁定，1未被锁定
        if(userInf.getState().equals("0")){
            throw new LockedAccountException("账号被锁定请联系管理员");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userInf,userInf.getPassword(),this.getName());
        return info;
    }
    //授权

    /**
     * 得到用户信息，查出所有权限并返回
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        //下面认证方法传什么这里就接收什么
        UserInf userInf = (UserInf) principalCollection.getPrimaryPrincipal();
        System.out.println(userInf.getUserid());
//通过userid查到此用户所有的perms
        Set<String> permsSet=pageInfService.getUserPermissions(userInf.getUserid());
        Set<String> rolesSet=pageInfService.getUserRoles(userInf.getUserid());
//        List<String> roleList=Arrays.asList("admin");//授予的角色
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(rolesSet);
//        List<String> permList=Arrays.asList("update");//授予的资源权限
        authorizationInfo.addStringPermissions(permsSet);
        return authorizationInfo;
    }
}
