package com.abc.controller;

import com.abc.bean.Student;
import com.abc.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/some")
public class SomeController {

    Logger log = LoggerFactory.getLogger(SomeController.class);

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public String registerHandler(Student student, Model model) throws Exception {
        model.addAttribute("student", student);
        service.addStudent(student);
        return "/jsp/welcome.jsp";
    }

    @PostMapping("/log")
    public String log() throws Exception {
        log.debug("dsakdhsalflkdsfds");
        return "/jsp/welcome.jsp";
    }

}
