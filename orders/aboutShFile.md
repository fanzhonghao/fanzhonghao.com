### 关于创建与执行`.sh`文件
<hr>
执行 .sh文件的三种方法:  
bash xxx.sh    
./ xxx.sh    
sh xxx.sh    

创建了 .sh文件之后，即可使用 `bash`和`sh`来执行，  
要想用 `.` 来执行，需要先为文件添加执行权限。  
	chmod +x xxx.sh  
之后即可使用`.`来执行  
另外：`source` xxx.sh, `dash` xxx.sh来执行。  
