package com.lovushkina.controller;

import com.lovushkina.domain.User;
import com.lovushkina.dto.UserDto;
import com.lovushkina.dto.assembler.UserDtoAssembler;
import com.lovushkina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoAssembler userDtoAssembler;

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<UserDto>> getAllUsers() {
        List<User> apps = userService.findAll();
        CollectionModel<UserDto> appDtos = userDtoAssembler.toCollectionModel(apps);
        return new ResponseEntity<>(appDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        User user = userService.findById(id);
        UserDto userDto = userDtoAssembler.toModel(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        User newUser = userService.create(user);
        UserDto userDto = userDtoAssembler.toModel(newUser);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id){
        userService.update(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/cursor")
    public ResponseEntity<?> createTablesWithСursor(){
        userService.createTablesWithСursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
