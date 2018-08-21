var slideIndex = 1;

var backImg;
var slides = document.getElementsByClassName("mySlides");
var currentSlide = slides[0];
var container = document.getElementsByClassName("slideshow-container");
var timer = 5000;

var intervalId = setInterval(function() {
	var i;
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    currentSlide = slides[slideIndex-1];
    currentSlide.style.display = "block";

}, timer);

$(document).ready(function(){

});

window.onload = function(){

	limitBoard();

	container[0].onmouseover = function(){

		currentSlide.style.opacity = "0.4";
		clearInterval(intervalId);
	};

	container[0].onmouseleave = function(){
		currentSlide.style.opacity = "1.0";
		intervalId = setInterval(function() {
			var i;
		    for (i = 0; i < slides.length; i++) {
		       slides[i].style.display = "none";
		    }
		    slideIndex++;
		    if (slideIndex > slides.length) {slideIndex = 1}
		    currentSlide = slides[slideIndex-1];
		    currentSlide.style.display = "block";
		}, timer);
	}
}

function limitBoard(){
	var limit = 2;

	var i;
	var information = document.getElementsByClassName("information");
	for(i=0;i<information.length;i++){
		if(i>=limit){
			information[i].style.display="none";
		}
	}
}

function openNewWindow(openName){
	window.open()
}