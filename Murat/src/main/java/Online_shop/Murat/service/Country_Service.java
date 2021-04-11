package Online_shop.Murat.service;


import Online_shop.Murat.entity.Country;
import Online_shop.Murat.repo.Country_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Country_Service {
    @Autowired
    private Country_Repo countryRepo;

    public void create(Country country){countryRepo.save(country);}

    public void update(Country country){countryRepo.save(country);}

    public void delete(Country country){countryRepo.delete(country);}

    public Optional<Country> find(Long id){return countryRepo.findById(id);}

    public List<Country> findAll(){return countryRepo.findAll();}
}