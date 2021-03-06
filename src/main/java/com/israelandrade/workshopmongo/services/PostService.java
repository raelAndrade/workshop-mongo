package com.israelandrade.workshopmongo.services;

import com.israelandrade.workshopmongo.domain.Post;
import com.israelandrade.workshopmongo.domain.User;
import com.israelandrade.workshopmongo.dto.UserDTO;
import com.israelandrade.workshopmongo.repositories.PostRepository;
import com.israelandrade.workshopmongo.repositories.UserRepository;
import com.israelandrade.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Optional<Post> findById(String id) {
        Optional<Post> post = repository.findById(id);
        if(post == null){
            throw  new ObjectNotFoundException("Objeto não encotrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        // Utilizando consulta com query methods
        // return repository.findByTitleContainingIgnoreCase(text);

        // Utilizando consulta com @Query
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
