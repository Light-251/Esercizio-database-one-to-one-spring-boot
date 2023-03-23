package it.softwareInside.EsercizioOneToOneLezione24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.EsercizioOneToOneLezione24.models.Autore;
import it.softwareInside.EsercizioOneToOneLezione24.services.AutoreService;

@RestController
public class AutoreRestController {
    @Autowired
    AutoreService autoreService;

    @PostMapping("add-autore")
    public String addAutore(@RequestBody Autore autore) {
        return autoreService.addAutore(autore);
    }

    @GetMapping("/get-tutti-autori")
    public Iterable<Autore> allAutore() {
        return autoreService.getAllAutore();
    }

    @GetMapping("/get-autore-by-id")
    public Autore getAutoreById(@RequestParam("id") int id){
        return autoreService.deleteAutoreById(id);
    }

    @DeleteMapping("/rimuovi-autore-by-id")
    public Autore deleteAutore(@RequestParam("id") int id) {
        return autoreService.deleteAutoreById(id);
    }

    @DeleteMapping("/rimuovi-tutti-autori")
    public boolean deleteAllAutore() {
        return autoreService.deleteAllAutore();
    }
}
