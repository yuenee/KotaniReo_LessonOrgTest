package com.example.demo.mentor.q04_sazae;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mentee.q04_sazae.SazaeService;

@Controller
@RequestMapping("sazae")
public class SazaeController {

    private final
    SazaeService sazaeService;

    public SazaeController(SazaeService sazaeService) {
        this.sazaeService = sazaeService;
    }

    @GetMapping("/")
    public String index() {
        return "q04_sazae/index";
    }

    @GetMapping("/janken")
    public String janken(@RequestParam("hand") String myHand, Model model) {
        List<String> handList = Arrays.asList("goo", "choki", "per");
        Random random = new Random();
        int index = random.nextInt(handList.size());
        String opponentHand = handList.get(index);

        String battleResult;
        try {
            battleResult = sazaeService.janken(myHand, opponentHand);
        } catch (IllegalArgumentException e) {
            return index();
        }

        model.addAttribute("myHand", myHand);
        model.addAttribute("opponentHand", opponentHand);
        model.addAttribute("result", battleResult);

        return "q04_sazae/jankenResult";
    }
}
