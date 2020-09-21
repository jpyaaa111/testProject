package utils;

import java.io.File;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;

public class ExcelUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 用Hutool工具类获得报表对象
     * @Title getHutoolExcelReport
     * @Description
     * @author JinPeiyao
     * @param dataList 源数据
     * @param path 报表生成路径, 带文件名
     * @param reportTitle 报表标题
     * @param attrArr 属性名数组, 需要与别名顺序一致, 类型 : String[]
     * @param columnArr 别名数组, 需要与属性名顺序一致, 类型 : String[]
     * @date 2020/9/9 11:28
     */
    public static <U> BigExcelWriter getHutoolExcelReport(List<U> dataList, String path, String reportTitle, String[] attrArr, String[] columnArr) {
        if (CollUtil.isEmpty(dataList)) {
            return null;
        }

        // 创建Excel文件, 判断是否存在文件, 存在先删除
        File excelFile = FileUtil.newFile(path);
        if (excelFile.exists()) {
            excelFile.delete();
        }
        // 开始生成报表
        BigExcelWriter writer = ExcelUtil.getBigWriter(excelFile, reportTitle);
        // --- 设置属性名对应的别名
        for (int i = 0; i < attrArr.length; i++) {
            writer.addHeaderAlias(attrArr[i], columnArr[i]);
        }

        // --- 合并单元格后的标题行，使用默认标题样式
        writer.merge(attrArr.length - 1, reportTitle);

        // --- 一次性写出内容，使用默认样式
        writer.setOnlyAlias(true);
        writer.write(dataList, true);

        return writer;
    }

    /**
     * 用Hutool工具类将报表写出至指定路径
     * @Title writerHutoolExcelReport
     * @Description
     * @author JinPeiyao
     * @param dataList 源数据
     * @param path 报表生成路径, 带文件名
     * @param reportTitle 报表标题
     * @param attrArr 属性名数组, 需要与别名顺序一致, 类型 : String[]
     * @param columnArr 别名数组, 需要与属性名顺序一致, 类型 : String[]
     * @param autoSizeColumnFlag 是否设置自动列宽, true : 是 | false : 否
     * @date 2020/9/12 18:21
     */
    public static <U> void writerHutoolExcelReport(List<U> dataList, String path, String reportTitle, String[] attrArr, String[] columnArr, boolean autoSizeColumnFlag) {
        BigExcelWriter writer = getHutoolExcelReport(dataList, path, reportTitle, attrArr, columnArr);
        writerHutoolExcelReport(writer, autoSizeColumnFlag);
    }

    /**
     * 用Hutool工具类, 在报表对象中添加新的标签, 将报表数据写入新的标签中
     * @Title addShellByHutoolExcel
     * @Description
     * @author JinPeiyao
     * @param writer 报表对象
     * @param dataList 源数据
     * @param reportTitle 报表标题
     * @param attrArr 属性名数组, 需要与别名顺序一致, 类型 : String[]
     * @param columnArr 别名数组, 需要与属性名顺序一致, 类型 : String[]
     * @date 2020/9/12 18:22
     */
    public static <U> void addShellByHutoolExcel(BigExcelWriter writer, List<U> dataList, String reportTitle, String[] attrArr, String[] columnArr) {
        if (writer == null) {
            return;
        }

        // 为报表文件添加新的标签页
        writer.setSheet(reportTitle);
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(attrArr.length - 1, reportTitle);

        // 设置属性名对应的别名
        for (int i = 0; i < attrArr.length; i++) {
            writer.addHeaderAlias(attrArr[i], columnArr[i]);
        }

        // 一次性写出内容，使用默认样式
        writer.setOnlyAlias(true);
        writer.write(dataList, true);
    }

    /**
     * 用Hutool工具类, 将报表对象写出到对象中的原定路径
     * @Title writerHutoolExcelReport
     * @Description
     * @author JinPeiyao
     * @param writer 报表对象, 此对象必须要有指定的路径
     * @param autoSizeColumnFlag 是否设置自动列宽, true : 是 | false : 否
     * @date 2020/9/12 18:56
     */
    public static void writerHutoolExcelReport(BigExcelWriter writer, boolean autoSizeColumnFlag) {
        if (writer == null) {
            return;
        }

        // 将所有的列设置自动列宽
        if (autoSizeColumnFlag) {
            SXSSFSheet sheet;
            List<Sheet> sheetList = writer.getSheets();
            if (CollUtil.isNotEmpty(sheetList)) {
                for (Sheet rows : sheetList) {
                    sheet = (SXSSFSheet) rows;
                    // 上面需要强转SXSSFSheet  不然没有trackAllColumnsForAutoSizing方法
                    sheet.trackAllColumnsForAutoSizing();
                    // 列宽自适应
                    writer.autoSizeColumnAll();
                }
            }
        }

        // 写出报表, 如果报表文件内没有指定文件, 则会异常, 异常了打印并关闭报表对象
        try {
            writer.flush();
        }
        catch (IORuntimeException e) {
            LOGGER.error("发生了异常, 可能是文件没有定义, 异常信息为 : " + e, e);
        }
        finally {
            writer.close();
        }
    }
}
