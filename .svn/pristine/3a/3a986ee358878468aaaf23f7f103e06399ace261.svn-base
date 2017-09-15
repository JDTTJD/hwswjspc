/**  
*
*/
package cn.ystk.pro.tang.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ystk.pro.tang.entity.Tang;

/**   
*    
* Title：hwswjs   
* Description：TestMybatisSave     
* @author：唐及第   
* @date：2017年7月7日 上午10:07:12        
* @version 1.0   
*    
*/
public class TestMybatisSave {

	@Test
	public void saveTangTest() throws IOException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		Tang tang =new Tang();
		tang.setUsername("lilei");
		tang.setUserpass("123456");
		tang.setUserage(12);
		sqlSession.insert("cn.ystk.pro.tang.mapper.TangMapper.saveTang", tang);
		System.out.println(tang.getUsername());
		sqlSession.commit();
		sqlSession.close();
	}

}
