package com.cg.pecunia.controller;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pecunia.dto.Account;
import com.cg.pecunia.service.AccountService;
import com.cg.pecunia.util.ConvertDate;
@CrossOrigin("http://localhost:4200")
@RestController
public class AccountController 
{
	@Autowired
	AccountService accountService;
	public void getAccountService(AccountService accountService)
	{
		this.accountService=accountService;
	}
	
	@GetMapping("/getAccount/{accountId}")
	public Account getAccount(Long accountId)
	{
		return accountService.getAccount(accountId);
	}
	
	/*@PostMapping("/addAccount/{branchCode}/{name}/{hNo}/{city}/{state}/{country}/{zipCode}/{aadharNo}/{pan}/{contactNo}/{dob}/{gender}/{status}/{type}/{balance}")
	public String addAccount(@PathVariable int branchCode,@PathVariable String name,@PathVariable String hNo,@PathVariable String city,@PathVariable String state,
			@PathVariable String country,@PathVariable int zipCode,@PathVariable long aadharNo,@PathVariable String pan,@PathVariable long contactNo,
			@PathVariable String dob,@PathVariable String gender,@PathVariable String status,@PathVariable String type,@PathVariable double balance)
	{
		  Date date=ConvertDate.convertDate(dob);
		  return accountService.addAccount(branchCode, name, hNo, city, state, country, zipCode, aadharNo, pan, contactNo, date, gender, status, type, balance);
		  
	}
	*/
	
	@PostMapping("/addAccount")
	public String addAccount(@RequestBody()Account account)
	{
		return accountService.addAccount(account);
	}
	
	@PutMapping(value="/updateAccount",consumes="application/json")
	public String updateAccount(@RequestBody()Account account)
	{
		return accountService.updateAccount(account);
	}
	
	@PutMapping("/deleteAccount/{accountId}")
	public String deleteAccount(@PathVariable Long accountId)
	{
		return accountService.deleteAccount(accountId);
			
	}
}
