//STRETCH

package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.User;
import com.lambdaschool.zoos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;
    @GetMapping(value = "/viewall",
                produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}",
                produces = {"application/json"})
    public ResponseEntity<?> getUsersById(@PathVariable long id)
    {
        User u = userService.findUserById(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUserById(
            @PathVariable
                    long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
