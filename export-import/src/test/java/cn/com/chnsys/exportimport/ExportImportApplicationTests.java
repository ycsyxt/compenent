package cn.com.chnsys.exportimport;

import cn.com.chnsys.exportimport.entity.TestTable;
import cn.com.chnsys.exportimport.service.ITestTableService;
import cn.com.chnsys.exportimport.utils.EasyExcelUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExportImportApplicationTests {
    @Autowired
    ITestTableService service;
    @Test
    void contextLoads() {
        TestTable table = new TestTable();
        table.setId(Long.parseLong("1"));
        table.setName("yuxt");
        table.setGender("男");
        service.insertTestTable(table);
    }
    @Test
    void selectTest(){
        TestTable table = service.selectTestTableById(Long.parseLong("1"));
        Assert.isTrue(table !=null,"没有查询到信息");
    }

    @Test
    void readExcelTest(){
        EasyExcelUtils.readExcel(service);
    }

    @Test
    void writeExcelTest(){
        TestTable table = service.selectTestTableById(Long.parseLong("1"));
        List<TestTable> testTables = new ArrayList<>();
        testTables.add(table);
        EasyExcelUtils.writeExcel(testTables);
    }
}
