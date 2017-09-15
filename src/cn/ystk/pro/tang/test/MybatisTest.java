package cn.ystk.pro.tang.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.ystk.pro.tang.entity.Tang;

/**
 * 
 * 
 * Title：hwswjs Description：MybatisTest
 * 
 * @author：唐及第
 * @date：2017年7月6日 下午5:03:31
 * @version 1.0
 *
 */
public class MybatisTest {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public int addTang(Tang tang) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_tang values(?,?,?)";
		Object[] param = { tang.getUsername(), tang.getUserpass(), tang.getUserage() };
		return DaoFactory.executeUpdate(sql, param);
	}

	public int deleteTangById(int id) {
		String sql = "delete from tb_tang where id=?";
		Object[] param = { id };
		return DaoFactory.executeUpdate(sql, param);
	}
}