package webBoard.demo.controller.form;

import lombok.Getter;
import lombok.Setter;

// 회원 가입시 정보
@Getter
@Setter
public class MemberForm {
    private String userId;
    private String nickName;
    private String password1;
    private String password2;
}
