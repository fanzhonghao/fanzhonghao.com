var page = require('webpage').create();
page.settings.userAgent = 'Mozilla/5.0 (Windows NT 6.1;WOW64; rv:49.0) Gecko/20100101 Firfox/49.0';
page.open('http://movie.mtime.com/108737/',function(status) {
  if (status !== 'success') {
    console.log('Unable to access network');
  }else {
    var u = page.evaluate(function() {
      return document.getElementById('ratingRegion').textContent;
    });
    console.log(u);
  }
  phantom.exit();
});
