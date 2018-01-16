package dev.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Collegue;
import dev.api.entite.Vote;
import dev.api.repository.VoteRepository;

@RestController
@RequestMapping("/votes")
public class VoteController {
	
	@Autowired
	private VoteRepository voteRepo;

	@GetMapping
	public List<Vote> ListerVotes(@RequestParam(value="since") Integer since) {
		
		List<Vote> listVotes = new ArrayList<Vote>();
		
		if(since != 0) {
			listVotes = voteRepo.findAll().stream().filter(v -> v.getId() > since).collect(Collectors.toList());
		}else {
			listVotes = voteRepo.findAll().stream().unordered().limit(3).collect(Collectors.toList());
		}
		
		return listVotes;
	}
	
	@PostMapping
	public List<Vote> SauvegarderCollegue(@RequestBody Vote vote) {

		voteRepo.save(vote);
		return ListerVotes(0);	
	}
}
