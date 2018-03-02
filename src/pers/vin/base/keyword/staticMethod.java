package pers.vin.base.keyword;

/**
 * Created by vin on 02/03/2018.
 */


class Animal {
    private static String name;
    private int age;


    Animal(int age) {
        this.name = name;
        this.age = age;
    }

    public static void setName(String n) {
        // static 与 this 无缘

        // 错误实例
        // this.name = name;
        name = n;
    }

    public void print() {
        System.out.println("animal : " + Animal.name + " , " + this.age);
    }
}

public class staticMethod {


    // 同属性(共享)(可访问性)(可使用的属性)
    // 不希望收到实例化的限制,不需要实例化即可使用

    public static void main(String[] args) {

        Animal.setName("dog");

        Animal a1 = new Animal(5);
        Animal a2 = new Animal(5);

        a1.print();//dog
        a2.print();//dog


        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        //javac staticMethod
        //java staticMethod args1 args2 args3 "args args"

    }
}
