package com.kodlama.io.SpringHW.business.concrete;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kodlama.io.SpringHW.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.SpringHW.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguage;
import com.kodlama.io.SpringHW.exception.CannotBlankAndEmptyNameException;
import com.kodlama.io.SpringHW.exception.CannotRepeatNameException;
import com.kodlama.io.SpringHW.exception.IdNotFoundException;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAllProgrammingLanguages() {
		return programmingLanguageRepository.findAll();
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(Long programmingLanguageId) throws Exception {
		Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(programmingLanguageId);
		if (programmingLanguage.isPresent()) {
			return programmingLanguageRepository.findById(programmingLanguageId).get();
		} else {
			throw new IdNotFoundException();
		}
	}

	@Override
	public ProgrammingLanguage saveProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception {
		if (isNameExist(programmingLanguage)) {
			throw new CannotRepeatNameException();
		} else if (isNameBlankAndEmpty(programmingLanguage)) {
			throw new CannotBlankAndEmptyNameException();
		}
		return programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage updateProgrammingLanguage(ProgrammingLanguage programmingLanguage,
			Long programmingLanguageId) throws Exception {
		Optional<ProgrammingLanguage> existingProgrammingLanguage = programmingLanguageRepository
				.findById(programmingLanguageId);

		if (existingProgrammingLanguage.isPresent()) {
			ProgrammingLanguage toUpdate = existingProgrammingLanguage.get();
			toUpdate.setName(programmingLanguage.getName());
			programmingLanguageRepository.save(toUpdate);
			return toUpdate;
		} else {
			throw new IdNotFoundException();
		}
	}

	@Override
	public void deleteProgrammingLanguage(Long programmingLanguageId) throws Exception {
		Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(programmingLanguageId);
		if (programmingLanguage.isPresent()) {
			programmingLanguageRepository.deleteById(programmingLanguageId);
		} else { 
			throw new IdNotFoundException();
		}
	}

	@Override
	public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : getAllProgrammingLanguages()) {
			if (language.getName().equalsIgnoreCase(programmingLanguage.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNameBlankAndEmpty(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName().isBlank() || programmingLanguage.getName().isEmpty()) {
			return true;
		}
		return false;
	}
}
