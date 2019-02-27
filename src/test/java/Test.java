import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : TODO
 * @date : 2019年02月02日 14:49
 */
public class Test {

    /**
     * 获得当前时间是上半年还是下半年
     * @param
     * @return
     */
    public static String refundTableName(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String year = c.get(Calendar.YEAR) + "";
        int j = c.get(Calendar.MONTH) + 1;
        String month = j + "";
        if (j >= 7) {

            return "re_trade_info_" + year + "7";
        } else {

            return "re_trade_info_" + year + "1";
        }
    }

    /**
     * 获得当前时间是上半年还是下半年
     * @param
     * @return
     */
    public static String transferTableName(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH) + 1);

        String year = c.get(Calendar.YEAR) + "";
        int j = c.get(Calendar.MONTH) + 1;

        String month = j + "";
        if (j >= 7) {

            return "tf_trade_info_" + year + "7";
        } else {

            return "tf_trade_info_" + year + "1";
        }
    }


    public static void main(String[] args) throws Exception{
        
        String queryDate ="190201";
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String tableName = transferTableName(sdf.parse(queryDate));
        System.out.println(tableName);
    }
}
