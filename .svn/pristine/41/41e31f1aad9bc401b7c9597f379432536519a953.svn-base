<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>会員登録</title>
	<script type="text/javascript">
		function insertUser()
		{
			alert('START');
 			var userId = document.getElementById("userId");

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

			var lastname_kanji = document.getElementById("lastname_kanji");
			var firstname_kanji = document.getElementById("firstname_kanji");
			var unicode = lastname_kanji.value.charCodeAt(0);

  			//氏(漢字)が未入力かチェック
			if(lastname_kanji.value.length < 1)
			{
				alert('氏(漢字)を入力してください');
				return false;
			}

			//氏(漢字)に漢字以外の項目を入力
		    if (!((unicode>=0x4e00  && unicode<=0x9fcf)  ||
			         (unicode>=0x3400  && unicode<=0x4dbf)  ||
			         (unicode>=0x20000 && unicode<=0x2a6df) ||
			         (unicode>=0xf900  && unicode<=0xfadf)  ||
			         (unicode>=0x2f800 && unicode<=0x2fa1f))){
			    alert('氏(漢字)に漢字を入力してください');
			    return false;
		    }

			//氏(漢字)の桁数チェック
			if(lastname_kanji.value.length > 20)
			{
				alert('氏(漢字)に20桁以下の桁数を入力してください');
				return false;
			}

			//名(漢字)が未入力かチェック
			if(firstname_kanji.value.length < 1)
			{
				alert('名(漢字)を入力してください');
				return false;
			}

		    unicode = firstname_kanji.value.charCodeAt(0);
			//名(漢字)に漢字以外の項目を入力
		    if (!((unicode>=0x4e00  && unicode<=0x9fcf)  ||
			         (unicode>=0x3400  && unicode<=0x4dbf)  ||
			         (unicode>=0x20000 && unicode<=0x2a6df) ||
			         (unicode>=0xf900  && unicode<=0xfadf)  ||
			         (unicode>=0x2f800 && unicode<=0x2fa1f))){
			    alert('名(漢字)に漢字を入力してください');
			    return false;
		    }

			//名(漢字)の桁数チェック
			if(firstname_kanji.value.length > 20)
			{
				alert('名(漢字)に20桁以下の桁数を入力してください');
				return false;
			}

			var lastname_hurigana = document.getElementById("lastname_hurigana");
			var firstname_hurigana = document.getElementById("firstname_hurigana");

  			//氏(フリガナ)が未入力かチェック
			if(lastname_hurigana.value.length < 1)
			{
				alert('氏(フリガナ)を入力してください');
				return false;
			}

			//氏(フリガナ)に全角フリガナ以外の項目を入力
			if(!lastname_hurigana.value.match(/^[ァ-ヶー　]*$/)){
				alert('氏(フリガナ)に全角フリガナを入力してください');
				return false;
			}

			//氏(フリガナ)の桁数チェック
			if(lastname_hurigana.value.length > 20)
			{
				alert('氏(フリガナ)に20桁以下の桁数を入力してください');
				return false;
			}

  			//名(フリガナ)が未入力かチェック
			if(firstname_hurigana.value.length < 1)
			{
				alert('名(フリガナ)を入力してください');
				return false;
			}

			//名(フリガナ)に全角フリガナ以外の項目を入力
			if(!firstname_hurigana.value.match(/^[ァ-ヶー　]*$/)){
				alert('名(フリガナ)に全角フリガナを入力してください');
				return false;
			}

			//名(フリガナ)の桁数チェック
			if(firstname_hurigana.value.length > 20)
			{
				alert('名(フリガナ)に20桁以下の桁数を入力してください');
				return false;
			}

			var email = document.getElementById("email");
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

			var password = document.getElementById("password");

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

			var password_confirm = document.getElementById("password_confirm");

			if(password.value != password_confirm.value){
				alert("入力したパスワードが一致しません。再入力してください");
				return false;
			}

			alert('END');
		}

		function displayDate(){
			(function(){
				var today = new Date();
				var this_year = today.getFullYear();
				var optionLoop = function(start, end, id, datestr) {
					var i, opt, dateStrFlg;
					opt = null;
					dateStrFlg = false;

					for (i = end; i >= start; i--) {
						if (!dateStrFlg && (datestr == 'yyyy年' || datestr == 'mm月' || datestr == 'dd日')){
							opt += "<option value='" + datestr + "' selected>" + datestr + "</option>";
							dateStrFlg = true;
						}

						opt += "<option value='" + i + "'>" + i + "</option>";
					}

					return document.getElementById(id).innerHTML = opt;
				};

				optionLoop(1900, this_year, 'year', 'yyyy年');
				optionLoop(1, 12, 'month', 'mm月');
				optionLoop(1, 31, 'day', 'dd日');
			})();
		}

		function checkID(){
			var userId = document.getElementById("userId");

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

			window.open("/kimschool_spring/login/getUserID?userId=" + userId.value, "popupView", "top=200,left=300,width=400,height=400,resizable=no");
		}
	</script>
