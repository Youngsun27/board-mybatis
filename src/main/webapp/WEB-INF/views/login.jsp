<%-- JSP 페이지 설정: 한글이 깨지지 않게 UTF-8 --%>
<%-- JSPページ設定：日本語・韓国語が文字化けしないようにUTF-8 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 태그 사용 선언 (c:out, c:if 등) --%>
<%-- JSTLタグの使用を宣言（c:out、c:if など） --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div align="center">

	<h1>로그인</h1>

	<%-- 로그인 폼: POST /login 으로 id, password 전송 → MemberController.login() --%>
	<%-- ログインフォーム：POST /login へ id、password を送信 → MemberController.login() --%>
	<form action="login" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="password" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">
	</form>

	<%-- 오류 메시지가 있을 때만 빨간 글씨로 출력 (컨트롤러가 model에 넣은 error) --%>
	<%-- エラーメッセージがある時だけ赤い文字で出力（コントローラーがmodelに入れた error） --%>
	<c:if test="${not empty error}">
		<p style="color:red"><c:out value="${error}" /></p>
	</c:if>

</div>
</body>
</html>
