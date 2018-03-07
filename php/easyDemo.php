<html>
    <head>
        <title>
            study
        </title>
    </head>
    <body>
        <?php
        define("name", "fan"); # 声明常量
        echo 'hello' , " " , name;
        echo '<br />';# 换行
        echo __FILE__,'<br />';# 输出当前文件路径和文件名
        echo PHP_VERSION;# 输出PHP版本
        $a = "test";# 定义变量
        echo '<br />',$a;
        $a = "hello";
        echo '<br />',$a;
        $a = "test";
        $$a = "test2";# 可变变量
        echo '<br>',$test;
        $a = "hello world";
        function printHello(){
            global $a;# 声明要调用的变量是全局变量
            echo '<br />',$a;
        }
        printHello();
        function printHello1(){
            $a = $GLOBALS['a'];# 通过 $GLOBALS 数组访问全局变量
            echo '<br />',$a;
        }
        printHello1();
        unset($a);# 销毁变量
//        echo $a;# 变量已经销毁，将报错
        # 数组
        echo '<br/>';
        $arr = array(0=>1,1=>1E+05,2=>"hello world");
        for ($i = 0;$i < count($arr);$i++){
            echo $arr[$i],'<br />';
        }
        $float1 = 22.01;
        echo "float1 = ",$float1,"<br/>after: float1 = ",settype($float1, 'int')."<br/>";
        # 类型转换后出现错误
        echo 'test'."test1"."<br/>";
        $err = @(1 / 0);# @用于屏蔽错误显示
        echo "随机数： ".rand(1, 100)."<br/>"; # 内置函数rand() 可产生随机数
        
        function add(&$a,$b){
            $a += $b;
        }
        $a = 1;
        $b = 2;
        add($a, $b);
        echo '引用调用相加和：'.$a;
        function &add1($a,$b){
            $a += $b;
//            return ($a + $b); 这样的写法错误？
            return $a;
        }
        $test1 = &add1($a, $b);
        echo '<br/>a = '.$a.'<br/>'.'b = '.$b.'<br/>'.$test1;
        $arr = array("test1","test2","test3");
        foreach ($arr as $tmp){ # foreach循环遍历
            echo '<br>'.'$arr[] = '.$tmp;
        }
        # 演示单引号和双引号
        echo "<br />双引号中".'$test1为'."$test1";
        echo "<br/>单引号中".'$test1为'.'$test1';
        $str = "   This is a string   ";
        echo '<br/>字符串长度为: '. str_word_count($str);
        echo '<br/>原始字符串： '.$str;
        echo '<br/>ltrim:  '. ltrim($str);
        echo '<br/>rtrim:  '. rtrim($str);
        echo '<br/>trim:   '. trim($str);
        $str = "split_this_sentance";
        $str1 = "按 空格 拆分 句子。";
        echo '<br/>';
        $a = explode('_', $str);
        print_r($a);
        echo '<br/>';
        $b = explode(' ', $str1);
        print_r($b);
        echo '<br/>'.implode('>', $a);
        echo '<br/>'. implode('*', $b);
        
        # 正则表达式
