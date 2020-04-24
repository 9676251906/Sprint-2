package com.cg.pecunia.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.pecunia.dao.AccountDAO;
import com.cg.pecunia.dao.AddressDAO;
import com.cg.pecunia.dao.CustomerDAO;
import com.cg.pecunia.dto.Account;
import com.cg.pecunia.dto.Address;
import com.cg.pecunia.dto.Customer;
@Service
public class AccountService 
{
	@Autowired
	AccountDAO accountDao;
	@Autowired
	CustomerDAO customerDao;
	@Autowired
	AddressDAO addressDao;
	public void setAccountDao(AccountDAO accountDao)
	{
		this.accountDao=accountDao;
	}
	public void setCustomerDao(CustomerDAO customerDao)
	{
		this.customerDao=customerDao;
	}
	public void setAddressDao(AddressDAO addressDao)
	{
		this.addressDao=addressDao;
	}
	
	@Transactional(readOnly=true)
	public Optional<Account> getAccount(Long accountId)
	{
		/*Account account=accountDao.findById(accountId).get();
		Customer customer=customerDao.findById(account.getCustomer().getCustomerId()).get();
		Address address=addressDao.findById(customer.getAddress().getAddressId()).get();*/
		return accountDao.findById(accountId);
	}
	
	@Transactional
	public String addAccount(Account account)
	{
		addressDao.save(account.getCustomer().getAddress());
		customerDao.save(account.getCustomer());
		if(accountDao.save(account)!=null)
			return "Account created";
		else
			return "Account creation failed";
	}
	
	@Transactional
	public String deleteAccount(Long accountId)
	{
		if(accountId!=0)
		{
			Account account=accountDao.findById(accountId).get();
			addressDao.deleteById(account.getCustomer().getAddress().getAddressId());
			customerDao.deleteById(account.getCustomer().getCustomerId());
     	     accountDao.deleteById(accountId);
     	     return "Account deleted";
		}
		else
			return "Account Doesn't Exist";
     }
	
	@Transactional
	public String updateAccount(Account newAccount)
	{
		Account account=accountDao.findById(newAccount.getAccountId()).get();
		if(account!=null)
		{
		    Customer c=account.getCustomer();
		    Address add=c.getAddress();
		    c.setName(newAccount.getCustomer().getName());
		    c.setPhone(newAccount.getCustomer().getPhone());
		    add.sethNo(newAccount.getCustomer().getAddress().gethNo());
		    add.setStreet(newAccount.getCustomer().getAddress().getStreet());
		    add.setCity(newAccount.getCustomer().getAddress().getCity());
		    add.setState(newAccount.getCustomer().getAddress().getState());
		    add.setCountry(newAccount.getCustomer().getAddress().getCountry());
		    add.setZipCode(newAccount.getCustomer().getAddress().getZipCode());
		    return "Account Updated";
		}
		else
			return "Account update failed";
	}			
}
