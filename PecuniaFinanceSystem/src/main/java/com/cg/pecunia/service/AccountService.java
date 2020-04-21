package com.cg.pecunia.service;
import java.util.Date;
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
	public Account getAccount(Long accountId)
	{
		return accountDao.findById(accountId).get();
	}
	
	/*@Transactional
	public String addAccount(int branchCode,String name,String hNo,String city,String state,String country,int zipCode,long aadharNo,String pan,long contactNo,Date date,String gender,String status,String type,double balance)
	{
		Account acc=new Account();
		Customer c=new Customer();
		Address add=new Address();
		add.sethNo(hNo);
		add.setCity(city);
		add.setState(state);
		add.setCountry(country);
		add.setZipCode(zipCode);
		addressDao.save(add);
		
		c.setName(name);
		c.setAadharNo(aadharNo);
		c.setContactNo(contactNo);
		c.setDob(date);
		c.setPan(pan);
		c.setGender(gender);
		customerDao.save(c);
		acc.setBranchId(branchCode);
		acc.setStatus(status);
		acc.setType(type);
		acc.setBalance(balance);
		if(type.equalsIgnoreCase("savings"))
		{
			acc.setMinimumBalance(1000);
		    acc.setNoOfTrans(5);
		}
		if(type.equalsIgnoreCase("current"))
		{
			acc.setMinimumBalance(0);
			acc.setNoOfTrans(10);
		}
		String contact=Long.toString(c.getContactNo());
		String day=Integer.toString(c.getDob().getDate());
		String accId=contact+day;
		long aId=Long.parseLong(accId);
		acc.setAccountId(aId);
		
		if(accountDao.save(acc)==null)
			return "Account creation failed";
		else 
			return "Account created with account ID "+acc.getAccountId();
	}*/
	
	
	@Transactional
	public String addAccount(Account account)
	{
		if(account!=null) 
		{
			if(account.getType().equalsIgnoreCase("savings"))
			{
				account.setMinimumBalance(1000);
			    account.setNoOfTrans(5);
			}
			else if(account.getType().equalsIgnoreCase("current"))
			{
				account.setMinimumBalance(0);
				account.setNoOfTrans(10);
			}
			accountDao.save(account);
			String contact=Long.toString(account.getCustomer().getContactNo());
			String date=Integer.toString(account.getCustomer().getDob().getDate());
			Long accId=Long.parseLong(contact+date);
			account.setAccountId(accId);
			return "Account created with account ID "+accId;
		}
		else
			return "Account creation failed";
	}
	
	@Transactional
	public String deleteAccount(Long accountId)
	{
		if(accountId!=0)
		{
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
		    c.setContactNo(newAccount.getCustomer().getContactNo());
		    add.sethNo(newAccount.getCustomer().getAddress().gethNo());
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
