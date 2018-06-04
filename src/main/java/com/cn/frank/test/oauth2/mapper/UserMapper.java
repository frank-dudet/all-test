package com.cn.frank.test.oauth2.mapper;

import com.cn.frank.test.oauth2.domain.User;

import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午1:07
 */
public interface UserMapper {

    User getUserByUserId(String userId);

    User findByGuid(String guid);

    void saveUser(User user);

    void updateUser(User user);

    User findByUsername(String username);

    List<User> findUsersByUsername(String username);


}
