package com.cdac.sem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.sem.model.TimeTable;
import com.cdac.sem.repository.TimeTableRepository;

@Service
public class TimeTableServiceImpl implements TimeTableService{

	@Autowired
	TimeTableRepository timeTableRepository;
	
	@Override
	public List<TimeTable> getTimetable() {
		List<TimeTable> timeTableList = timeTableRepository.findAll();
		return timeTableList;
	}

}
