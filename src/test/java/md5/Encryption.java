package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Encryption.java
 * @Description : 网上摘录的MD5加密算法
 * @date : 2019年02月02日 10:17
 */
public class Encryption {

    public static String strToMD5(String inStr) throws NoSuchAlgorithmException {
        String result;
        MessageDigest md5;

        md5 = MessageDigest.getInstance("MD5");

        char[] charArr = inStr.toCharArray();
        byte[] byteArr = new byte[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            byteArr[i] = (byte) charArr[i];
        }

        byte[] md5Bytes = md5.digest(byteArr);

        int val;
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }

        result = hexValue.toString();

        return result;
    }
}
