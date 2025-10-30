package com.devjoliveira.jomovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devjoliveira.jomovie.dto.MovieDTO;
import com.devjoliveira.jomovie.dto.ScoreDTO;
import com.devjoliveira.jomovie.entities.MovieEntity;
import com.devjoliveira.jomovie.entities.ScoreEntity;
import com.devjoliveira.jomovie.entities.UserEntity;
import com.devjoliveira.jomovie.repositories.MovieRepository;
import com.devjoliveira.jomovie.repositories.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private UserService userService;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		UserEntity user = userService.authenticated();

		MovieEntity movie = movieRepository.findById(dto.getMovieId()).get();

		ScoreEntity score = new ScoreEntity();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (ScoreEntity s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);

		return new MovieDTO(movie);
	}
}
