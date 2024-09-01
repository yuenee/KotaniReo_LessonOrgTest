package com.example.demo.mentor.q01_introduce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.mentee.q01_introduce.IntroduceService;

@Controller
public class IntroduceController {

    @Autowired
    IntroduceService service;

    @GetMapping("/introduce/")
    public String getHome(Model model) {
        String introduceName = service.getName();
        String introduceComment = service.getComment();

        model.addAttribute("introduceName", introduceName);
        model.addAttribute("introduceComment", introduceComment);

        return "q01_introduce/index";
    }

}