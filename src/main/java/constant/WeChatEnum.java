package constant;

/**
 * 微信的枚举类
 * @author JinPeiyao
 * @date 2021-2-25 09:50:17
 */
public enum WeChatEnum {
    /**
     * 外服易积分公众号
     */
    WF_WX_PUBLIC("appid", "secret"),
    ;

    private final String appId;
    private final String secret;

    WeChatEnum(String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
    }

    public String getAppId() {
        return appId;
    }

    public String getSecret() {
        return secret;
    }
}
