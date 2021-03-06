package pers.vin.base.dataType;

/**
 * Created by vin on 25/02/2018.
 */
public class Binary {

    /**
     *二进制 正负数:

       看二进制数左数第一位（即最高位）：
       用0表示非负数，
       用1表示负数，
     */

    /**
     * int 类型区间[原码]
          1. int 类型 4byte ,1byte=8bit; 4*8位 = 32位
          2. (正)0  111111....11111[原码]     2147483647   2^31-1( 搜搜 二进制转10进制 )
          3. (负)1  111111....11111[原码]     -2147483647   2^31-1
          4. (负)1  000000....00000[补码]     -2147483648   2^31

          区间范围[2147483647  -2147483648]
     * 计算机用[补码]存储负数
          因为机器使用补码, 所以对于编程中常用到的32位int类型,
          可以表示范围是: [-2^31, 2^31-1] 因为第一位表示的是符号位.
          而使用补码表示时又可以多保存一个最小值.(0的原码 补码 相同 占一个)
          解释:
            [0000 0000]原和[1000 0000]原两个编码表示0.
            [1000 0000] = -0 ;
            [1000 0000]  反  [1111 1111] 加一 [0000 0000]
            即 0 不区分 正负 [0000 0000] 表示 ; [1000 0000] 可用来多表示一位负数-128
     * 正数的反码是其本身;负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.
     * 补码=[原码]=>[符号位不变][反码]=>加一

     */






    /**
     *进制溢出问题
     */
    public static void main(String[] args) {
       int num = 2147483647;
        num = num +1;
        System.out.println(num);// result : -2147483648

        //解释
        // 1. 二级制的 2147483647
        //     0  111111....11111   2147483647
        // 2. 2147483647 加 1
        //    0 0001  00000....00000   2147483648  此时用 36位表示
        // 3. 转回未int  32 位,溢出截断
        //         1  00000....00000
        // 4. 此时符号位 为 1, 按负数对待
        // 5. 减一  取反
        //    1 00000....00000  减一=> 1 111111....11111 取反 1 00000....00000 => 负号  -2147483648

    }



}
