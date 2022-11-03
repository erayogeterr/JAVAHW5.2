package com.kodlama.io.SpringHW.webAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.SpringHW.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguageController {

	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping
	public List<ProgrammingLanguage> getAllProgrammingLanguages() {
		return programmingLanguageService.getAllProgrammingLanguages();
	}

	@GetMapping("{id}")
	public ProgrammingLanguage getProgrammingLanguageById(@PathVariable("id") Long programmingLanguageId)
			throws Exception {
		return programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
	}

	@PostMapping
	public ProgrammingLanguage saveProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage)
			throws Exception {
		return programmingLanguageService.saveProgrammingLanguage(programmingLanguage);
	}

	@PutMapping("{id}")
	public ProgrammingLanguage updateProgrammingLanguage(@PathVariable("id") Long programmingLanguageId,
			@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		return programmingLanguageService.updateProgrammingLanguage(programmingLanguage, programmingLanguageId);
	}

	@DeleteMapping("{id}")
	public void deleteProgrammingLanguage(@PathVariable("id") Long programmingLanguageId) throws Exception {
		programmingLanguageService.deleteProgrammingLanguage(programmingLanguageId);
	}

}
