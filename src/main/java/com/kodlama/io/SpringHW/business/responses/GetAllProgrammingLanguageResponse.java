package com.kodlama.io.SpringHW.business.responses;

import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetAllProgrammingLanguageResponse {

	private Long id;
	private String name;
	
	public GetAllProgrammingLanguageResponse(ProgrammingLanguage programmingLanguage) {
		this.id = programmingLanguage.getId();
		this.name = programmingLanguage.getName();
	}
	

}
