package dev.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		
		if(since == null) {
			listVotes = voteRepo.findAll().stream().filter(v -> v.getId() > 1).collect(Collectors.toList());
		}else {
			listVotes = voteRepo.findAll().stream().filter(v -> v.getId() > since).collect(Collectors.toList());
		}
		return listVotes;
	}
}
