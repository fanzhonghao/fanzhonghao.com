# phpStudy--First  
声明常量：  
> define("常量名",常量值)  

PHP中的变量是弱类型，不需要对每一个变量声明类型，PHP中的变量以"$"作为前缀，以字母或下划线作为开头。  
PHP中不需要显示的声明变量。  
PHP中变量的使用也需要以"$"作为前缀。  

可变变量：  
以"$$"为前缀声明可变变量。
> $a = "test"; $$a = "demo";  

例子中 $test = "demo"。可以看出其中 test 相当于 $a。  
在PHP中，函数不能直接访问外部全局变量，可以在函数中通过 global 关键字来声明要调用的变量为全局变量。  
也可以通过 $GLOBALS 数组来访问全局变量。  
> $a = $GLOBALS['a'];

这样即可访问外部全局变量 a。  
在函数中，在变量的前面加上 static 关键字，可声明静态变量。  
> static $a = 5;

PHP可以自动回收垃圾，也可以手动销毁变量。  
> unset (变量)

当在函数中销毁变量时，如果变量是局部变量，则变量可被销毁，如果是全局变量，则不能被销毁。  

在PHP中，使用list()函数或array()函数来创建数组，也可以直接赋值。  
> $arr = array(0=>1,2=>1E+05,1=>"string");  
> $arr = array(1,1E+05,"string");  
> $arr[0] ;  

第一，二句为声明和赋值数组，第三句为引用。  
PHP使用"."来将两个字符串连接成一个字符串。  
> echo "test"."test1";

PHP除了常见比较运算符外，还有"==="和"!=="比较运算符。  
其中"==="为精确等于，要求比较双方不仅数值相等，类型也要一致。  
"!=="为不精确等于，比较双方可能数值不等，也可能类型不同。  

<b>错误控制运算符 "@",在一个操作数之前使用，用来屏蔽错误信息的生成。</b>    
> $err = @(1 / 0);

自定义和调用函数：  
> function name_of_function(param1,param2,...){  
>     statement  
> }  

在函数中要使用引用调用时，在参数前加上"&"即可。  
同样也可以对函数进行引用，定义函数时，在函数名之前加上"&"。  
如果要使用在别的文件中的函数或变量，需要包含被引用的文件名:  
> require(name) 或者 include(name)

其中require()在脚本执行前读入它包含的文件，include()在脚本读到它的时候才将包含的文件读进来。  
> include_once()和require_once()作用与include和require语句类似，但是如果文件已经被包含，则不会重复包含。  

