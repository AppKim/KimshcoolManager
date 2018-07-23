<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>お知らせ一覧</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">

//登録画面遷移
$(document).ready(function(){
	$("#write").click(function(){
		location.href = "/kimschool_spring/osirase/create"; //戻るボタン非活性化のためにreplace使用
		//location.href = "edit.jsp";
	});
});

</script>
<body>

<!-- 新規作成ボタン -->
<table width="800px">
	<tr>
		<td align="right">
			<button id="write" name="write">新規作成</button>
		</td>
	</tr>
</table>

<!-- お知らせリスト -->
<table border="1" width="800px">
	<tr bgcolor="#6699FF">
		<!-- 掲載番号 -->
		<th width="50px" >NO</th>
		<!-- タイトル -->
		<th width="550px">タイトル</th>
		<!-- 作成者 -->
		<th width="100px">作成者</th>
		<!-- 作成日 -->
		<th width="150px">作成日</th>
		<!-- 観覧数 -->
		<th width="50px">観覧数</th>
	</tr>
	<c:forEach items="${list }" var="vo" varStatus="status">
	<tr>
		<th>${vo.idx }</th>
		<th><a href="/kimschool_spring/osirase/view?idx=${vo.idx}">${vo.title }</a></th>
		<th>${vo.user_id }</th>
		<th>${vo.reg_date }</th>
		<th>${vo.count }</th>
	</tr>
	</c:forEach>

</table>
</body>
</html>