package lec250430.dao;

public class MySqlDao implements DataAccessObject {
	@Override
	public void insert() {
		System.out.println("Oracle DB에 산입");
	}
	public void select() {
		System.out.println("Oracle DB에 검색");
	}
	public void update() {
		System.out.println("Oracle DB에 수정");
	}
	public void delete() {
		System.out.println("Oracle DB에 삭제");
	}

}
