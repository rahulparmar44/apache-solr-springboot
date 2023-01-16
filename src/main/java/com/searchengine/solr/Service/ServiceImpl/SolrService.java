package com.searchengine.solr.Service.ServiceImpl;

import com.searchengine.solr.Model.Film;
import com.searchengine.solr.Repository.FilmRepository;
import com.searchengine.solr.Service.ISolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SolrService")
public class SolrService implements ISolrService {

    @Autowired
    FilmRepository filmRepository;

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> getFilmsByIdOrName(String name) {
        return (List<Film>) filmRepository.findByCustomQuery(name, Pageable.ofSize(10));
    }

    public List<Film> getFilmsByName(String name) {
        return filmRepository.findByName(name);
    }

    public List<Film> getAll() {
        return (List<Film>) filmRepository.findAll();
    }

    public void deleteByName(String name) {
        List<Film> films = filmRepository.findByName(name);
        for (Film film : films) {
            filmRepository.deleteById(film.getId());
        }

    }
}
