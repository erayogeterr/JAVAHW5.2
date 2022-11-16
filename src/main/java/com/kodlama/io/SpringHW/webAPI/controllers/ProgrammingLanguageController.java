package com.kodlama.io.SpringHW.webAPI.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ProgrammingLanguage>> getAllProgrammingLanguages() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageService.getAllProgrammingLanguages();
		return new ResponseEntity<List<ProgrammingLanguage>>(programmingLanguages,HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ProgrammingLanguage> getProgrammingLanguageById(@PathVariable("id") Long programmingLanguageId)
			throws Exception {
		ProgrammingLanguage getProgrammingLanguageId = programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
		return new ResponseEntity<ProgrammingLanguage>(getProgrammingLanguageId,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProgrammingLanguage> saveProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage)
			throws Exception {
		ProgrammingLanguage saveProgrammingLanguage = programmingLanguageService.saveProgrammingLanguage(programmingLanguage);
		return new ResponseEntity<ProgrammingLanguage>(saveProgrammingLanguage,HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<ProgrammingLanguage> updateProgrammingLanguage(@PathVariable("id") Long programmingLanguageId,
			@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		ProgrammingLanguage updateProgrammingLanguage = programmingLanguageService.updateProgrammingLanguage(programmingLanguage, programmingLanguageId);
		return new ResponseEntity<ProgrammingLanguage>(updateProgrammingLanguage,HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProgrammingLanguage(@PathVariable("id") Long programmingLanguageId) throws Exception {
		programmingLanguageService.deleteProgrammingLanguage(programmingLanguageId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
