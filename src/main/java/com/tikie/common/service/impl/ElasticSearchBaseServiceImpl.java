package com.tikie.common.service.impl;

import com.tikie.common.service.ElasticSearchBaseService;
import com.tikie.common.service.ElasticsearchFactory;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zcs
 *         基础操作
 *         2016/11/23
 */
@Service
public class ElasticSearchBaseServiceImpl implements ElasticSearchBaseService{
    @Autowired
    private ElasticsearchFactory elasticsearchFactory;

    /**
     * 获取Client对象
     *
     * @return Client
     */
    public Client getClient() {
        return elasticsearchFactory.getClient();
    }

    public void closeClient(){
        getClient().close();
    }

    /**
     * 构建基础query对象
     *
     * @return BoolQueryBuilder
     */
    public BoolQueryBuilder buildBaseQuery() {
        return QueryBuilders.boolQuery();
    }

    /**
     * 构建基础Request
     *
     * @return SearchRequestBuilder
     */
    public SearchRequestBuilder buildSearchRequest() {
        //索引和类型（库和表）从mysql动态读取，限定数据范围
        String[] indexs = {"customer","test"};
        String[] types = {"users","external"};

        return getClient().prepareSearch(indexs).setTypes(types);
    }

    /**
     * 构建基础Request
     *
     *         query
     * @return SearchRequestBuilder
     */
    public SearchRequestBuilder buildSearchRequest(BoolQueryBuilder query) {
        return buildSearchRequest().setQuery(query);
    }

}
