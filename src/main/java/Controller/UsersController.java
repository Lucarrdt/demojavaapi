package Controller;

import Data.UsersEntity;
import Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UsersEntity> getUserById(@PathVariable("id") int id) {
        UsersEntity user = usersRepository.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<UsersEntity> addUser(@RequestBody UsersEntity user) {
        usersRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<UsersEntity> updateUser(@RequestBody UsersEntity user) {
        usersRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsersEntity> deleteUser(@PathVariable("id") int id) {
        UsersEntity user = usersRepository.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            usersRepository.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
