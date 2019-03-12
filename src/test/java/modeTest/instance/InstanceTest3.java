package modeTest.instance;

/**
 * <p>双重校验单例模式</p>
 * <p>恶汉模式单例的升级</p>
 * <p>优点 : 优化了恶汉模式每次均同步的问题, 只有一开始获得时, 对象为空才会走同步块加载, volatile同时保证了外部判断的可见性 与 有序性</p>
 * <p>缺点 : <b>JDK1.5以下使用有危险, 可能得到不完整的对象</b></p>
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest3
 * @Description : 双重校验单例模式
 * @date : 2019-1-31 15:31:28
 */
public class InstanceTest3 {

    // 私有化静态变量, 加入volatile, 保证该变量的可见性 与 有序性
    private volatile static InstanceTest3 instance;

    // 私有构造器
    private InstanceTest3() {
    }

    // 公共静态方法, 获得单例对象
    public static InstanceTest3 getInstance() {
        // 不为空不进同步块
        if (instance == null) {
            // 为空进入同步块, 创建实例
            synchronized (InstanceTest3.class) {
                if (instance == null) {
                    instance = new InstanceTest3();
                }
            }
        }

        return instance;
    }
}
