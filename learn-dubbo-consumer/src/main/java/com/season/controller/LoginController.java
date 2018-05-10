package com.season.controller;

import com.season.domain.Role;
import com.season.domain.User;
import com.season.service.ILoginService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api("登录")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    //post登录
    @ApiOperation(value = "登录",notes = "通过shiro安全登录",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",required = true,paramType = "String",value = "用户名"),
            @ApiImplicitParam(name = "password",required = true,paramType = "String",value = "密码")
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String userName, @RequestParam("password")String pwd){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, pwd);
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            return "帐号不存在！";
        } catch (IncorrectCredentialsException e) {
            return "密码错误！";
        } catch (LockedAccountException e) {
            return "帐号已锁定！";
        }
        return "登录成功";
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "error ok!";
    }

    //数据初始化
    @ApiOperation(value = "添加user",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "password",value = "密码")
    })
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody Map<String,Object> map){
        User user = loginService.addUser(map);
        return "addUser is ok! \n" + user;
    }

    //角色初始化
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id"),
            @ApiImplicitParam(name = "roleName",value = "角色名称")
    })
    @ApiOperation(value = "添加角色",httpMethod = "post")
    @RequestMapping(value = "/addRole")
    public String addRole(@RequestBody Map<String,Object> map){
        Role role = loginService.addRole(map);
        return "addRole is ok! \n" + role;
    }

    //注解的使用
    @ApiOperation(value = "权限测试")
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
}