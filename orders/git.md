How to use git hub ?
===
Basesd on ubuntu:
---
+ first, you should download git
+ then chose a folder, and enter order `git init` and then it will located in it
+ next step you can enter `git config --global user.name "your name"`
+ followed by enter `git config --global user.email "your email"`
+ then you should add remote address like this
`git remote add origin "your github url"`
> the origin stand for your github url in the following operation before uploading your codes

+ you can clone one warehouse by command like this  
`git clone "your address"`

+ and you can updata your warehouse by
`git pull`

+ then if it's normal, you can upload your codes by these three steps:
`git add .` or `git add "the document's url"`
> this order is used to add all floders, you can use  the name of floder to replace
> that dot to add just one floder

	`git commit -m "the name"`
> there you should add the name of the floder

	`git push -u origin master`
> if it's ok, you will commit your codes

use git to create a new  branch
---
	You can use the following orders to public it:
    	1. git branch name	--use for create a new branch locally
    	2. git checkout name  --use for switch to the new branch
    	3. git push origin name --use for publish it

use git to remove a floder
---
	you can use the following orders:
		1. git rm "..."
		2. git commit -m "remove ..."
		3. git push -u origin master
Change your origin
---
	you can use the following orders:
    	1. git remote set-url origin url --change directly
    	or
        1. git remote rm origin
        2. git remote add origin url --change after delete

 all of these