package cn.lrk.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lrk.domain.Customer;
import cn.lrk.service.ICustomerService;

/**
 * Customer的动作类
 * @author eva
 *
 */
@Controller("customerAction")
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
	@Result(name="addUICustomer",type="dispatcher",location="/jsp/customer/add.jsp"),
	@Result(name="findAllCustomer",type="dispatcher",location="/jsp/customer/list.jsp"),
	@Result(name="listCustomer",type="redirectAction",location="findAllCustomer.action")
})
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="customerService")
	private ICustomerService customerService;
	
	private List<Customer> customers;
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}

	@Action("addCustomer")
	public String addCustomer() {
		customerService.saveCustomer(customer);
		return "listCustomer";
	}
	
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer() {
		
		return "addUICustomer";
	}
	/**
	 * 查找所有客户
	 * @return
	 */
	@Action("findAllCustomer")
	public String findAllCustomer() {
		customers = customerService.findAllCustomer();
		return "findAllCustomer";
	}



	
//=================设置getter and setter 之后 自动出现在值栈============================================
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
