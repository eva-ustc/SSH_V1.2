package cn.lrk.service;

import java.util.List;
import cn.lrk.domain.Customer;

/**
 * 客户的业务层接口
 * @author eva
 *
 */
public interface ICustomerService {

	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAllCustomer();
	/**
	 * 添加客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);
}
