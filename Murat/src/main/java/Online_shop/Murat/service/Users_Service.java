package Online_shop.Murat.service;

import Online_shop.Murat.entity.Users;
import Online_shop.Murat.repo.Users_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Users_Service {
    @Autowired
    private Users_Repo users_Repo;

    public void create(Users users){users_Repo.save(users);}

    public void update(Users users){users_Repo.save(users);}

    public void delete(Users users){users_Repo.delete(users);}

    public Optional<Users> find(Long id){return users_Repo.findById(id);}

    public List<Users> findAll(){return users_Repo.findAll();}
}