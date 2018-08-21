<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>お問い合わせ</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#checkForm").on("click", checkForm);

			function checkForm(){

				var unicode = $("#name_kanji").val().charCodeAt(0);

				//お名前が未入力かチェック
				if ($("#name_kanji").val().length < 1) {
					alert('お名前を入力してください');
					return false;
				}

				//お名前に漢字以外の項目を入力
				if (!((unicode >= 0x4e00 && unicode <= 0x9fcf)
						|| (unicode >= 0x3400 && unicode <= 0x4dbf)
						|| (unicode >= 0x20000 && unicode <= 0x2a6df)
						|| (unicode >= 0xf900 && unicode <= 0xfadf) || (unicode >= 0x2f800 && unicode <= 0x2fa1f))) {
					alert('お名前に漢字を入力してください');
					return false;
				}

				//お名前の桁数チェック
				if ($("#name_kanji").val().length > 20) {
					alert('お名前に20桁以下の桁数を入力してください');
					return false;
				}

				var name_hurigana = document.getElementById("name_hurigana");

				//お名前(フリガナ)が未入力かチェック
				if (name_hurigana.value.length < 1) {
					alert('お名前(フリガナ)を入力してください');
					return false;
				}

				//お名前(フリガナ)に全角フリガナ以外の項目を入力
				if (!name_hurigana.value.match(/^[ァ-ヶー　]*$/)) {
					alert('お名前(フリガナ)に全角フリガナを入力してください');
					return false;
				}

				//お名前(フリガナ)の桁数チェック
				if (name_hurigana.value.length > 20) {
					alert('お名前(フリガナ)に20桁以下の桁数を入力してください');
					return false;
				}

				var email = document.getElementById("email");
				var regexp = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;

				//メールアドレスが未入力かチェック
				if (email.value.length < 1) {
					alert('メールアドレスを入力してください');
					return false;
				}

				//メールアドレスの形式以外の項目かチェック
				if (!email.value.match(regexp)) {
					alert('メールアドレスの形式に入力してください');
					return false;
				}

				var content = document.getElementById("content");

				//お問い合わせ内容が未入力かチェック
				if (content.value.length < 1) {
					alert('お問い合わせ内容を入力してください');
					return false;
				}

				var checkContent = inquiry.checkContent.checked;

				if(!checkContent){
					alert("送信内容を確認したらチェックを入れてください");
					return false;
				}

				location.href="/kimschool_spring/inquiry/test";
			}
		});

	</script>
</head>
<body>
<div id="header">
	<%@ include file="/header.jsp" %>
</div>
<div id="container">
	<!-- フォーム -->
	<form name="inquiry" action="/kimschool_spring/inquiry/test" method="post">
		<table>
			<tr>
				<h2>お問い合わせ</h2>
			</tr>
			<tr>
				<td></td>
				<td>*必須項目</td>
			</tr>

				<tr>
					<td>カテゴリー<span>*</span></td>
					<td>
						<select name="category" >
							<option value="STUDY関連">STUDY関連</option>
							<option value="その他">その他</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>お名前<span>*</span></td>
					<td>
						<input type="text" name="name_kanji" id="name_kanji">
					</td>
				</tr>
				<tr>
					<td>お名前(フリガナ)<span>*</span></td>
					<td>
						<input type="text" name="name_hurigana" id="name_hurigana">
					</td>
				</tr>
				<tr>
					<td>メールアドレス<span>*</span></td>
					<td>
						<input type="text" name="email" id="email">
					</td>
				</tr>
				<tr>
					<td>お問い合わせ内容<span>*</span></td>
					<td>
						<textarea rows="50" cols="50" name="content" id="content"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="checkbox" name="checkContent">
						上記送信内容を確認したらチェックを入れてください
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button id="checkForm">メールを送信する</button>
					</td>
				</tr>
		</table>
	</form>
</div>
<div id="footer">
	<%@ include file="/footer.jsp" %>
</div>
</body>
</html>
