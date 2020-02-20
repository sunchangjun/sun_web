package com.sun.web.elasticsearch;

/**
 * @author ：suncj
 * @date ：2020/1/15 15:11
 */

/**
 * @author ：suncj
 * @date ：2020/1/14 15:47
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * Created by qcl on 2018/7/10.
 * ES相关
 */
@Document(indexName = "mv", type = "docs", shards = 1, replicas = 0)
public class MvElasticsearch {

    //主键自增长
    @Id
    private Long id;//主键

    private String mv_id;

    @Field(type = FieldType.Auto, analyzer = "ik_max_word")
    private String mv_name;

    private String  singer_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMv_id() {
        return mv_id;
    }

    public void setMv_id(String mv_id) {
        this.mv_id = mv_id;
    }

    public String getMv_name() {
        return mv_name;
    }

    public void setMv_name(String mv_name) {
        this.mv_name = mv_name;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
