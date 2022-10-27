package com.csm.extend_01;

public class Sub extends Base{//子类
    public Sub(){
        //隐藏了super();//默认调用父类的无参构造器\
        super("simth",20);
        System.out.println("子类sub()无参构造器被调用");
    }
    public Sub(String name){
        super("jack",25);
        System.out.println("Sub(String name)构造器被调用");
    }
    public Sub(String name,int age){
//        super();//调用父类无参构造器
//        super("csm");//调用Base(String name)
        super("csm",20);//调用Base(String name ,int age)
        //this()用了Super以后不能再用this,super和this只能放在第一行
        System.out.println("子类Sub(String name,int age)被调用");
    }
    public void say(){//子类方法
        //子类可以直接访问父类中非私有的属性和方法
        //但是你可以
        System.out.println(n1 + " " + n2 + " " + n3 );
        test100();
        test200();
        test300();
        //test400();不能直接访问私有变量
        System.out.println("n4="+getN4());//通过在父类的公有方法调用私有变量n4
        callTest400();//通过在父类的公有方法调用私有方法test400
    }

}
