package fr.orsys.kingsley.series.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus.Series;

@RepositoryRestResource(exported = true)
public interface SeriesDao extends JpaRepository<Series, Long> {

}
