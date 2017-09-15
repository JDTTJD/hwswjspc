package cn.ystk.pro.util.database;
import java.lang.annotation.*;
/**
 * 
 * 功能:注解类
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月12日
 * 修改日期: 2017年4月12日
 * 修改列表:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceKey {
    String value() default "";
}