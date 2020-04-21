package com.cg.pecunia.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.pecunia.dto.Address;
@Repository
public interface AddressDAO extends JpaRepository<Address,Integer>
{

}
