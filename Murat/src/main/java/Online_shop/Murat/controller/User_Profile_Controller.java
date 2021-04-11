package Online_shop.Murat.controller;

import Online_shop.Murat.entity.User_Profile;
import Online_shop.Murat.service.User_Profile_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class User_Profile_Controller {

    private final User_Profile_Service userProfileService;

    @Autowired
    public User_Profile_Controller(User_Profile_Service userProfileService){
        this.userProfileService = userProfileService;
    }
    @PostMapping("/api/userProfile")
    public ResponseEntity<?> create(@RequestBody User_Profile userProfile){
        userProfileService.create(userProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/userProfile")
    public ResponseEntity<List<User_Profile>> findALL(){
        final List<User_Profile> userProfileList = userProfileService.findAll();
        return userProfileList != null && !userProfileList.isEmpty()
                ? new ResponseEntity<>(userProfileList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/userProfile/{id}")
    public ResponseEntity<Optional<User_Profile>> find(@PathVariable(name = "id")Long id){
        final Optional<User_Profile> userProfile = userProfileService.find(id);
        return userProfile!=null
                ? new ResponseEntity<>(userProfile, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/userProfile/{id}")
    public ResponseEntity<?> updateUserProfile(@PathVariable(name = "id")Long id, @RequestBody User_Profile userProfileUpdate){
        return userProfileService.find(id).map(userProfile -> {
            userProfile.setFirstName(userProfileUpdate.getFirstName());
            userProfile.setLastName(userProfileUpdate.getLastName());
            userProfile.setMiddleName(userProfileUpdate.getMiddleName());
            userProfile.setBirthday(userProfileUpdate.getBirthday());
            userProfile.setCity(userProfileUpdate.getCity());
            userProfile.setStreet(userProfileUpdate.getStreet());
            userProfileService.update(userProfile);
            return new ResponseEntity<>(userProfile, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}