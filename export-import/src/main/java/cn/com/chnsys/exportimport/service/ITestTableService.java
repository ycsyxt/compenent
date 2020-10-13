package cn.com.chnsys.exportimport.service;

import cn.com.chnsys.exportimport.entity.TestTable;

import java.util.List;

/**
 * @author yuxt
 **/
public interface ITestTableService
{
    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    public TestTable selectTestTableById(Long id);

    /**
     * 查询测试列表
     *
     * @param testTable 测试
     * @return 测试集合
     */
    public List<TestTable> selectTestTableList(TestTable testTable);

    /**
     * 新增测试
     *
     * @param testTable 测试
     * @return 结果
     */
    public int insertTestTable(TestTable testTable);

    /**
     * 修改测试
     *
     * @param testTable 测试
     * @return 结果
     */
    public int updateTestTable(TestTable testTable);

    /**
     * 批量删除测试
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestTableByIds(String ids);

    /**
     * 删除测试信息
     *
     * @param id 测试ID
     * @return 结果
     */
    public int deleteTestTableById(Long id);
}
