package com.devjoliveira.jomovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjoliveira.jomovie.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}