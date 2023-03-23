package it.softwareInside.EsercizioOneToOneLezione24.repository;

import org.springframework.data.repository.CrudRepository;
import it.softwareInside.EsercizioOneToOneLezione24.models.Libro;

public interface LibroRepo extends CrudRepository<Libro, Integer> {

}
