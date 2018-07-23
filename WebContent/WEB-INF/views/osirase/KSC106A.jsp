<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>お知らせ登録</title>
</head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//お知らせ一覧画面遷移
		$("#list").click(function() {
			location.href = "/kimschool_spring/osirase/list";
		});

		//お知らせ一登録処理
		$("#save").click(function() {

			if($("#title").val().trim() == ""){
				alert("タイトルを入力してください。");
				$("#title").focus();
				return false;
			}
			if($("#content").val().trim() == ""){
				alert("内容を入力してください。");
				$("#content").focus();
				return false;
			}

			var objParams = {
					title : $("#title").val(),
					content : $("#content").val(),
					file : $("#file").val()
			};


			$.ajax({
				url : "/kimschool_spring/osirase/save",
				dataType : "JSON",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				type : "GET",
				data : objParams,
				success : function(retVal){

					if(retVal.code=="OK"){
						alert(retVal.message);
						location.href = "/kimschool_spring/osirase/list";
				 	} else {
						alert(retVal.message);
					}
				},
				error : function(request,status,error){
					location.href = "/kimschool_spring/osirase/list";
					alert("code"+request.stats+"\n"+"message"+request.responseText+"\n"+"error"+error);
				}
			});

		});

	});
</script>
<style>
th {
	background-color: #6699FF;
}
</style>
<body>
	<!-- 登録項目 -->
		<table border="1" width="800px">
			<!-- タイトル -->
			<tr height="15px">
				<th width="200px">タイトル</th>
				<td width="600px"><input type="text" id="title" name="title"  size="83.7"></td>
			</tr>
			<!-- 内容 -->
			<tr height="200px">
				<th width="200px">内容</th>
				<td><textarea rows="20" cols="85" id="content" name="content"></textarea></td>
			</tr>
			<!-- 添付 -->
			<tr height="15px">
				<th width="200px">添付</th>
				<td width="600px"><button id="file" name="file">添付ファイル</button></td>
			</tr>
		</table>
	<table width="800px">
		<tr>
			<td align="center">
				<!-- 一覧ボタン -->
				<button id="list" name="list" >一覧</button>&nbsp&nbsp
				<!-- 登録ボタン -->
				<button id="save" name="save">登録</button>
			</td>
		</tr>
	</table>
</body>
</html>