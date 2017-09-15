package cn.ystk.pro.log.mapper;

import cn.ystk.pro.log.entity.Log;

/**
 * 
 * 功能:日志保存功能
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月15日
 * 修改日期: 2017年5月15日
 * 修改列表:
 */
public interface LogMapper {
	/**
	 * 
	 * 功能：日志信息保存功能
	 * @param log
	 */
   public void saveLog(Log log);
}