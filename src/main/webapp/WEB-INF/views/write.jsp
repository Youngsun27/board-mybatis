<%-- JSP 페이지 설정: 한글이 깨지지 않게 UTF-8 --%>
<%-- JSPページ設定：日本語・韓国語が文字化けしないようにUTF-8 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 태그 사용 선언 --%>
<%-- JSTLタグの使用を宣言 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
<div align="center">

	<h1>글 등록</h1>

	<%-- 글쓰기 폼: POST /insertBoard 로 title, writer, content 전송 → BoardController.insertBoard() --%>
	<%-- 投稿作成フォーム：POST /insertBoard へ title、writer、content を送信 → BoardController.insertBoard() --%>
	<form action="insertBoard" method="post">
		제목: <input type="text" name="title"><br>

		<%-- 작성자 칸에 로그인 회원 이름을 미리 채워 둠 --%>
		<%-- 作成者欄にログイン会員の名前をあらかじめ入れておく --%>
		작성자: <input type="text" name="writer" value="<c:out value='${loginMember.name}' />"><br>

		내용: <textarea name="content" rows="10" cols="50"></textarea><br>
		<input type="submit" value="등록">
	</form>

	<a href="getBoardList">목록</a>

</div>
</body>
</html>
