package dev.Aditi.BookMyShow.controller;

import dev.Aditi.BookMyShow.dto.CityRequestDTO;
import dev.Aditi.BookMyShow.model.City;
import dev.Aditi.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCity(@PathVariable("name") String cityName)
    {
           City city = cityService.getCityByName(cityName);
           return ResponseEntity.ok(city);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO) {
        try {
            String cityName = cityRequestDTO.getName();
            if (cityName == null || cityName.length() == 0 || cityName.isEmpty() || cityName.isBlank())
                throw new Exception("city name is invalid");

            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @DeleteMapping("/city/{id}")
    public  ResponseEntity deleteCity(@PathVariable("id") int cityId)
    {
       boolean isDeleted =  cityService.deleteCity(cityId);
       return  ResponseEntity.ok(isDeleted);

    }

    @GetMapping("/city/{id}")
    public ResponseEntity getCityById(@PathVariable("id") int cityId)
    {
        City city = cityService.getCityById(cityId);
        return  ResponseEntity.ok(city);
    }
}
