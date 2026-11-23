package com.board.dto;

// DTO: board 테이블 한 행(글 1개)을 담는 상자
// DTO：boardテーブルの1行（投稿1件）を入れる入れ物
public class BoardDTO {

	// 글 번호
	// 投稿番号
	private int seq;

	// 제목
	// タイトル
	private String title;

	// 작성자
	// 作成者
	private String writer;

	// 내용
	// 内容
	private String content;

	// 등록일 ("2026-11-24" 같은 글자로 받음 → 화면에 그대로 출력)
	// 登録日（"2026-11-24" のような文字で受け取る → 画面にそのまま出力）
	private String regDate;

	// 조회수
	// 閲覧数
	private int cnt;

	// getter/setter
	// getter/setter
	public int getSeq() { return seq; }
	public void setSeq(int seq) { this.seq = seq; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	public String getRegDate() { return regDate; }
	public void setRegDate(String regDate) { this.regDate = regDate; }

	public int getCnt() { return cnt; }
	public void setCnt(int cnt) { this.cnt = cnt; }
}
