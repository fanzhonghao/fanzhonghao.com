var page = require('webpage').create();

page.viewportSize = {width:1024,height:768};//视为将打开的浏览器窗口缩放
page.clipRect = {top:256,left:256,width:512,height:256}//前两个是基点，后两个是宽和高

page.open('https://github.com/fanzhonghao/',function(status){
	console.log("Status: " + status);
	if(status === "success"){
		page.render('github-fan.png');
	}
	phantom.exit();
});
