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
 * Title：hwswjs Description：TestMybatis
 * 
 * @author：唐及第
 * @date：2017年7月7日 上午9:29:13
 * @version 1.0
 * 
 */
public class TestMybatis {
	@Test
	public void findTangByIdTest() throws IOException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		Tang tang = sqlSession.selectOne("cn.ystk.pro.tang.mapper.TangMapper.findTangById", 10);
		System.out.println(tang.getUsername());
		sqlSession.close();
	}
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
		tang.setUsername("缑小敏");
		tang.setUserpass("123456");
		tang.setUserage(12);
		sqlSession.insert("cn.ystk.pro.tang.mapper.TangMapper.saveTang", tang);
		System.out.println(tang.getUsername());
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void deleteTangTest() throws IOException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		sqlSession.delete("cn.ystk.pro.tang.mapper.TangMapper.deleteTang", 11);
		System.out.println("成功");
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void updateTangTest() throws IOException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		Tang tang=new Tang();
		tang.setId(10);
		tang.setUsername("lixiaolei");
		tang.setUserpass("123");
		tang.setUserage(20);
		sqlSession.update("cn.ystk.pro.tang.mapper.TangMapper.updateTang", tang);
		System.out.println("成功");
		sqlSession.commit();
		sqlSession.close();
	}
}
