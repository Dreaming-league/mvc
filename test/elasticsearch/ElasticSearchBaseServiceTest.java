package elasticsearch;

import com.tikie.common.service.ElasticSearchBaseService;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zcs
 * ES 基础service
 * 2016/11/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class ElasticSearchBaseServiceTest {

    @Autowired
    ElasticSearchBaseService elasticSearchBaseService;

    @Test
    public void testUpdate(){
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        queryBuilder.filter();
//        System.out.println("输出内容:"+ queryBuilder.toString());
//        elasticSearchBaseService.buildSearchRequest(queryBuilder);

        String json = "{" +
                "\"name\":\"test\"," +
                "\"password\":\"123456\"" +
                "}";
        IndexResponse response = elasticSearchBaseService.getClient()
                .prepareIndex("test-index", "test_type", "1")
                .setSource(json)
                .get();

        // Index name
        String _index = response.getIndex();
        // Type name
                String _type = response.getType();
        // Document ID (generated or not)
                String _id = response.getId();
        // Version (if it's the first time you index this document, you will get: 1)
                long _version = response.getVersion();
        // isCreated() is true if the document is a new one, false if it has been updated
//                boolean created = response.isCreated();
        System.out.println("输出内容:"+ _index);
        System.out.println("输出内容:"+ _type);
        System.out.println("输出内容:"+ _id);
        System.out.println("输出内容:"+ response.toString());

        elasticSearchBaseService.closeClient();
    }

    @Test
    public void testQuery(){
        System.out.println("输出内容:"+ elasticSearchBaseService.getClient().prepareSearch().toString());
        SearchResponse sr = elasticSearchBaseService.getClient().prepareSearch()
//                .setQuery(QueryBuilders.matchQuery("message", "i"))
//                .addAggregation(AggregationBuilders.terms("top_10_states")
//                        .field("state").size(10))
                .execute().actionGet();

        System.out.println("输出内容:"+ sr.toString());

        elasticSearchBaseService.closeClient();
    }
}