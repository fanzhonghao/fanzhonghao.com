window.onload = rolloverInit;
function rolloverInit() {
  for (var i = 0; i < document.images.length; i++) {
    if (document.images[i].parentNode.tagName == "A") {
      setupRollover(document.images[i]);
    }
  }
}
function setupRollover(theImage) {
  theImage.outImage = new Image();
  theImage.outImage.src = theImage.src;
  theImage.onmouseout = function() {
    this.src = this.outImage.src;
  }

  theImage.overImage = new Image();
  theImage.overImage.src = "images/" + theImage.id + "_on.jpg";
  theImage.onmouseover = function(){
    this.src = this.overImage.src;
  }
}
