<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="UpdateMemberController.do" method="post">
	<input type="hidden" name="id" value="${sessionScope.mvo.id}">
	<input type = "password" name = "password" required="required" placeholder="비밀번호" style="height: 40px;" id="password"><br>
	<input type = "password" name = "passwordcheck" required="required" placeholder="비밀번호확인" style="height: 40px;" id = "passwordcheck"><br>
	<input type = "text" name = "name" required="required" placeholder="이름" style="height: 40px;"><br>
	<input type = "text" name = "address" required="required" placeholder="주소" style="height: 40px;"><br>
	<input type = "text" name = "nickname" required="required" placeholder="닉네임" style="height: 40px;"><br>
	<input type = "text" name = "email" required="required" placeholder="이메일" style="height: 40px;"><br>
	<input type = "text" name = "tel" id="memberTel" required="required" placeholder="전화번호" onkeyup="checkTel()" style="height: 40px;"><br>
	<input type = "text" name = "accountNo" required="required" placeholder="계좌번호" style="height: 40px;"><br>
	<input type="checkbox" value="약관동의"><br>
	<button type = "submit" style="width: 190px;   background-color: #00ac00; color: white;">회원정보 수정</button>
</form>