package com.cn.frank.test.oauth2.service.impl;

import com.cn.frank.test.oauth2.domain.OauthClientDetailsDto;
import com.cn.frank.test.oauth2.service.OauthService;
import com.cn.frank.test.oauth2.domain.OauthClientDetails;
import com.cn.frank.test.oauth2.mapper.OauthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午3:03
 */
@Service("oauthService")
public class OauthServiceImpl implements OauthService {


    @Autowired
    private OauthMapper oauthMapper;

    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) {
        return oauthMapper.findOauthClientDetails(clientId);
    }

    @Override
    public List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos() {
        List<OauthClientDetails> clientDetailses = oauthMapper.findAllOauthClientDetails();
        return OauthClientDetailsDto.toDtos(clientDetailses);
    }

    @Override
    public void archiveOauthClientDetails(String clientId) {
        oauthMapper.updateOauthClientDetailsArchive(clientId, true);
    }

    @Override
    public OauthClientDetailsDto loadOauthClientDetailsDto(String clientId) {
        OauthClientDetails oauthClientDetails = oauthMapper.findOauthClientDetails(clientId);
        return oauthClientDetails != null ? new OauthClientDetailsDto(oauthClientDetails) : null;
    }

    @Override
    public void registerClientDetails(OauthClientDetailsDto formDto) {
        OauthClientDetails clientDetails = formDto.createDomain();
        oauthMapper.saveOauthClientDetails(clientDetails);
    }
}
