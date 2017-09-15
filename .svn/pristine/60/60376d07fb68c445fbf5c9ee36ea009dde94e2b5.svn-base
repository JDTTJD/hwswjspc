package cn.ystk.pro.util.geometry;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
/**
 * 
 * 功能:自定义类型typeHandler接口
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月11日
 * 修改日期: 2017年5月11日
 * 修改列表:
 */
public interface TypeHandler<T> {  

    /** 
     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型 
     * @param ps 当前的PreparedStatement对象 
     * @param i 当前参数的位置 
     * @param parameter 当前参数的Java对象 
     * @param jdbcType 当前参数的数据库类型 
     * @throws SQLException 
     */  
    void setParameter(PreparedStatement ps, int i, T parameter,  
           JdbcType jdbcType);

    /** 
     * 用于在Mybatis获取数据结果集时如何把数据库类型转换为对应的Java类型 
     * @param rs 当前的结果集 
     * @param columnName 当前的字段名称 
     * @return 转换后的Java对象 
     * @throws SQLException 
     */  
    T getResult(ResultSet rs, String columnName) ;  

    /** 
     * 用于在Mybatis通过字段位置获取字段数据时把数据库类型转换为对应的Java类型 
     * @param rs 当前的结果集 
     * @param columnIndex 当前字段的位置 
     * @return 转换后的Java对象 
     * @throws SQLException 
     */  
    T getResult(ResultSet rs, int columnIndex);  

    /** 
     * 用于Mybatis在调用存储过程后把数据库类型的数据转换为对应的Java类型 
     * @param cs 当前的CallableStatement执行后的CallableStatement 
     * @param columnIndex 当前输出参数的位置 
     * @return 
     * @throws SQLException 
     */  
    T getResult(CallableStatement cs, int columnIndex);  

}  
