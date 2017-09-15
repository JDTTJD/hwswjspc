package cn.ystk.pro.photodetains.mapper;

import java.util.List;

import cn.ystk.pro.photodetains.entity.PhotoDetains;
import cn.ystk.pro.photodetains.entity.PhotoDetainsPage;

/**
 * 
 * 功能:图片详情接口类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月28日
 * 修改日期: 2017年6月28日
 * 修改列表:
 */
public interface PhotoDetainsMapper {
	 
	/**
	 * 
	 * 功能：列表
	 * 
	 * @param page
	 * @return
	 */
	List<PhotoDetains> findByPage(PhotoDetainsPage page);

	/**
	 * 
	 * 功能：总的记录数
	 * 
	 * @param page
	 * @return
	 */
	Integer getCount(PhotoDetainsPage page);
	/**
	 * 
	 * 功能：图片的保存
	 * @param photoDetains
	 */
	void savePhotoDetains(PhotoDetains photoDetains);
	
	/**
	 * 
	 * 功能：根据id获得图片实体类信息
	 * @param id
	 * @return
	 */
	PhotoDetains findPhotoDetainsById(Integer id);
}
