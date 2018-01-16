package dev.api.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dev.api.entite.Avis;
import dev.api.entite.Collegue;
import dev.api.entite.Vote;
import dev.api.repository.AvisRepository;
import dev.api.repository.CollegueRepository;
import dev.api.repository.VoteRepository;


@Component
public class AppliStartupListener implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	CollegueRepository colleguebRepo;
	
	@Autowired
	AvisRepository avisRepo;
	
	@Autowired
	VoteRepository voteRepo;
	
	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		
		Collegue collegue1 = new Collegue();
		collegue1.setNom("Thomas");
		collegue1.setUrlImage("https://organicthemes.com/demo/profile/files/2012/12/profile_img.png");
		collegue1.setScore(100);
	
		Collegue collegue2 = new Collegue();
		collegue2.setNom("Jade");
		collegue2.setUrlImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeUB0Ng134QUKbFtlElyixg6d--dpWQLME3xG4UziTCV2Io1JR");
		collegue2.setScore(50);
		
		Collegue collegue3 = new Collegue();
		collegue3.setNom("Sarah");
		collegue3.setUrlImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN7ASemR4brCI404buAJu-ZZ3s_JKs7t2GZ04cJqPP-FnhtSTmdw");
		collegue3.setScore(80);
		
		colleguebRepo.save(collegue1);
		colleguebRepo.save(collegue2);
		colleguebRepo.save(collegue3);
		
		Avis avis1 = new Avis();
		avis1.setMessage("commentaire 1");
		
		Avis avis2 = new Avis();
		avis2.setMessage("commentaire 2");
		
		avisRepo.save(avis1);
		avisRepo.save(avis2);
		
		Vote vote1 = new Vote();
		vote1.setAvis(avis1);
		vote1.setCollegue(collegue1);
		
		Vote vote2 = new Vote();
		vote2.setAvis(avis2);
		vote2.setCollegue(collegue2);
		
		Vote vote3 = new Vote();
		vote3.setAvis(avis1);
		vote3.setCollegue(collegue3);
		
		Vote vote4 = new Vote();
		vote4.setAvis(avis2);
		vote4.setCollegue(collegue1);
		
		voteRepo.save(vote1);
		voteRepo.save(vote2);
		voteRepo.save(vote3);
		voteRepo.save(vote4);
	}

}
