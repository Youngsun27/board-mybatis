package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.BoardDTO;
import com.board.mapper.BoardMapper;

@Service // 서비스 클래스 선언 (Spring Bean 등록 → 컨트롤러에서 사용)
// サービスクラスを宣言（Spring Beanとして登録 → コントローラーで使う）
public class BoardService {

	// 게시판 매퍼 (Spring이 자동으로 넣어 줌)
	// 掲示板マッパー（Springが自動で入れてくれる）
	@Autowired
	private BoardMapper boardMapper;

	// 글 목록 조회
	// 投稿一覧を取得
	public List<BoardDTO> getBoardList() {
		return boardMapper.getBoardList();
	}

	// 글 하나 조회
	// 投稿を1件取得
	public BoardDTO getBoard(int seq) {
		return boardMapper.getBoard(seq);
	}

	// 글 등록
	// 投稿を登録
	public void insertBoard(BoardDTO board) {
		boardMapper.insertBoard(board);
	}

	// 글 수정
	// 投稿を修正
	public void updateBoard(BoardDTO board) {
		boardMapper.updateBoard(board);
	}

	// 글 삭제
	// 投稿を削除
	public void deleteBoard(int seq) {
		boardMapper.deleteBoard(seq);
	}
}
