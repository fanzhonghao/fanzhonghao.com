var page = require('webpage').create();
page.open('https://github.com/fanzhonghao/',function(status){
	console.log("Status: " + status);
	if(status === "success"){
		page.render('github-fan.png');
	}
	phantom.exit();
});
