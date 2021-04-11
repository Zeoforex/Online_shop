package Online_shop.Murat.controller;


import Online_shop.Murat.entity.Country;
import Online_shop.Murat.service.Country_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Country_Controller {

    private final Country_Service countryService;

    @Autowired
    public Country_Controller(Country_Service countryService){
        this.countryService = countryService;
    }
    @PostMapping("/api/country")
    public ResponseEntity<?> create(@RequestBody Country country){
        countryService.create(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/country")
    public ResponseEntity<List<Country>> findALL(){
        final List<Country> countryList = countryService.findAll();
        return countryList != null && !countryList.isEmpty()
                ? new ResponseEntity<>(countryList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/country/{id}")
    public ResponseEntity<Optional<Country>> find(@PathVariable(name = "id")Long id){
        final Optional<Country> country = countryService.find(id);
        return country!=null
                ? new ResponseEntity<>(country, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/country/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable(name = "id")Long id, @RequestBody Country countryUpdate){
        return countryService.find(id).map(country -> {
            country.setCountryName(countryUpdate.getCountryName());
            countryService.update(country);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

}