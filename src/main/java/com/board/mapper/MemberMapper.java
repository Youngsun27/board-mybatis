package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.MemberDTO;

@Mapper // MyBatis 매퍼 선언 → 구현 클래스는 MyBatis가 자동으로 만듦 (Spring Bean 등록)
// MyBatisのマッパーを宣言 → 実装クラスはMyBatisが自動で作る（Spring Beanとして登録）
public interface MemberMapper {

	// 아이디 + 비밀번호로 회원 찾기 → MemberMapper.xml의 id="getMember" SQL 실행 (없으면 null)
	// IDとパスワードで会員を探す → MemberMapper.xml の id="getMember" のSQLを実行（なければnull）
	MemberDTO getMember(MemberDTO member);
}
