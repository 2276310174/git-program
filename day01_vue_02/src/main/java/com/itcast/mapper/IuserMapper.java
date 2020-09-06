package com.itcast.mapper;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName IuserMapper.java
 * @Description TODO
 * @createTime 2020年09月05日 10:38:00
 */
@Repository
public interface IuserMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> selectAll();

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User selectById(Integer id);

    /**
     * 修改用户
     * @param id
     */
   @Select("update user set age = #{age},username = #{username},password = #{password}," +
           "email = #{email},sex = #{sex} where id = #{id}")
    public void updateUser(User user);
}
