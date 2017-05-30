route = 866
print(route,type(route))
print ( len ( ("one") ) )
print ( len([3,5,1,2,"pause",5]) )
print ( len ("auto") )

#添加对象
x = ["zebra",49,-879,"aardvark",200]
x.append("more")
print ( x )
#使用列表的append()方法
list.append(x,"extra")
print ( x )
#索引操作
print ( x[0] )
#可以直接改变列表中元素的值
x[1] = "forty nine"
print ( x )
#查询多个对象是否指向相同的对象,比较的是二者的地址
a = ["man",3,None]
b = ["woman",4,None] #None 为定义过的位置标记值，指示“未知”或 “不存在”，none未定义
print ( a is b )
b = a
print ( a is b )
#default
c = "many paths"
b = "many paths"
print ("c", c is b )
print ("b", c == b )
#可以结链比较
a = 9
print ( 0 <= a <= 9)
#成员操作符 in
p = (4,"frog",9,-33,9,2)
print ( 2 in p )
print ( "dog" not in p )
#逻辑运算符
five = 5
two = 2
zero = 0
print ( "5 and 2", ":" , five and two )
print ( "2 and 5", ":" , two and five )
print ( "5 and 0", ":" , five and zero )
nought = 0
print ( "5 or 2 ", ":" , five or two )
print ( "2 or 5 ", ":" , two or five )
print ( "0 or 5 ", ":" , zero or five )
print ( "0 or 0 ", ":" , zero or nought )
#if-elif-else
i = 0
for i in range (10):
    if i < 5 :
        print ( i , " < 5 ")
    elif i < 8:
        print ( i , " < 8 ")
    else:
        print ( i , "i < 10")
#for
for a in ["Dark","Bright","Blue"]:
    print (a)
#or
b = ["Dark","Bright","Blue"]
for a in b:
    print (a)
#异常处理
s = input("enter an integer:")
try:
    i = int(s)
    print ("valid integer entered:",i) #输入正确，执行
except ValueError as err:
    print(err)#错误时执行
#字符串操作
a = "john"
b = " dog"
print (a+b)
