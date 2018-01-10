package dev.api.controller;

import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Collegue;
import dev.api.repository.CollegueRepository;
import net.minidev.json.parser.JSONParser;

@RestController
@RequestMapping("/collegues")
public class CollegueController {
	
	@Autowired
	private CollegueRepository collegueRepo;
	
	@GetMapping
	public List<Collegue> ListeCollaborateurs() {

		return collegueRepo.findAll();
	}
	
	@PostMapping
	public Collegue SauvegarderCollegue(@RequestBody Collegue collegue) {

		if(collegueRepo.findByNom(collegue.getNom()) == null){
			return collegueRepo.save(collegue);
		}
		else {
			return null;
		}
		
	}
	
	@RequestMapping(method = RequestMethod.PATCH, path = "/{pseudo}/")
	public Collegue ModifierScoreCollegue(@PathVariable("pseudo") String pseudo,
			@RequestBody String action) throws JSONException {
		
		// récupération de la valeur string JSON
		JSONObject jo = new JSONObject(action);
		String decision = jo.getString("action");

		Collegue collegue = collegueRepo.findByNom(pseudo);

		if(decision.equals("aimer")) {
			collegue.setScore(collegue.getScore()+10);
		}
		if(decision.equals("detester")) {
			collegue.setScore(collegue.getScore()-5);
		}
		
		return collegueRepo.save(collegue);
	}
}
