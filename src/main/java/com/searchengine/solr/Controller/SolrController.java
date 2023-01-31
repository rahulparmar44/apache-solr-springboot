package com.searchengine.solr.Controller;


import com.searchengine.solr.Model.Film;
import com.searchengine.solr.Service.ServiceImpl.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class SolrController {
    @Autowired
    SolrService solrService;

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