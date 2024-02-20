package com.example.task313.Service;

import com.example.task313.Model.User;
import com.example.task313.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getById(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return userOptional.get();
        }
        else {
            throw new NoSuchElementException("Пользователь не найден");
        }
    }

    public int create(User user){
        int id = userRepository.saveAndFlush(user).getId();
        return id;
    }

    public void update(User user){
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()){
            User updatedUser = userOptional.get();
            updatedUser.setName(user.getName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setAge(user.getAge());
            userRepository.save(updatedUser);
        }
        else {
            throw new NoSuchElementException ("Пользователь не найден");
        }
    }

    public void deleteById(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            userRepository.deleteById(id);
        }
        else {
            throw new NoSuchElementException ("Пользователь не найден");
        }
    }

}
