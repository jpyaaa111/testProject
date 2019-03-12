package BigDecimal;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : TODO
 * @date : 2019年03月05日 14:19
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2018-12-01");

        calendar.setTime(date);

        System.out.println(calendar.get(Calendar.MONTH));

        calendar.add(Calendar.MONTH, 1);

        System.out.println(calendar.get(Calendar.MONTH));
    }


    /**
     * 获得2个日期之间的月份差
     * @title monthDifference
     * @description 获得2个日期之间的月份差
     * @author JinPeiyao
     * @updateTime 2019/3/6 13:26
     * @throws ParseException 可能发生的日期转换异常
     */
    private static void monthDifference() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = "2018-08-3";
        String str2 = "2019-03-17";
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(sdf.parse(str1));
        aft.setTime(sdf.parse(str2));
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        System.out.println("月份相减的值 : " + result + " , 年份相减的值 * 12 : " + month);
        System.out.println(Math.abs(month + result));
    }
}
