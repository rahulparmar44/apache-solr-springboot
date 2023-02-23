package com.hashedin.broadcast.searchengine.solr.controller;


import com.hashedin.broadcast.searchengine.solr.service.SolrService;
import com.hashedin.broadcast.searchengine.solr.service.serviceimpl.SolrServiceImpl;
import com.hashedin.broadcast.searchengine.solr.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    SolrServiceImpl solrService;

    @PostMapping("/save")
    public Film saveFilm(@RequestBody Film film) {
        return solrService.saveFilm(film);
    }

    @GetMapping("/get-films-by-name")
    public List<Film> getFilmsByName(@RequestParam String name) {
        return solrService.getFilmsByName(name);
    }

    @GetMapping("/get-films-by-id-or-name")
    public List<Film> getFilmsByIdOrName(@RequestParam String name) {
        return solrService.getFilmsByIdOrName(name);
    }

    @GetMapping("/get-all-films")
    public List<Film> getAllFilms() {
        return solrService.getAll();
    }

    @DeleteMapping
    public void deleteFilmByName(@RequestParam String name) {
        solrService.deleteByName(name);
    }

}