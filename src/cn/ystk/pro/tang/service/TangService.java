package cn.ystk.pro.tang.service;

import cn.ystk.pro.tang.entity.Tang;

public interface TangService {
	int saveTang(Tang tang);
	Tang findTangById(int id);
}
