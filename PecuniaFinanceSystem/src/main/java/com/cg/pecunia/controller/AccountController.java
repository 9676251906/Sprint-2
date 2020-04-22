package com.cg.pecunia.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pecunia.dto.Account;
import com.cg.pecunia.service.AccountService;

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
	public ResponseEntity<Optional<Account>> getAccount(Long accountId)
	{
		Optional<Account> account =  accountService.getAccount(accountId);
  	  if(account.isPresent())
  		  return new ResponseEntity<Optional<Account>>(account,HttpStatus.OK);
  	  return new ResponseEntity<Optional<Account>>(account,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity<String> addAccount(@RequestBody()Account account)
	{
		try
  	  {
			accountService.addAccount(account);
  	      return new ResponseEntity<String>("Account created",HttpStatus.OK);
  	  }
  	  catch(Exception ex)
  	  {
  	    	return new ResponseEntity<String>(ex.getMessage()+" Account Creation Failed",HttpStatus.BAD_REQUEST);
  	  } 
	}
	
	@PutMapping(value="/updateAccount",consumes="application/json")
	public ResponseEntity<String> updateAccount(@RequestBody()Account account)
	{
		try
		{
			accountService.updateAccount(account);
			return new ResponseEntity<String>("Account Updated",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Account Update Failed",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/deleteAccount/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountId)
	{
		try
  	  {
			accountService.deleteAccount(accountId);
  	    return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
  	  }
  	  catch(Exception ex)
  	  {
  		  return new ResponseEntity<String>("Deletion Failed",HttpStatus.BAD_REQUEST);
  	  }			
	}
}
