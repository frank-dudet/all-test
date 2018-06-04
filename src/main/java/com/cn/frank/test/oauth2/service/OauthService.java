package com.cn.frank.test.oauth2.service;

import com.cn.frank.test.oauth2.domain.OauthClientDetailsDto;
import com.cn.frank.test.oauth2.domain.OauthClientDetails;

import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午3:02
 */
public interface OauthService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);

}
