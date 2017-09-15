package cn.ystk.pro.util.geometry;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import cn.ystk.pro.util.DBConsts;
/**
 * 
 * 功能:空间数据
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月11日
 * 修改日期: 2017年5月11日
 * 修改列表:
 */
@MappedTypes({JGeometry.class})
@MappedJdbcTypes({JdbcType.STRUCT})//这两个Mapped也可不需要
public class SdoGeometryTypeHandler implements TypeHandler<JGeometry> {
	
    @Override
    public void setParameter(PreparedStatement ps, int i, JGeometry parameter,
            JdbcType jdbcType){
    	try {	
    		Class.forName(DBConsts.driverclass);
    		Connection conn=null;
    		conn=DriverManager.getConnection(DBConsts.url,DBConsts.username, DBConsts.password);   	
	        STRUCT st = JGeometry.store(conn, parameter);   
	        ps.setObject(i, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @Override
    public JGeometry getResult(ResultSet rs, String columnName)
            throws SQLException {
        STRUCT st = (STRUCT) rs.getObject(columnName);
        if (st != null) {
            return JGeometry.load(st);
        }
        return null;
    }

    @Override
    public JGeometry getResult(ResultSet rs, int columnIndex)
            throws SQLException {
        STRUCT st = (STRUCT) rs.getObject(columnIndex);
        if (st != null) {
            return JGeometry.load(st);
        }
        return null;
    }

    @Override
    public JGeometry getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        STRUCT st = (STRUCT) cs.getObject(columnIndex);
        if (st != null) {
            return JGeometry.load(st);
        }
        return null;
    }

}
