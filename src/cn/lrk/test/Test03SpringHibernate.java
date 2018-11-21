package cn.lrk.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lrk.domain.Customer;
import cn.lrk.service.ICustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class Test03SpringHibernate {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Test
	public void testSession() {
//		Session session1 = hibernateTemplate.getSessionFactory().getCurrentSession();
//		Session session2 = hibernateTemplate.getSessionFactory().getCurrentSession();
		Session session1 = hibernateTemplate.getSessionFactory().openSession();
		Session session2 = hibernateTemplate.getSessionFactory().openSession();
		System.out.println(session1 == session2);
	}
	
	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setCustName("SpringHibernate整合测试添加1");
		customerService.saveCustomer(customer);
	}
	@Test
	public void testFindAll() {
		List<Customer> customers = customerService.findAllCustomer();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
