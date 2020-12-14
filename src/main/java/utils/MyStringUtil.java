package utils;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串相关的工具类, 与以往不同, 一般的通用统一用hutool包的StrUtil, 此处的工具类是一些业务逻辑上需要用到的字符串相关的工具类
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : MyStringUtil.java
 * @Description :
 * @date : 2020年10月10日 10:26
 */
public class MyStringUtil {

    /**
     * 随机获得一个大陆手机号
     * @Title getPhoneNum
     * @Description
     * @author JinPeiyao
     * @date 2020/10/22 15:39
     * @return java.lang.String 随机的手机号码
     */
    public static String getPhoneNum() {
        String[] top3 = { "133", "149", "153", "173", "177", "180", "181", "189", "199", "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172", "178", "182", "183", "184", "187", "188", "198", "170", "171" };
        // 随机出真实号段 使用数组的length属性，获得数组长度，
        // 通过Math.random（）* 数组长度获得数组下标，从而随机出前三位的号段
        String firstNum = top3[(int) (Math.random() * top3.length)];
        // 随机出剩下的8位数
        StringBuilder lastNum = new StringBuilder();
        final int last = 8;
        for (int i = 0; i < last; i++) {
            // 每次循环都从0~9挑选一个随机数
            lastNum.append((int) (Math.random() * 10));
        }
        // 最终将号段和尾数连接起来
        return firstNum + lastNum;
    }

    /**
     * 字符串脱敏<br>
     * 使用本方法时, 需要注意一下几点 : <br>
     * <li>原数据为空时, 返回null;</li>
     * <li>原数据的长度, 如果小于需要保留的首位长度 + 末位长度, 那么直接返回原数据;</li>
     * <li>首位与末位需要保留的位数都没有 或者 中间需要脱敏的位数没有, 则没必要脱敏, 返回原数据;</li>
     * @Title desensitize
     * @Description
     * @author JinPeiyao
     * @param value 原数据字符串
     * @param firstNum 需要保留的首位位数
     * @param asteriskNum 中间脱敏的位数
     * @param lastNum 需要保留的末位位数
     * @date 2020/11/10 14:38
     * @return java.lang.String 最后脱敏的字符串
     */
    public static String desensitize(String value, int firstNum, int asteriskNum, int lastNum) {
        // 原数据为空, 则直接返回null
        if (StrUtil.isEmpty(value)) {
            return null;
        }
        // 原数据的长度, 如果小于需要保留的首位长度 + 末位长度, 那么直接返回原数据
        if (value.length() < firstNum + lastNum) {
            return value;
        }
        // 判断, 如果首位与末位需要保留的位数都没有 或者 中间需要脱敏的位数没有, 则没必要脱敏, 返回原数据
        boolean numFlag = (firstNum <= 0 && lastNum <= 0) || asteriskNum <= 0;
        if (numFlag) {
            return value;
        }

        StringBuilder resultValue = new StringBuilder();
        // 拼接首位
        resultValue.append(value, 0, firstNum);
        // 拼接脱敏星号
        for (int i = 0; i < asteriskNum; i++) {
            resultValue.append("*");
        }
        // 拼接后缀
        resultValue.append(value.substring(value.length() - lastNum));

        return resultValue.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPhoneNum());
//        System.out.println(desensitize("310110199208043213", 6, 8, 4));
    }
}
