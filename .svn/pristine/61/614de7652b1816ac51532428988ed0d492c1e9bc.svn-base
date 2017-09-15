package cn.ystk.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ystk.pro.tang.entity.Tang;
import cn.ystk.pro.tang.service.TangService;

/**
 * 
 * Title：hwswjs Description：TangController
 * 
 * @author：唐及第
 * @date：2017年7月7日 下午6:22:09
 * @version 1.0
 * 
 */
@Controller
public class TangController {
	@Autowired
	private TangService tangService;

	@RequestMapping("/taskSendList")
	public ModelAndView tangQuery() {
		Tang tang = tangService.findTangById(13);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tang", tang);
		// 前缀后缀已经在web.xml中配置了，这个是 jsp路径
		modelAndView.setViewName("tang/tangQuery");
		return modelAndView;

	}
}
