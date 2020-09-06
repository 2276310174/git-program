package com.itcast.service;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName IuserMapperService.java
 * @Description TODO
 * @createTime 2020年09月05日 10:43:00
 */

public interface IuserMapperService {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAll();

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    public User selectById(Integer id);
    /**
     * 修改用户
     * @param id
     */
    public void updateUser(User user);
}
