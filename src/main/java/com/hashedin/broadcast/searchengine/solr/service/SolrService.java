package com.hashedin.broadcast.searchengine.solr.service;


import com.hashedin.broadcast.searchengine.solr.model.Film;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SolrService {

    List<Film> getFilmsByName(String category);

    Film saveFilm(Film film);

    List<Film> getFilmsByIdOrName(String name);

}
