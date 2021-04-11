package Online_shop.Murat.service;

import Online_shop.Murat.entity.Role;
import Online_shop.Murat.repo.Role_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Role_Service {

    @Autowired
    private Role_Repo roleRepo;

    public void create(Role role){roleRepo.save(role);}

    public void update(Role role){roleRepo.save(role);}

    public void delete(Role role){roleRepo.delete(role);}

    public Optional<Role> find(Long id){return roleRepo.findById(id);}

    public List<Role> findAll(){return roleRepo.findAll();}

}