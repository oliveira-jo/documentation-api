package com.devjoliveira.jomovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjoliveira.jomovie.dto.MovieDTO;
import com.devjoliveira.jomovie.dto.ScoreDTO;
import com.devjoliveira.jomovie.services.ScoreService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/scores")
@Tag(name = "Scores", description = "Controller for score movie")
public class ScoreController {

	@Autowired
	private ScoreService service;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@PutMapping(produces = "application/json")
	public MovieDTO saveScore(@Valid @RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
}
