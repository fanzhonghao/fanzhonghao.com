<h1>how to use git hub ?</h1>
<p>
<ul>
<h4>Basesd on ubuntu:</h4>  
<li>first, you should download git</li>  
<li>then chose a folder, and enter order "<b>git init</b>" and then it will located in it  </li>  
<li>next step you can enter "<b>git config --global user.name "your name"</b> "</li>  
<li>followed by enter "<b>git config --global user.email "your email" </b>"</li>  
<li>then you should add remote address like this  
"<b>git remote add origin "your github url"</b> "  
the origin stand for your github url in the following operation before uploading your codes</li>  
<li>you should check your warehouse by clone   
"<b>git clone "your address" </b>"</li>   
<li>after this you can updata your warehouse by   
"<b>git pull</b>"</li>   
<li>then if it's normal, you can upload your codes by these three steps:   
<b>git add .</b>               /*this order is used to add all floders, you can use  the name of floder to replace that dot to add just one floder*/   
<b>git commit -m "..."</b>     /*there you should add the name of the floder*/   
<b>git push -u origin master</b> /*if it's ok, you will commit your codes*/
</li>  
</ol>
</p>
<h1>use git to remove a floder</h1>
 <p>
 you can use following orders:  
 <b>
 <li>git rm "..."  
 <li>git commit -m "remove ..."  
 <li>git push -u origin master</b>  </li>
 all of these
 </p>