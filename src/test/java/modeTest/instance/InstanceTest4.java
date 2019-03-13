package modeTest.instance;

/**
 * 优化版双重检测单例
 * <p>利用局部线程ThreadLocal, 将判空的部分用局部线程处理, 解决多线程的问题</p>
 * <p>优点 : 利用局部线程解决了原双重检测单例在JKD1.5之前可能获得不完成实例的问题, 比较安全可靠</p>
 * <p>缺点 : 速度比较慢, 只适合JDK1.5之前的版本使用</p>
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest4.java
 * @Description : 优化版双重检测单例
 * @date : 2019年02月01日 11:26
 */
@SuppressWarnings("unused")
public class InstanceTest4 {

    // 私有静态最终的局部线程变量
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    // 私有静态对象
    private static InstanceTest4 instance;

    // 私有构造器
    private InstanceTest4() {
    }

    // 公共静态获得单例对象
    public static InstanceTest4 getInstance() {
        // 局部线程无赋值, 则初始化加载
        if (THREAD_LOCAL.get() == null) {
            initInstance();
        }

        return instance;
    }

    // 初始化加载单例
    private static void initInstance() {
        // 静态快赋值
        synchronized (InstanceTest4.class) {
            // 为空时赋值
            if (instance == null) {
                instance = new InstanceTest4();
            }
        }

        // 加载后局部线程赋值
        THREAD_LOCAL.set(THREAD_LOCAL);
    }
}
