package com.pgs.FoodToEat.service;

import java.util.List;
import java.util.Optional;

import com.pgs.FoodToEat.model.FoodItems;
import com.pgs.FoodToEat.model.Vendors;
import com.pgs.FoodToEat.repo.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodRepository foodRepository ;
	
	public void addfood(FoodItems food) {
		  foodRepository.save(food) ;
	}

	public void removeFoodById(Long fid) {
		// TODO Auto-generated method stub
		foodRepository.deleteById(fid);
	}

	public Optional<FoodItems> getFoodItemById(Long fid) {
		// TODO Auto-generated method stub
		return foodRepository.findById(fid);
	}

	public List<FoodItems> getAllFood() {
		// TODO Auto-generated method stub
		return  (List<FoodItems>) foodRepository.findAll();
		
	}
	

}
