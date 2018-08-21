<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ログイン</title>
	<script type="text/javascript">
		function formCheck()
		{
			var userId = document.getElementById("userId");
			var password = document.getElementById("password");

			//IDが未入力かチェック
			if(userId.value.length < 1)
			{
				alert('IDを入力してください');
				return false;
			}

			//IDに半角英数字以外の項目を入力
			if(!userId.value.match(/^[A-Za-z0-9]*$/)){
				alert('IDに半角英数字を入力してください');
				return false;
			}

			//IDの桁数チェック
			if(!(userId.value.length >= 8 && userId.value.length <= 20))
			{
				alert('IDに8桁以上、20桁以下の桁数を入力してください');
				return false;
			}

			//パスワードが未入力かチェック
			if(password.value.length < 1)
			{
				alert('パスワードを入力してください');
				return false;
			}

			//パスワードに半角英数字以外の項目を入力
			if(!password.value.match(/^[A-Za-z0-9]*$/)){
				alert('パスワードに半角英数字を入力してください');
				return false;
			}

			//パスワードの桁数チェック
			if(!(password.value.length >= 8 && password.value.length <= 20))
			{
				alert('パスワードに8桁以上、20桁以下の桁数を入力してください');
				return false;
			}

			if(getUser.saveId.checked == true){
				getUser.isSaveId.value = "on";
			}else{
				getUser.isSaveId.value = "off";
			}

			return true;
		}
	</script>
</head>
<body>
	<div id="header">
		<%@ include file="/header.jsp" %>
	</div>
	<div id="container" style="height:300px" >
		<!-- イメージ -->
		<div>
			<p>
				<img src="" alt="KIM SCHOOL">
			</p>
		</div>

		<!-- フォーム -->
		<div>
			<form name="getUser" action="/kimschool_spring/login/getUser" method="post"
				onsubmit="return formCheck()">
				ID<br>
				<input type="text" name="userId" id="userId">
				<div id="loginResult"></div><br>
				PASSWORD<br>
				<input type="password" name="password" id="password"><br><br>
				<input type="checkbox" name="saveId" value="on">IDを保存する
				<input type="hidden" name="isSaveId">
				<p>
					<input type="submit" value="ログイン"><br>
				</p>
			</form>
		</div>

		<!-- リンク -->
		<div>
			<p>
				<a href="/kimschool_spring/login/searchIDForm">IDを探す</a>
				<a href="/kimschool_spring/login/searchPWForm">PASSWORDを探す</a>
				<a href="/kimschool_spring/login/insertUserForm">会員登録をする</a>
			</p>
		</div>

		<c:if test="${userId != null && userInfoVo == null}">
			<script type="text/javascript">
				getUser.userId.value = "${userId}";
			</script>
		</c:if>

		<c:choose>
			<c:when test="${checkboxFlg == true}">
				<script type="text/javascript">
					getUser.userId.value = "${userId}";
					getUser.saveId.checked = true;
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					getUser.saveId.checked = false;
				</script>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="footer">
		<%@ include file="/footer.jsp" %>
	</div>
</body>
</html>