package cn.ystk.pro.tang.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * ��̬����
 * 
 * @author Administrator
 *
 */
public class DaoFactory {
	/**
	 * �����������������ӵķ�װ����
	 * 
	 * @param args
	 */
	public static Connection getConnection() {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// 1.建立连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2.��������
			String url = "jdbc:sqlserver://localhost:1433;databasename=hwswjs";
			con = DriverManager.getConnection(url, "sa", "123");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * �ͷ���Դ��װ�ľ�̬����
	 * 
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * ����ɾ����ͨ�÷���
	 * @param sqlִ�е�sql���
	 * @param param��sql���ռλ���ṩֵ
	 * @return��Ӱ�������
	 */
	public static int executeUpdate(String sql, Object[] param) {
		Connection con=null;
		PreparedStatement  pst=null;
		int r =-1;
		try {
			con=DaoFactory.getConnection();
			pst=con.prepareStatement(sql);
			if(param!=null){
				//ѭ������
				for (int i = 0; i < param.length; i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			r=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DaoFactory.close(con, pst, null);
		}
		return r;
	}
	/**
	 * ʹ�����ӳؽ������ӵķ���
	 * 
	 * @param args
	 */
	public static Connection getConnection2() {
		Context ctx=null;
		Connection con = null;
		try {
			ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/news"); 
			con=ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
