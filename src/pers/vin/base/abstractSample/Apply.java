package pers.vin.base.abstractSample;

/**
 * Created by vin on 03/03/2018.
 */

abstract class Person {

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public abstract void print();
}

class Student extends Person {
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);//显示调用
        this.school = school;
    }

    public void print() {
        System.out.println("student : " + this.getName() + " , " + this.getAge() + " , " + this.school);
    }
}


public class Apply {


    public static void main(String[] args) {
        Student stu1 = new Student("tom", 17, "北京大学");
        stu1.print();

    }
}
