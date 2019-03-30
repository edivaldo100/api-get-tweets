package com.edivaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edivaldo.model.TweetsEntity;

public interface TweetsRepository extends JpaRepository<TweetsEntity, Long> {
	TweetsEntity findById(long id);
}
