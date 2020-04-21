package com.cg.pecunia.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.pecunia.dto.Account;
@Repository
public interface AccountDAO extends JpaRepository<Account,Long>
{

}
