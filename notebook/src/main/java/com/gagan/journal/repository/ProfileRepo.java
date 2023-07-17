package com.gagan.journal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gagan.journal.models.Profile;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Long> {

	List<Profile> findAll();
}