在PHP中的 break 语句中，可以在break后加上Int值，其中int值表示要跳出的嵌套数，默认为1。  
在字符串的使用中，单引号和双引号存在区别。  
双引号中会输出变量的值，单引号中直接输出变量名称。  
双引号中使用'\'转义字符输出的特殊字符为：  
	
	\n:新一行  
	\t:Tab  
	\\:反斜杠  
	\0:ASCII码的0  
	\$:把此符号转义为单纯的美元符号，而不再作为声明变量使用。  
	\r:回车
	\{local #}:八进制转义
	\x{hexadecimal #}:十六进制转义

单引号能够通过'\'转义的特殊字符只有：  

	\':转义为单引号本身
	\\:转义为反斜杠本身

在PHP中，既可以通过'\'手动转义，也可以通过内置函数addslashes()来完成，还原此操作则是通过stripslashes()来完成的。这两个函数也用于格式化字符串，以用于MySQL的数据库存储。  
内置函数str_word_count()函数可以统计字符串中单词数量，但是只对ASCLL码的英文单词起作用。  

清除空格：ltrim(),rtrim()和trim()函数。  
以上三个函数分别为从左边清除字符串头部空格，从右边清除字符串尾部空格，从两边同时清除头部和尾部空格。  
字符串的切分与组合：  
切分使用explode()和strtok()函数。组合使用implode()和join()函数。  
explode()把字符串切分成不同部分然后存入一个数组，implode()函数则是把数组中元素按照一定的间隔标准组合成一个字符串。  

> substr(目标字符串，起始位置，截取长度) # 截取字符串子串  
> substr_replace(目标字符串，替换字符串，起始位置，替换长度) # 字符串子串替换  
> strstr(目标字符串，需查找的字符串) # 字符串查找，返回从第一个查找到字符串的位置往后所有的字符串内容。  
> stristr()函数为不敏感查找，用法与strstr()相同，但是对大小写不敏感。  
> strtolower(string);strtoupper(string);转换为小写/大写  
> ucfirst(string) 字符串首字母大写  
> ucwords(string) 整个字符串中以空格为分隔符的单词首字母大写  

PHP中使用ereg(<b>正则表达规范</b>，目标字符串，数组)来根据指定模式匹配文件名或字符串。  
也可以使用eregi(...)，ereg对大小写不敏感，eregi敏感。  
使用正则表达式替换字符串子串：  
> ereg_replace(正则表达式规范，欲取代字符串子串，目标字符串)

使用正则表达式切分字符串：  
> strtok(正则表达式规范，目标字符串)

该函数以正则规范内出现的字符为准，把目标切分成若干子串，并且存入数组。  
关联索引数组键名可以是数值和字符串的组合。  
> $price_per_day = array("单人间" => 100,"标准间" => 200);  
> echo $price_per_day["单人间"];

常量数组：  
php5.6中：  
> const arr = array(...);  

php7中可以使用define()定义。  
> define("arr1", ["1","2","3"]);  

遍历数组时，若是使用each()函数，会将内存中的实时函数置为数组的最后一个元素，若想继续重复使用each()，则需要将数组reset(array)一下。  
<b>排序函数</b>  
内置排序函数中：sort()为默认排序，asort()根据数组元素值的升序排序，ksort()根据数组元素的键值即关键字升序排序。  
rsort(),arsort(),krsort()为对应的降序排序。  
PHP对数组添加元素使用push和unshift函数。  
> array_unshift($array,value);

PHP从数组中删除元素使用 pop和shift：  
> array_pop($array);

其中push和pop从尾部操作，shift和unshift从头部操作。  
PHP提供in_array()、array_key_exists()、array_search()、array_keys()和array_values()函数按照不同的方式查询数组。  
用内置函数 count() 统计数组中元素个数。  
array_count_values()对数组中相同元素值个数进行统计。  
array_unique($array)将$array数组中值相同的元素清除。  
array_flip($array)调换数组中的键值和元素值。  
serialize($array)将数组序列化为字符串。  
unserialize($string)将字符串反序列化为数组。  
<b>获取当前时间</b>  
> $t = time();#距离1970.1.1 0：0：0 到当前的时间秒数
> $t = date();#返回当前日期

string date(string format [时间戳整数]) 产生格式化时间  
getdate()函数返回数组，包含日期和时间的各个部分。  
> getdate(date(time()))

PHP中类的使用：  
> 权限修饰符 class 类名{  
>   类的内容;
>  }

在PHP类中声明成员属性时，不可以进行赋值操作。  
类的实例化：  
> $变量名 = new 类名称([参数]);

new为创建对象的关键字。  
PHP中引用可以访问的成员属性和方法时，使用运算符 <b>"->"</b>。  
> $变量名 = new 类名();  
> $变量名->成员属性 = 值;  
> $变量名->成员方法;  

使用操作符 <b>"$this"</b> 来完成对象内部成员之间的访问。  
使用操作符 "::" 可以在没有声明实例的情况下访问类中的成员。语法如下：  
> 关键字::变量名/常量名/方法名  

其中，关键字主要包括parent、self和类名3种。  
PHP中的构造方法在PHP5之前使用构造方法与类名相同的方式，从PHP5版本开始，构造方法的名称必须以两个下划线开头，即"__construct",语法格式如下：  
> function __construct([mix args]){  
> }  

同样析构方法的名称也必须以两个下划线开头，即"__destruct"，语法格式如下：  
> function __destruct(){  
> }

访问方法(accessor):  
通过使用访问方法_get和_set可以避免直接对类属性的访问。无论何时，类属性被访问和操作时，访问方法都会被激发。    
> class guests{  
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

"$xiaohua->name = "小华";" 和 "$xiaohua->gender = "男性";"直接添加属性 name和gender并且赋值，此时类guest中的 _set 函数被调用。 $xiaohua->name 则是调用了类 guest 中 _get 函数。  

类继承的关键字为 "extends"。  
用"static"声明类熟悉或方法，就可以不实例化类而直接访问。静态属性不能通过一个类已实例化的对象来访问，但是静态方法可以。静态方法不需要通过对象即可调用，因此伪变量 $this 在静态方法中不可用。静态属性不可以由对象通过 -> 操作符来访问。从PHP 5.3.0起，可以用一个变量来动态调用类。但是该变量的值不能为关键字self、parent或static。  
静态属性和静态方法不需要实例化就可以直接使用调用格式为"类名::静态属性名"或"类名：：静态方法名"。  
final关键词可以终止类的继承。final类不能有子类，final方法不能被覆盖。  

<b>抽象类：</b>   
抽象类使用abstract来声明，语法格式如下：  
> abstract class 抽象类名称{  
>          abstract function 成员方法1(参数);  
>          abstract function 成员方法2(参数);  
> }  

抽象类和普通类的主要区别在于抽象类的方法没有方法内容，而且至少包含一个抽象方法。抽象方法也必须使用关键字abstract来修饰，抽象方法后必须有分号。  

PHP只支持单继承，如果要实现多继承，就需要使用接口。PHP可以实现多个接口。  
接口类通过关键字interface来声明，接口中不能声明变量，只能使用关键字const声明为常量的成员属性，接口中声明的方法必须是抽象方法，并且接口中所有成员都必须具有public访问权限。格式如下：  
  
> interface 接口名称{  
> //常量成员  
> //抽象方法  
> }

实现接口使用 "implement" 关键字。  
> class 接口类 implement 接口名称{}  

实现接口的类必须实现接口中声明的所有方法，除非该类为抽象类。  

在(function(){})();中，function前的一对括号作为分隔符，后面的括号表示立即执行这个方法。  

try...throw...catch异常处理。  

得到当前文件位置: $_SERVER['DOCUMENT_ROOT'];  
得到当前工作目录: getcwd();  

通过PHP用户可以创建cookie。创建cookie使用setcookie()函数，语法如下：  
> setcookie(名称，cookie值，到期日，路径，域名，secure)

其中secure表示cookie不能通过单一的HTTP连接传递。   
setcookie()函数必须位于<html>标签之前。  
> setcookie("user","value",time()+3600);

上述程序会在Cookies文件加下自动创建一个Cookie文件，有效期为一小时，在Cookie失效后，Cookies文件会自动被删除。  
使用$_COOKIE变量取回Cookie值。  
使用isset()函数确认是否已经设置cookie。  
PHP中有三种创建会话的方式，包括PHP自动创建、使用session_start()函数创建和使用session_register()函数创建。  
使用session_start()函数：  
> bool session_start(void);

这个函数首先检查当前是否已经存在一个会话，如果不存在，就创建一个全新的 会话，并且这个会话可以访问超全局变量$_SESSION数组。如果已经有一个存在的会话，函数会直接使用这个会话，加载已经注册过的会话变量，然后使用。  
session_start(void)函数必须位于<html>标签之前。  
会话变量被启动后，全部保存在数组$_SESSION中。用户可以通过对$_SESSION数组赋值来注册会话变量。  
> $_SESSION['name']='xiaohong';

会话变量值会在会话结束或被注销后失效，或者根据 php.ini中的session.gc_maxlifetime(time)设置会话最大生命周期数，过期失效。  
使用isset()或empty()来确定$_SESSION中会话变量是否为空。  
使用$_SESSION变量：  
> $_SESSION['views']=1;  
> echo $_SESSION['views];  

注销会话变量：  
> unset($_SESSION['name']);  

如果cookie不设定失效时间，则表示它的生命周期为未关闭浏览器前的时间段，一旦浏览器关闭，Cookie就会自动消失。  
浏览器最多存储300个Cookie文件，每个Cookie文件最大4KB，一旦超过4KB，浏览器则会自动删除。  

连接数据库：  
> $db=mysqli_connect('MySQL服务地址','用户名','密码','数据库名');

关闭数据库连接：  
> mysqli_close(连接对象);

执行SQL语句：  
> mysqli_query(连接对象，SQL语句);

获取查询结果集中的记录数：  
> mysqli_num_rows(result);

获取查询、插入、更新和删除操作所影响的行数：  
> mysqli_affected_rows(connection);

从查询结果中取出数据：  
> $row = mysqli_fetch_rows(result);  #每次只能取出一条

上述查询方法结果以数组的形式存放。  
取出查询结果方法为：  
> $row[n];

另一种方法：  
> $row = mysqli_fetch_assoc(result)

查询结果存放在关联数组中。  
取出查询结果方法为:  
> $row["name"];

获取结果集中记录作为对象：  
> $row  = mysqli_fetch_object(result);

取出查询结果方法为:  
> $row->name;  

获取结果集记录：  
> $row = mysqli_fetch_array(result[,result_type]);

其中result_type可以选择MYSQL_ASSOC（关联数组）、MYSQL_NUM(数字数组)和MYSQL_BOTH(二者兼有)，默认为MYSQL_BOTH.  
取出查询结果方法为:  
> $row["name"];  
> 或$row[1];

释放资源：  
> mysqli_free_result(SQL请求所返回的数据库对象)

释放SQL请求所返回的对象所占用的资源。  
