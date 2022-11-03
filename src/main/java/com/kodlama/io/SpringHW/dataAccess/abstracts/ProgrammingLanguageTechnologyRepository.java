package com.kodlama.io.SpringHW.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.SpringHW.entities.concrete.ProgrammingLanguageTechnology;

public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Long> {

}
