package com.pgs.FoodToEat.repo;

import java.util.List;

import com.pgs.FoodToEat.model.FoodItems;
import com.pgs.FoodToEat.model.Vendors;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodRepository extends CrudRepository< FoodItems ,Long> {
	
    @Query( "Select f from FoodItems f where f.vid =:idtemp" )
    List<FoodItems> findFoodsById(@Param("idtemp") Long id);
	
	

}
