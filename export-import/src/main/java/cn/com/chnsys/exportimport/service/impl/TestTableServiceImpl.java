package cn.com.chnsys.exportimport.service.impl;

import cn.com.chnsys.exportimport.entity.TestTable;
import cn.com.chnsys.exportimport.mapper.TestTableMapper;
import cn.com.chnsys.exportimport.service.ITestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuxt
 **/
@Service
public class TestTableServiceImpl implements ITestTableService
{
    @Autowired
    private TestTableMapper testTableMapper;

    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public TestTable selectTestTableById(Long id)
    {
        return testTableMapper.selectTestTableById(id);
    }

    /**
     * 查询测试列表
     *
     * @param testTable 测试
     * @return 测试
     */
    @Override
    public List<TestTable> selectTestTableList(TestTable testTable)
    {
        return testTableMapper.selectTestTableList(testTable);
    }

    /**
     * 新增测试
     *
     * @param testTable 测试
     * @return 结果
     */
    @Override
    public int insertTestTable(TestTable testTable)
    {
        return testTableMapper.insertTestTable(testTable);
    }

    /**
     * 修改测试
     *
     * @param testTable 测试
     * @return 结果
     */
    @Override
    public int updateTestTable(TestTable testTable)
    {
        return testTableMapper.updateTestTable(testTable);
    }

    /**
     * 删除测试对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestTableByIds(String ids)
    {
        return testTableMapper.deleteTestTableByIds(ids.split(","));
    }

    /**
     * 删除测试信息
     *
     * @param id 测试ID
     * @return 结果
     */
    @Override
    public int deleteTestTableById(Long id)
    {
        return testTableMapper.deleteTestTableById(id);
    }
}
