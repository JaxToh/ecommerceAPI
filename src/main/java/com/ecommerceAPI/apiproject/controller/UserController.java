package com.ecommerceAPI.apiproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import com.ecommerceAPI.apiproject.entity.User;
import com.ecommerceAPI.apiproject.service.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  // CREATE
  // @PostMapping("")
  // public ResponseEntity<User> createCustomer(@Valid @RequestBody User user) {
  //   return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
  // }

  // READ (GET ALL)
  @GetMapping("")
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }

  // READ (GET ONE)
  @GetMapping("{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
  }

  // UPDATE
  @PutMapping("{id}")
  public ResponseEntity<User> updateCustomer(@PathVariable Long id, @RequestBody User user) {
    return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);

  }

  // DELETE
  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
