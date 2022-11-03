package com.kodlama.io.SpringHW.business.abstracts;

import java.util.List;

import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	List<ProgrammingLanguage> getAllProgrammingLanguages();
	ProgrammingLanguage getProgrammingLanguageById(Long programmingLanguageId) throws Exception;
	ProgrammingLanguage saveProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception;
	ProgrammingLanguage updateProgrammingLanguage(ProgrammingLanguage programmingLanguage, Long programmingLanguageId) throws Exception;
	void deleteProgrammingLanguage(Long programmingLanguageId) throws Exception;
	
	boolean isNameExist(ProgrammingLanguage programmingLanguage);
	boolean isNameBlankAndEmpty(ProgrammingLanguage programmingLanguage);
	

}
