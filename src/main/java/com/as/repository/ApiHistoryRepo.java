package com.as.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.domain.ApiHistory;

@Repository
public interface ApiHistoryRepo extends JpaRepository<ApiHistory, String> {

}
