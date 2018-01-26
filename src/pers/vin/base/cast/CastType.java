package pers.vin.base.cast;

/**
 * Created by vin on 26/01/2018.
 *  short byte
 */
public class CastType {
    public static void main(String[] args) {

        short s1 = (short) 1;

        int a = s1 + (short) 1;//int default
        int b = s1 + s1;// int default

        // C# language specification https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/byte
        // because the arithmetic expression on the right-hand side of the assignment operator evaluates to int by default. this case (s1+(short)s1)
        //
        // java language specification https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.2.2
        // The numerical operators, which result in a value of type int or long:

        s1 = (short) (s1 + (short) 1);//1. result is int type 2. cast int to short
        System.out.println(s1);
        s1 += 1;//(short) (s1 + (short) 1)
        System.out.println(s1);

    }
}
