package cn.com.chnsys.exportimport.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

/**
 * @author yuxt
 **/

public class TestTable
{
    /** 学号 */
    @ExcelProperty("学号")
    @ColumnWidth(15)
    private Long id;

    /** 姓名 */
    @ExcelProperty("姓名")
    @ColumnWidth(15)
    private String name;

    /** 性别 */
    @ExcelProperty("性别")
    @ColumnWidth(15)
    private String gender;

    public void setId(Long id) { this.id = id; }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }

}
