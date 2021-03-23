package com.israelandrade.workshopmongo.resources;

import com.israelandrade.workshopmongo.domain.Post;
import com.israelandrade.workshopmongo.domain.User;
import com.israelandrade.workshopmongo.dto.UserDTO;
import com.israelandrade.workshopmongo.resources.util.URL;
import com.israelandrade.workshopmongo.services.PostService;
import com.israelandrade.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Optional<Post> obj = service.findById(id);
        return ResponseEntity.ok().body(obj.get());
    }

    @RequestMapping(value = "/titlesearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
