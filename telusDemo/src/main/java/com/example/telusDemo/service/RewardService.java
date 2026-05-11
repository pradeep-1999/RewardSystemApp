package com.example.telusDemo.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telusDemo.dto.RewardResponseDto;
import com.example.telusDemo.exceptionHandling.CustomerNotFoundException;
import com.example.telusDemo.repositories.TransactionRepository;
import com.example.telusDemo.repositories.UserRepository;


@Service
public class RewardService {
	
	@Autowired
	public UserRepository usersRepo;
	
	@Autowired
	public TransactionRepository transactionRepository;

	
	/**
	 * Calculates monthly and total reward points
	 * for a customer for the last 3 months.
	 *
	 * @param custId customer identifier
	 * @return reward response containing monthly
	 *         and total reward points
	 */
	
	public RewardResponseDto calculateRewardsByMonth(String custId) {
		
		if (!usersRepo.existsById(Long.valueOf(custId))) {
		    throw new CustomerNotFoundException(
		            "Customer not found with id: " + custId
		    );
		}
		
		RewardResponseDto rewardResponseDTO = null;
	    Map<String, Integer> monthlyRewards = new HashMap<>();

        int totalRewards = 0;

        // current month
        YearMonth currentMonth = YearMonth.now();

        // loop for last 3 months
        for (int i = 0; i < 3; i++) {

            YearMonth yearMonth = currentMonth.minusMonths(i);

            LocalDate startDate = yearMonth.atDay(1);

            LocalDate endDate = yearMonth.atEndOfMonth();

            var transactions = transactionRepository.findTransactions(custId,startDate,endDate);

            int monthlyPoints = transactions.stream()
                    .mapToInt(transaction ->
                            calculatePoints(
                                    transaction.getAmount())).sum();

            Month month = yearMonth.getMonth();

            monthlyRewards.put( month.toString(),  monthlyPoints );

            totalRewards += monthlyPoints;
        }

        rewardResponseDTO = new RewardResponseDto();

        rewardResponseDTO.setCustId(custId);
        rewardResponseDTO.setMonthlyRewards(monthlyRewards);
        rewardResponseDTO.setTotalRewards(totalRewards);

        return rewardResponseDTO;
    }

	
	/**
	 * Calculates reward points based on transaction amount.
	 *
	 * Rules:
	 * - No points for amount <= 50
	 * - 1 point for every dollar spent between 50 and 100
	 * - 2 points for every dollar spent above 100
	 *
	 * @param amount transaction amount
	 * @return reward points
	 */
    public int calculatePoints(Double amount) {

        if (amount <= 50) {
            return 0;
        }

        if (amount <= 100) {
            return (int) (amount - 50);
        }

        return 50 +
                (int) ((amount - 100) * 2);
    }

}
