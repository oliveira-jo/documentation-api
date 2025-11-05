package com.devjoliveira.jomovie.dto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.devjoliveira.jomovie.entities.MovieEntity;

public class MovieGenreDTO {

	private static final DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	private String genreName;

	public MovieGenreDTO() {
	}

	public MovieGenreDTO(Long id, String title, Double score, Integer count, String image, String genreName) {
		this.id = id;
		this.title = title;
		this.score = Double.valueOf(df.format(score));
		this.count = count;
		this.image = image;
		this.genreName = genreName;
	}

	public MovieGenreDTO(MovieEntity movie) {
		this(movie.getId(), movie.getTitle(), movie.getScore(), movie.getCount(), movie.getImage(),
				movie.getGenre().getName());
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Double getScore() {
		return score;
	}

	public Integer getCount() {
		return count;
	}

	public String getImage() {
		return image;
	}

	public String getGenreName() {
		return genreName;
	}

}
