package modeTest.instance;

/**
 * 内部类单例模式
 * <p>利用内部类的方法, 另寻捷径, 得到完美延迟加载的目的</p>
 * <p>优点 : 实现了比较完美的单例模式</p>
 * <p>缺点 : 结构比较复杂</p>
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : InstanceTest5
 * @Description : 内部类的单例模式
 * @date : 2019-1-31 17:08:22
 */
@SuppressWarnings("unused")
public class InstanceTest5 {

    private InstanceTest5() {
    }

    private static class InitInstance {
        private static InstanceTest5 instance = new InstanceTest5();
    }

    public static InstanceTest5 getInstance() {
        return InitInstance.instance;
    }
}