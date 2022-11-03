package com.kodlama.io.SpringHW.entities.concrete;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@Entity
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" , nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	//@OneToMany(mappedBy = "programmingLanguage")
	//List<ProgrammingLanguageTechnology> programmingLanguageTechnologies;
	
	@OneToMany(mappedBy = "programingLanguage")
    Set<ProgrammingLanguageTechnology> technologies;
}
