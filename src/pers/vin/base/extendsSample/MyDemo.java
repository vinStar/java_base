package pers.vin.base.extendsSample;

/**
 * Created by vin on 02/03/2018.
 */

class Person {
    public Person() {

        System.out.println("Person initialized");
    }

}

class Student extends Person {

    public Student() {
        super();// 无参 隐士调用
        System.out.println("Student initialized");
    }

}

class PersonThis {
    public PersonThis() {

        System.out.println("Person initialized This");
    }

}

class StudentThis extends PersonThis {


    public StudentThis() {
        //supper
        // 此处调用父类无参构造

        System.out.println("Student initialized This");
    }

    public StudentThis(String name) {
        //super();// 无参 隐士调用

        //// this 也是第一行 , 调用构造函数  (StudentThis)
        // this , supper 只能出现一个
        this();

        System.out.println("Student initialized This");
    }

}

class PersonParam {


    // 有参 出现 无参的构造函数不在出现
    public PersonParam(String name) {

        System.out.println("Person initialized Param " + name);
    }

}

class StudentParam extends PersonParam {

    public StudentParam(String name) {

        super(name);// 必须 第一行出现


        System.out.println("Student initialized Param ");
    }


}

class C {
}

class D extends C {
}

class E extends D {
}


public class MyDemo {

    public static void main(String[] args) {

        // 没有一条语句明确调用父类构造方法,但是父类构造方法执行了打印
        // 证明子类的实例化一定会同时实例化父类构造方法
        // 子类构造方法 ,无参构造  隐藏了  "super()"
        new Student();
        //Person initialized
        //Student initialized

        System.out.println("=====================================");


        // this  supper 只能同时出现一个
        new StudentThis();

        System.out.println("=====================================");

        // 父类如果只有默认无参构造方法报错 ,  子类 用 supper 调用 有参构造
        // 父类类有参(无参不出现) , 子类 supper 显示调用
        new StudentParam("vin");


        //1.  不允许多重继承 , 允许多层集成(三层可以了)  C继承D  E继承C;
        //2.  子类继承所有结构( 私有属性 )   , 隐示调用(非 private ) , 显示调用(getter)
        //3.  先父类构造,再子类构造

    }

}
