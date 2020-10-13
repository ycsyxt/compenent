package cn.com.chnsys.exportimport.utils;

import cn.com.chnsys.exportimport.entity.TestTable;
import cn.com.chnsys.exportimport.service.ITestTableService;
import cn.com.chnsys.exportimport.utils.listenser.ReadExcelListener;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.List;

/**
 * @author yuxt
 **/
public class EasyExcelUtils {
    public static void readExcel(ITestTableService service){
        String filePath = "C:/Users/ycs/Desktop/测试表.xlsx";
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(filePath, TestTable.class, new ReadExcelListener(service)).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }

    public static void writeExcel(List<TestTable> testTables){
        String filePath = "C:/Users/ycs/Desktop/测试表1.xlsx";
        ExcelWriter excelWriter = null;
        try{
            excelWriter = EasyExcel.write(filePath,TestTable.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("学生表").build();
            excelWriter.write(testTables, writeSheet);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
