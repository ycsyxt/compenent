package cn.com.chnsys.exportimport.contrller;

import cn.com.chnsys.exportimport.entity.TestTable;
import cn.com.chnsys.exportimport.service.ITestTableService;
import cn.com.chnsys.exportimport.utils.listenser.ReadExcelListener;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxt
 **/
@Controller
public class ExportImportController {
    @Autowired
    ITestTableService service;

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>1. 创建excel对应的实体对象
     * <p>2. 设置返回的 参数
     * <p>3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<TestTable> testTables = service.selectTestTableList(new TestTable());
        EasyExcel.write(response.getOutputStream(), TestTable.class).sheet("模板").doWrite(testTables);
    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象
     * <p>2. 由于默认一行行的读取excel
     * <p>3. 直接读即可
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), TestTable.class, new ReadExcelListener(service)).sheet().doRead();
        return "success";
    }
}
