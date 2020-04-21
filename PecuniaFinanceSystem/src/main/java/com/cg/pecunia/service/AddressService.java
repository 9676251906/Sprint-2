package com.cg.pecunia.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.pecunia.dao.AddressDAO;
import com.cg.pecunia.dto.Address;
@Service
public class AddressService 
{
	@Autowired
	AddressDAO addressDao;
	public void setAddressDao(AddressDAO addressDao)
	{
		this.addressDao=addressDao;
	}
	
	@Transactional(readOnly=true)
	public Address getAddress(int addressId)
	{
		return addressDao.findById(addressId).get();
	}
	
	@Transactional
	public void addAddress(Address address)
	{
		addressDao.save(address);
	}
	
	@Transactional
	public void updateAddress(Address address)
	{
		addressDao.save(address);
	}
	
	@Transactional
	public void deleteAddress(int addressId)
	{
		addressDao.deleteById(addressId);
	}
}
