package com.cdac.sem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.sem.model.Games;

@Repository
public interface GameRepository extends JpaRepository<Games, Long>{

}
