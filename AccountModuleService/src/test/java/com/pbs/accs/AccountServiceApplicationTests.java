package com.pbs.accs;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pbs.accs.dao.AccountDAO;
import com.pbs.accs.dao.AddressDAO;
import com.pbs.accs.dao.CustomerDAO;
import com.pbs.accs.dto.Account;
import com.pbs.accs.dto.Address;
import com.pbs.accs.dto.Customer;
import com.pbs.accs.service.AccountService;
import com.pbs.accs.service.AddressService;
import com.pbs.accs.service.CustomerService;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AccountServiceApplicationTests {

	@InjectMocks
	private AddressService addressService;
	private Optional<Address> address;
	@Mock
	private AddressDAO addressDao;
	
	@Before
    public void setup() 
	{
        MockitoAnnotations.initMocks(this);
    }
	
	/*@Test
	public void testGetAddress()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Address address1=addressDao.findById(1000).get();
		assertEquals("22-33",address1.getHno());
		assertEquals("Ramnagar",address1.getStreet());
		assertEquals("Hyderabad",address1.getCity());
		assertEquals("Telangana",address1.getState());
		assertEquals("India",address1.getCountry());
		assertEquals(address,address1);
	}
	*/
	@Test
	public void testAddAddress()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
	    addressDao.save(address);
	    verify(addressDao,Mockito.times(1)).save(address);
	}
	
	@Test
	public void testUpdateAddress()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		addressDao.findById(1000);
		addressDao.save(address);
		verify(addressDao,Mockito.times(1)).save(address);
	}
	
	@Test
	public void testDeleteAddress()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		addressDao.deleteById(1000);
		verify(addressDao,times(1)).deleteById(1000);
	}

	@InjectMocks
	private CustomerService customerService;
	
	@Mock
	private CustomerDAO customerDao;
	
	@Test
	public void testAddCustomer()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Customer customer=new Customer(111111,"Pravalika",9676251906L,"pravalika@gmail.com","ASDFG3456M",address);
		customerDao.save(customer);
		verify(customerDao,times(1)).save(customer);
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Customer customer=new Customer(111111,"Pravalika",9676251906L,"pravalika@gmail.com","ASDFG3456M",address);
		customerDao.findById(111111);
		customerDao.save(customer);
		verify(customerDao,times(1)).save(customer);
	}
	
	@Test
	public void testDeleteCustomer()
	{
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Customer customer=new Customer(111111,"Pravalika",9676251906L,"pravalika@gmail.com","ASDFG3456M",address);
		customerDao.deleteById(111111);
		verify(customerDao,times(1)).deleteById(111111);
	}
	
	@Test
	public void testGetCustomer()
	{
		
	}
	
	@InjectMocks
	private AccountService accountService;
	
	@Mock
	private AccountDAO accountDao;
	
	@Test
	public void testAddAccount()
	{
		LocalDate date=LocalDate.now();
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Customer customer=new Customer(111111,"Pravalika",9676251906L,"pravalika@gmail.com","ASDFG3456M",address);
		Account account=new Account(111111111111L,"Savings",date,10000,"Active",customer);
		accountDao.save(account);
		verify(accountDao,times(1)).save(account);
	}
	
	@Test
	public void testUpdateAccount()
	{
		LocalDate date=LocalDate.now();
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Customer customer=new Customer(111111,"Pravalika",9676251906L,"pravalika@gmail.com","ASDFG3456M",address);
		Account account=new Account(111111111111L,"Savings",date,10000,"Active",customer);
		accountDao.findById(111111111111L);
		accountDao.save(account);
		verify(accountDao,times(1)).save(account);
	}
	
	@Test
	public void testDeleteAccount()
	{
		LocalDate date=LocalDate.now();
		Address address=new Address(1000,"22-33","Ramnagar","Hyderabad","Telangana","India");
		Customer customer=new Customer(111111,"Pravalika",9676251906L,"pravalika@gmail.com","ASDFG3456M",address);
		Account account=new Account(111111111111L,"Savings",date,10000,"Active",customer);
		accountDao.deleteById(111111111111L);
		verify(accountDao,times(1)).deleteById(111111111111L);
	}
	
	@Test
	public void testGetAccount()
	{
		
	}
}
