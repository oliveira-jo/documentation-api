package com.devjoliveira.jomovie.dto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.hibernate.validator.constraints.URL;

import com.devjoliveira.jomovie.entities.MovieEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class MovieDTO {

	private static final DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

	@Schema(description = "Database generated movie id")
	private Long id;

	@Schema(description = "Movie title")
	@NotBlank(message = "Required field")
	@Size(min = 5, max = 80, message = "Title must be between 5 and 80 characters")
	private String title;

	@Schema(description = "Score average of the movie")
	@PositiveOrZero(message = "Score should be greater than or equal to zero")
	private Double score;

	@Schema(description = "Number of scores received for the movie")
	@PositiveOrZero(message = "Count should be greater than or equal to zero")
	private Integer count;

	@Schema(description = "Movie image URL")
	@NotBlank(message = "Required field")
	@URL(message = "Field must be a valid url")
	private String image;

	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, Double score, Integer count, String image) {
		this.id = id;
		this.title = title;
		this.score = Double.valueOf(df.format(score));
		this.count = count;
		this.image = image;
	}

	public MovieDTO(MovieEntity movie) {
		this(movie.getId(), movie.getTitle(), movie.getScore(), movie.getCount(), movie.getImage());
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
}
