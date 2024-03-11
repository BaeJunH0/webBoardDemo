package webBoard.demo.domain;

import static ch.qos.logback.core.joran.JoranConstants.NULL;

public class Member {
    private long id;
    private String userId;
    private String password;
    private String nickName;
    public Member(){
        this.id = -1;
        this.userId = this.password = this.nickName = NULL;
    }
    public Member(int id, String userId, String password, String nickName) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(String id) {
        this.userId = id;
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
