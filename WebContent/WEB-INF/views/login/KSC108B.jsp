<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PASSWORDを探す</title>
	<script type="text/javascript">
		function searchPW()
		{
			var userId = document.getElementById("userId");
			var birthDate = document.getElementById("birthDate");

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

			//誕生日が未入力かチェック
			if(birthDate.value.length < 1)
			{
				alert('誕生日を入力してください');
				return false;
			}

			//誕生日に半角数字以外の項目を入力
			if(!birthDate.value.match(/^[0-9]*$/)){
				alert('誕生日に半角数字を入力してください');
				return false;
			}

			//誕生日に8桁以外の項目を入力
			if(birthDate.value.length != 8){
				alert('誕生日に8桁を入力してください');
				return false;
			}

			window.open("/kimschool_spring/login/searchPW?userId=" + userId.value + "&birthDate=" + birthDate.value, "popupView", "top=200,left=300,width=600,height=400,resizable=no");
		}

		function updatePW()
		{
			var password = document.getElementById("password");
			var password_confirm = document.getElementById("password_confirm");

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

			if(password.value != password_confirm.value){
				alert("入力したパスワードが一致しません。再入力してください");
				return false;
			}
		}
	</script>
</head>
<body>

<c:if test="${isSearchPWFormFlg == false}">
	<c:choose>
		<c:when test="${updatePWFlg == true}">
			<div>
				<p>PASSWORD更新完了</p>
			</div>
		</c:when>
		<c:otherwise>
			<c:if test="${empty userInfoVo}">
				<div>
					<h2>PASSWORDを探す 検索結果</h2>
					<p>一致するID、生年月日が存在しません。</p>
				</div>
			</c:if>

			<c:if test="${not empty userInfoVo}">
				<!-- ラベル -->
				<div>
					<p>
						<h2>PASSWORD更新</h2>
					</p>
				</div>

				<!-- フォーム -->
				<div>
					<form action="/kimschool_spring/login/updatePW" method="post"
							onsubmit="return updatePW()">
						パスワードを入力してください<br>
						<input type="password" name="password" id="password"><br>
						パスワードを再入力してください<br>
						<input type="password" id="password_confirm"><br><br>
						<input type="submit" value="送信">
						<c:if test="${not empty userInfoVo}">
							<input type="hidden" name="userId" value="${userInfoVo.userId}">
							<input type="hidden" name="birthDate" value="${userInfoVo.birthDate}">
						</c:if>
					</form>
				</div>
			</c:if>
		</c:otherwise>
	</c:choose>
</c:if>

<c:if test="${isSearchPWFormFlg == true}">
	<!-- イメージ -->
	<div>
		<p>
			<img src="" alt="KIM SCHOOL">
		</p>
	</div>

	<!-- ラベル -->
	<div>
		<p>
			PASSWORDを探す<br>
			：KIM SCHOOLに登録したIDと生年月日を入力してください<br>
		</p>
	</div>

	<!-- フォーム -->
	<div>
		<form method="post" onsubmit="return searchPW()">
			ID<br>
			<input type="text" name="userId" id="userId"><br>
			生年月日<br>
			<input type="text" name="birthDate" id="birthDate"><br><br>
			<p>
				<input type="submit" value="送信"><br>
			</p>
		</form>
	</div>
</c:if>

</body>
</html>