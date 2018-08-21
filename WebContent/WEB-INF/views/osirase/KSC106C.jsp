<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>お知らせ情報</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//一覧画面遷移
	$("#list").click(function(){
		location.href="home.jsp";
	});
	//編集画面遷移
	$("#modify").click(function(){
		location.href="modify.jsp";
	});
});

</script>
<style>
	th{
		background-color: #6699FF;
	}
</style>
<body>
<!-- お知らせ情報 -->
<table border="1" width="800px">
    <!-- 掲載番号 -->
	<tr height="15px">
		<th width="200px">番号</th>
		<td width="600px">1</td>
	</tr>
	<!-- タイトル -->
	<tr height="15px">
		<th width="200px">タイトル</th>
		<td width="600px">【情報】プロジェクト開始</td>
	</tr>
	<!-- 観覧数 -->
	<tr height="15px">
		<th width="200px">観覧数</th>
		<td width="600px">1000</td>
	</tr>
	<!-- 作成者 -->
	<tr height="15px">
		<th width="200px">作成者</th>
		<td width="600px">管理者</td>
	</tr>
	<!-- 作成日 -->
	<tr height="15px">
		<th width="200px">作成日</th>
		<td width="600px">2018/06/29</td>
	</tr>
	<!-- 更新日 -->
	<tr height="15px">
		<th width="200px">更新日</th>
		<td width="600px">-</td>
	</tr>
	<!-- 内容 -->
	<tr height="200px">
		<th width="200px">内容</th>
		<td>企画中止</td>
	</tr>
	<!-- 添付ファイル -->
	<tr height="15px">
		<th width="200px">添付</th>
		<td width="600px"><button id="file" name="file">添付ファイル</button></td>
	</tr>
</table>
<table width="800px">
	<tr >
		<td align="center">
		<!-- 一覧画面遷移ボタン -->
		<button name="list" id="list" name="list">一覧</button>&nbsp&nbsp
		<!-- 編集画面遷移ボタン -->
		<button id="modify" name="modify">編集</button>
		</td>
	</tr>
</table>
</body>
</html>