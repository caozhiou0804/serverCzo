package com.doctor.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {

	/**
	 * 将object转换成jsonObject
	 * 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> jsonObjToString(Map<String, Object> object) {
		String str = JSONObject.fromObject(object).toString();
		System.out.println("str :" + str);
		return object;
	}
	/**
	 * 讲object转换成jsonarry
	 * 
	 * @param object
	 * @return
	 */
	public static List<Map<String, Object>> jsonArryToString(List<Map<String, Object>> object) {
		String str = JSONArray.fromObject(object).toString();
		return object;
	}

	public static Map<String, Object> parserToMap(String str) {
		Map<String, Object> map = new HashMap();
		JSONObject json = JSONObject.fromObject(str);
		Iterator keys = json.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = json.get(key).toString();
			if (value.startsWith("{") && value.endsWith("}")) {
				map.put(key, parserToMap(value));
			} else {
				map.put(key, value);
			}

		}
		return map;
	}

	public static Map<String, Object> strToMap(HttpServletRequest request) {
		String params = request.getParameter("params");
//		System.out.println("url : "+request.getRequestURI());
//		System.out.println("params : " + params);
		Map<String, Object> m = new HashMap<String, Object>();
		if (params != null && !"".equals(params)) {
			m = JSONUtil.parserToMap(params);
			if(m.get("limit")!=null &&!"".equals(m.get("limit").toString())){
				m.put("limit", Integer.parseInt(m.get("limit").toString()));
			}
		}
		return m;
	}


	/**  
	 * 把数据对象转换成json字符串  
	 * DTO对象形如：{"id" : idValue, "name" : nameValue, ...}  
	 * 数组对象形如：[{}, {}, {}, ...]  
	 * map对象形如：{key1 : {"id" : idValue, "name" : nameValue, ...}, key : {}, ...}  
	 */
	public static String getJSONString(Object object) {
		String jsonString = null;
		if (object != null) {
			if (object instanceof Collection || object instanceof Object[]) {
				jsonString = JSONArray.fromObject(object).toString();
			} else {
				jsonString = JSONObject.fromObject(object).toString();
			}
		}
		return jsonString == null ? "{}" : jsonString;
	}

}
