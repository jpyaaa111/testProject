package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : TimeUtils.java
 * @Description : 日期相关的工具类, 包括跨月查询的表名集合等
 * @date : 2019年03月21日 10:13
 */
public class TimeUtils {

    /**
     * 获得2个日期之间的月份总数
     * @title monthDifference
     * @description 获得2个日期之间的月份总数
     * @author JinPeiyao
     * @param startDateStr 开始时间字符串
     * @param endDateStr 结束时间字符串
     * @param formatStr 时间格式字符串
     * @updateTime 2019/3/6 13:26
     * @throws ParseException 可能发生的日期转换异常
     */
    public static int monthDifference(String startDateStr, String endDateStr, String formatStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        Calendar bef = getCalendar(startDateStr, sdf);
        Calendar aft = getCalendar(endDateStr, sdf);

        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        System.out.println("月份相减的值 : " + result + " , 年份相减的值 * 12 : " + month);
        System.out.println(Math.abs(month + result));

        // 差值 + 1, 为2个日期包括的总月数
        return Math.abs(month + result) + 1;
    }


    /**
     * 通过2个时间, 判断月份差, 获得需要查询的月表
     * @title getTableNameList
     * @description 通过2个时间, 判断月份差, 获得需要查询的月表
     * @author JinPeiyao
     * @param startDateStr 开始时间字符串
     * @param endDateStr 结束时间字符串
     * @param formatStr 时间格式字符串
     * @param tableName 基础表名
     * @param descFlag 是否倒序boolean
     * @updateTime 2019/3/21 10:08
     * @return java.util.List<java.lang.String> 需要查询的表名List
     * @throws ParseException 可能发生的日期转换异常, 日期格式错误
     */
    public static List<String> getTableNameList(String startDateStr, String endDateStr, String formatStr, String tableName, boolean descFlag) throws ParseException {
        List<String> tableNameList = new ArrayList<>();

        String newFormatStr = "yyyy-MM-dd";
        // 日期转换格式
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        // 新的所需日期转换格式
        SimpleDateFormat newFormat = new SimpleDateFormat(newFormatStr);

        // =====> 格式不一样, 先转换为必须的格式
        if (!newFormatStr.equals(formatStr)) {
            startDateStr = newFormat.format(format.parse(startDateStr));
            endDateStr = newFormat.format(format.parse(endDateStr));
        }

        // 当前时间日期
        Calendar currentCal = Calendar.getInstance(); currentCal.setTime(newFormat.parse(newFormat.format(new Date())));
        // 开始日期
        Calendar startCal = getCalendar(startDateStr, newFormat);
        // 结束日期
        Calendar endCal = getCalendar(endDateStr, newFormat);

        // =====> 获得2个时间的包含总月数
        int monthNum = monthDifference(startDateStr, endDateStr, newFormatStr);

        // =====> 判断开始时间 与 结束时间是否一天 && 是当天 --> 直接返回当前表
        if (startCal.compareTo(endCal) == 0 && endCal.compareTo(currentCal) == 0) {
            tableNameList.add(tableName);
            return tableNameList;
        }

        // =====> 循环总月数, 拼接表名
        for (int i = 0; i < monthNum; i++) {
            if (i > 0) {
                startCal.add(Calendar.MONTH, 1);
            }
            tableNameList.add(tableName + "_" + startCal.get(Calendar.YEAR) + (startCal.get(Calendar.MONTH) + 1));
        }
        // 判断结束时间为当天 --> 拼接当前表
        if (endCal.compareTo(currentCal) == 0) {
            tableNameList.add(tableName);
        }

        // =====> 是否需要倒序
        if (descFlag) {
            Collections.reverse(tableNameList);
        }

        return tableNameList;
    }


    /**
     * 通过时间字符串 与 时间格式对象, 转换为日历对象
     * @title getCalendar
     * @description 通过时间字符串 与 时间格式对象, 转换为日历对象
     * @author JinPeiyao
     * @param timeStr 时间字符串
     * @param format 对应时间的format对象
     * @updateTime 2019/3/21 10:19
     * @return java.util.Calendar 时间对应的日历对象
     * @throws ParseException 可能发生的日期转换异常, 日期格式错误
     */
    public static Calendar getCalendar(String timeStr, DateFormat format) throws ParseException {
        Calendar timeCal = Calendar.getInstance();
        timeCal.setTime(format.parse(timeStr));

        return timeCal;
    }
}
