package com.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.MemberDTO;
import com.board.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller // Spring MVC 컨트롤러 선언 (Spring Bean 등록)
// Spring MVCのコントローラーを宣言（Spring Beanとして登録）
public class MemberController {

	// 로그 객체 생성: 실행 정보 및 오류 기록
	// ログオブジェクトを作成：実行情報を記録
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// 회원 서비스 (Spring이 자동으로 넣어 줌)
	// 会員サービス（Springが自動で入れてくれる）
	@Autowired
	private MemberService memberService;


	// "/" 주소로 GET 요청 시 로그인 화면으로 이동
	// "/" にGETリクエストが来ると、ログイン画面へ移動
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/login";
	}


	// "/login" 주소로 GET 요청 시 로그인 화면 보여주기
	// "/login" にGETリクエストが来ると、ログイン画面を表示
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {

		// login View 페이지 반환 (/WEB-INF/views/login.jsp)
		// login Viewページを返す（/WEB-INF/views/login.jsp）
		return "login";
	}


	// "/login" 주소로 POST 요청 시 로그인 처리
	// MemberDTO → 폼의 id, password 값이 자동으로 담김
	// "/login" にPOSTリクエストが来ると、ログイン処理
	// MemberDTO → フォームの id、password の値が自動で入る
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO member, Model model, HttpSession session) {

		// 로그 출력: 로그인 시도한 아이디 기록 (비밀번호는 기록하지 않음)
		// ログを出力：ログインを試したIDを記録（パスワードは記録しない）
		logger.info("로그인 시도: {}", member.getId());

		// 아이디·비밀번호 확인
		// ID・パスワードを確認
		MemberDTO loginMember = memberService.login(member);

		// 실패 → 오류 메시지를 담아 로그인 화면 다시 보여주기
		// 失敗 → エラーメッセージを入れてログイン画面をもう一度表示
		if (loginMember == null) {
			model.addAttribute("error", "아이디 또는 비밀번호를 확인하세요.");
			return "login";
		}

		// 성공 → 세션에 회원 정보 저장
		// 成功 → セッションに会員情報を保存
		session.setAttribute("loginMember", loginMember);

		// 글 목록 주소로 이동
		// 投稿一覧のアドレスへ移動
		return "redirect:/getBoardList";
	}


	// "/logout" 주소로 GET 요청 시 로그아웃
	// "/logout" にGETリクエストが来ると、ログアウト
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		// 세션 삭제 (로그인 정보가 사라짐)
		// セッションを削除（ログイン情報が消える）
		session.invalidate();

		// 로그인 화면으로 이동
		// ログイン画面へ移動
		return "redirect:/login";
	}

}
