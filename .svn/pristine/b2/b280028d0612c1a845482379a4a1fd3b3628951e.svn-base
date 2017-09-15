package cn.ystk.pro.util.database;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
/**
 * 
 * 功能:配置多个数据源
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年4月12日
 * 修改日期: 2017年4月12日
 * 修改列表:
 */
@Component
@Aspect
public class MultipleDataSourceAspectAdvice {
    @Around("execution(* cn.ystk.pro.menu.mapper..*(..))||execution(* cn.ystk.pro.role.mapper..*(..))||execution(* cn.ystk.pro.user.mapper..*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = joinPoint.getTarget();
        DataSourceKey annotation = AnnotationUtils.findAnnotation(object.getClass(),DataSourceKey.class);
        if (null != annotation) {//没有注解的用默认值
            String value = annotation.value();
            if (null != value && value.length() > 0) {
                MultipleDataSource.setDataSourceKey(value);
            }
        }
        return joinPoint.proceed();
    }
}