</head>
<body>

<c:if test="${isInsertUserFormFlg == false}">
	<c:choose>
		<c:when test="${isUserIDFlg == true}">
			<div>
				<p>すでに存在するIDです</p>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<p>使用可能なIDです</p>
			</div>
		</c:otherwise>
	</c:choose>
</c:if>

<c:if test="${isInsertUserFormFlg == true}">
	<!-- イメージ -->
	<div>
		<p>
			<img src="" alt="KIM SCHOOL">
		</p>
	</div>

	<div>
		<p>
			<img src="" alt="会員登録">
		</p>
	</div>

	<!-- フォーム -->
	<div>
		<form action="/kimschool_spring/login/insertUser" method="post"
			onsubmit="return insertUser()">
			<p>
				ID<br>
				<input type="text" name="userId" id="userId">
				<span">必須</span>
				<input type="button" value="ID確認" onclick="checkID()">
			</p>
			<p>
				氏名（漢字）<br>
				<input type="text" name="lastname_kanji" id="lastname_kanji" placeholder="氏">
				<input type="text" name="firstname_kanji" id="firstname_kanji" placeholder="名">
				<span">必須</span>
				</p>
			<p>
				氏名（フリガナ）<br>
				<input type="text" name="lastname_hurigana" id="lastname_hurigana" placeholder="氏">
				<input type="text" name="firstname_hurigana" id="firstname_hurigana" placeholder="名">
				<span">必須</span>
				</p>
			<p>
				性別<br>
				<input type="radio" name="sex" value="M">男
				<input type="radio" name="sex" value="F">女
				<span">必須</span>
			</p>
			<p>
				生年月日<br>
				<select name="year" id="year"></select>
				<select name="month" id="month"></select>
				<select name="day" id="day"></select>
				<span">必須</span>
			</p>
			<p>
				E-mail<br>
				<input type="text" name="email" id="email">
				<span">必須</span>
			</p>
			<p>
				PASSWORD<br>
				<input type="password" name="password" id="password" placeholder="8桁以上の半角英数字">
				<span">必須</span>
			</p>
			<p>
				PASSWORD（確認）<br>
				<input type="password" id="password_confirm" placeholder="確認のため、もう一度入力してください">
				<span">必須</span>
			</p>
			<p>
				LINE ID<br>
				<input type="text" name="lineId">
			</p>
			<p>
				KaKaoTalk ID<br>
				<input type="text" name="kakaoId">
			</p>
			<p>
				住所<br>
				<input type="text" name="address">
			</p>
			<p>
				携帯電話<br>
				<input type="text" name="phone">
			</p>
			<p>
				<input type="submit" value="会員登録">
			</p>
		</form>

		<!-- 生年月日 プルダウン 表示  -->
		<script>
			displayDate();
	    </script>
	</div>
</c:if>

</body>
</html>