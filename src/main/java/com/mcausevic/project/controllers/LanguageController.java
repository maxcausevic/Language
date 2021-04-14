package com.mcausevic.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcausevic.project.models.Language;
import com.mcausevic.project.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/")
	public String redirect() {
		return "redirect:languages";
	}
	@RequestMapping("/languages")
	public String index(Model model) {
	List<Language> Language =languageService.allLanguages();
	model.addAttribute("languages", Language);
	model.addAttribute("language", new Language());
	return "languages/index.jsp";
}


	@RequestMapping(value="/languages", method=RequestMethod.POST)
	  public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	      if (result.hasErrors()) {
	          return "/languages/index.jsp";
	      } else {
	          languageService.createLanguage(language);
	          return "redirect:/languages";
	      }
	}
	@RequestMapping("/languages/{id}/edit")
	  public String edit(@PathVariable("id") Long id, Model model) {
	     Language language = languageService.findLanguage(id);
	     model.addAttribute("language", language);
	         return "/languages/edit.jsp";
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.update(language);
            return "redirect:/languages";
        }
	}
    @GetMapping("/languages/{id}")
    	public String destroy(@PathVariable("id") Long id) {
            languageService.deleteLanguage(id);
            return "redirect:/languages";
        }
    }

