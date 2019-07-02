package lejit.test.aopXML.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value = "/aop.do", method = RequestMethod.GET)
	public String aop(Model model) {
		logger.info("call aop.do");
		
		
		boolean flag = false;
		if(flag) {
			throw new RuntimeException("Test Exception!");
		}
		
		return "aop";
	}
	
	@RequestMapping(value = "/firstInterceptor.do", method = RequestMethod.GET)
	public String firstInterceptor(Model model) {
		logger.info("call firstInterceptor.do");
		
		return "firstInterceptor";
	}

	
	@RequestMapping(value = "/secondInterceptor.do", method = RequestMethod.GET)
	public String secondInterceptor(Model model) {
		logger.info("call secondInterceptor.do");
		
		return "secondInterceptor";
	}

	
	@RequestMapping(value = "/filter.do", method = RequestMethod.GET)
	public String filter(Model model) {
		logger.info("call filter.do");
		
		return "filter";
	}

}
