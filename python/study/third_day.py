import random
x = random.randint(1,6)
y = random.choice(["apple","banana","cherry","durian"])
print(x)
print(y)
x = 2
y = 3
print ('x = 2',' y = 3')
print (x // y)  #舍弃小数部分
print (x**y) #x的y次方
print (divmod(x,y)) #一二元组形式返回x除以y的商和余数（两个正整数）
print (pow(x,y)) #同x**y
z = 2
print(pow(x,y,z)) #同(x**y)%z
print(round(1.2225,3)) #返回前一个操作数四舍五入后，最多有后一个操作数的数字
x = int() #直接为x赋予空号中的值
print (x)
x = 4
print (bin(x)) #返回x的二进制
print (hex(x)) #返回x的十六进制
s = '8'
print (s)
print (int(s)) #把s转换为整数 。。。
print (oct(x)) #返回x的八进制字符串
x = 1
y = 1
print (x ^ y) #异或运算
x = 3
y = 0
print (x & y) #进行位与运算

print (x << 1) #左移一位
print (x)
print (~x) #反转x的每一位
#字符串分片与步距
s = "the waxwork man"
s = s[:12] + "wo" + s[12:]
print (s)
print (s.capitalize())#首字母大写
print (s.count('w')) #统计子字符串出现次数
print (s.find('w'))#找出最左位置
print (s.islower())#s中至少有一个小写字母
#字符串复制
s = "="*5
print (s)
s *= 10
print (s)
#判断文件格式
filename = "1.jpg"
if filename.lower().endswith((".jpg",".jpeg")):
    print(filename,"is a JPEG image")
#将字符剥离
s = "\t no parking "
print (s.lstrip(),s.rstrip(),s.strip())#分别剥离左右全部空白字符
print("<[unbracketed]>".strip("[](){}<>"))#剥离小括号内的字符
#子串替换
x = "three"
s = "{0} {1} {2}"
s = s.format("The",x,"tops")
print (s)
#基于字典的键值替换
element = "Silver"
number = 47
print ("Element {number} is {element}".format(**locals()))#**为映射拆分操作符
#格式约束
s = "The sword of truth"
print ("{0}".format(s))
print ("{0:25}".format(s)) #min width 25
print ("{0:>25}".format(s))#right align, min width 25
print ("{0:^25}".format(s))#center align
print ("{0:-^25}".format(s))#-fill
print ("{0:.<25}".format(s))#.fill, left align
print ("{0:.10}".format(s))#max width 10
#进制变换
x = 14613198
print ("x = ",x)
print ("{0:b} {0:o} {0:x} {0:X}".format(x))
