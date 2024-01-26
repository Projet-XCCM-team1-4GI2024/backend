package com.projectXCCM.composix.repository;

import com.projectXCCM.composix.model.Composition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompositionRepository extends MongoRepository<Composition, String> {

    List<Composition> findAllByAuthor(String author);
}
