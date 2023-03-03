package dev.rayh.pdfspringbackend.service;

import dev.rayh.pdfspringbackend.model.City;
import dev.rayh.pdfspringbackend.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    @Override
    public List<City> getAll() {
       return cityRepository.findAll();
    }
}
