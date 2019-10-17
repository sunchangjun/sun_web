/**
 * 
 */
package com.sun.web.domain;

import com.sun.web.enums.IptvObjectEnum;
import com.sun.web.enums.IptvStatsAction;
import lombok.Data;

/**
 * @Description 操作日志模型
 * @author Randy ran
 * @Date 2019年7月30日 下午3:10:38
 */
@Data
public class OperationLog {
	private String partner;
	private IptvStatsAction action;
	private String ip;
	private String mac;
	private String userId;
	private Long prid;
	private Long rid;
	private Long extrid;
	private String pinyin;
	private IptvObjectEnum type;
	private Integer duration;
	private String method;
	private String platform;
	private boolean test;
	private String path;
	private Long createTime = System.currentTimeMillis();
}
