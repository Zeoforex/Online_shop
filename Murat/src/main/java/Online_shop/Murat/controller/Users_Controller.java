package Online_shop.Murat.controller;

import Online_shop.Murat.entity.Users;
import Online_shop.Murat.service.Users_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Users_Controller {

    private final Users_Service usersService;

    @Autowired
    public Users_Controller(Users_Service usersService){
        this.usersService = usersService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> create(@RequestBody Users users){
        usersService.create(users);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<Users>> findALL(){
        final List<Users> usersList = usersService.findAll();
        return usersList != null && !usersList.isEmpty()
                ? new ResponseEntity<>(usersList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Optional<Users>> find(@PathVariable(name = "id")Long id){
        final Optional<Users> users = usersService.find(id);
        return users!=null
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<?> updateUsers(@PathVariable(name = "id")Long id, @RequestBody Users usersUpdate){
        return usersService.find(id).map(users -> {
            // users.setRole(usersUpdate.getRole());
            users.setEmail(usersUpdate.getEmail());
            users.setUserProfile(usersUpdate.getUserProfile());
            users.setHashedPassword(usersUpdate.getHashedPassword());
            users.setIsActive(usersUpdate.getIsActive());
            usersService.update(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}