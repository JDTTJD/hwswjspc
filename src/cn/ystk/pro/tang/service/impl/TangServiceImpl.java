package cn.ystk.pro.tang.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.tang.entity.Tang;
import cn.ystk.pro.tang.mapper.TangMapper;
import cn.ystk.pro.tang.service.TangService;
import cn.ystk.pro.util.database.MultipleDataSource;

public class TangServiceImpl implements TangService {
	@Autowired
	private TangMapper tangMapper;
	@Override
	public int saveTang(Tang tang) {
		// TODO Auto-generated method stub
		tang.setUsername("tangjidi");
		tang.setUserpass("123");
		tang.setUserage(18);
		return tangMapper.saveTang(tang);
	}
	/* (non-Javadoc)
	 * @see cn.ystk.pro.tang.service.TangService#findTangById(int)
	 */
	@Override
	public Tang findTangById(int id) {
		// TODO Auto-generated method stub
//		MultipleDataSource.setDataSourceKey("oracleDS");
		return tangMapper.findTangById(id);
	}

}
