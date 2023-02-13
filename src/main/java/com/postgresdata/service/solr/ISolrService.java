package com.postgresdata.service.solr;


import com.postgresdata.model.solr.film.Film;

import java.util.List;

public interface ISolrService {

    List<Film> getFilmsByName(String category);

    Film saveFilm(Film film);

    List<Film> getFilmsByIdOrName(String name);

}
