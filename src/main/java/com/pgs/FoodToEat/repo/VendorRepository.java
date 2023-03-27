package com.pgs.FoodToEat.repo;



import com.pgs.FoodToEat.model.Vendors;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface VendorRepository extends CrudRepository< Vendors ,Long> {
	
	@Query("select v from Vendors v where v.Email=:mail and v.Password=:pwd")
    Vendors signIn(@Param("mail") String username, @Param("pwd") String password);

}
