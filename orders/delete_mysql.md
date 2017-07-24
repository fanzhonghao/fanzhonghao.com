Delete mysql
---
1. sudo apt-get autoremove --purge mysql-server-5.7
2. sudo apt-get remove mysql-server
3. sudo apt-get autoremove mysql-server
4. sudo apt-get remove mysql-common
>Some order above is needless, likes the third and the forth, but they are importment
>that you should run them over

Delete residual data
---
+ dpkg -l |grep ^rc | awk '{print $2}' |sudo xargs dpkg -p
>Sorry, I don't know the real meaning of above orders, and I can't run it or them

Install mysql
---
+ sudo apt-get install mysql-server
+ sudo apt-get install mysql-client
+ sudo apt-get install php5-mysql
>The last order is connect php and mysql

Check whether Mysql is running
---
+ sudo netstat -tap | grep mysql
>if your server can't run good, you can run the under order to run it

+ sudo /etc/init.d/mysql restart