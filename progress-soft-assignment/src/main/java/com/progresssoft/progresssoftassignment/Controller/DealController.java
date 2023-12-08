package com.progresssoft.progresssoftassignment.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progresssoft.progresssoftassignment.Model.Deal;
import com.progresssoft.progresssoftassignment.Service.DealService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/deals")
public class DealController {
    private final DealService dealService;

    Logger logger = LoggerFactory.getLogger(DealController.class);

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveDeals(@Valid @RequestBody List<Deal> deals, BindingResult result) {
        logger.info("Request for adding a new deals {}",deals);
        if (result.hasErrors()) {
            return handleValidationErrors(result,deals);
        }
        try {
            List<Deal> savedDeals = dealService.saveDeals(deals);
            return new ResponseEntity<>("Deals imported successfully. Count: " + savedDeals.size(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity<?> handleValidationErrors(BindingResult result, List<Deal> deals) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        if (!deals.isEmpty()) {
            logger.error("Validation errors occurred while processing deals. Details: {}", errors);
        } else {
            logger.error("Validation errors occurred, but no deals were provided. Details: {}", errors);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    

}
