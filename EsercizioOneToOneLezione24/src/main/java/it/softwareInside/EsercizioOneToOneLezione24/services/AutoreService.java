package it.softwareInside.EsercizioOneToOneLezione24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.EsercizioOneToOneLezione24.models.Autore;
import it.softwareInside.EsercizioOneToOneLezione24.repository.AutoreRepo;

@Service
public class AutoreService {

    @Autowired
    AutoreRepo autoreRepo;

    /**
     * Aggiunge un autore al DB
     * 
     * @param autore
     * @return
     */
    public String addAutore(Autore autore) {
        try {
            autoreRepo.save(autore);
            return "Aggiunto";
        } catch (Exception e) {
            return "NON Aggiunto";
        }
    }

    /**
     * Ritorna la lista di tutti gli autori
     * 
     * @return
     */
    public Iterable<Autore> getAllAutore() {
        try {
            return autoreRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Rimuove tutti gli autori dal DB
     * 
     * @param id
     * @return
     */
    public Autore deleteAutoreById(int id) {
        try {
            Autore autoreRimosso = autoreRepo.findById(id).get();
            autoreRepo.deleteById(id);
            return autoreRimosso;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE AUTORE: " + e);
            return null;
        }
    }

    /**
     * Rimuove tutti gli autori dal DB
     * 
     * @return
     */
    public boolean deleteAllAutore() {
        try {
            autoreRepo.deleteAll();
            ;
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE TUTTI GLI AUTORI: " + e);
            return false;
        }
    }

    /**
     * Ritorna un autore tramite id
     * 
     * @param id
     * @return
     */
    public Autore getAutoreById(int id) {
        try {
            return autoreRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

}
