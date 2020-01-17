package com.sun.web.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author ：suncj
 * @date ：2020/1/15 15:14
 */
public interface MvElasticsearchRepository extends ElasticsearchRepository<MvElasticsearch, Long> {
}
