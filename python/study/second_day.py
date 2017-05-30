#列表+=操作符右边的操作数必须是一个iterable
s = ["sesame","sunflower"]
print ("s = ",s)
#错误 s += 5
s += [5]
print ("s += [5], s = ",s)
#添加字符串
b = s #直接赋予的是地址，而不是值
s += "durian"
print ("s += durian,s = ",s)#中间为字符串
s = b
s += ["durian"]
print ("s += [durian],s = ",s)#中间为字符串
#一个小程序
print ("Type integers, each followed by Enter; or just Enter to finsh")
total = 0
count = 0
while True:
    line = input("integer: ")
    if line:
        try:
            number = int(line)
        except ValueError as e:
            print(e)
            continue
        total += number
        count += 1
    else:
        break
if count:
    print("count = ",count," total = ",total," mean = ",total / count)
    
