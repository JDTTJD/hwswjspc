/**  
*
*/
package cn.ystk.pro.tang.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ystk.pro.task.entity.Task;

/**   
*    
* Title：hwswjs   
* Description：TestTask     
* @author：唐及第   
* @date：2017年7月12日 下午5:32:02        
* @version 1.0   
*    
*/
public class TestTask {
	@Test
	public void findTaskById() throws IOException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		Task task = sqlSession.selectOne("cn.ystk.pro.task.mapper.TaskMapper.findTaskById", 2);
		System.out.println(task.getTaskName());
		sqlSession.close();
	}
	@Test
	public void saveTask() throws IOException, ParseException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		Task task=new Task();
		task.setTaskName("最近辛苦了，谢谢大家");
		task.setTaskContent("明天去野营，好好歇歇。");//早上七点集合去黄河水域观察水情，不得迟到，否则扣工资。
		task.setCreateUserId(1);
		task.setRoleId(1);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
		task.setCreateTime(format.parse(format.format(new Date())));
		
		sqlSession.insert("cn.ystk.pro.task.mapper.TaskMapper.saveTask", task);
		System.out.println(task.getCreateTime());
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void updateTask() throws IOException, ParseException {

		String resource = "mybatis/Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于namespac+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配parameterType类型的参数
		Task task=new Task();
		task.setTaskName("最近辛苦了，谢谢大家");
		task.setTaskContent("明天去野营，好好歇歇。");
		task.setCreateUserId(1);
		task.setRoleId(2);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
		task.setCreateTime(format.parse(format.format(new Date())));
		
		sqlSession.insert("cn.ystk.pro.task.mapper.TaskMapper.saveTask", task);
		System.out.println(task.getCreateTime());
		sqlSession.commit();
		sqlSession.close();
	}
}
