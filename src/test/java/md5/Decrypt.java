package md5;

/**
 * MD5解密算法
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Decrypt.java
 * @Description : 网上摘录的MD5解密(辣鸡的位运算......我为什么那么傻逼)
 * @date : 2019年02月02日 10:34
 */
public class Decrypt {

    public static String convertMD5(String inStr) {
        char[] chars = inStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ 't');
        }

        return new String(chars);
    }
}
