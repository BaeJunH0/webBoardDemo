package webBoard.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static ch.qos.logback.core.joran.JoranConstants.NULL;

@Setter
@Getter
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userid;
    private String password;
    private String nickname;
    public Member(){
        this.userid = this.password = this.nickname = NULL;
    }
    public Member(int id, String userId, String password, String nickName) {
        this.id = id;
        this.userid = userId;
        this.password = password;
        this.nickname = nickName;
    }

}
