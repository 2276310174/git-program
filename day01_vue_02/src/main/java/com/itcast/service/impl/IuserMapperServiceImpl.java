package com.itcast.service.impl;

import com.itcast.domain.User;
import com.itcast.mapper.IuserMapper;
import com.itcast.service.IuserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName IuserMapperServiceImpl.java
 * @Description TODO
 * @createTime 2020年09月05日 10:44:00
 */

@Service
public class IuserMapperServiceImpl implements IuserMapperService {
    @Autowired
    private IuserMapper iuserMapper;
    @Override
    public List<User> selectAll() {
        return iuserMapper.selectAll();
    }

    @Override
    public User selectById(Integer id) {
        return iuserMapper.selectById(id);
    }

    @Override
    public void updateUser(User user) {
        iuserMapper.updateUser(user);
    }
}
