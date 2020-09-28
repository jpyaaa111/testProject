package BigDecimal;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import time.TimeUtils;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : TODO
 * @date : 2019年03月05日 14:19
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        BigDecimal decimal = new BigDecimal("-3");
        decimal = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal.toString());
        decimal = decimal.abs();
        System.out.println(decimal.toString());

        List<String> tableNameList = TimeUtils.getTableNameList("2019-02-01", "2019-03-21", "yyyy-MM-dd", "test", true);
        System.out.println(tableNameList);
    }
}
