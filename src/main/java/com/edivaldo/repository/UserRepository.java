package com.edivaldo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.edivaldo.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	Optional<UserEntity> findById(Long id);
	UserEntity findByName(String name);
	UserEntity findByIdTwitter(Long idTwitter);
}
