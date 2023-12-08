package com.progresssoft.progresssoftassignment.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progresssoft.progresssoftassignment.Model.Deal;



public interface DealRepo extends JpaRepository<Deal, Long> {
    boolean existsByDealUniqueId(String dealUniqueId);
}
