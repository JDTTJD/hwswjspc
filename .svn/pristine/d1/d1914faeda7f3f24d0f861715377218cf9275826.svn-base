package cn.ystk.pro.photo.mapper;
import java.util.List;
import cn.ystk.pro.photo.entity.Photo;
import cn.ystk.pro.photo.entity.PhotoPage;
/**
 * 
 * 功能:接口Mapper
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年6月28日
 * 修改日期: 2017年6月28日
 * 修改列表:
 */
public interface PhotoMapper {
	/**
	 * 
	 * 功能：照片保存功能
	 * @param photo
	 */
	void  savePhoto(Photo photo);
	/**
	 * 
	 * 功能：列表
	 * 
	 * @param page
	 * @return
	 */
	List<Photo> findByPage(PhotoPage page);

	/**
	 * 
	 * 功能：总的记录数
	 * 
	 * @param page
	 * @return
	 */
	Integer getCount(PhotoPage page);
}
