package dev.Aditi.BookMyShow.service;


import dev.Aditi.BookMyShow.model.City;
import dev.Aditi.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);


    }
    public  City saveCity(City city)
    {
         return cityRepository.save(city);
    }
    public Boolean deleteCity(int cityId)
    {
        cityRepository.deleteById(cityId);
        return true;
    }

    public City getCityByName(String cityName)
    {
       City city = cityRepository.findCityByName(cityName);
       return  city;

    }

    public City getCityById(int cityId)
    {
        City city = cityRepository.findById(cityId).get();
        return city;
    }


}
