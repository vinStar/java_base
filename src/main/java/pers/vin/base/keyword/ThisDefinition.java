package pers.vin.base.keyword;

/**
 * 一
 * Created by vin on 10/03/2018.
 * 1. --调用类属性
 * 2. --调用类方法(普通\构造)
 * 3. 表示当前类
 * <p>
 * 二
 * 普通方法 与 构造方法
 * 1. 构造方法 , 在 new 的时候使用一次
 * 2. 在构造方法之后,可调用多次
 * <p>
 * 三
 * 构造方法可相互调用
 */


class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    /**
     * 一
     */

    //  public Dog(String n, int a){
    //  name = name;
    //  age = a;
    //  }
    // 以上代码无误 , 不过 参数命名无意义
    // 此处若不用 this 传入参数 与 属性  同名,则采用就近规则. name=name 则无法赋值
    // this.name 当前对象的属性
    public Dog(String name, int age) {

        this(name);// 必须 首行

        this.name = name;
        this.age = age;

        //  System.out.println("hello world");

        // 调用本类方法 建议追加 this . 明确在本类 父类的时候的调用
        this.print();
    }

    public void print() {
        System.out.println("print ");
    }


    public Dog() {
        System.out.println("hello world");
    }

    public Dog(String name) {

        //调用本类无参构造
        //必须首行
        this();
        // System.out.println("hello world");
    }


}

public class ThisDefinition {

    public static void main(String[] args) {

        /**
         * 二
         */
        Dog d1 = new Dog("husky", 2);
        d1.print();
        d1.print();


        /**
         * 三
         * */

        // 构造方法可相互调用
        // 要求 不管调用哪个构造方法 都打印 hello world
        // 1. 每个构造方法都写
        // 2. 调用构造方法 this()  === 留有出口 防止递归调用
        d1 = new Dog();
        d1 = new Dog("husky");

    }

}
