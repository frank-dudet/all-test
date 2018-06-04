package com.cn.frank.test.oauth2.service;


import com.cn.frank.test.oauth2.domain.User;
import com.cn.frank.test.oauth2.domain.UserFormDto;
import com.cn.frank.test.oauth2.domain.UserJsonDto;
import com.cn.frank.test.oauth2.domain.UserOverviewDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午1:24
 */
public interface UserService extends UserDetailsService {

    User getUserByUserId(String userId);

    @Override
    UserDetails loadUserByUsername(String username);

    UserJsonDto loadCurrentUserJsonDto();

    UserOverviewDto loadUserOverviewDto(UserOverviewDto overviewDto);

    boolean isExistedUsername(String username);

    String saveUser(UserFormDto formDto);

}
