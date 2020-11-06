package constant;

public enum TestEnum {
    /**
     * 0-未发薪
     */
    NOT_SENT_SALARY(0, "未发薪"),
    /**
     * 1-已发薪
     */
    SENT_SALARY(1, "已发薪"),
    /**
     * 2-发薪处理中
     */
    PROCESSING(2, "发薪处理中"),
    /**
     * 3-发薪失败
     */
    FAIL(3, "发薪失败"),
    ;
    private final int code;
    private final String name;

    TestEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String switchName(int code) {
        for (TestEnum anEnum : TestEnum.values()) {
            if (anEnum.code == code) {
                return anEnum.name;
            }
        }
        return "";
    }
}
