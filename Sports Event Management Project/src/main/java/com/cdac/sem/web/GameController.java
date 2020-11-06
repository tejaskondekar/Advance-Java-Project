package com.cdac.sem.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.sem.model.Games;
import com.cdac.sem.service.GamesService;

@Controller
public class GameController {
	
	@Autowired
	private GamesService gameService;
	
	@GetMapping("/games_title")
	public String Games() {
		return "games";
	}
	
	// display list of games
	@GetMapping("/games")
	public String viewGamesPage(Model model) {
		return findPaginated(1, "gameName", "asc", model);		
	}
	
	@GetMapping("/showNewGamesForm")
	public String showNewGameForm(Model model) {
		// create model attribute to bind form data
		Games game = new Games();
		model.addAttribute("game", game);
		return "new_game";
	}
	
	@PostMapping("/saveGames")
	public String saveGames(@ModelAttribute("game")Games game) {
		// save employee to database
		gameService.saveGames(game);
		return "redirect:/games";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get game from the service
		Games game = gameService.getGamesById(id);
		
		// set game as a model attribute to pre-populate the form
		model.addAttribute("game",game);
		return "update_game";
	}
	
	@GetMapping("/deleteGames/{id}")
	public String deleteGames(@PathVariable (value = "id") long id) {
		
		// call delete games method 
		this.gameService.deleteGamesById(id);
		return "redirect:/games";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Games> page = gameService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Games> listGames = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listGames", listGames);
		return "games";
	}

}
