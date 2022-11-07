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
	public List<ProgrammingLanguageTechnology> getAllProgrammingLanguagesTechnology() {
		return programmingLanguageTechnologyService.getAllProgrammingLanguagesTechnology();
	}

	@GetMapping("{id}")
	public ProgrammingLanguageTechnology getProgrammingLanguageTechnologyById(
			@PathVariable("id") Long programmingLanguageTechnologyId) throws Exception {
		return programmingLanguageTechnologyService
				.getProgrammingLanguageTechnologyById(programmingLanguageTechnologyId);
	}

	@PostMapping
	public ProgrammingLanguageTechnology saveProgrammingLanguageTechnology(
			@RequestBody ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		return programmingLanguageTechnologyService.saveProgrammingLanguageTechnology(programmingLanguageTechnology);
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
