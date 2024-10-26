package com.rcoem.deveops.Interface;
import com.rcoem.deveops.User;
import com.rcoem.deveops.services.UserServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserServices userservice;

    HashMap<String , User> k;
    @PostMapping()
    ResponseEntity<String> createUser(@RequestBody User user){

        if(userservice.existsByNameAndDept(user.getName() , user.getDepartment())){
            return ResponseEntity.status(400).body("user with same name and department already exist");
        }
        String userId = userservice.createUser(user);
        return ResponseEntity.status(201).body(userId);
    }
    @GetMapping
    ResponseEntity<List<User>> getAllUser(){
        List<User> users = userservice.getAllUser();
        if(users.isEmpty()){
            return ResponseEntity.status(404).build();
        }
       return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    ResponseEntity <String>  getUserbyid(@PathVariable String id){
       User user = userservice.getUser(id);
       if(user == null){
           return ResponseEntity.status(404).build();
       }
       return ResponseEntity.ok("User updated succesfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        boolean userDeleted = userservice.deleteUser(id);
        if (!userDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found."); // 404 if user doesn't exist
        }
        return ResponseEntity.ok("User deleted successfully.");
    }
}
