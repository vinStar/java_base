package pers.vin.base.keyword;

/**
 * Created by vin on 02/03/2018.
 */

class Book {
    static int count = 0;

    public Book() {
        count++;
    }

    static void print() {
        System.out.println("对象个数" + count);
    }
}

public class StaticApply {

    public static void main(String[] args) {

        Book b1 = new Book();
        Book b2 = new Book();

        Book.print();
    }


}
