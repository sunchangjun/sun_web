package com.sun.web.dao;

import com.sun.web.domain.IptvRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IptvResDao {

	public int insertRes(IptvRes res);// 最简单的创建,仅是占行与类型的保存

	public IptvRes findByRid(@Param("rid") Long rid);
	public IptvRes findByResId(@Param("res_id") Long res_id);
	public IptvRes findByCateIds(@Param("cate_ids") String cate_ids);
	public List<IptvRes> findParentResByLinkCrid(@Param("rid") Long rid);//找子为rid的res
	
	public void updateRes(IptvRes ver);
	public void updateGlobalDisable(@Param("rid") Long rid);//该方法不需要disable参数,会在0,1之间跳动

	// import
	public List<IptvRes> findAllByResidNotNull();
	public void updateMefiaInfo(@Param("rid") Long rid, @Param("iptv_code1") String iptv_code1, @Param("media_definition") String media_definition, @Param("media_lyric") String media_lyric);
	public void updateMvid(@Param("rid") long rid, @Param("song_mv_id") long song_mv_id);
//	public List<IptvRes> findByType(@Param("type") IptvObjectEnum type);
	
}