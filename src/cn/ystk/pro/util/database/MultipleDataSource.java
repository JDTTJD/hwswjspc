/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.ystk.pro.util.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 
 * 功能:配置多个数据源
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月12日
 * 修改日期: 2017年4月12日
 * 修改列表:
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private final static ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}