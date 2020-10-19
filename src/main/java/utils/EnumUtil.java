package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import constant.TestEnum;

/**
 * 枚举类的工具类, 封装了hutool工具类, 包装为了业务逻辑需求的封装类
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : EnumUtil.java
 * @Description :
 * @date : 2020年10月10日 14:22
 */
public class EnumUtil {

    /**
     * 获得枚举类的属性List集合
     * @Title getEnumFieldList
     * @Description
     * @author JinPeiyao
     * @param enumClass 枚举类的Class对象
     * @date 2020/10/10 15:14
     * @return java.util.List&lt;java.util.Map&lt;java.lang.String,java.lang.Object&gt;&gt; 枚举类对应的属性List集合
     */
    public static List<Map<String, Object>> getEnumFieldList(Class<? extends Enum<?>> enumClass) {
        // 获得对应的枚举类数组
        Enum<?>[] enumArr = enumClass.getEnumConstants();
        if (ArrayUtil.isEmpty(enumArr)) {
            return new ArrayList<>(1);
        }

        List<Map<String, Object>> enumList = new ArrayList<>(enumArr.length);

        // 获得枚举的所有属性名
        List<String> enumFieldNameList = cn.hutool.core.util.EnumUtil.getFieldNames(enumClass);
        if (CollUtil.isEmpty(enumFieldNameList)) {
            return new ArrayList<>(1);
        }

        // 迭代封装
        Map<String, Object> map;
        for (Enum<?> anEnum : enumArr) {
            map = CollUtil.newHashMap(enumFieldNameList.size());
            // 将所有的属性都封闭到Map中
            for (String name : enumFieldNameList) {
                map.put(name, ReflectUtil.getFieldValue(anEnum, name));
            }
            enumList.add(map);
        }

        return enumList;
    }

    public static void main(String[] args) {
        System.out.println(getEnumFieldList(TestEnum.class));
    }
}
