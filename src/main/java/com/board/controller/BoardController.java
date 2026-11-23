package com.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller // Spring MVC 컨트롤러 선언 (Spring Bean 등록)
// Spring MVCのコントローラーを宣言（Spring Beanとして登録）
public class BoardController {

	// 로그 객체 생성: 실행 정보 및 오류 기록
	// ログオブジェクトを作成：実行情報を記録
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 게시판 서비스 (Spring이 자동으로 넣어 줌)
	// 掲示板サービス（Springが自動で入れてくれる）
	@Autowired
	private BoardService boardService;


	// "/getBoardList" 주소로 GET 요청 시 글 목록 보여주기
	// "/getBoardList" にGETリクエストが来ると、投稿一覧を表示
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model, HttpSession session) {

		// 로그인 안 했으면 로그인 화면으로 이동
		// ログインしていなければログイン画面へ移動
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}

		// 로그 출력
		// ログを出力
		logger.info("글 목록 조회");

		// DB에서 글 목록 가져오기
		// DBから投稿一覧を取得
		List<BoardDTO> boardList = boardService.getBoardList();

		// View에 글 목록 전달
		// Viewに投稿一覧を渡す
		model.addAttribute("boardList", boardList);

		// list View 페이지 반환 (/WEB-INF/views/list.jsp)
		// list Viewページを返す（/WEB-INF/views/list.jsp）
		return "list";
	}


	// "/getBoard?seq=3" 주소로 GET 요청 시 글 상세 보여주기
	// @RequestParam → 주소의 seq 값을 꺼냄
	// "/getBoard?seq=3" にGETリクエストが来ると、投稿の詳細を表示
	// @RequestParam → アドレスの seq の値を取り出す
	@RequestMapping(value = "/getBoard", method = RequestMethod.GET)
	public String getBoard(@RequestParam("seq") int seq, Model model, HttpSession session) {

		// 로그인 안 했으면 로그인 화면으로 이동
		// ログインしていなければログイン画面へ移動
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}

		// 로그 출력: 몇 번 글을 봤는지 기록
		// ログを出力：何番の投稿を見たか記録
		logger.info("글 상세 조회: {}", seq);

		// DB에서 글 하나 가져오기
		// DBから投稿を1件取得
		BoardDTO board = boardService.getBoard(seq);

		// View에 글 전달
		// Viewに投稿を渡す
		model.addAttribute("board", board);

		// detail View 페이지 반환
		// detail Viewページを返す
		return "detail";
	}


	// "/insertBoard" 주소로 GET 요청 시 글쓰기 화면 보여주기
	// "/insertBoard" にGETリクエストが来ると、投稿作成画面を表示
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoardForm(HttpSession session) {

		// 로그인 안 했으면 로그인 화면으로 이동
		// ログインしていなければログイン画面へ移動
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}

		// write View 페이지 반환
		// write Viewページを返す
		return "write";
	}


	// "/insertBoard" 주소로 POST 요청 시 글 등록
	// BoardDTO → 폼의 title, writer, content 값이 자동으로 담김
	// "/insertBoard" にPOSTリクエストが来ると、投稿を登録
	// BoardDTO → フォームの title、writer、content の値が自動で入る
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(BoardDTO board, HttpSession session) {

		// 로그인 안 했으면 로그인 화면으로 이동
		// ログインしていなければログイン画面へ移動
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}

		// 로그 출력
		// ログを出力
		logger.info("글 등록: {}", board.getTitle());

		// DB에 글 저장
		// DBに投稿を保存
		boardService.insertBoard(board);

		// 글 목록 주소로 이동 (새로고침해도 다시 등록되지 않음)
		// 投稿一覧のアドレスへ移動（再読み込みしても再登録されない）
		return "redirect:/getBoardList";
	}


	// "/updateBoard" 주소로 POST 요청 시 글 수정
	// "/updateBoard" にPOSTリクエストが来ると、投稿を修正
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(BoardDTO board, HttpSession session) {

		// 로그인 안 했으면 로그인 화면으로 이동
		// ログインしていなければログイン画面へ移動
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}

		// 로그 출력
		// ログを出力
		logger.info("글 수정: {}", board.getSeq());

		// DB의 글 수정
		// DBの投稿を修正
		boardService.updateBoard(board);

		// 글 목록 주소로 이동
		// 投稿一覧のアドレスへ移動
		return "redirect:/getBoardList";
	}


	// "/deleteBoard" 주소로 POST 요청 시 글 삭제
	// "/deleteBoard" にPOSTリクエストが来ると、投稿を削除
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(@RequestParam("seq") int seq, HttpSession session) {

		// 로그인 안 했으면 로그인 화면으로 이동
		// ログインしていなければログイン画面へ移動
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}

		// 로그 출력
		// ログを出力
		logger.info("글 삭제: {}", seq);

		// DB에서 글 삭제
		// DBから投稿を削除
		boardService.deleteBoard(seq);

		// 글 목록 주소로 이동
		// 投稿一覧のアドレスへ移動
		return "redirect:/getBoardList";
	}

}
