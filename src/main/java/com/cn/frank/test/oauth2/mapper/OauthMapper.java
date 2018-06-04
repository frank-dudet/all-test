package com.cn.frank.test.oauth2.mapper;

import com.cn.frank.test.oauth2.domain.OauthClientDetails;

import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午2:56
 */
public interface OauthMapper {

    /**
     * 根据客户端ID查找该客户端的授权信息
     * @param clientId
     * @return
     */
    OauthClientDetails findOauthClientDetails(String clientId);

    /**
     * 列出所有的客户端授权信息
     * @return
     */
    List<OauthClientDetails> findAllOauthClientDetails();

    /**
     * 更新客户端的archive字段为1
     * @param clientId
     * @param archive
     */
    void updateOauthClientDetailsArchive(String clientId, boolean archive);

    /**
     * 添加授权的客户端
     * @param clientDetails
     */
    void saveOauthClientDetails(OauthClientDetails clientDetails);

}
