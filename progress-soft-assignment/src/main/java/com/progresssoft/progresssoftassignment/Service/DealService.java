package com.progresssoft.progresssoftassignment.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.progresssoft.progresssoftassignment.Model.Deal;
import com.progresssoft.progresssoftassignment.Repo.DealRepo;

import jakarta.transaction.Transactional;

@Service
public class DealService {
    private final Logger logger = LoggerFactory.getLogger(DealService.class);

    private final DealRepo dealRepo;

    public DealService(DealRepo dealRepo) {
        this.dealRepo = dealRepo;
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Deal> saveDeals(List<Deal> deals) {
        List<Deal> savedDeals = new ArrayList<Deal>();
        for (Deal deal : deals) {
            try {
                if (!dealRepo.existsByDealUniqueId(deal.getDealUniqueId())) {
                    dealRepo.save(deal);
                    savedDeals.add(deal);
                }else{
                    logger.error("Deal with UniqueID {} already exists", deal.getDealUniqueId());
                }
            } catch (Exception e) {
                logger.error("Error saving deal with ID: {}. Error: {}", deal.getDealUniqueId(), e.getMessage());
            }
        }
        logger.info("Successfully saved deals: {}", savedDeals);
        return savedDeals;

    }

}
