<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>IDを探す</title>
	<script type="text/javascript">
		function searchID()
		{
			var email = document.getElementById("email");
			var birthDate = document.getElementById("birthDate");
			var regexp = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;

			//メールアドレスが未入力かチェック
			if(email.value.length < 1)
			{
				alert('メールアドレスを入力してください');
				return false;
			}

			//メールアドレスの形式以外の項目かチェック
			if(!email.value.match(regexp))
			{
				alert('メールアドレスの形式に入力してください');
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

			window.open("/kimschool_spring/login/searchID?email=" + email.value + "&birthDate=" + birthDate.value, "popupView", "top=200,left=300,width=400,height=400,resizable=no");
		}
	</script>
</head>
<body>

<c:if test="${isSearchIDFormFlg == false}">
	<div>
		<h2>IDを探す 検索結果</h2>
		<c:choose>
			<c:when test="${not empty userIdList}">
				<c:forEach var="vo" items="${userIdList}" varStatus="status">
					<p>${vo.userId}</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>IDが存在しません</p>
			</c:otherwise>
		</c:choose>
	</div>
</c:if>

<c:if test="${isSearchIDFormFlg == true}">
	<!-- イメージ -->
	<div>
		<p>
			<img src="" alt="KIM SCHOOL">
		</p>
	</div>

	<!-- ラベル -->
	<div>
		<p>
			IDを探す<br>
			：KIM SCHOOLに登録したメールアドレスと生年月日を入力してください<br>
		</p>
	</div>

	<!-- フォーム -->
	<div>
		<form method="post" onsubmit="return searchID()">
			メールアドレス<br>
			<input type="text" name="email" id="email"><br>
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