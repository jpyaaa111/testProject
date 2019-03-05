package BigDecimal;

import java.math.BigDecimal;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : TODO
 * @date : 2019年03月05日 14:19
 */
public class Test {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("2").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal b2 = new BigDecimal("3").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal b3 = b1.add(b2);
        System.out.println(b3.toString());
    }
}
