package webBoard.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "main/mainPageFormBeforeLogin";
    }
    @GetMapping(value = "/after")
    public String loginHome(@RequestParam("nickName") String nickName, Model model){
        model.addAttribute("nickName", nickName);
        return "main/mainPageFormAfterLogin";
    }
}
