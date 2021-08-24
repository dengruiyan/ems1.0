package com.abc.action;

import com.abc.bean.User;
import com.abc.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserAction {
    //声明service对象
    @Autowired
    private UserService userService;

    private String username;
    private String password;
    //登录
    public String login() throws IOException {
        //System.out.println(username);
        //System.out.println(password);

        Map<String,Object> map = new HashMap<>();

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = userService.login(username);
        if(user != null){
            if(password.equals(user.getPassword())){
                session.setAttribute("user", user);
                map.put("success", true);
            }else{
                map.put("success", false);
                map.put("backResult", "密码错误");
            }
        }else{
            map.put("backResult", "用户名不存在");
        }
        String s = JSONObject.toJSONString(map);
        response.getWriter().print(s);
        return null;
    }
    private User user;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //注册
    public String regist() throws IOException {
        //System.out.println("================"+user+"==============");
        Map<String,Object> map = new HashMap<>();
        HttpSession session = ServletActionContext.getRequest().getSession();
        String validationCode = (String)session.getAttribute("validationCode");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        if(code.equals(validationCode)){
            User user1 = userService.selectByName(user.getUsername());
            if(user1 == null){
                userService.insert(user);
                map.put("success", true);
            }else{
                map.put("success", false);
                map.put("backResult", "用户名已存在");
            }
        }else{
            map.put("success", false);
            map.put("backResult", "验证码输入错误");
        }
        String s = JSONObject.toJSONString(map);
        response.getWriter().print(s);
        return null;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
