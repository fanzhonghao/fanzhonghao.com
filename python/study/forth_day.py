#确定用户ID,登录名和一些默认设置
import os
print(os.getuid())
print("*********************")
import pwd
print(pwd.getpwuid(os.getuid()))
print("*********************")
for id in pwd.getpwall():
    print(id[0])
