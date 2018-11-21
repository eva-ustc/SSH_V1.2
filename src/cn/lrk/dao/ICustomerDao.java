package cn.lrk.dao;

import java.util.List;

import cn.lrk.domain.Customer;
/**
 * 客户的持久层接口
 * @author eva
 *
 */
public interface ICustomerDao {

	List<Customer> findAllCustomer();

	void saveCustomer(Customer customer);

}
