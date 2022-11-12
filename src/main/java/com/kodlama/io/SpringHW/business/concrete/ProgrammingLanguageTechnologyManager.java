package com.kodlama.io.SpringHW.business.concrete;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kodlama.io.SpringHW.business.abstracts.ProgrammingLanguageTechnologyService;
import com.kodlama.io.SpringHW.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguageTechnology;
import com.kodlama.io.SpringHW.exception.CannotBlankAndEmptyNameException;
import com.kodlama.io.SpringHW.exception.CannotRepeatNameException;
import com.kodlama.io.SpringHW.exception.IdNotFoundException;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;

	public ProgrammingLanguageTechnologyManager(
			ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository) {
		this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
	}

	@Override
	public List<ProgrammingLanguageTechnology> getAllProgrammingLanguagesTechnology() {
		return programmingLanguageTechnologyRepository.findAll();
	}

	@Override
	public ProgrammingLanguageTechnology getProgrammingLanguageTechnologyById(Long programmingLanguageTechnologyId)
			throws Exception {
		Optional<ProgrammingLanguageTechnology> programmingLanguageTechnology = programmingLanguageTechnologyRepository.findById(programmingLanguageTechnologyId);
		if (programmingLanguageTechnology.isPresent()) {
			return programmingLanguageTechnologyRepository.findById(programmingLanguageTechnologyId).get();
		} else {
			throw new IdNotFoundException("There is no programming language registered to this id number.");
		}
	}

	@Override
	public ProgrammingLanguageTechnology saveProgrammingLanguageTechnology(
			ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		if (isNameBlankAndEmpty(programmingLanguageTechnology)) {
			throw new CannotBlankAndEmptyNameException("Programming Language Cannot be Empty.");
		} else if (isNameExist(programmingLanguageTechnology)) {
			throw new CannotRepeatNameException("The Programming Language Cannot Repeat.");
		}
		return programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
	}

	@Override
	public ProgrammingLanguageTechnology updateProgrammingLanguageTechnology(
			ProgrammingLanguageTechnology programmingLanguage, Long programmingLanguageId) throws Exception {
		Optional<ProgrammingLanguageTechnology> programmingLanguageTechnology = programmingLanguageTechnologyRepository
				.findById(programmingLanguageId);

		if (programmingLanguageTechnology.isPresent()) {
			ProgrammingLanguageTechnology toUpdate = programmingLanguageTechnology.get();
			toUpdate.setName(programmingLanguage.getName());
			programmingLanguageTechnologyRepository.save(toUpdate);
			return toUpdate;
		}
		else {
			throw new IdNotFoundException("There is no programming language registered to this id number.");
		}
	}

	@Override
	public void deleteProgrammingLanguageTechnology(Long programmingLanguageTechnologyId) throws Exception {
		Optional<ProgrammingLanguageTechnology> programmingLanguage = programmingLanguageTechnologyRepository.findById(programmingLanguageTechnologyId);
		if (programmingLanguage.isPresent()) {
			programmingLanguageTechnologyRepository.deleteById(programmingLanguageTechnologyId);
		} else { 
			throw new IdNotFoundException("There is no programming language registered to this id number.");
		}
	}

	@Override
	public boolean isNameExist(ProgrammingLanguageTechnology programmingLanguageTechnology) {
		for (ProgrammingLanguageTechnology languageTechnology : getAllProgrammingLanguagesTechnology()) {
			if (languageTechnology.getName().equalsIgnoreCase(programmingLanguageTechnology.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNameBlankAndEmpty(ProgrammingLanguageTechnology programmingLanguageTechnology) {
		if (programmingLanguageTechnology.getName().isEmpty() || programmingLanguageTechnology.getName().isBlank()) {
			return true;
		}
		return false;
	}

}
