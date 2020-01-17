package com.sun.web.controller;

import com.sun.web.elasticsearch.MvElasticsearch;
import com.sun.web.elasticsearch.MvElasticsearchRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：suncj
 * @date ：2020/1/15 15:16
 */

@RestController
@RequestMapping("/mv")
public class MvElasticsearchController {

    @Autowired
    private MvElasticsearchRepository mvElasticsearchRepository;

    @GetMapping("/create")
    public String create(
            @RequestParam("id") Long id,
            @RequestParam("mv_name") String mv_name,
            @RequestParam("mv_id") String mv_id,
            @RequestParam("singer_name") String singer_name) {
        MvElasticsearch mvElasticsearch=new MvElasticsearch();
        mvElasticsearch.setId(id);
        mvElasticsearch.setMv_name(mv_name);
        mvElasticsearch.setMv_id(mv_id);
        mvElasticsearch.setSinger_name(singer_name);


        return mvElasticsearchRepository.save(mvElasticsearch).toString();
    }

    private String names;

    @GetMapping("/get")
    public String get() {
        names = "";
        Iterable<MvElasticsearch> userES = mvElasticsearchRepository.findAll();
        userES.forEach(userES1 -> {
            names += userES1.toString() + "\n";
        });
        return names;
    }

    private String searchs = "";

    @GetMapping("/search")
    public String search(@RequestParam("searchKey") String searchKey) {
        searchs = "";
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("mv_name", searchKey));
        // 搜索，获取结果
        Page<MvElasticsearch> items = mvElasticsearchRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        searchs += "总共数据数：" + total + "\n";
        items.forEach(userES -> {
            searchs += userES.toString() + "\n";
        });
        return searchs;
    }
}
