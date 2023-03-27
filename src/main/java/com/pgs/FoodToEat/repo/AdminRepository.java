package com.pgs.FoodToEat.repo;

import com.pgs.FoodToEat.model.Admin;
import com.pgs.FoodToEat.model.Customers;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository extends CrudRepository< Admin ,Long>{
	
	@Query("select a from Admin a where a.Email=:mail and a.Password=:pwd")
    Admin signIn(@Param("mail") String username, @Param("pwd") String password);

	
	
	

}
