package com.progresssoft.progresssoftassignment.Service;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import com.progresssoft.progresssoftassignment.ProgressSoftAssignmentApplication;
import com.progresssoft.progresssoftassignment.Model.Deal;
import com.progresssoft.progresssoftassignment.Repo.DealRepo;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DealServiceTest {

	private final Logger logger = LoggerFactory.getLogger(ProgressSoftAssignmentApplication.class);


    @Test
    public void testForAddingDeals() {
        DealRepo mockDealRepository = mock(DealRepo.class);
        DealService dealService = new DealService(mockDealRepository);

        Deal deal1 = new Deal(null, "uniqueId1","USD","EUR","2023-01-01T12:00:00",1000.0);
        Deal deal2 = new Deal(null, "uniqueId2","USD","EUR","2023-01-01T12:00:00",9000.0);
        List<Deal> dealsToSave = List.of(deal1, deal2);

        when(mockDealRepository.existsByDealUniqueId("uniqueId1")).thenReturn(false);
        when(mockDealRepository.existsByDealUniqueId("uniqueId2")).thenReturn(false);

        List<Deal> savedDeals = dealService.saveDeals(dealsToSave);

        verify(mockDealRepository, times(1)).existsByDealUniqueId("uniqueId1");
        verify(mockDealRepository, times(1)).existsByDealUniqueId("uniqueId2");
        verify(mockDealRepository, times(1)).save(deal1);
        verify(mockDealRepository, times(1)).save(deal2);

        assertEquals(2, savedDeals.size());
        assertTrue(savedDeals.contains(deal1));
        assertTrue(savedDeals.contains(deal2));
        logger.info("Unit testing for adding deals passed successfully well done!");
    }

    @Test
    public void testForCheckForDublicateUniqueId() {
        DealRepo mockDealRepository = mock(DealRepo.class);
        DealService dealService = new DealService(mockDealRepository);

        Deal deal3 = new Deal(null, "uniqueId3","USD","EUR","2023-01-01T12:00:00",1000.0);
        List<Deal> dealsToSave = List.of(deal3);

        when(mockDealRepository.existsByDealUniqueId("uniqueId3")).thenReturn(true);

        List<Deal> savedDeals = dealService.saveDeals(dealsToSave);

        verify(mockDealRepository, times(1)).existsByDealUniqueId("uniqueId3");
        verify(mockDealRepository, never()).save(deal3);

        assertEquals(0, savedDeals.size());
        logger.info("Unit testing for checking for dublicate deals id passed successfully well done!");

    }
}
