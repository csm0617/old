package com.csm.extend_exercise01;

public class Exercise {
    public static void main(String[] args) {
        C c = new C();
    }
}
//main 方法中： C c =new C(); 输出么内容? 3min
class A {//A 类

    public A() {
        System.out.println("我是 A 类");
    }
}

class B extends A { //B 类,继承 A 类
    public B() {
        System.out.println("我是 B 类的无参构造");
    }

    public B(String name) {//!!!默认的supper()调用父类的无参构造器.->12
        System.out.println(name + "我是 B 类的有参构造");
    }
}

class C extends B { //C 类，继承 B 类
    public C() {
        this("hello");//执行了this就不会再执行默认的supper; ->32
        System.out.println("我是 c 类的无参构造");
    }

    public C(String name) {
        super("hahah");//->21
        System.out.println("我是 c 类的有参构造");
    }
}