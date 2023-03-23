package it.softwareInside.EsercizioOneToOneLezione24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.softwareInside.EsercizioOneToOneLezione24.models.Libro;
import it.softwareInside.EsercizioOneToOneLezione24.services.LibroService;

@RequestMapping("/api")
@RestController
public class LibroRestController {

    @Autowired
    LibroService libroService;

    @PostMapping("/add-libro")
    public String addLibro(@RequestBody Libro libro) {
        return libroService.addLibro(libro);
    }

    @GetMapping("/tutti-libri")
    public Iterable<Libro> getLibri() {
        return libroService.getAllLibro();
    }

    @GetMapping("/get-libro-by-id")
    public Libro getLibroById(@RequestParam("id") int id) {
        return libroService.getLibroById(id);
    }

    @DeleteMapping("/delete-libro-by-id")
    public Libro deleteLibroById(@RequestParam(value = "id") int id) {
        return libroService.deleteLibroById(id);
    }

    @DeleteMapping("/delete-all-libri")
    public boolean deleteAllLibro() {
        return libroService.deleteAllLibro();
    }

}
