package cn.com.chnsys.pageplugin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class PagePluginApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
    }
    @Test
    void dataSourceTest() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }


}
