package modeTest.instance;

/**
 * 恶汉模式单例
 * 优点 : 优化了懒汉模式的直接初始化加载, 而是在调用时才进行创建加载
 * 缺点 : 每次调用都经过同步方法, 同步锁牺牲了工作效率
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest2
 * @Description : 饿汉模式
 * @date : 2019-1-31 15:15:18
 */
public class InstanceTest2 {

    // 私有静态变量, 先不复制
    private static InstanceTest2 instance;

    // 稀有构造器
    private InstanceTest2() {
    }

    // 公共静态同步方法, 直接调用获得对象, 同步锁保证多线程的原子性, 可见性, 有序性
    public synchronized static InstanceTest2 getInstance() {
        if (instance == null) {
            instance = new InstanceTest2();
        }

        return instance;
    }
}
