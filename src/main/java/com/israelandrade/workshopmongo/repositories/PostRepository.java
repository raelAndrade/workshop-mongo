package com.israelandrade.workshopmongo.repositories;

import com.israelandrade.workshopmongo.domain.Post;
import com.israelandrade.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
