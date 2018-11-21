package cn.lrk.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.lrk.domain.Customer;

/**
 * 测试hibernate
 * @author eva
 *
 */
public class Test02Hibernate {

	public static void main(String[] args) {
		
		// 1 加载配置文件
		Configuration config = new Configuration();
		config.configure();
		// 2 获取SessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 3 获取session
		Session session = factory.getCurrentSession();
		// 4 开启事务
		Transaction tx = session.beginTransaction();
		// 5 执行操作
		Customer c = new Customer();
		c.setCustName("ssh测试hibernate2");
		session.save(c);
		// 6 提交/回滚事务
		tx.commit();
		// 7 关闭资源
//		session.close();
		factory.close();

	}

}
