package webBoard.demo.domain;

import static ch.qos.logback.core.joran.JoranConstants.NULL;

public class Member {
    private String id;
    private String password;
    private String nickName;
    public Member(){
        this.id = this.password = this.nickName = NULL;
    }
    public Member(String id, String password, String nickName) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
