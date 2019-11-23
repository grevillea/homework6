package com.fs.homework6.controller;

import com.fs.homework6.dao.MembersDao;
import com.fs.homework6.pojo.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    MembersDao membersDao;
    @RequestMapping(value = "/save")
    public String saveUser(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        Members m = new Members();
        m.setName(request.getParameter("j_name"));
        m.setMail(request.getParameter("j_mail"));
        m.setUserName(request.getParameter("j_username"));
        m.setPassword(request.getParameter("j_password"));
        int i = membersDao.saveUser(m);
        if(i>0){
            return "login";
        }else{
            return "";
        }
    }
    @RequestMapping(value = "/update")
    public String updateUser(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        Members m = new Members();
        m.setName(request.getParameter("j_name"));
        m.setMail(request.getParameter("j_mail"));
        m.setUserName(request.getParameter("j_username"));
        m.setPassword(request.getParameter("j_password"));
        int i = membersDao.updateUser(m);
        if(i>0){
            return "login";
        }else{
            return "";
        }
    }
}
