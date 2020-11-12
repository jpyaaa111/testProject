package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.hutool.core.date.LocalDateTimeUtil;

/**
 * 表相关的工具类, 本工具使用hutool工具类
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : TableUtil.java
 * @Description :
 * @date : 2020年10月16日 09:55
 */
public class TableUtil {

    /**
     * 判断是否需要查询月表, 本方法只适用于当前表只保留当天数据的情况
     * @Title isNeedMonthTable
     * @Description
     * @author JinPeiyao
     * @param dateStr 日期字符串
     * @param formatStr 日期格式字符串
     * @date 2020/10/16 15:06
     * @return boolean 是否需要查询月表, true : 需要 | false : 不需要
     */
    public static boolean isNeedMonthTable(String dateStr, String formatStr) {
        return isNeedMonthTable(dateStr, formatStr, 0);
    }

    /**
     * 判断是否需要查询月表, 本方法只适用于当前表只保留当天数据的情况
     * @Title isNeedMonthTable
     * @Description
     * @author JinPeiyao
     * @param localDateTime LocalDateTime时间
     * @date 2020/10/16 15:45
     * @return boolean 是否需要查询月表, true : 需要 | false : 不需要
     */
    public static boolean isNeedMonthTable(LocalDateTime localDateTime) {
        return isNeedMonthTable(localDateTime.toLocalDate(), 0);
    }

    /**
     * 判断是否需要查询月表, 本方法只适用于当前表只保留当天数据的情况
     * @Title isNeedMonthTable
     * @Description
     * @author JinPeiyao
     * @param localDate LocalDate日期
     * @date 2020/10/16 15:30
     * @return boolean 是否需要查询月表, true : 需要 | false : 不需要
     */
    public static boolean isNeedMonthTable(LocalDate localDate) {
        return isNeedMonthTable(localDate, 0);
    }

    /**
     * 判断是否需要查询月表, 本方法可以自定义数据多保留的天数
     * @Title isNeedMonthTable
     * @Description
     * @author JinPeiyao
     * @param dateStr 日期字符串
     * @param formatStr 日期格式字符串
     * @param dateNum 多保留数据的天数
     * @date 2020/10/16 14:53
     * @return boolean 是否需要查询月表, true : 需要 | false : 不需要
     */
    public static boolean isNeedMonthTable(String dateStr, String formatStr, int dateNum) {
        LocalDate localDate = LocalDateTimeUtil.parseDate(dateStr, formatStr);
        return isNeedMonthTable(localDate, dateNum);
    }

    /**
     * 判断是否需要查询月表, 本方法可以自定义数据多保留的天数
     * @Title isNeedMonthTable
     * @Description
     * @author JinPeiyao
     * @param localDateTime LocalDateTime时间
     * @param dateNum 多保留数据的天数
     * @date 2020/10/16 15:44
     * @return boolean 是否需要查询月表, true : 需要 | false : 不需要
     */
    public static boolean isNeedMonthTable(LocalDateTime localDateTime, int dateNum) {
        return isNeedMonthTable(localDateTime.toLocalDate(), dateNum);
    }

    /**
     * 判断是否需要查询月表, 本方法可以自定义数据多保留的天数
     * @Title isNeedMonthTable
     * @Description
     * @author JinPeiyao
     * @param localDate LocalDate日期
     * @param dateNum 多保留数据的天数
     * @date 2020/10/16 15:29
     * @return boolean 是否需要查询月表, true : 需要 | false : 不需要
     */
    public static boolean isNeedMonthTable(LocalDate localDate, int dateNum) {
        // 获得今天的日期
        LocalDate todayLocalDate = LocalDate.now();

        return todayLocalDate.compareTo(localDate) > dateNum;
    }

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

    public static void main(String[] args) {
        System.out.println(LocalDateTimeUtil.parseDate("2020-09-10"));
    }
}
