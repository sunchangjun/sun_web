package com.sun.web.domain;

import com.sun.web.enums.IptvObjectEnum;
import java.util.Date;

public class IptvRes implements java.io.Serializable{
	
	private static final long serialVersionUID = 6323787363392783244L;
	protected Long rid;
	protected IptvObjectEnum type;
	protected IptvObjectEnum child_type;
	protected Long prod_vid;
	protected Long test_vid;
	protected Long res_id;//内部资源id
	protected Long music_id;//腾讯id
	protected String cate_ids;//分类标签id
	protected Boolean global_disable;
	protected Date create_time;
	protected String iptv_code1;
	protected Boolean iptv_code1_inject;
	protected String iptv_code2;
	protected Boolean iptv_code2_inject;
	protected boolean media_ok = true;//媒资就诸
	protected String media_definition;//媒资清晰度
	protected String media_lyric;//媒资歌词文件
	protected Long song_mv_id;//腾讯song关联的mv_id
	protected Long listen_num;//收听次数
	protected Integer batch_num;//导入时的批次号
	protected Integer free;//免费1,付费0
	protected Integer play_time;
	protected int res_flag;//资源特殊标记,0为默认值无意义,1表示hot,2表示newest
	//非表字段
	protected Boolean newCreate;//代表新增
	protected Integer mv_rid;//关联mv的rid

	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public IptvObjectEnum getType() {
		return type;
	}
	public void setType(IptvObjectEnum type) {
		this.type = type;
	}
	public IptvObjectEnum getChild_type() {
		return child_type;
	}
	public void setChild_type(IptvObjectEnum child_type) {
		this.child_type = child_type;
	}
	public Long getProd_vid() {
		return prod_vid;
	}
	public void setProd_vid(Long prod_vid) {
		this.prod_vid = prod_vid;
	}
	public Long getTest_vid() {
		return test_vid;
	}
	public void setTest_vid(Long test_vid) {
		this.test_vid = test_vid;
	}
	public Long getRes_id() {
		return res_id;
	}
	public void setRes_id(Long res_id) {
		this.res_id = res_id;
	}
	public Long getMusic_id() {
		return music_id;
	}
	public void setMusic_id(Long music_id) {
		this.music_id = music_id;
	}
	public Boolean getGlobal_disable() {
		return global_disable;
	}
	public void setGlobal_disable(Boolean global_disable) {
		this.global_disable = global_disable;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getIptv_code1() {
		return iptv_code1;
	}
	public void setIptv_code1(String iptv_code1) {
		this.iptv_code1 = iptv_code1;
	}
	public String getIptv_code2() {
		return iptv_code2;
	}
	public void setIptv_code2(String iptv_code2) {
		this.iptv_code2 = iptv_code2;
	}
	public Long getListen_num() {
		return listen_num;
	}
	public void setListen_num(Long listen_num) {
		this.listen_num = listen_num;
	}
	public Boolean isNewCreate() {
		if(this.newCreate==null){
			return false;
		}
		return newCreate;
	}
	public void setNewCreate(Boolean newCreate) {
		this.newCreate = newCreate;
	}
	public Integer getBatch_num() {
		return batch_num;
	}
	public void setBatch_num(Integer batch_num) {
		this.batch_num = batch_num;
	}
	public String getCate_ids() {
		return cate_ids;
	}
	public void setCate_ids(String cate_ids) {
		this.cate_ids = cate_ids;
	}
	public Boolean getIptv_code1_inject() {
		return iptv_code1_inject;
	}
	public void setIptv_code1_inject(Boolean iptv_code1_inject) {
		this.iptv_code1_inject = iptv_code1_inject;
	}
	public Boolean getIptv_code2_inject() {
		return iptv_code2_inject;
	}
	public void setIptv_code2_inject(Boolean iptv_code2_inject) {
		this.iptv_code2_inject = iptv_code2_inject;
	}
	public boolean isMedia_ok() {
		return media_ok;
	}
	public void setMedia_ok(boolean media_ok) {
		this.media_ok = media_ok;
	}
	public String getMedia_definition() {
		return media_definition;
	}
	public void setMedia_definition(String media_definition) {
		this.media_definition = media_definition;
	}
	public String getMedia_lyric() {
		return media_lyric;
	}
	public void setMedia_lyric(String media_lyric) {
		this.media_lyric = media_lyric;
	}
	public Long getSong_mv_id() {
		return song_mv_id;
	}
	public void setSong_mv_id(Long song_mv_id) {
		this.song_mv_id = song_mv_id;
	}
	public Integer getMv_rid() {
		return mv_rid;
	}
	public void setMv_rid(Integer mv_rid) {
		this.mv_rid = mv_rid;
	}
	public Integer getFree() {
		return free;
	}
	public void setFree(Integer free) {
		this.free = free;
	}
	public Integer getPlay_time() {
		return play_time;
	}
	public void setPlay_time(Integer play_time) {
		this.play_time = play_time;
	}
	public int getRes_flag() {
		return res_flag;
	}
	public void setRes_flag(int res_flag) {
		this.res_flag = res_flag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IptvRes other = (IptvRes) obj;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IptvRes [rid=" + rid + ", type=" + type + ", child_type=" + child_type + ", prod_vid=" + prod_vid + ", test_vid=" + test_vid + ", res_id="
				+ res_id + ", music_id=" + music_id + ", cate_ids=" + cate_ids + ", global_disable=" + global_disable + "]";
	}
}
