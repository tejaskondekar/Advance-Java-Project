package com.cdac.sem.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cdac.sem.model.Games;
import com.cdac.sem.repository.GameRepository;

@Service
public class GamesServiceImpl implements GamesService {

	@Autowired
	private GameRepository gameRepository;

	@Override
	public List<Games> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public void saveGames(Games game) {
		this.gameRepository.save(game);
	}

	@Override
	public Games getGamesById(long id) {
		Optional<Games> optional = gameRepository.findById(id);
		Games game = null;
		if (optional.isPresent()) {
			game = optional.get();
		} else {
			throw new RuntimeException(" Game not found for id :: " + id);
		}
		return game;
	}

	@Override
	public void deleteGamesById(long id) {
		this.gameRepository.deleteById(id);
	}

	@Override
	public Page<Games> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.gameRepository.findAll(pageable);
	}
}
