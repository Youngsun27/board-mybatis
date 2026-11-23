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
<title>글 상세보기</title>
</head>
<body>
<div align="center">

	<h1>글 상세보기</h1>

	<%-- 수정 폼: POST /updateBoard 로 seq, title, content 전송 → BoardController.updateBoard() --%>
	<%-- 修正フォーム：POST /updateBoard へ seq、title、content を送信 → BoardController.updateBoard() --%>
	<form action="updateBoard" method="post">

		<%-- 글 번호 (화면에는 안 보이지만 같이 전송됨) --%>
		<%-- 投稿番号（画面には見えないが一緒に送信される） --%>
		<input type="hidden" name="seq" value="${board.seq}">

		제목: <input type="text" name="title" value="<c:out value='${board.title}' />"><br>
		작성자: <c:out value="${board.writer}" /><br>
		등록일: ${board.regDate} | 조회수: ${board.cnt}<br>
		내용: <textarea name="content" rows="10" cols="50"><c:out value="${board.content}" /></textarea><br>
		<input type="submit" value="수정">
	</form>

	<%-- 삭제 폼: POST /deleteBoard 로 seq 전송 (확인 창에서 취소하면 전송 안 함) --%>
	<%-- 削除フォーム：POST /deleteBoard へ seq を送信（確認ダイアログでキャンセルすると送信しない） --%>
	<form action="deleteBoard" method="post" onsubmit="return confirm('삭제할까요?')">
		<input type="hidden" name="seq" value="${board.seq}">
		<input type="submit" value="삭제">
	</form>

	<a href="getBoardList">목록</a>

</div>
</body>
</html>
