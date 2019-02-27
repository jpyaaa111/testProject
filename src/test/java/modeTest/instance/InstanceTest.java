package modeTest.instance;

/**
 * 懒汉模式单例, 最简单的单例模式
 * 优点 : 简单方便, 速度快
 * 缺点 : 初始化加载类时就加载的对象, 占用内存
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest
 * @Description : 懒汉单例
 * @date : 2019-1-31 15:03:37
 */
public class InstanceTest {

    // 懒汉, 加载类时, 直接新建单例
    private static InstanceTest instance = new InstanceTest();

    // 私有化构造参数
    private InstanceTest() {
    }

    // 公共静态方法, 直接用类获得对象, 对象为初始化加载对象, 保证单例
    public static InstanceTest getInstance() {
        return instance;
    }
}
