package pers.vin.base.abstractSample;

/**
 * Created by vin on 03/03/2018.
 */


//1. 如果父类不能在构造无参构造方法 , 子类 new 报错
//2. 子类有 有参或无参构造方法 都会隐式调用 父类 无参构造方法(父类没有构造方法会自动生成,含有参构造方法则不会)
//3. 结论:如果构造方法没有执行,那么对象中的属性值一定是其默认值
abstract class E {
    public E() {// step 3
        this.print();//调用抽象方法  //step 4 被子类覆写过的方法
    }


    public abstract void print(); //step 5  此时 num 还未初始化 , 默认值为 0 ,所以打印 0

}

class F extends E {
    private int num = 100;

    public F(int num) {

        //supper()   step 2:  此处隐式调用 supper() 实际优先调用父类构造方法
        //                    此时构造未执行,内存已开辟(new 开辟类对象空间),但没有值
        //                    1. 类加载 2. 对象实例化(new) 3. 初始化(构造方法)
        this.num = num; // 子类对象属性初始化
    }

    public void print() {
        System.out.println(" override print() " + this.num);
    }
}

public class Apply2 {

    public static void main(String[] args) {

        new F(30);// step 1:  instantiate an object 实例化对象
        //new F(30).print();

    }

}
