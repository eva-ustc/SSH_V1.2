package cn.lrk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.lrk.dao.ICustomerDao;
import cn.lrk.domain.Customer;
import cn.lrk.service.ICustomerService;
/**
 * 客户的业务层接口实现类
 * @author eva
 *
 */
@Service("customerService")
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class CustomerServiceImpl implements ICustomerService {

	@Resource(name="customerDao")
	private ICustomerDao customerDao;
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Customer> findAllCustomer() {
		
		return customerDao.findAllCustomer();
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		customerDao.saveCustomer(customer);
	}

}
