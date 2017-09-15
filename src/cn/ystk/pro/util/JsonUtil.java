package cn.ystk.pro.util;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
/**
 * 
 * 功能:
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月8日
 * 修改日期: 2017年5月8日
 * 修改列表:
 */
public class JsonUtil {
	
private static	Gson gson=new Gson();
	
	public static String toJson(Object src)
	{
		if(src!=null)
		{
			return gson.toJson(JsonNull.INSTANCE);
		}
		return gson.toJson(src);
	}
			

}
