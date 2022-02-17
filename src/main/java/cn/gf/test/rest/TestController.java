package cn.gf.test.rest;

import cn.gf.elasticsearch.util.ElasticsearchUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GuoFeng
 * Describe :
 * Created on 2022/1/17
 * Modified By :
 */
@RestController
public class TestController {

    private ElasticsearchUtils elasticsearchUtils;

    @Autowired
    public TestController(ElasticsearchUtils elasticsearchUtils) {
        this.elasticsearchUtils = elasticsearchUtils;
    }

    @GetMapping("/test")
    public void test() {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        elasticsearchUtils.word("正文", "正文", boolQueryBuilder);
        SearchResponse query = elasticsearchUtils.query(boolQueryBuilder, "原创");
        SearchHits hits = query.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    @GetMapping("/test1")
    public void test1() {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        elasticsearchUtils.word("正文", "正文", boolQueryBuilder);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        elasticsearchUtils.page(0, 3, searchSourceBuilder);
        SearchResponse query = elasticsearchUtils.query(boolQueryBuilder, searchSourceBuilder, "原创");
        SearchHits hits = query.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
