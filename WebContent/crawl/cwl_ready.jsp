<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="m2member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Scraping Ready</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

<h2>ID및 비밀번호</h2>
<!-- <form action="/1jojo/BoardAddAction.bo" method="post"  -->
<!-- 	enctype="multipart/form-data" name="boardform"> -->
		아이디 : <input type="text" name="id" required="required" ><p>
		암호 : <input type="password" name="password" required="required" ><p>
	<p>해당 id가 실제로 사람인에서 사용하는 id와 비밀번호 입니까?</p>
	<button type="button" formaction="/1jojo/CrawlReadyAction.bo">예(스크래핑 시작)</button>
	<button type="button" formaction="https://www.saramin.co.kr/zf_user/member/registration/join">아니오(사람인 회원가입)</button>

</body>
</html>