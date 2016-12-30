package com.tikie.common.service;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;

/**
 * @author zcs
 *         基础ESservice
 *         2016/11/23
 */
public interface ElasticSearchBaseService {
    /**
     * 获取Client对象
     * @return  Client
     */
    Client getClient();
    void closeClient();
    /**
     * 构建基础query对象
     * @return  BoolQueryBuilder
     */
    BoolQueryBuilder buildBaseQuery();
    /**
     * 构建基础Request
     * @return  SearchRequestBuilder
     */
    SearchRequestBuilder buildSearchRequest();
    /**
     * 构建基础Request
     * @return  SearchRequestBuilder
     */
    SearchRequestBuilder buildSearchRequest(BoolQueryBuilder query);

}
