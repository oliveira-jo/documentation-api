package com.devjoliveira.jomovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjoliveira.jomovie.dto.MovieGenreDTO;
import com.devjoliveira.jomovie.services.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/v1/movies")
@Tag(name = "Movies", description = "Controller for Movie")
public class MovieControllerV1 {

	@Autowired
	private MovieService service;

	@Operation(description = "Get all movie", summary = "Find all movie with genre", responses = {
			@ApiResponse(description = "Ok", responseCode = "200")
	})
	@GetMapping(produces = "application/json")
	public Page<MovieGenreDTO> findAll(Pageable pageable) {
		return service.findAllMovieGenre(pageable);
	}

	@Operation(description = "Get movie by id", summary = "Find a movie byt id", responses = {
			@ApiResponse(description = "OK", responseCode = "200"),
			@ApiResponse(description = "Not Found", responseCode = "404")
	})
	@GetMapping(value = "/{id}", produces = "application/json")
	public MovieGenreDTO findById(@PathVariable Long id) {
		return service.findMovieGenreById(id);
	}

}
