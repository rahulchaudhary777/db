package com.example.DBtoExcel.repo;

import com.example.DBtoExcel.MyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepo extends JpaRepository<MyDetails, Integer> {
}
