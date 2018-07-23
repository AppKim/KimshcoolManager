var slideIndex = 1;

var backImg;
var slides = document.getElementsByClassName("mySlides");
var currentSlide = slides[0];
var container = document.getElementsByClassName("slideshow-container");

setInterval(function() {
	var i;
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    currentSlide = slides[slideIndex-1];
    currentSlide.style.display = "block";

}, 3000);


window.onload = function(){

	limitBoard();

	container[0].onmouseleave =function(){
		intervalId = setInterval(function() {
			var i;
		    for (i = 0; i < slides.length; i++) {
		       slides[i].style.display = "none";
		    }
		    slideIndex++;
		    if (slideIndex > slides.length) {slideIndex = 1}
		    currentSlide = slides[slideIndex-1];
		    currentSlide.style.display = "block";

		}, 3000);
	};

	container[0].onmouseover=function(){

		currentSlide.style.display = "block";
		clearInterval(intervalId);
	};
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