package cn.ystk.pro.photodetains.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ystk.pro.photodetains.entity.PhotoDetains;
import cn.ystk.pro.photodetains.entity.PhotoDetainsPage;
import cn.ystk.pro.photodetains.mapper.PhotoDetainsMapper;
import cn.ystk.pro.photodetains.service.PhotoDetainsService;
/**
 * 
 * 功能:图片接口实现类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月28日
 * 修改日期: 2017年6月28日
 * 修改列表:
 */
public class PhotoDetainsServiceImpl implements PhotoDetainsService{
    @Autowired
	PhotoDetainsMapper photoDetainsMapper;
	@Override
	public List<PhotoDetains> findByPage(PhotoDetainsPage page) {
		return photoDetainsMapper.findByPage(page);
	}
	@Override
	public Integer getCount(PhotoDetainsPage page) {
		return photoDetainsMapper.getCount(page);
	}
	@Override
	public void savePhotoDetains(PhotoDetains photoDetains) {
		photoDetainsMapper.savePhotoDetains(photoDetains);
	}
	@Override
	public PhotoDetains findPhotoDetainsById(Integer id) {
		return photoDetainsMapper.findPhotoDetainsById(id);
	}

}
