package com.devjoliveira.jomovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjoliveira.jomovie.entities.ScoreEntity;
import com.devjoliveira.jomovie.entities.ScoreEntityPK;

public interface ScoreRepository extends JpaRepository<ScoreEntity, ScoreEntityPK> {

}