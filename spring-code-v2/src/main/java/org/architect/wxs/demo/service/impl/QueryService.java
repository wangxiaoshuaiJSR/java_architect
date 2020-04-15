package org.architect.wxs.demo.service.impl;

import org.architect.wxs.demo.service.IQueryService;
import org.architect.wxs.framework.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 查询业务
 *
 */
@Service
public class QueryService implements IQueryService {

	/**
	 * 查询
	 */
	public String query(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
		System.err.println("这是在业务方法中打印的：" + json);
		return json;
	}

}
