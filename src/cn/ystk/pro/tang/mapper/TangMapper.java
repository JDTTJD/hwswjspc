package cn.ystk.pro.tang.mapper;

import cn.ystk.pro.tang.entity.Tang;

public interface TangMapper {
	int saveTang(Tang tang);
	Tang findTangById(int id);
}
