package dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.api.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer>{

	Collegue findByNom(String pseudo);

}
