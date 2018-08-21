<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/kimschool_spring/css/common.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="header_table_layout" style="margin:0px 0px 20px 0px">
		<table height="100px" cellspacing="0" border="0">
			<colgroup>
				<col width="10%" />
				<col width="10%" />
				<col width="8%" />
				<col width="8%" />
				<col width="8%" />
				<col width="5%" />
				<col width="10%" />
				<col width="27%" />
			</colgroup>
			<tr class="header_table_layout_tr">
				<td rowspan="2" align="center"><img src="/kimschool_spring/img/leftlogo.png" height="40%"></td>
				<td height="50px"><td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<img src="/kimschool_spring/img/facebook.png" height="60%" style="margin-top: 20px" onclick='window.open("https://www.facebook.com/Kimschool-439867869811236", "Kimschool Official", "width=1000, height=600, left=100, top=50")'>
					<img src="/kimschool_spring/img/insta.png" height="60%" onclick='window.open("https://www.instagram.com/kimschooljp", "Kimschool Official", "width=1000, height=600, left=100, top=50")'>
					<img src="/kimschool_spring/img/youtube.png" height="60%">
				</td>
				<td>
					<select style="margin-top: 20px" >
						<option>日本語&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
						<option>한국어&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
				</td>
			</tr>
			<tr class="header_table_layout_tr">
				<td id='kimschool' onclick='location.href="hello.jsp"'>KIM SCHOOL</td>
				<td id='cource' onclick='location.href="hello.jsp"'>授業コース</td>
				<td id='news' onclick='location.href="hello.jsp"'>NEWS&TOPICS</td>
				<td id='galary' onclick='location.href="hello.jsp"'>ギャラリー</td>
				<td id='qna' onclick='location.href="hello.jsp"'>Q&A</td>
				<td id='mail' onclick='location.href="/kimschool_spring/inquiry/index.action"'>お問い合わせ</td>
				<td id='login' onclick='location.href="/kimschool_spring/login/index.action"'>LOGIN / 会員登録</td>
			</tr>
		</table>
	</div>
</body>
</html>