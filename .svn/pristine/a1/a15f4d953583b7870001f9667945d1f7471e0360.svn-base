package cn.ystk.pro.photo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.photo.entity.Photo;
import cn.ystk.pro.photo.entity.PhotoPage;
import cn.ystk.pro.photo.mapper.PhotoMapper;
import cn.ystk.pro.photo.service.PhotoService;
/**
 * 
 * 功能: 照片接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月28日
 * 修改日期: 2017年6月28日
 * 修改列表:
 */
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	PhotoMapper photoMapper;
	@Override
	public void savePhoto(Photo photo) {	
		photoMapper.savePhoto(photo);
	}
	@Override
	public List<Photo> findByPage(PhotoPage page) {
		return photoMapper.findByPage(page);
	}
	@Override
	public Integer getCount(PhotoPage page) {
		return photoMapper.getCount(page);
	}

}
