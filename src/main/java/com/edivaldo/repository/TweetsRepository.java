package com.edivaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edivaldo.model.TweetsEntity;

@Repository
public interface TweetsRepository extends JpaRepository<TweetsEntity, Long> {

}
