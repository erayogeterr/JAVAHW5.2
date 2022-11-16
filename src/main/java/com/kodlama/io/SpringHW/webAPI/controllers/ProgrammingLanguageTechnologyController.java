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
		ProgrammingLanguageTechnology getProgrammingLanguageTechnologyId = programmingLanguageTechnologyService.getProgrammingLanguageTechnologyById(programmingLanguageTechnologyId);
		return new ResponseEntity<ProgrammingLanguageTechnology>(getProgrammingLanguageTechnologyId,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProgrammingLanguageTechnology> saveProgrammingLanguageTechnology(@RequestBody ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		ProgrammingLanguageTechnology saveProgrammingLanguageTechnology = programmingLanguageTechnologyService.saveProgrammingLanguageTechnology(programmingLanguageTechnology);
		return new ResponseEntity<ProgrammingLanguageTechnology>(saveProgrammingLanguageTechnology,HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<ProgrammingLanguageTechnology> updateProgrammingLanguageTechnology(
			@PathVariable("id") Long programmingLanguageTechnologyId,
			@RequestBody ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		ProgrammingLanguageTechnology updateProgrammingLanguageTechnology = programmingLanguageTechnologyService.updateProgrammingLanguageTechnology(programmingLanguageTechnology, programmingLanguageTechnologyId);
		return new ResponseEntity<ProgrammingLanguageTechnology>(updateProgrammingLanguageTechnology,HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProgrammingLanguageTechnology(@PathVariable("id") Long programmingLanguageTechnologyId) throws Exception {
		programmingLanguageTechnologyService.deleteProgrammingLanguageTechnology(programmingLanguageTechnologyId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
