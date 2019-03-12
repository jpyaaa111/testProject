import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : TODO
 * @date : 2019年02月02日 14:49
 */
public class Test {

    private static Properties props;

    static {
        props = System.getProperties();
    }

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


    public static void main(String[] args) throws IOException {
/*        Properties properties = getPropertie("test.properties");
        System.out.println(properties.get("loginName"));*/

        ResourceBundle resource = ResourceBundle.getBundle("test");
        System.out.println(resource.getString("loginName") + ", " + resource.getString("moblie"));
    }

    private static Properties getPropertie(String filePath) throws IOException {
        Properties properties = new Properties();

        System.out.println(Objects.requireNonNull(Test.class.getClassLoader().getResource("")).getPath());

        InputStream in = Test.class.getClassLoader().getResourceAsStream(filePath);
        properties.load(in);

        return properties;
    }
}
