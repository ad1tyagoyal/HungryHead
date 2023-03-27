package com.pgs.FoodToEat.repo;


import com.pgs.FoodToEat.model.Customers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository< Customers ,Long>{
	
	@Query("select c from Customers c where c.Email=:mail and c.Password=:pwd")
    Customers signIn(@Param("mail") String username, @Param("pwd") String password);


}
