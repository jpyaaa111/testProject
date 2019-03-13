package modeTest.instance;

/**
 * 枚举类形式的单例
 * <p>利用枚举类的特性, 实现的比较流行的单例模式</p>
 * <p>优势 : 枚举类特性, 天生单例, 线程安全, 反序列化安全, 代码简洁</p>
 * <p>劣势 : 不是懒加载, 为饿汉模式的单例</p>
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest6
 * @Description : 枚举类的单例模式
 * @date : 2019-3-12 16:26:05
 */
@SuppressWarnings("unused")
public enum InstanceTest6 {

    // 代表了这个枚举类对象, 枚举类特性会生成一个私有的构造方法, 直接形成的单例
    INSTANCE;

    public void testMethod() {
        System.out.println("测试单例的方法");
    }
}