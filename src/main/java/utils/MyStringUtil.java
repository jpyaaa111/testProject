package utils;

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
     * 在分页查询条件中, 去除开头and拼接, and的格式固定, 必须为' AND '才可使用本方法
     * @Title filterRmAnd
     * @Description
     * @author JinPeiyao
     * @param filter String, 拼接完成的分页查询条件字符串
     * @date 2020/10/10 10:45
     * @return java.lang.String 去除开头and后的分页查询参数
     */
    public static String filterRmAnd(String filter) {
        return filterRmAnd(filter, " AND ");
    }

    /**
     * 在分页查询条件中, 去除开头and拼接, and拼接需要传入, 防止拼接的and格式不同, 导致无法正确截取
     * @Title filterRmAnd
     * @Description
     * @author JinPeiyao
     * @param filter String, 拼接完成的分页查询条件字符串
     * @param appendAnd String, 拼接的and字符串, 为了防止格式不统一
     * @date 2020/10/10 10:36
     * @return java.lang.String 去除开头and后的分页查询参数
     */
    public static String filterRmAnd(String filter, String appendAnd) {
        return filter.indexOf(appendAnd) == 0 ? filter.substring(filter.indexOf(appendAnd) + appendAnd.length()) : filter;
    }
}
