package com.postgresdata.service.solr.ServiceImpl;

import com.postgresdata.model.solr.film.Film;
import com.postgresdata.repository.solr.repository.SolrFilmRepository;
import com.postgresdata.service.solr.ISolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("SolrService")
public class SolrFilmService implements ISolrService {

    @Autowired
    SolrFilmRepository filmRepository;

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> getFilmsByIdOrName(String name) {
        //return (List<Film>) filmRepository.findByCustomQuery(name, Pageable.ofSize(10));
        return new ArrayList<>();
    }

    public List<Film> getFilmsByName(String name) {
        return filmRepository.findByName(name);
    }

    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        Iterator<Film> filmIterator = filmRepository.findAll().iterator();
        while (filmIterator.hasNext())
            films.add(filmIterator.next());
        return films;
    }

    public void deleteByName(String name) {
        List<Film> films = filmRepository.findByName(name);
        for (Film film : films) {
            filmRepository.deleteById(film.getId());
        }

    }
}
