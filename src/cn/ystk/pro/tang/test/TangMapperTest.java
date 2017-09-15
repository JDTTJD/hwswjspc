/**  
*
*/
package cn.ystk.pro.tang.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ystk.pro.tang.entity.Tang;
import cn.ystk.pro.tang.mapper.TangMapper;

/**
 * 
 * Title：hwswjs Description：TangMapperTest
 * 
 * @author：唐及第
 * @date：2017年7月7日 下午2:40:30
 * @version 1.0
 * 
 */
public class TangMapperTest {
	ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}

	/**
	 * Test method for
	 * {@link cn.ystk.pro.tang.mapper.TangMapper#findTangById(int)}.
	 */
	@Test
	public void testFindTangById() {
		TangMapper tangMapper=(TangMapper) applicationContext.getBean("tangMapper");
		Tang tang=tangMapper.findTangById(1);
	}

}
