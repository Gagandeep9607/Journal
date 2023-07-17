package com.gagan.journal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gagan.journal.models.Information;

@Repository
public interface InformationRepo extends CrudRepository<Information, Long> {

	List<Information> findAll();
}
