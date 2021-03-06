package com.israelandrade.workshopmongo.services;

import com.israelandrade.workshopmongo.domain.User;
import com.israelandrade.workshopmongo.dto.UserDTO;
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

    public User insert(User obj){
        return repository.save(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        Optional<User> newObj = repository.findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateData(Optional<User> newObj, User obj) {
        newObj.get().setName(obj.getName());
        newObj.get().setEmail(obj.getEmail());
    }
}
