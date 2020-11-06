package com.cdac.sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.sem.model.TimeTable;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

}
