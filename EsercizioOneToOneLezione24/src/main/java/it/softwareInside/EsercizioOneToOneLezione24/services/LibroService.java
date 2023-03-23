package it.softwareInside.EsercizioOneToOneLezione24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.EsercizioOneToOneLezione24.models.Libro;
import it.softwareInside.EsercizioOneToOneLezione24.repository.LibroRepo;

@Service
public class LibroService {

    @Autowired
    LibroRepo libroRepo;

    /**
     * Ritorna la lista di tutti i libri
     * 
     * @return
     */
    public Iterable<Libro> getAllLibro() {
        try {
            Iterable<Libro> tuttiLibri = libroRepo.findAll();
            return tuttiLibri;

        } catch (Exception e) {
            System.err.println("ERRORE: " + e);
            return null;
        }
    }

    /**
     * Aggiunge un libro al DB
     * 
     * @param libro
     * @return
     */
    public String addLibro(Libro libro) {
        try {
            libroRepo.save(libro);
            System.out.println(libro);
            return "Libro aggiunto";
        } catch (Exception e) {
            System.out.println(libro + " : " + e);
            return "Libro non aggiunto";
        }
    }

    /**
     * Ritorna un libro dal DB fornendo un ID
     * 
     * @param id
     * @return
     */
    public Libro getLibroById(int id) {
        try {
            return libroRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Rimuove un libro fornendo l'id
     * 
     * @param id
     * @return
     */
    public Libro deleteLibroById(int id) {
        try {
            Libro libroRimosso = libroRepo.findById(id).get();
            libroRepo.deleteById(id);
            return libroRimosso;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE LIBRO BY ID: " + e);
            return null;
        }
    }

    /**
     * Rimuove tutti i libri nel DB
     * 
     * @return
     */
    public boolean deleteAllLibro() {
        try {
            libroRepo.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
