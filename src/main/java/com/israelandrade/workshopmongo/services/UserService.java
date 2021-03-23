package com.israelandrade.workshopmongo.services;

import com.israelandrade.workshopmongo.domain.User;
import com.israelandrade.workshopmongo.repositories.UserRepository;
import com.israelandrade.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = repository.findById(id);
        if(user == null){
            throw  new ObjectNotFoundException("Objeto não encotrado");
        }
        return user;
    }
}
