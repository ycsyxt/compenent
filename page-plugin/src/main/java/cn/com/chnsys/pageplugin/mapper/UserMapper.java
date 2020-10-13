package cn.com.chnsys.pageplugin.mapper;

import cn.com.chnsys.pageplugin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuxt
 **/
@Mapper
public interface UserMapper
{
    /**
     * 查询用户信息
     *
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public User selectUserById(Long userId);

    /**
     * 查询用户信息列表
     *
     * @param user 用户信息
     * @return 用户信息集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户信息
     *
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserByIds(String[] userIds);
}