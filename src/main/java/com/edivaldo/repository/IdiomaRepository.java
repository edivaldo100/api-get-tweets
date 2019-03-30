package com.edivaldo.repository;

import org.springframework.data.repository.CrudRepository;

import com.edivaldo.model.IdiomaEntity;

public interface IdiomaRepository extends CrudRepository<IdiomaEntity, Long> {
	IdiomaEntity findByCodigoIdioma(String CodigoIdioma);
}
