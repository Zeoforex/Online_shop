package Online_shop.Murat.service;

import Online_shop.Murat.entity.Manufacturer;
import Online_shop.Murat.repo.Manufacturer_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Manufacturer_Service {

    @Autowired
    private Manufacturer_Repo manufacturerRepo;

    public void create(Manufacturer manufacturer){manufacturerRepo.save(manufacturer);}

    public void update(Manufacturer manufacturer){manufacturerRepo.save(manufacturer);}

    public void delete(Manufacturer manufacturer){manufacturerRepo.delete(manufacturer);}

    public Optional<Manufacturer> find(Long id){return manufacturerRepo.findById(id);}

    public List<Manufacturer> findAll(){return manufacturerRepo.findAll();}

}