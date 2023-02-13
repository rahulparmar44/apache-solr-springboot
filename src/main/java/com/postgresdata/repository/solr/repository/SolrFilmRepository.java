package com.postgresdata.repository.solr.repository;


import com.postgresdata.model.solr.film.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FilmRepository")
public interface SolrFilmRepository extends SolrCrudRepository<Film, String> {
    List<Film> findByName(String name);

    Film save(Film film);

    @Query("id:*?0* OR name:*?0* OR directed_by:*?0*")
    public List<Film> findByCustomQuery(String searchTerm, Pageable pageable);

    void deleteById(String id);

    Iterable<Film> findAll();
}


