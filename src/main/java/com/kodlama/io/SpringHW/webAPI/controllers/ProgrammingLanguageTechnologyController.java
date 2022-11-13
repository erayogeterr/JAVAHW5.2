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

import com.kodlama.io.SpringHW.business.abstracts.ProgrammingLanguageTechnologyService;
import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguageTechnology;

@RestController
@RequestMapping("/api/programminglanguagestechnology")
public class ProgrammingLanguageTechnologyController {

	private ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;

	public ProgrammingLanguageTechnologyController(
			ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
		this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
	}

	@GetMapping
	public ResponseEntity<List<ProgrammingLanguageTechnology>> getAllProgrammingLanguagesTechnology() {
		List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyService.getAllProgrammingLanguagesTechnology();
		return new ResponseEntity<List<ProgrammingLanguageTechnology>>(programmingLanguageTechnologies,HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ProgrammingLanguageTechnology> getProgrammingLanguageTechnologyById(@PathVariable("id") Long programmingLanguageTechnologyId) throws Exception {
		ProgrammingLanguageTechnology programmingLanguageTechnology = programmingLanguageTechnologyService.getProgrammingLanguageTechnologyById(programmingLanguageTechnologyId);
		return new ResponseEntity<ProgrammingLanguageTechnology>(programmingLanguageTechnology,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProgrammingLanguageTechnology> saveProgrammingLanguageTechnology(@RequestBody ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		ProgrammingLanguageTechnology programmingLanguageTechnology1 = programmingLanguageTechnologyService.saveProgrammingLanguageTechnology(programmingLanguageTechnology);
		return new ResponseEntity<ProgrammingLanguageTechnology>(programmingLanguageTechnology1,HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ProgrammingLanguageTechnology updateProgrammingLanguageTechnology(
			@PathVariable("id") Long programmingLanguageTechnologyId,
			@RequestBody ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		return programmingLanguageTechnologyService.updateProgrammingLanguageTechnology(programmingLanguageTechnology,
				programmingLanguageTechnologyId);
	}

	@DeleteMapping("{id}")
	public void deleteProgrammingLanguageTechnology(@PathVariable("id") Long programmingLanguageTechnologyId) throws Exception {
		programmingLanguageTechnologyService.deleteProgrammingLanguageTechnology(programmingLanguageTechnologyId);
	}

}
