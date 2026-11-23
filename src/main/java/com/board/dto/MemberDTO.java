package com.board.dto;

// DTO: users 테이블 한 행(회원 1명)을 담는 상자
// DTO：usersテーブルの1行（会員1人）を入れる入れ物
public class MemberDTO {

	// 아이디
	// ID
	private String id;

	// 비밀번호
	// パスワード
	private String password;

	// 이름
	// 名前
	private String name;

	// 권한 (Admin / User)
	// 権限（Admin / User）
	private String role;

	// getter/setter: MyBatis는 set으로 값을 넣고, 컨트롤러는 get으로 꺼냄
	// getter/setter：MyBatisはsetで値を入れ、コントローラーはgetで取り出す
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
}
