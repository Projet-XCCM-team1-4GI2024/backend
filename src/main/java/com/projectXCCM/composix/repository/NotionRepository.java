package com.projectXCCM.composix.repository;

import com.projectXCCM.composix.model.Notion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface NotionRepository extends MongoRepository<Notion, String> {

    List<Notion> findAllByParagraph(String paragraph);

    List<Notion> findAllByPart(String part);

    List<Notion> findAllByChapter(String chapter);
}
