package com.cdac.sem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.sem.model.PointsTable;
import com.cdac.sem.repository.PointsTableRepository;

@Service
public class PointsTableServiceImpl implements PointsTableService{

	@Autowired
	PointsTableRepository pointsTablerepository;
	
	@Override
	public List<PointsTable> getAllTimeTable() {
		List<PointsTable> pointsTableList = pointsTablerepository.findAll();
		return pointsTableList;
	}

}