//        $email = '123456@qq.com';
//        $regex = '^[a-zA-Z0-9_.]+@[a-zA-Z0-9_]+\.[a-zA-Z0-9.]+$';
//        if (eregi($regex, $email))
//        {
//            echo '<br/>This is a email.<br/>';
//        }
        # ???
        #正则表达式切分字符串
        $str = "A easy sentance.";
        $token = strtok($str," ");
        while ($token !== false){
            echo "$token<br/>";
            $token = strtok(" ");
        }
        # 关联索引数组
        $price_per_day = array("单人间" => 100,"标准间" => 200,'三床房' => 300);
        echo '<br/>单人间价格'.$price_per_day["单人间"];
        
        const arr = array("1","2","3");
        echo '<br/>'.arr[0];
        define("arr1", ["1","2","3"]);
        echo '<br/>'.arr1[0];
        # 遍历一维联合索引数组
        foreach ($price_per_day as $price):
            echo '<br/>'.$price;
        endforeach;
        foreach ($price_per_day as $key => $price):
            echo '<br/>'.$key.' => '.$price;
        endforeach;
        reset($price_per_day);# 把实时元素重新定义为数组的开头元素
        while ($element = each($price_per_day)):#each为遍历数组元素及关键字的函数
            echo '<br/>'.$element['key']."  ".$element['value'];
        endwhile;
        
        echo '<br/>test';
        foreach ($price_per_day as $key => $price):
            echo '<br/>'.$key.' => '.$price;
        endforeach;
        echo '<br/>endtest';
        
        reset($price_per_day);
        while (list($type,$price) = each($price_per_day)):#list把each()中的值分开赋值和输出
            echo '<br/>'."$type - $price";
        endwhile;
        reset($price_per_day);
        # 字符串与数组之间的转换
        echo '<br/>字符串与数组之间的转换';
        echo '<br/>'.implode('元/每天  ', $price_per_day).'<br/>';
        
        $arr1 = '单人房,标准间,三床房';
        print_r(explode(',',$arr1));# 可以直接输出数组
        
        echo '<br/>';
        $arr1 = explode(',', $arr1);
        array_unshift($arr1, "四人房");
        print_r($arr1);
        echo '<br/>从头删除<br/>';
        array_shift($arr1);
        print_r($arr1);
        if (in_array('单人房', $arr1)):# in_array()查询数组中指定元素
            echo '<br/>单人房在$arr1中';
        endif;
        echo '<br/>$arr1中元素个数为： '. count($arr1);
        echo '<br/>$price_per_day中相同元素值的个数： ';
        print_r(array_count_values($price_per_day));
        
        date_default_timezone_set("PRC");#设置默认时区为北京时间
        $t = time();
        echo '<br/>当前时间为：';
        echo '<br/>'. date("Y年m月d日[l]H点i分s秒",$t);
        echo '<br/>'. date("F,d,y l",$t);
        echo '<br/>'. date('Y-M-D H:I:S',$t).'<br/>';
        
        unset($arr);#释放
        
        @($arr = getdate(date(time())));
        print_r($arr);
        echo '<br/>'.$arr['year'].'年'.$arr['mon'].'月'.$arr['mday'].'日';
        # 类
        class student{
            private $name;
            public function getName() {
                return $this->name;
            }
            public function setName($a){
                $this->name = $a;
            }
        }
        $name1 = "小明";
        $xiaoMing = new student();
        $xiaoMing->setName($name1);
        echo '<br>'.'name is '.$xiaoMing->getName();
        
        class student2{
            private $name;
            public function __construct($name1) {
                $this->name = $name1;
            }
//            private function __destruct() {
//                echo '<br>'.'destruct';
//            }
            public function getName(){
                return $this->name;
            }
        }
        $xiaohong = new student2("小红");
        echo '<br>'.'name is '.$xiaohong->getName();
        # 访问方法(accessor) _get and _set
        class guests{
            public $property;
            function _set($propName,$propValue){
                $this->$propName = $propValue;
            }
            function _get($propName){
                return $this->$propName;
            }
        }
        $xiaohua = new guests;
        $xiaohua->name = "小华";
        $xiaohua->gender = "男性";
        echo '<br>'.$xiaohua->name.'是'.$xiaohua->gender;
        # 类继承
        class A{
            var $name = 1;
        }
        class B extends A{
            var $name2 = 2;
        }
        $b = new B();
        echo '<br>继承： '.$b->name.' '.$b->name2;
        
        function numtest($num){
            if($num > 1):
                throw new Exception("数值必须小于1");
            endif;
            return TRUE;
        }
        try{
            numtest(2);
            echo '<br/>没有异常';
        } catch (Exception $e) {
            echo '<br/>异常信息：'.$e->getMessage();
        }
        # 处理异常
        @$fp = fopen("book.txt", 'rb');
        try{
            if(!$fp){
                throw new Exception("<br/>文件路径错误");
            }
        } catch (Exception $ex) {
            echo $ex->getMessage();
            echo '在文件'.$ex->getFile().'的'.$ex->getLine().'行<be/>';
        }
        @fclose($fp);
        
        echo '<br/>文件位置: '.$_SERVER['DOCUMENT_ROOT'];
        echo '<br/>工作目录: '. getcwd();
        
        ?>
    </body>
</html>