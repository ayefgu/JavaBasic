package member;

public class Member {
    private int memberNo;
    private String id;
    private String password;
    private String username;

    public Member(int memberNo, String id, String password, String username) {
        this.memberNo = memberNo;
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "[" + memberNo + "] ID: " + id + ", 이름: " + username;
    }
}