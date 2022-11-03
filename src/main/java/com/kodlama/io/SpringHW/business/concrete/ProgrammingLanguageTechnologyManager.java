package com.kodlama.io.SpringHW.business.concrete;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kodlama.io.SpringHW.business.abstracts.ProgrammingLanguageTechnologyService;
import com.kodlama.io.SpringHW.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService{

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	
	public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository) {
		this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
	}

	@Override
	public List<ProgrammingLanguageTechnology> getAllProgrammingLanguagesTechnology() {
		return programmingLanguageTechnologyRepository.findAll();
	}

	@Override
	public ProgrammingLanguageTechnology getProgrammingLanguageTechnologyById(Long programmingLanguageId)throws Exception {
		ProgrammingLanguageTechnology programmingLanguageTechnology = programmingLanguageTechnologyRepository.findById(programmingLanguageId).get();
		if(programmingLanguageTechnology != null) {
		return programmingLanguageTechnologyRepository.findById(programmingLanguageId).get();
		}
		throw new Exception("There is no programming language technology registered to this id number.");
	}

	@Override
	public ProgrammingLanguageTechnology saveProgrammingLanguageTechnology(ProgrammingLanguageTechnology programmingLanguageTechnology)throws Exception {
		if (isNameBlankAndEmpty(programmingLanguageTechnology)) {
			throw new Exception("Programming Language Technology Cannot be Empty.");
		} else if (isNameExist(programmingLanguageTechnology)) {
			throw new Exception("The Programming Language Technology Cannot Repeat.");
		}
		return programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
	}

	@Override
	public ProgrammingLanguageTechnology updateProgrammingLanguageTechnology(ProgrammingLanguageTechnology programmingLanguage,	Long programmingLanguageId) throws Exception {
		Optional<ProgrammingLanguageTechnology> programmingLanguageTechnology = programmingLanguageTechnologyRepository.findById(programmingLanguageId);
		
		if(programmingLanguageTechnology.isPresent()) {
			ProgrammingLanguageTechnology toUpdate = programmingLanguageTechnology.get();
			toUpdate.setName(programmingLanguage.getName());
			programmingLanguageTechnologyRepository.save(toUpdate);
			return toUpdate;
		}
		throw new Exception("There is no programming language technology registered to this id number.");
	}

	@Override
	public void deleteProgrammingLanguageTechnology(Long programmingLanguageTechnologyId) throws Exception {
		this.programmingLanguageTechnologyRepository.deleteById(programmingLanguageTechnologyId);
		
	}

	@Override
	public boolean isNameExist(ProgrammingLanguageTechnology programmingLanguageTechnology) {
		for(ProgrammingLanguageTechnology languageTechnology : getAllProgrammingLanguagesTechnology()) {
			if(languageTechnology.getName().equalsIgnoreCase(programmingLanguageTechnology.getName())) {
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
