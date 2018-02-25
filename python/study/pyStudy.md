# python 学习
### 文件操作
open函数用来打开文件，语法如下：  
> open(name[.mode[.buffering]])

open函数使用一个文件名作为唯一的强制参数，返回一个文件对象。模式（mode)和缓冲区（buffering）  
参数可选，默认模式是读模式，默认缓冲区为无。  
> f = open(r'/home/xxx/shell/py.sh')

模式中 'r','w','a','b','+'分别表示 读模式，写模式，追加模式，二进制模式和读、写模式，后两  
种模式可添加到其它模式中。  
`f.read()`可以一次将文件内容全部读到内存中。  
`f.close()`关闭对文件的引用。  
`f.read(size)`可以一次最多读取size个字节。  
`f.readline()`每次读取一行。  
`f.readlines()`读取所有内容并按行返回列表。  
`f.write('something')`向文件中写入something。  

`os.getcwd()`获得当前Python脚本工作的目录路径。  
把内存中的变量变成可存储或可传输的过程叫做序列化，反之，叫做反序列化。  
使用 cPickle 和 pickle 模块来实现序列化，cPickle用C语言编写，效率较高。  
模块中的 dumps和loads,dump和load分别为一对序列化和反序列化。  

使用 os模块的fork方法和multiprocessing模块来创建和使用多进程。  
Pipe用于两个进程间通信，Queue用于多个进程间通信。  

使用thread和threading模块使用线程，其中threading是高级模块，对thread进行了封装。  
threading中使用Lock和RLock来实现线程的同步。  
Lock对象使用acquire和release分别获得和释放锁。  
、
