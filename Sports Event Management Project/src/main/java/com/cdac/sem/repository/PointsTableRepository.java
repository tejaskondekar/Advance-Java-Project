package com.cdac.sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.sem.model.PointsTable;

@Repository
public interface PointsTableRepository extends JpaRepository<PointsTable, Long>{

}
