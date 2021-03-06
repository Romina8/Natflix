package ar.com.ada.api.natflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.natflix.entities.Serie;
import ar.com.ada.api.natflix.repos.SerieRepository;

public class SerieService {

    @Autowired
    SerieRepository sRepository;

    public void grabar(Serie serie) {
        sRepository.save(serie);
    }    
    public List<Serie> listarSeries() {
        return sRepository.findAll();
    }
    
}