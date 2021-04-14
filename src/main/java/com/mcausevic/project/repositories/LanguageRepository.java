package com.mcausevic.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcausevic.project.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository <Language, Long>{
	List<Language> findAll();
    Language countByNameContaining(String search);
    Language deleteByNameStartingWith(String search);
}
