package cn.lrk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lrk.service.ICustomerService;

/**
 * 测试SpringIOC环境是否能用
 * @author eva
 *
 */
public class Test01Spring {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService customerService = (ICustomerService) context.getBean("customerService");
		customerService.findAllCustomer();

	}

}
