package modeTest.instance;

import java.io.Serializable;

/**
 * 优化双重锁校验单例
 * <p>优化了原版双重锁校验单例中, 反序列化可能破坏单例模式的问题</p>
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest7.java
 * @Description : 优化双重锁校验单例
 * @date : 2019年03月12日 16:44
 */
public class InstanceTest7 implements Serializable  {

    // 私有化静态变量, 加入volatile, 保证该变量的可见性 与 有序性
    private volatile static InstanceTest7 instanceTest7;


    // 私有构造器
    private InstanceTest7() {
    }


    // 公共静态方法, 获得单例对象
    public static InstanceTest7 getInstance() {
        // 不为空不进同步块
        if (instanceTest7 == null) {
            // 为空进入同步块, 创建实例
            synchronized (InstanceTest7.class) {
                if (instanceTest7 == null) {
                    instanceTest7 = new InstanceTest7();
                }
            }
        }

        return instanceTest7;
    }


    // 此方法用作反于序列化的判断 与 返回实力, 当有此方法时, 可以通过此方法获得本对象实力, 从而保证了反序列化的单例
    private Object readResolve() {
        return instanceTest7;
    }
}

