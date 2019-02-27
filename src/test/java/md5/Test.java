package md5;

import static java.lang.String.valueOf;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * The type Test.
 *
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : TODO
 * @date : 2019年02月02日 10:28
 */
public class Test {

    private static int counter;

    /**
     * The entry point of application.
     *
     * @param args
     *            the input arguments
     * @throws NoSuchAlgorithmException
     *             the no such algorithm exception
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {

        // 设定一个数组, 里面包含了绝大多数的字符
        String str = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM/*-+\\`~!@#$%^&*()_=. ,<>?;:'\"[]{}|";
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));

        System.out.println();

        String md5Password = "e2d2982eae6824e7957af4297179a7a6";

/*        File file = new File("D:/9.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(file));*/

        String original;// 明文
//        String cipherText;// 密文
/*        String result;// 结果*/

/*        ps.println();*/

        int charsLength = chars.length;

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        // 遍历字符, 从8位开始MD5加密, 生成明文密文, 字符串拼接
        for (int i1 = 0; i1 < charsLength; i1++) {// 1
            char a = chars[i1];
            for (int i2 = 0; i2 < charsLength; i2++) {// 2
                char b = chars[i2];
                for (int i3 = 0; i3 < charsLength; i3++) {// 3
                    char c = chars[i3];
                    for (int i4 = 0; i4 < charsLength; i4++) {// 4
                        char d = chars[i4];
                        for (int i5 = 0; i5 < charsLength; i5++) {// 5
                            char e = chars[i5];
                            for (int i6 = 0; i6 < charsLength; i6++) {// 6
                                char f = chars[i6];
                                for (int i7 = 0; i7 < charsLength; i7++) {// 7
                                    char g = chars[i7];
                                    for (int i8 = 0; i8 < charsLength; i8++) {// 8
                                        char h = chars[i8];
                                        for (int i9 = 0; i9 < charsLength; i9++) {// 9
                                            char i = chars[i9];
                                            // 获得明文
                                            original = valueOf(a) + b + c + d + e + f + g + h + i;
                                            // 解密判断
                                            if (encryption(original, md5Password)) {
                                                return;
                                            }

                                            if (i1 == charsLength - 1 && i2 == charsLength - 1 && i3 == charsLength - 1 && i4 == charsLength - 1 && i5 == charsLength - 1 && i6 == charsLength - 1 && i7 == charsLength - 1 && i8 == charsLength - 1 && i9 == charsLength - 1 && !flag1) {
                                                System.out.println("进入十位数循环");
                                                flag1 = true;
                                                i1 = 0;
                                                i2 = 0;
                                                i3 = 0;
                                                i4 = 0;
                                                i5 = 0;
                                                i6 = 0;
                                                i7 = 0;
                                                i8 = 0;
                                                i9 = 0;
                                            }
                                            if (flag1) {
                                                for (int i10 = 0; i10 < charsLength; i10++) {// 10
                                                    char j = chars[i10];
                                                    // 获得明文
                                                    original = valueOf(a) + b + c + d + e + f + g + h + i + j;
                                                    // 解密判断
                                                    if (encryption(original, md5Password)) {
                                                        return;
                                                    }

                                                    if (i1 == charsLength - 1 && i2 == charsLength - 1 && i3 == charsLength - 1 && i4 == charsLength - 1 && i5 == charsLength - 1 && i6 == charsLength - 1 && i7 == charsLength - 1 && i8 == charsLength - 1 && i9 == charsLength - 1 && i10 == charsLength - 1 && !flag2) {
                                                        System.out.println("进入十一位数循环");
                                                        flag2 = true;
                                                        i1 = 0;
                                                        i2 = 0;
                                                        i3 = 0;
                                                        i4 = 0;
                                                        i5 = 0;
                                                        i6 = 0;
                                                        i7 = 0;
                                                        i8 = 0;
                                                        i9 = 0;
                                                        i10 = 0;
                                                    }
                                                    if (flag2) {
                                                        for (int i11 = 0; i11 < charsLength; i11++) {// 11
                                                            char k = chars[i11];
                                                            original = valueOf(a) + b + c + d + e + f + g + h + i + j + k;
                                                            // 解密判断
                                                            if (encryption(original, md5Password)) {
                                                                return;
                                                            }

                                                            if (i1 == charsLength - 1 && i2 == charsLength - 1 && i3 == charsLength - 1 && i4 == charsLength - 1 && i5 == charsLength - 1 && i6 == charsLength - 1 && i7 == charsLength - 1 && i8 == charsLength - 1 && i9 == charsLength - 1 && i10 == charsLength - 1 && i11 == charsLength - 1 && !flag3) {
                                                                System.out.println("进入十二位数循环");
                                                                flag3 = true;
                                                                i1 = 0;
                                                                i2 = 0;
                                                                i3 = 0;
                                                                i4 = 0;
                                                                i5 = 0;
                                                                i6 = 0;
                                                                i7 = 0;
                                                                i8 = 0;
                                                                i9 = 0;
                                                                i10 = 0;
                                                                i11 = 0;
                                                            }
                                                            if (flag3) {
                                                                for (int i12 = 0; i12 < charsLength; i12++) {// 12
                                                                    char l = chars[i12];
                                                                    original = valueOf(a) + b + c + d + e + f + g + h + i + j + k + l;
                                                                    // 解密判断
                                                                    if (encryption(original, md5Password)) {
                                                                        return;
                                                                    }

                                                                    if (i1 == charsLength - 1 && i2 == charsLength - 1 && i3 == charsLength - 1 && i4 == charsLength - 1 && i5 == charsLength - 1 && i6 == charsLength - 1 && i7 == charsLength - 1 && i8 == charsLength - 1 && i9 == charsLength - 1 && i10 == charsLength - 1 && i11 == charsLength - 1 && i12 == charsLength - 1 && !flag4) {
                                                                        System.out.println("进入十三位数循环");
                                                                        flag4 = true;
                                                                        i1 = 0;
                                                                        i2 = 0;
                                                                        i3 = 0;
                                                                        i4 = 0;
                                                                        i5 = 0;
                                                                        i6 = 0;
                                                                        i7 = 0;
                                                                        i8 = 0;
                                                                        i9 = 0;
                                                                        i10 = 0;
                                                                        i11 = 0;
                                                                        i12 = 0;
                                                                    }
                                                                    if (flag4) {
                                                                        for (int i13 = 0, charsLength1 = chars.length; i13 < charsLength1; i13++) {// 13
                                                                            char m = chars[i13];
                                                                            original = valueOf(a) + b + c + d + e + f + g + h + i + j + k + l + m;
                                                                            // 解密判断
                                                                            if (encryption(original, md5Password)) {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

/*        ps.flush();
        ps.close();*/
    }

    private static boolean encryption(String original, String md5Password) throws NoSuchAlgorithmException {
        // 获得密文
        String cipherText = Encryption.strToMD5(original);
        if (md5Password.equalsIgnoreCase(cipherText)) {
            System.out.println("匹配的原文为 : " + original);
            return true;
        }

        return false;
    }
}
