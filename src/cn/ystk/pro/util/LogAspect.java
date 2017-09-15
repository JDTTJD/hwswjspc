package cn.ystk.pro.util;
import java.lang.reflect.Method;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import cn.ystk.pro.log.entity.Log;
import cn.ystk.pro.log.service.LogService;
/**
 * 
 * 功能:日志切面
 * 版本: 1.0
 * 开发人员: 徐长江
 * 创建日期: 2017年5月15日
 * 修改日期: 2017年5月15日
 * 修改列表:
 */
@Aspect
public class LogAspect {
	@Autowired
	private LogService lService;//日志记录Service 
	/**
	 * 添加业务逻辑方法切入点
	 *//*
    @Pointcut("execution(* cn.ystk.pro.*.service.*.*.save*(..))")
    public void insertServiceCall() { }
    
    *//**
	 * 修改业务逻辑方法切入点
	 *//*
    @Pointcut("execution(* cn.ystk.pro.*.service.*.*.update*(..))")
    public void updateServiceCall() { }   
    */
    /**
 	 * 删除业务逻辑方法切入点
 	 */
     @Pointcut("execution(* cn.ystk.pro.*.service.*.*.delete*(..))")
     public void deleteServiceCall() { }   
    
    
   /* *//**
     * 管理员添加操作日志(后置通知)
     * @param joinPoint
     * @param rtv
     * @throws Throwable
     *//*
	@AfterReturning(value="insertServiceCall()", argNames="rtv", returning="rtv")
    public void insertServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{
		
		//获取登录管理员id
		Integer adminUserId = SystemSession.getUserSession().getId();
		
		if(adminUserId == null){//没有管理员登录
			return;
		}
		
		//判断参数
		if(joinPoint.getArgs() == null){//没有参数
			return;
		}
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(), methodName);
		
		//创建日志对象
		Log log = new Log();
		log.setUserid(adminUserId);//设置管理员id
		log.setCreatedate(new Date(System.currentTimeMillis()));//操作时间
		log.setContent(opContent);//操作内容
		log.setOperation("添加");//操作
		lService.saveLog(log);
		ClassPathResource resource = new ClassPathResource("application-log.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("factory========="+factory);
		System.out.println("logAspect========="+factory.getBean("logAspect"));
	}
	
	 *//**
     * 管理员修改操作日志(后置通知)
     * @param joinPoint
     * @param rtv
     * @throws Throwable
     *//*
	@AfterReturning(value="updateServiceCall()", argNames="rtv", returning="rtv")
    public void updateServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{
		
		//获取登录管理员id
		Integer adminUserId = SystemSession.getUserSession().getId();
		
		if(adminUserId == null){//没有管理员登录
			return;
		}
		
		//判断参数
		if(joinPoint.getArgs() == null){//没有参数
			return;
		}
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(), methodName);
		
		//创建日志对象
		Log log = new Log();
		log.setUserid(adminUserId);//设置管理员id
		log.setCreatedate(new Date(System.currentTimeMillis()));//操作时间
		log.setContent(opContent);//操作内容
		log.setOperation("修改");//操作
		lService.saveLog(log);//添加日志
	}*/
	/**
	 * 
	 * 功能：删除操作的日志
	 * @param joinPoint
	 * @param rtv
	 * @throws Throwable
	 */
	@AfterReturning(value="deleteServiceCall()", argNames="rtv", returning="rtv")
    public void deleteServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{		
		//获取登录管理员id
		Integer adminUserId = SystemSession.getUserSession().getId();
	
		if(adminUserId == null){//没有管理员登录
			return;
		}
		//判断参数
		if(joinPoint.getArgs() == null){//没有参数
			return;
		}
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(), methodName);
		
		//创建日志对象
		Log log = new Log();
		log.setUserid(adminUserId);//设置管理员id
		log.setCreatedate(new Date(System.currentTimeMillis()));//操作时间
		log.setContent(opContent);//操作内容
		log.setOperation("删除");//操作
		lService.saveLog(log);
		/*ClassPathResource resource = new ClassPathResource("application-log.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("factory========="+factory);
		System.out.println("logAspect========="+factory.getBean("logAspect"));*/
	}
	
	
	
	
	
	/**
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值，
	 * 将参数值拼接为操作内容
	 */
	public String adminOptionContent(Object[] args, String mName) throws Exception{

		if (args == null) {
			return null;
		}
		
		StringBuffer rs = new StringBuffer();
		rs.append(mName);
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args) {
			
			//获取对象类型
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[参数" + index + "，类型：" + className + "，值：");
			
			// 获取对象的所有方法
			Method[] methods = info.getClass().getDeclaredMethods();
			
			// 遍历方法，判断get方法
			for (Method method : methods) {
				
				String methodName = method.getName();
				// 判断是不是get方法
				if (methodName.indexOf("get") == -1) {// 不是get方法
					continue;// 不处理
				}
				
				Object rsValue = null;
				try {
					
					// 调用get方法，获取返回值
					rsValue = method.invoke(info);
					
					if (rsValue == null) {//没有返回值
						continue;
					}
					
				} catch (Exception e) {
					continue;
				}
				
				//将值加入内容中
				rs.append("(" + methodName + " : " + rsValue + ")");
			}
			
			rs.append("]");
			
			index++;
		}
		
		return rs.toString();
	}

	public LogService getlService() {
		return lService;
	}

	public void setlService(LogService lService) {
		this.lService = lService;
	}
}