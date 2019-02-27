package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : BubbleSortTest.java
 * @Description : 冒泡排序的测试类
 * @date : 2019年02月11日 16:38
 */
public class BubbleSortTest {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int[] integers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 ,0};// 测试数组数据

        int length = integers.length - 1;// 数组的长度 - 1(最后一位下标)

        int lastSwapPos = 0, lastSwapPosTemp = 0;// 内循环终止值 与 内循环终止值的临时变量

        int var;// 交换数据的临时变量
        int count = 0;// 进判断的排序次数
        int frequency = 1;// 总循环次数

        for (int i = 0; i < length; i++) {

            lastSwapPos = lastSwapPosTemp;

            for (int j = length; j > lastSwapPos; j--) {

                System.out.println("经过了第" + frequency + "次循环, 内循环的终止值为 : " + lastSwapPos);

                frequency++;

                if (integers[j - 1] > integers[j]) {
                    var = integers[j - 1];
                    integers[j - 1] = integers[j];
                    integers[j] = var;

                    count++;
                    lastSwapPosTemp = j;

                    System.out.println("排序过后的结果为 : " + Arrays.toString(integers));
                }
            }

            if (lastSwapPos == lastSwapPosTemp) {
                break;
            }
        }

        System.out.println("内循环终止值 : " + lastSwapPos);
        System.out.println("总共排序次数 : " + count);
        System.out.println("总循环次数 : " + frequency);
    }
}
