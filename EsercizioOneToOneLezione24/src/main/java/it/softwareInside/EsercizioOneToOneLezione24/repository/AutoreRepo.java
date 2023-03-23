package it.softwareInside.EsercizioOneToOneLezione24.repository;
import org.springframework.data.repository.CrudRepository;

import it.softwareInside.EsercizioOneToOneLezione24.models.Autore;

public interface AutoreRepo extends CrudRepository<Autore, Integer> {

}
