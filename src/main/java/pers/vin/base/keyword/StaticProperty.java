package pers.vin.base.keyword;

/**
 * Created by vin on 02/03/2018.
 */


class Person {

    private String name;
    private int age;
    protected static String country;

    Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setCountry(String country) {
        this.country = country;

    }

    public String getCountry() {
        return this.country;
    }


    void print() {

        System.out.println("person :" + this.name + ", " + this.age + ", " + this.country);
    }

}

//不允许 static 关键字修饰
class Dept {

    void print(final int a) {
        System.out.println("Dept");


        class inner {

            public void print() {
                System.out.println("inner" + a);
            }
        }
    }
}


public class StaticProperty {
    //内部类可以用 static 修饰
    static class Employee {
        void print() {
            System.out.println("Employee");
        }
    }

    class EmployeeTest {
        void print() {
            System.out.println("Employee");
        }
    }

    private String str1 = "hello";


    public static void main(String[] args) {

        //0. static 属性

        //1. static(由类直接调用) 没有 this(this代表当前对象) 调用的属性 方法自然也就没有 ;
        // this 下没有 Employee 类,因为是静态的. static this 只能存在一个

        //2. 用 static 修饰 属性后,将不会保存在堆内存中,而是保存在一个全局数据区的内存中
        //   所有对象都可以进行访问 , 称为类属性 , 可通过类名直接调用

        //3. 定义类属性 99% 不会用到 static
        //   如果需要共享属性概念, 或者不希望收到实例化控制的

        //4. 内部类 可以定义在 任务地方 方法快 ,方法内(jdk 1.8 正常 ,推广函数式编程 1,7 加 final)

        // 内部 static 类可以 new
        new Employee().print();

        //错误范例: 静态方法内 main 不可以访问非静态类 方法 属性
        //new this.EmployeeTest().print();
        //错误范例:
        //System.out.println(this.str1);


        Person p1 = new Person("tom", 22, "China");
        Person p2 = new Person("tom", 22, "");

        p1.print();
        p2.print();

        //true ,p1 ,p2 的 name 的赋值都是"tom", 所以共享, p1.getName p2.GetName 的栈地址相同,指向"tom"
        System.out.println(p1.getName() == p2.getName());

        p1.print();//country 为 空字符串
        p2.print();//country 为 空字符串 , country 再次赋值后覆盖 "China"

        p1.setCountry("Japan");

        p1.print();//country 为 "Japan"
        p2.print();//country 为 "Japan"

        Person.country = "USA";

        p1.print();
        p2.print();

    }

}



