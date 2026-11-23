package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.BoardDTO;

@Mapper // MyBatis 매퍼 선언 → 메서드 이름 = BoardMapper.xml의 SQL id
// MyBatisのマッパーを宣言 → メソッド名 = BoardMapper.xml のSQL id
public interface BoardMapper {

	// 글 목록 조회
	// 投稿一覧を取得
	List<BoardDTO> getBoardList();

	// 글 하나 조회 (없으면 null)
	// 投稿を1件取得（なければnull）
	BoardDTO getBoard(int seq);

	// 글 등록
	// 投稿を登録
	void insertBoard(BoardDTO board);

	// 글 수정
	// 投稿を修正
	void updateBoard(BoardDTO board);

	// 글 삭제
	// 投稿を削除
	void deleteBoard(int seq);
}
