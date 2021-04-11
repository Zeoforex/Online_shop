package Online_shop.Murat.service;

import Online_shop.Murat.entity.User_Profile;
import Online_shop.Murat.repo.User_Profile_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class User_Profile_Service {
    @Autowired
    private User_Profile_Repo userProfileRepo;

    public void create(User_Profile userProfile){userProfileRepo.save(userProfile);}

    public void update(User_Profile userProfile){userProfileRepo.save(userProfile);}

    public void delete(User_Profile userProfile){userProfileRepo.delete(userProfile);}

    public Optional<User_Profile> find(Long id){return userProfileRepo.findById(id);}

    public List<User_Profile> findAll(){return userProfileRepo.findAll();}
}