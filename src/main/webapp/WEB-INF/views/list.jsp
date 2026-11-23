<%-- JSP 페이지 설정: 한글이 깨지지 않게 UTF-8 --%>
<%-- JSPページ設定：日本語・韓国語が文字化けしないようにUTF-8 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 태그 사용 선언 (c:forEach, c:out 등) --%>
<%-- JSTLタグの使用を宣言（c:forEach、c:out など） --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<div align="center">

	<h1>글 목록</h1>

	<%-- 세션의 로그인 회원 이름 출력 + 로그아웃·글쓰기 링크 --%>
	<%-- セッションのログイン会員名を出力 + ログアウト・投稿作成リンク --%>
	<p>
		<c:out value="${loginMember.name}" />님 |
		<a href="logout">로그아웃</a> |
		<a href="insertBoard">글쓰기</a>
	</p>

	<table border="1">
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th>
		</tr>

		<%-- boardList(컨트롤러가 model에 넣은 목록)에서 글을 하나씩 꺼내 반복 --%>
		<%-- boardList（コントローラーがmodelに入れた一覧）から投稿を1件ずつ取り出して繰り返す --%>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.seq}</td>

			<%-- 제목 → 상세 화면 링크 (c:out → 태그를 글자로 바꿔 출력해서 XSS 방지) --%>
			<%-- タイトル → 詳細画面へのリンク（c:out → タグを文字に変えて出力するのでXSS防止） --%>
			<td><a href="getBoard?seq=${board.seq}"><c:out value="${board.title}" /></a></td>

			<td><c:out value="${board.writer}" /></td>
			<td>${board.regDate}</td>
			<td>${board.cnt}</td>
		</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>
