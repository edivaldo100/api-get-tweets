package com.edivaldo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edivaldo.model.TweetsEntity;
import com.edivaldo.repository.TweetsRepository;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

	@Autowired
	private TweetsRepository tweetsRepository;
	
	@GetMapping
	public List<TweetsEntity> listar() {
		return tweetsRepository.findAll();
	}
	
}