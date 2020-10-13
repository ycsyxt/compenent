package cn.com.chnsys.pageplugin.service.impl;

import cn.com.chnsys.pageplugin.entity.User;
import cn.com.chnsys.pageplugin.mapper.UserMapper;
import cn.com.chnsys.pageplugin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yuxt
 **/
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户信息
     *
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public User selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }

    /**
     * 查询用户信息列表
     *
     * @param user 用户信息
     * @return 用户信息
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        user.setCreateTime(new Date());
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        user.setUpdateTime(new Date());
        return userMapper.updateUser(user);
    }

    /**
     * 删除用户信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserByIds(String ids)
    {
        return userMapper.deleteUserByIds(ids.split(","));
    }

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long userId)
    {
        return userMapper.deleteUserById(userId);
    }
}
