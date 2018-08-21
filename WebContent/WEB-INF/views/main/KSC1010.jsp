<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="../css/KSC1010.css" type="text/css">
<script type="text/javascript" src="../js/KSC1010.js"></script>
<title>KimSchool Main</title>
</head>
<body>
	<div class="slideshow-container margin-back">
		<div class="mySlides fade" style="display: block;">
			<img src="../images/background/main_img_1.jpg" style="width: 100%; height: 70%">
		</div>

		<div class="mySlides fade">
			<img src="../images/background/main_img_2.jpg" style="width: 100%; height: 70%">
		</div>

<!-- 		<div class="mySlides fade">
			<img src="../images/background/rilakkuma.png" style="width: 100%; height: 300px">
		</div> -->
	</div>

	<div id="oshiraseBox">
		<div id = "blueArea">
		<span>NEWS & TOPICS</span>
		<span id = "showList"><a href = "게시판 링크">一覧を見る</a></span>
		</div>

		<c:forEach items="${boardInfoVoList }" var="vo" varStatus="status">
			<div class="information" id="showIndex${status.index }">
				<a href="/oshiraseList?idx=${vo.idx }">${vo.title }</a>
			</div>

		</c:forEach>
	</div>

	<div id = "bannerArea">
		<p><label>KIM SCHOOL Official SNS</label></p>
		<div id = "logoArea">
			<div class="facebookArea">
				<button class="imgFaceBook" onclick='openNewWindow("faceBook")'></button>
				<div class="txtFaceBook">kimschool_official</div>
			</div>

			<div class="instagramArea">
				<button class="imgInstagram" onclick='openNewWindow("instagram")'></button>
				<div class="txtInstagram">kimschool_official</div>
			</div>

			<div class="youtubeArea">
				<button class="imgYoutube" onclick='openNewWindow("youtube")'></button>
				<div class="txtYoutube">kimschool_official</div>
			</div>
		</div>

	</div>
</body>
</html>