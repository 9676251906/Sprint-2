package com.cg.pecunia.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.pecunia.dao.CustomerDAO;
import com.cg.pecunia.dto.Customer;
@Service
public class CustomerService 
{
	@Autowired
	CustomerDAO customerDao;
	public void setCustomerDao(CustomerDAO customerDao)
	{
		this.customerDao=customerDao;
	}
	
	@Transactional(readOnly=true)
	public Customer getCustomer(Long customerId)
	{
		return customerDao.findById(customerId).get();
	}
	
	@Transactional
	public void addCustomer(Customer customer)
	{
		customerDao.save(customer);
	}
	
	@Transactional
	public void deleteCustomer(Long customerId)
	{
		customerDao.deleteById(customerId);
	}
	
	@Transactional
	public void updateCustomer(Customer customer)
	{
		customerDao.save(customer);
	}
	
}
