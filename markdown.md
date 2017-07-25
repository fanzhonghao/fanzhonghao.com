Markdown语法
===
基于github
---
	首先，markdown是兼容HTML的，但是此处不过分考虑HTML,Markdown 的语法全由一些符号所组成。
### 标题:

	Markdown支持两种标题的语法，类 Setext 和类 atx 形式。
	类 Setext 形式是用底线的形式，利用 = （最高阶标题）和 - （第二阶标题）,
    不过需要三个或以上的 = 或 - 才有效果。

	类 Atx 形式则是在行首插入 1 到 6 个 # ，对应到标题 1 到 6 阶,例如：
    # 这是H1
    ## 这是H2
    ###### 这是H6

### 区块：
	在每行的前面加上>，即可建立一个区块引用。或者只在整个段落的第一行最前面加上>也可以建立区块。
    区块引用可以嵌套（例如：引用内的引用），只要根据层次加上不同数量的 >
    引用的区块内也可以使用其他的 Markdown 语法，包括标题、列表、代码区块等。

### 列表:
	Markdown既支持有序列表同时也支持无序列表。
    无序列表使用星号、加号或是减号作为列表标记，三者是等价的
    有序列表使用数字接着一个英文句点来实现列表
    列表项目标记通常是放在最左边，但是其实也可以缩进，最多 3
    个空格，项目标记后面则一定要接着至少一个空格或制表符
	列表项目可以包含多个段落，每个项目下的段落都必须缩进 4 个空格或是 1 个制表符
    如果要放代码区块的话，该区块就需要缩进两次，也就是 8 个空格或是 2 个制表符
    在行首出现类似20.时，可以写成20\.避免当成列表

### 表格：
	示例演示：
     name | age | hobby
 	-----|-----|------
	 xu   |20   |ball
	 li   |20   |play
	 fan  |20   |ball
     表现如下：
 name | age | hobby
 -----|-----|------
 xu   |20   |ball
 li   |20   |play
 fan  |20   |ball

### 代码区块:
	要在 Markdown 中建立代码区块很简单，只要简单地缩进 4 个空格或是 1 个制表符就可以
    一个代码区块会一直持续到没有缩进的那一行
    代码区块中，一般的 Markdown 语法不会被转换，像是星号便只是星号，这表示你可以很容
    易地以 Markdown 语法撰写 Markdown 语法相关的文件

### 分隔线:
	你可以在一行中用三个以上的星号、减号、底线来建立一个分隔线，行内不能有其他东西。
    你也可以在星号或是减号中间插入空格，例如：
    ***
    * * *
    - - -
    -----------

### 链接：
	Markdown 支持两种形式的链接语法： 行内式和参考式两种形式。
    不管是哪一种，链接文字都是用 [方括号] 来标记。
    要建立一个行内式的链接，只要在方块括号后面紧接着圆括号并插入网址链接即可，
    如果你还想要加上链接的 title 文字，只要在网址后面，用双引号把 title 文字包
    起来即可，例如：
    This is [an example](http://example.com/ "Title") inline link.
	[This link](http://example.net/) has no title attribute.
    样例如下：
This is [an example](http://example.com/ "Title") inline link.
[This link](http://example.net/) has no title attribute.

	参考式的链接是在链接文字的括号后面再接上另一个方括号，而在第二个方括号里面要填入用以辨识链接的标	记：
	This is [an example][id] reference-style link.
	你也可以选择性地在两个方括号中间加上一个空格：
	This is [an example] [id] reference-style link.
	接着，在文件的任意处，你可以把这个标记的链接内容定义出来：
	[id]: http://example.com/  "Optional Title Here"
    
    链接内容定义的形式为：
    1. 方括号（前面可以选择性地加上至多三个空格来缩进），里面输入链接文字
    2. 接着一个冒号
    3. 接着一个以上的空格或制表符
    4. 接着链接的网址
    5. 选择性地接着 title 内容，可以用单引号、双引号或是括弧包着

	下面这三种链接的定义都是相同：		
	[foo]: http://example.com/  "Optional Title Here"
	[foo]: http://example.com/  'Optional Title Here'
	[foo]: http://example.com/  (Optional Title Here)

### 强调：
	Markdown 使用星号（*）和底线（_）作为标记强调字词的符号，被 * 或 _ 包围的字词会被转成用 <em> 标签包围，用两个 * 或 _ 包起来的话，则会被转成 <strong>。

### 代码:
	如果要标记一小段行内代码，你可以用反引号把它包起来（`），例如：
    Use the `printf()` function. 样式如下：
Use the `printf()` function.

	如果要在代码区段内插入反引号，你可以用多个反引号来开启和结束代码区段：
    ``There is a literal backtick (`) here.``	样例如下：
``There is a literal backtick (`) here.``

### 图片:
	Markdown 使用一种和链接很相似的语法来标记图片，同样也允许两种样式： 行内式和参考式。
    行内式的图片语法看起来像是：
	![Alt text](/path/to/img.jpg)
	![Alt text](/path/to/img.jpg "Optional title")

	详细叙述如下：
    一个惊叹号 !
    接着一个方括号，里面放上图片的替代文字
    接着一个普通括号，里面放上图片的网址，最后还可以用引号包住并加上 选择性的 'title' 文字。

### 自动链接:
	Markdown 支持以比较简短的自动链接形式来处理网址和电子邮件信箱，只要是用方括号包起来，
    Markdown 就会自动把它转成链接。一般网址的链接文字就和链接地址一样，例如：
    <http://example.com/>
	Markdown 会转为：
	<a href="http://example.com/">http://example.com/</a>

### 反斜杠:
	Markdown 可以利用反斜杠来插入一些在语法中有其它意义的符号，例如：如果你想要用星号加在文字旁边的	方式来做出强调效果（但不用 <em> 标签），你可以在星号的前面加上反斜杠：
    \*literal asterisks\*，样例如下：
\*literal asterisks\*

### Markdown 支持以下这些符号前面加上反斜杠来帮助插入普通的符号：
	\   反斜线
	`   反引号
	*   星号
	_   底线
	{}  花括号
	[]  方括号
	()  括弧
	#   井字号
	+   加号
	-   减号
	.   英文句点
	!   惊叹号

#### [相关链接](http://www.appinn.com/markdown/)

