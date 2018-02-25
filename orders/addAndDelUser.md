# Add and delete user on ubuntu
<hr>
<b>新建用户：</b>  

使用命令 `useradd`来新建用户。  
> sudo useradd test

adduser会自动创建 用户目录 和 shell,并且自动创建分组。  

使用 `passwd` 命令可以为用户设置密码：  
> sudo passwd test

<b>修改用户：</b>  
使用命令 `usermod` 修改用户信息  
> usermod -l test test1  
> 用 test 替换 test1  

<b>删除用户</b>  
使用命令 `userdel` 删除用户  
> sudo userdel test


<b>删除用户同时删除用户工作目录</b>  
> sudo userdel -r test

