package cn.ystk.pro.tang.test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import cn.ystk.pro.tang.entity.Tang;
import cn.ystk.pro.tang.mapper.TangMapper;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configfile = "cn/ystk/pro/tang/mapper/TangMapper.xml";
		int id=1;
		InputStream is = null;
		SqlSessionFactory sessionFactory = null;
		SqlSession session = null;
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			is = Resources.getResourceAsStream(configfile);
			sessionFactory = builder.build(is);
			session = sessionFactory.openSession();
			TangMapper mapper = session.getMapper(TangMapper.class);
			Tang tang = new Tang();
			tang.getUsername();
			tang.getUserpass();
			System.out.println("tang:" + tang);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
