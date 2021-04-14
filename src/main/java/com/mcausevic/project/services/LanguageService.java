package com.mcausevic.project.services;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mcausevic.project.models.Language;
import com.mcausevic.project.repositories.LanguageRepository;

@Service
public class LanguageService {
private final LanguageRepository languageRepository;

    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
        }
        public Language updatelanguage(Long id, String name, String creator, String currentVersion) {
    		Language language1 = findLanguage(id);
    		language1.setName(name);
    		language1.setCreator(creator);
    		language1.setCurrentVersion(currentVersion);
    		languageRepository.save(language1);
    		return language1;
    }
        public void deleteLanguage(Long id) {
    		Language language1 = findLanguage(id);
    		languageRepository.delete(language1);
    		
    	}
        public Language update(Language language) {
            return languageRepository.save(language);
        }

}
