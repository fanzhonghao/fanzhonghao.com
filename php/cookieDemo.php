<?php
setcookie("user","cookieTest", time()+60);
session_start();
$_SESSION['name']='xiaohong';
?>
<html>
    <head>
        <title>
            cookieTest
        </title>
    </head>
    <body>
        <?php
        if(isset($_COOKIE["user"])){
            echo $_COOKIE["user"]."<br/>";# 输出一个cookie
            print_r($_COOKIE);# 输出所有cookie
        } else {
            echo '没有cookie';
        }
        echo '<br/>name = '.$_SESSION['name'];
        unset($_SESSION['name']);# 注销会话
        
        ?>
    </body>
</html>