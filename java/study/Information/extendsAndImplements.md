***JAVA中extends 与 implements区别***
<ol>
<li> 在类的声明中，通过关键字extends来创建一个类的子类。一个类通过关键字implements声明自己使用一个或者多个接口。
extends 是继承某个类, 继承之后可以使用父类的方法, 也可以重写父类的方法; implements 是实现多个接口, 接口的方法一般为空的, 必须重写才能使用。</li>
<li>extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承，Java中不支持多重继承，但是可以用接口 来实现，这样就要用到implements，继承只能继承一个类，但implements可以实现多个接口，用逗号分开就行了。</li>
</ol>

>例如：
>class A extends B implements C,D,E

**接口实现的注意事项**
<ol>
<li>实现一个接口就是要实现该接口的所有的方法(抽象类除外)。</li>
<li>接口中的方法都是抽象的。</li>
<li>多个无关的类可以实现同一个接口，一个类可以实现多个无关的接口。</li>
</ol>

**extends与implements的不同**
<ul>
<li>extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承，Java中不支持多重 继承，但是可以用接口来实现，这样就要用到implements，继承只能继承一个类，但implements可以实现多个接口，用逗号分开就行了。</li>
</ul>

     extends， 可以实现父类，也可以调用父类初始化 this.parent()。而且会覆盖父类定义的变量或者函数。这样的好处是：架构师定义好接口，让工程师实现就可以了。整个项目开发效率和开发成本大大降低。
     implements，实现父类，子类不可以覆盖父类的方法或者变量。即使子类定义与父类相同的变量或者函数，也会被父类取代掉。

**接口一般是只有方法声明而没有定义的**

[相关链接](http://www.cnblogs.com/hnrainll/archive/2011/10/11/2207773.html)
