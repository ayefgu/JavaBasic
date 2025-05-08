package member;

import java.util.LinkedList;

public class MemberService {

    private LinkedList<Member> members = new LinkedList<>();
    private int memberCount = 0;

    public boolean registMember(String id, String password, String username) {
        if (!isIdValid(id)) return false;
        members.add(new Member(++memberCount, id, password, username));
        return true;
    }

    public boolean isIdValid(String id) {
        return members.stream().noneMatch(m -> m.getId().equals(id));
    }

    public LinkedList<Member> listMembers() {
        return new LinkedList<>(members); // возвращаем копию списка
    }

    public Member detailMemberInfo(int memberNo) throws NoMemberException {
        return members.stream()
                .filter(m -> m.getMemberNo() == memberNo)
                .findFirst()
                .orElseThrow(() -> new NoMemberException("해당 회원이 존재하지 않습니다."));
    }

    public boolean updateMember(int memberNo, String newPassword, String newName) throws NoMemberException {
        Member m = detailMemberInfo(memberNo);
        m.setPassword(newPassword);
        m.setUsername(newName);
        return true;
    }

    public void removeMember(int memberNo) throws NoMemberException {
        Member m = detailMemberInfo(memberNo);
        members.remove(m);
    }
}