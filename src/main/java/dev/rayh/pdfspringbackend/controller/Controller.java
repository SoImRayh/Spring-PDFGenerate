package dev.rayh.pdfspringbackend.controller;

import dev.rayh.pdfspringbackend.model.City;
import dev.rayh.pdfspringbackend.service.CityService;
import dev.rayh.pdfspringbackend.utils.GeneratePdfReport;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final CityService service;
    @GetMapping("/")
    public ResponseEntity<InputStreamResource> getAll(){
        var cities = service.getAll();

        var bis = GeneratePdfReport.citiesReport(cities);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
