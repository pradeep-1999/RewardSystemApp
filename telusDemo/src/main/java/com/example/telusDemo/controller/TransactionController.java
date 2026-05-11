package com.example.telusDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telusDemo.dto.RewardResponseDto;
import com.example.telusDemo.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class TransactionController {
	
	 @Autowired
	 private RewardService rewardService;

	 /**
	  * Fetches reward points for a customer.
	  *
	  * @param customerId customer identifier
	  * @return reward response
	  */

	   @GetMapping("/{customerId}")
	   public  ResponseEntity<?> getRewards( @PathVariable String customerId) {

		   RewardResponseDto response = rewardService.calculateRewardsByMonth(customerId);
	        return ResponseEntity.ok(response);
	    }
	
}
