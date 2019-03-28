package com.edivaldo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edivaldo.model.TweetsEntity;
import org.springframework.data.repository.CrudRepository;
public interface TweetsRepository extends CrudRepository<TweetsEntity, Long> {
	Optional<TweetsEntity> findById(Long id);
}
