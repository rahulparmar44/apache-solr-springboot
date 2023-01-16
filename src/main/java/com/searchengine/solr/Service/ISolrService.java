package com.searchengine.solr.Service;


import com.searchengine.solr.Model.Film;

import java.util.List;

public interface ISolrService {

    List<Film> getFilmsByName(String category);

    Film saveFilm(Film film);

    List<Film> getFilmsByIdOrName(String name);
}
