How to use git hub ?
===
Basesd on ubuntu:
---
+ first, you should download git
+ then chose a folder, and enter order "**git init**" and then it will located in it
+ next step you can enter " **git config --global user.name "your name"** "
+ followed by enter "**git config --global user.email "your email"**"
+ then you should add remote address like this
"**git remote add origin "your github url"** "
the origin stand for your github url in the following operation before uploading your codes
+ you should check your warehouse by clone
"**git clone "your address"**"
+ after this you can updata your warehouse by
"**git pull**"
+ then if it's normal, you can upload your codes by these three steps:
 **git add .**
 >this order is used to add all floders, you can use  the name of floder to replace
 >that dot to add just one floder

 **git commit -m "..."**
 >there you should add the name of the floder

  **git push -u origin master**
  >if it's ok, you will commit your codes

use git to remove a floder
---
	you can use following orders:
	  1. git rm "..."
	  2. git commit -m "remove ..."
	  3. git push -u origin master

 all of these