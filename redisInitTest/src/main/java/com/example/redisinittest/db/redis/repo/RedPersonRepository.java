package com.example.redisinittest.db.redis.repo;

import com.example.redisinittest.db.redis.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface RedPersonRepository extends CrudRepository<Person, String> {




}
