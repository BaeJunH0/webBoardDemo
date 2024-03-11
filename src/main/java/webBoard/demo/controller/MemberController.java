package webBoard.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webBoard.demo.domain.Member;
import webBoard.demo.service.MemberService;

import java.util.List;


@Controller
public class MemberController {
    private final MemberService memberService;
    private String name = "user";
    private Long seq = 0L;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setNickName(name + ' ' + ++seq);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping(value = "/members/login")
    public String login(){
        return "/members/loginPage";
    }
    @PostMapping(value = "/members/login")
    public String check_login(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setNickName(name + ' ' + ++seq);
        if(memberService.findOne(member.getId()).isPresent()){
            return "/mainPage";
        }
        else{
            return "redirect:/";
        }
    }

}
