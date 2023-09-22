package com.ecommerceAPI.apiproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.ecommerceAPI.apiproject.entity.User;
import com.ecommerceAPI.apiproject.exception.UserAlreadyExistsException;
import com.ecommerceAPI.apiproject.exception.UserNotFoundException;
import com.ecommerceAPI.apiproject.repository.UserRepository;
import com.ecommerceAPI.apiproject.security.model.LoginBody;
import com.ecommerceAPI.apiproject.security.model.RegistrationBody;
import com.ecommerceAPI.apiproject.security.service.EncryptionService;
import com.ecommerceAPI.apiproject.security.service.JWTService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private EncryptionService encryptionService;
  private JWTService jwtService;

  // Create
  @Override
  public User createUser(User user) {
    // return customer;
    return userRepository.save(user);
  }

  // Get One
  @Override
  public User getUser(Long id) {

    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  // Get All
  @Override
  public List<User> getAllUsers() {
    List<User> allusers = userRepository.findAll();
    return allusers;
  }

  // Update
  @Override
  public User updateUser(Long id, User user) {

    // Retrieve customer from DB
    User userToUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

    // Update the fields
    userToUpdate.setFirstName(user.getFirstName());
    userToUpdate.setLastName(user.getLastName());
    userToUpdate.setEmail(user.getEmail());

    return userRepository.save(userToUpdate);
  }

  // Delete
  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
    if (userRepository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
        || userRepository.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
      throw new UserAlreadyExistsException();
    }
    User user = new User();
    user.setEmail(registrationBody.getEmail());
    user.setUsername(registrationBody.getUsername());
    user.setFirstName(registrationBody.getFirstName());
    user.setLastName(registrationBody.getLastName());
    user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
    return userRepository.save(user);
  }

  @Override
  public String loginUser(LoginBody loginBody) {
    Optional<User> opUser = userRepository.findByUsernameIgnoreCase(loginBody.getUsername());
    if (opUser.isPresent()) {
      User user = opUser.get();
      if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
        return jwtService.generateJWT(user);
      }
    }
    return null;
  }

  @Override
  public List<User> searchUsers(String firstName) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'searchUsers'");
  }

}