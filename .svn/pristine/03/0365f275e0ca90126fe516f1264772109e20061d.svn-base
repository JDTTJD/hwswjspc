package cn.ystk.pro.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.log.entity.Log;
import cn.ystk.pro.log.mapper.LogMapper;
import cn.ystk.pro.log.service.LogService;
/**
 * 
 * 功能:日志添加接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月15日
 * 修改日期: 2017年5月15日
 * 修改列表:
 */
public class LogServiceImpl implements LogService {
	@Autowired
    LogMapper logMapper;
	@Override
	public void saveLog(Log log) {
		logMapper.saveLog(log);
	}

}
