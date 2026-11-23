package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.MemberDTO;
import com.board.mapper.MemberMapper;

@Service // 서비스 클래스 선언 (Spring Bean 등록 → 컨트롤러에서 사용)
// サービスクラスを宣言（Spring Beanとして登録 → コントローラーで使う）
public class MemberService {

	// 회원 매퍼 (Spring이 자동으로 넣어 줌)
	// 会員マッパー（Springが自動で入れてくれる）
	@Autowired
	private MemberMapper memberMapper;

	// 로그인: 아이디·비밀번호가 맞으면 회원 정보, 틀리면 null
	// ログイン：ID・パスワードが合えば会員情報、違えばnull
	public MemberDTO login(MemberDTO member) {

		// DB에서 회원 찾기 (MemberMapper.xml의 getMember 실행)
		// DBで会員を探す（MemberMapper.xml の getMember を実行）
		MemberDTO loginMember = memberMapper.getMember(member);

		// 세션에 비밀번호가 남지 않도록 지움
		// セッションにパスワードが残らないよう消す
		if (loginMember != null) {
			loginMember.setPassword(null);
		}

		// 결과 반환
		// 結果を返す
		return loginMember;
	}
}
