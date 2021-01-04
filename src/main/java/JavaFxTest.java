import cn.hutool.core.swing.clipboard.ClipboardUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import utils.MyStringUtil;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : JavaFXTest.java
 * @Description :
 * @date : 2021年01月02日 22:11
 */
public class JavaFxTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(11, 12, 13, 14));
        // 设置控件之间的垂直间隔距离
        flowPane.setHgap(5);
        // 设置控件之间的水平间隔距离
        flowPane.setVgap(5);

        // 文本框
        TextField textField = new TextField();

        // 按钮
        Button btn = new Button();
        btn.setText("生成");

        // 点击按钮触发
        btn.setOnAction(event -> {
            // 生成手机号
            String phoneNum = MyStringUtil.getPhoneNum();
            // 将手机号映射到文本框
            textField.setText(phoneNum);
            // 将手机号映射到剪贴板
            ClipboardUtil.setStr(phoneNum);
        });

        // 主窗口
        flowPane.getChildren().addAll(textField, btn);
        Scene scene = new Scene(flowPane, 240, 50);
        primaryStage.setTitle("手机号生成器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
