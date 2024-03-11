package webBoard.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webBoard.demo.controller.form.MemberForm;
import webBoard.demo.domain.Member;
import webBoard.demo.service.MemberService;

@Controller
public class RegisterController {
    private Long seq = 0L;
    private final MemberService memberService;
    @Autowired
    public RegisterController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        String password1 = form.getPassword1();
        String password2 = form.getPassword2();
        if(!password1.equals(password2)){
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setId(++seq);
        member.setUserId(form.getUserId());
        member.setPassword(password1);
        member.setNickName(form.getNickName());

        try {
            memberService.checkingDuplicate(member);
        }
        catch (IllegalStateException e){
            if(e.getMessage().equals("이미 존재하는 회원명입니다."))
                System.out.println("same nick name!");
            else
                System.out.println("same user id!");
            return "members/createMemberForm";
        }
        memberService.join(member);
        return "redirect:/";
    }

}
