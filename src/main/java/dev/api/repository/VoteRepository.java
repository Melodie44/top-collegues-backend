package dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.api.entite.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{

}
