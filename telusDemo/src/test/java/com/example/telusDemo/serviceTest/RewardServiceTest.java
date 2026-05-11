package com.example.telusDemo.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.telusDemo.service.RewardService;

public class RewardServiceTest {

    private RewardService rewardService =
            new RewardService();

    @Test
    void shouldReturnZeroPointsBelow50() {

        int points =
                rewardService.calculatePoints(40.0);

        assertEquals(0, points);
    }

    @Test
    void shouldReturn25PointsFor75Dollars() {

        int points =
                rewardService.calculatePoints(75.0);

        assertEquals(25, points);
    }

    @Test
    void shouldReturn90PointsFor120Dollars() {

        int points =
                rewardService.calculatePoints(120.0);

        assertEquals(90, points);
    }
    
    @Test
    void shouldReturnZeroPointsFor50Dollars() {

        int points =
                rewardService.calculatePoints(50.0);

        assertEquals(0, points);
    }

    @Test
    void shouldReturn50PointsFor100Dollars() {

        int points =
                rewardService.calculatePoints(100.0);

        assertEquals(50, points);
    }
}