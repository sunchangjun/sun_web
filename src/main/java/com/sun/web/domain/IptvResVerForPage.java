package com.sun.web.domain;

import com.sun.web.enums.IptvObjectEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈用于页面的属性转换〉
 *
 * @author comelk
 * @create 2019/4/16
 */
public class IptvResVerForPage extends IptvResVer implements java.io.Serializable{

	private static final long serialVersionUID = -706465730041480101L;
	private IptvResVer ver;
    /**
     * 栏目绝对定位的top值
     */
    private Integer top;
    /**
     * 非固定布局栏目高度
     */
    private Integer column_height;
    /**
     * 绝对定位的x值
     */
    private Integer absolute_x;
    /**
     * 绝对定位的y值
     */
    private  Integer absolute_y;

    private  List<IptvResVerForPage> page_list = new ArrayList<>();

    private String width;

    private String height;
    //广电专版使用
    private int resHeight;
    private int resWidth;
    private String resTitle;
    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getAbsolute_x() {
        return absolute_x;
    }

    public void setAbsolute_x(Integer absolute_x) {
        this.absolute_x = absolute_x;
    }

    public Integer getAbsolute_y() {
        return absolute_y;
    }

    public void setAbsolute_y(Integer absolute_y) {
        this.absolute_y = absolute_y;
    }

    public List<IptvResVerForPage> getPage_list() {
        return page_list;
    }

    public void setPage_list(List<IptvResVerForPage> page_list) {
        this.page_list = page_list;
    }

    public Integer getColumn_height() {
        return column_height;
    }

    public void setColumn_height(Integer column_height) {
        this.column_height = column_height;
    }

    public IptvResVerForPage(IptvResVer ver) {
        this.ver = ver;
    }

    public IptvResVer getVer() {
        return ver;
    }

    public void setVer(IptvResVer ver) {
        this.ver = ver;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
    @Override
    public Long getRid() {
        return ver.getRid();
    }

    @Override
    public IptvObjectEnum getType() {
        return ver.getType();
    }

    @Override
    public IptvObjectEnum getChild_type() {
        return ver.getChild_type();
    }

    @Override
    public Long getProd_vid() {
        return ver.getProd_vid();
    }

    @Override
    public Long getTest_vid() {
        return ver.getTest_vid();
    }

    @Override
    public Long getRes_id() {
        return ver.getRes_id();
    }

    @Override
    public Long getMusic_id() {
        return ver.getMusic_id();
    }

    @Override
    public Date getCreate_time() {
        return ver.getCreate_time();
    }

    @Override
    public String getIptv_code1() {
        return ver.getIptv_code1();
    }

    @Override
    public String getIptv_code2() {
        return ver.getIptv_code2();
    }

    @Override
    public Long getListen_num() {
        return ver.getListen_num();
    }

    @Override
    public Integer getBatch_num() {
        return ver.getBatch_num();
    }

    @Override
    public Boolean getVersion_disable() {
        return ver.getVersion_disable();
    }

    @Override
    public String getCate_ids() {
        return ver.getCate_ids();
    }

    @Override
    public Boolean getIptv_code1_inject() {
        return ver.getIptv_code1_inject();
    }

    @Override
    public Boolean getIptv_code2_inject() {
        return ver.getIptv_code2_inject();
    }

    @Override
    public String getMedia_definition() {
        return ver.getMedia_definition();
    }

    @Override
    public String getMedia_lyric() {
        return ver.getMedia_lyric();
    }

    @Override
    public Long getSong_mv_id() {
        return ver.getSong_mv_id();
    }

    @Override
    public Integer getMv_rid() {
        return ver.getMv_rid();
    }

    @Override
    public Long getVid() {
        return ver.getVid();
    }

    @Override
    public String getName() {
        return ver.getName();
    }

    @Override
    public Float getSort() {
        return ver.getSort();
    }

    @Override
    public String getBposter() {
        return (StringUtils.isNotBlank(ver.getPoster()))?ver.getPoster():ver.getBposter();
    }

    @Override
    public String getSposter() {
        return ver.getSposter();
    }

    @Override
    public Date getVersion_create_time() {
        return ver.getVersion_create_time();
    }

    @Override
    public Long getLink_prid() {
        return ver.getLink_prid();
    }

    @Override
    public Long getLink_crid() {
        return ver.getLink_crid();
    }

    @Override
    public String getKeyword() {
        return ver.getKeyword();
    }

    @Override
    public String getSinger_name() {
        return ver.getSinger_name();
    }

    @Override
    public String getSinger_res_ids() {
        return ver.getSinger_res_ids();
    }

    @Override
    public String getCountry() {
        return ver.getCountry();
    }

    @Override
    public Integer getPlay_time() {
        return ver.getPlay_time();
    }

    @Override
    public String getLayout_start() {
        return ver.getLayout_start();
    }

    @Override
    public String getLayout_end() {
        return ver.getLayout_end();
    }

    @Override
    public List<IptvResVer> getList() {
        return ver.getList();
    }

    @Override
    public Integer getLayout_line() {
        return ver.getLayout_line();
    }

    @Override
    public Boolean getLayout_show_title() {
        return ver.getLayout_show_title();
    }

    @Override
    public Boolean getLayout_show_child_title() {
        return ver.getLayout_show_child_title();
    }

    @Override
    public Boolean getLayout_big() {
        return ver.getLayout_big();
    }

    @Override
    public Boolean getLayout_regular() {
        return ver.getLayout_regular();
    }

    @Override
    public Long getLink_vid() {
        return ver.getLink_vid();
    }

    @Override
    public Long getLink_rid() {
        return ver.getLink_rid();
    }

    @Override
    public Boolean getCommit() {
        return ver.getCommit();
    }

    @Override
    public IptvResVer getParent() {
        return ver.getParent();
    }

    @Override
    public Integer getSex() {
        return ver.getSex();
    }

    @Override
    public Integer getChild_num() {
        return ver.getChild_num();
    }

    @Override
    public Long getLink_test_vid() {
        return ver.getLink_test_vid();
    }

    @Override
    public Long getLink_prod_vid() {
        return ver.getLink_prod_vid();
    }

    @Override
    public String getFposter() {
        return ver.getFposter();
    }

    @Override
    public  String doMajor(){
       return  getRid()+"|"+getVid()+"|"+getType()+"|"+getChild_type()+"|"+getName();
    }

    public  int getResHeight(){
        try {
            String height = this.height.substring(0,this.height.length()-2);
            this.resHeight = Integer.valueOf(height);
            return this.resHeight;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public  int getResWidth(){
        try {
            String height = this.width.substring(0,this.width.length()-2);
            this.resWidth = Integer.valueOf(height);
            return this.resWidth;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public  String getResTitle(){
        if(this.getType().equals(IptvObjectEnum.mv)){
             this.resTitle =CommonStringUtils.getWordCount(this.getName(),32);
        }else{
             this.resTitle =CommonStringUtils.getWordCount(this.getName(),22);
        }
        return this.resTitle;
    }

    @Override
    public Integer getFree() {
        return ver.getFree();
    }
}
