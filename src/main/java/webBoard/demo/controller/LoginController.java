package webBoard.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webBoard.demo.controller.form.LoginForm;
import webBoard.demo.domain.Member;
import webBoard.demo.service.MemberService;

import java.util.Optional;

@Controller
public class LoginController {
    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/login")
    public String login(){
        return "/members/loginForm";
    }
    @PostMapping(value = "/members/login")
    public String check_login(LoginForm form) {
        Member member = new Member();
        Optional<Member> memberCheck = memberService.findOne(form.getUserId());
        if(memberCheck.isPresent()){
            Member member2 = memberCheck.get();
            if(member2.getPassword().equals(form.getPassword())){
                System.out.println("Success");
                return "redirect:/after?nickName=" + member2.getNickName();
            }
            else{
                System.out.println("Wrong Password");
                return "/members/loginForm";
            }
        }
        else{
            System.out.println("Wrong Id");
            return "/members/loginPage";
        }
    }
}
