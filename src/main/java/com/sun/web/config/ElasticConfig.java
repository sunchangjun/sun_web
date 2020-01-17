//package com.sun.web.config;
//
///**
// * @author ：suncj
// * @date ：2020/1/17 15:59
// */
//
//import org.elasticsearch.client.Client;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
//import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
//import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;
//
//@Configuration
//@AutoConfigureBefore(RedisConfig.class)
//public class ElasticConfig {
//
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate(Client client,
//                                                       ElasticsearchConverter converter) {
//        try {
//            return new ElasticsearchTemplate(client, converter);
//        }
//        catch (Exception ex) {
//            throw new IllegalStateException(ex);
//        }
//    }
//
//    @Bean
//    public ElasticsearchConverter elasticsearchConverter(
//            SimpleElasticsearchMappingContext mappingContext) {
//        return new MappingElasticsearchConverter(mappingContext);
//    }
//
//    @Bean
//    public SimpleElasticsearchMappingContext mappingContext() {
//        return new SimpleElasticsearchMappingContext();
//    }
//
//}