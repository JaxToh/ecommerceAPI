package com.ecommerceAPI.apiproject.service;

import java.util.List;
import com.ecommerceAPI.apiproject.entity.User;
import com.ecommerceAPI.apiproject.exception.UserAlreadyExistsException;
import com.ecommerceAPI.apiproject.security.model.LoginBody;
import com.ecommerceAPI.apiproject.security.model.RegistrationBody;

public interface UserService {
  //User createUser(User user);

  User getUser(Long id);

  List<User> getAllUsers();

  User updateUser(Long id, User user);

  void deleteUser(Long id);

  List<User> searchUsers(String firstName);

  User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException;

//User registerUser(User User) throws UserAlreadyExistsException;


  String loginUser(LoginBody loginBody);

}
