package com.ssp.movie.api.service;

import com.ssp.movie.api.entity.Movie;
import com.ssp.movie.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> fetchMovies(double minimumRating, int minimumVotes) {
        return movieRepository.findMovies(minimumRating, minimumVotes);
    }

    @Override
    public List<Movie> fetchMoviesListByReleaseYear(int year, double minimumRating, int minimumVotes) {
        return movieRepository.findByReleaseYear(year, minimumRating, minimumVotes);
    }

    @Override
    public List<Movie> fetchByReleaseYearBetween(int startYear, int endYear, double minimumRating, int minimumVotes) {
        return movieRepository.findByReleaseYearBetween(startYear, endYear, minimumRating, minimumVotes);
    }

    @Override
    public List<Movie> fetchByGenre(String genre, double minimumRating, int minimumVotes) {
        return movieRepository.findByGenre(genre, minimumRating, minimumVotes);
    }

    @Override
    public List<Movie> fetchByMovieId(List<String> movieIds) {
        return movieRepository.findByMovieId(movieIds);
    }

    @Override
    public List<Movie> fetchMovieByName(String movieName, double minimumRating, int minimumVotes) {
        return movieRepository.findByMovieNameContaining(movieName, minimumRating, minimumVotes);
    }

}
