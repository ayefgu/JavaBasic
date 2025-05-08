package app;

import java.util.LinkedList;
import java.util.Scanner;

import member.Member;
import member.MemberService;
import member.NoMemberException;

public class MemberApplication {

    Scanner sc = new Scanner(System.in);
    MemberService ms = new MemberService();

    public void controlMenu() {
        int menu;
        do {
            menu = selectMenu();
            switch (menu) {
                case 1 -> menuRegistMember();
                case 2 -> menuMemberList();
                case 3 -> menuMemberDetailInfo();
                case 4 -> menuMemberUpdate();
                case 5 -> menuMemberRemove();
                case 0 -> System.out.println("*** 회원 관리 종료 ***");
                default -> System.out.println("없는 메뉴입니다.");
            }
        } while (menu != 0);
    }

    private void menuMemberRemove() {
        System.out.println("*** 회원 탈퇴 ***");
        menuMemberList();
        System.out.print(">> 회원 번호 : ");
        int memberNo = inputInt();

        try {
            ms.removeMember(memberNo);
            System.out.println("회원 탈퇴 성공");
        } catch (NoMemberException e) {
            System.out.println(e.getMessage());
        }
    }

    private void menuMemberUpdate() {
        System.out.println("*** 회원 정보 수정 ***");
        menuMemberList();
        System.out.print(">> 회원 번호 : ");
        int memberNo = inputInt();

        try {
            Member member = ms.detailMemberInfo(memberNo);
            System.out.println("현재 정보: " + member);

            System.out.print(">> 새로운 비밀번호 : ");
            String newPassword = sc.nextLine();

            System.out.print(">> 새로운 이름 : ");
            String newName = sc.nextLine();

            if (ms.updateMember(memberNo, newPassword, newName)) {
                System.out.println("회원 정보 수정 성공");
            } else {
                System.out.println("회원 정보 수정 실패");
            }
        } catch (NoMemberException e) {
            System.out.println(e.getMessage());
        }
    }

    private void menuRegistMember() {
        System.out.println("*** 회원 가입 ***");

        String id;
        do {
            System.out.print(">> 아이디 (중복불가) : ");
            id = sc.nextLine();
        } while (!ms.isIdValid(id));

        System.out.print(">> 비밀번호 : ");
        String password = sc.nextLine();

        System.out.print(">> 이름 : ");
        String username = sc.nextLine();

        if (ms.registMember(id, password, username)) {
            System.out.println("회원 가입이 되었습니다.");
        } else {
            System.out.println("회원 가입에 실패하였습니다.");
        }
    }

    private void menuMemberList() {
        System.out.println("*** 회원 목록 ***");
        LinkedList<Member> memberList = ms.listMembers();
        System.out.println("---------------------------------------");

        if (memberList.isEmpty()) {
            System.out.println("가입한 회원이 없습니다.");
        } else {
            for (Member member : memberList) {
                System.out.println(member);
            }
        }

        System.out.println("---------------------------------------");
    }

    private void menuMemberDetailInfo() {
        System.out.println("*** 회원 상세 정보 ***");
        System.out.print(">> 회원 번호 : ");
        int memberNo = inputInt();

        try {
            Member member = ms.detailMemberInfo(memberNo);
            System.out.println("회원 정보: " + member);
        } catch (NoMemberException e) {
            System.out.println(e.getMessage());
        }
    }

    private int selectMenu() {
        String[] menuList = {"종료", "회원가입", "회원목록", "회원상세정보", "회원정보수정", "회원탈퇴"};

        System.out.println("==============================");
        for (int i = 1; i < menuList.length; i++) {
            System.out.println(i + ". " + menuList[i]);
        }
        System.out.println("0. " + menuList[0]);
        System.out.println("==============================");
        System.out.print(">> 메뉴 선택 : ");

        return inputInt();
    }

    private int inputInt() {
        int num = -1;
        while (true) {
            try {
                num = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("숫자를 다시 입력해 주세요: ");
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MemberApplication app = new MemberApplication();
        app.controlMenu();
    }
}