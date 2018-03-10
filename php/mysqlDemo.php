<html>
    <head>
        <title>

        </title>
    </head>
    <body>
        <?php
        $host = 'localhost';
        $username = 'fan';
        $password = 'xxx';
        $port = 3306;
        $database = "test";
        $db= mysqli_connect($host, $username, $password, $database, $port)
                or die('无法连接数据库');
        $sql = "select * from firsttable";
        $result = mysqli_query($db,$sql);# $result为资源类型，保存查询结果集
        $num = mysqli_num_rows($result);
        echo '<br/>查询结果中的记录数： '.$num;
        ?>
        <table width = "300" border="1" cellspacing="0" cellpadding="0">
            <tr>
                <th>姓名</th>
                <th>编号</th>
            </tr>
            <?php
                    while ($row= mysqli_fetch_row($result)){
                        #逐行获取结果集中的记录，并显示在表格中
            ?>
            <tr>
                <td align="center"><?php                    echo $row[0]; ?></td>
                <td align="center"><?php                    echo $row[1]; ?></td>
            </tr>
        <?php
                    }   
        ?>
        </table>
        
        <?php
        mysqli_free_result($result);
        mysqli_close($db);
        ?>
    </body>
</html>
