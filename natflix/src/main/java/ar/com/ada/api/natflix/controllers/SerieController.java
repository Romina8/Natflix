package ar.com.ada.api.natflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.natflix.entities.Serie;
import ar.com.ada.api.natflix.models.GenericResponse;
import ar.com.ada.api.natflix.services.SerieService;

public class SerieController {
    
    @Autowired
    SerieService serieService;

    @PostMapping("/api/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody Serie serieInfo){

        serieService.grabar(serieInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message =  "Serie creada con exito!";
        response.id= serieInfo.get_id().toHexString();

        return  ResponseEntity.ok(response);
    }

    @GetMapping("/api/series")
    public ResponseEntity<List<Serie>> listarSeries(){

        return ResponseEntity.ok(serieService.listarSeries());
    }
}