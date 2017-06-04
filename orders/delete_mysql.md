<h4>Delete mysql</h4>
<ol>
<li>sudo apt-get autoremove --purge mysql-server-5.7</li>
<li>sudo apt-get remove mysql-server</li>
<li>sudo apt-get autoremove mysql-server</li>
<li>sudo apt-get remove mysql-common</li>
</ol>
>Some order above is needless, likes the third and the forth, but they are importment
>that you should run them over

<h4>Delete residual data</h4>
<ul>
<li>dpkg -l |grep ^rc | awk '{print $2}' |sudo xargs dpkg -p
</li>
</ul>
>Sorry, I don't know the real meaning of above orders, and I can't run it or them

<h4>Install mysql</h4>
<ol>
<li>sudo apt-get install mysql-server</li>
<li>sudo apt-get install mysql-client</li>
<li>sudo apt-get install php5-mysql</li>
</ol>
>The last order is connect php and mysql

<h4>Check whether Mysql is running</h4>
<ul>
<li>sudo netstat -tap | grep mysql
</ul>
if your server can't run good, you can run the under order to run it
<ul>
<li>sudo /etc/init.d/mysql restart
</ul>