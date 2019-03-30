package com.edivaldo;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edivaldo.model.IdiomaEntity;
import com.edivaldo.model.TweetsEntity;
import com.edivaldo.model.UserEntity;
import com.edivaldo.service.TweetsServicesImp;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Autowired
	private TweetsServicesImp tweetsServicesImp;
	
	
	//@Test
	public void getUsers() {
		System.out.println(" ");System.out.println(" ");System.out.println(" ");
		IdiomaEntity findByCodigoIdioma = tweetsServicesImp.findByCodigoIdioma("en");
	
		Long id = findByCodigoIdioma.getId();
		String codigoIdioma = findByCodigoIdioma.getCodigoIdioma();
		String idioma = findByCodigoIdioma.getIdioma();
		
		System.out.println(id+" "+codigoIdioma+" "+idioma);
		System.out.println(" ");System.out.println(" ");System.out.println(" ");
	}
	
	@Test
	public void geTIdiomaUser() {
		System.out.println(" --------------------------->");System.out.println(" ");System.out.println(" ");
		Optional<UserEntity> userById = tweetsServicesImp.getUserById(2456L);
		UserEntity userEntity = userById.get();
		Long id = userEntity.getId();
		byte[] idioma2 = userEntity.getIdioma();
		String idioma = new String(idioma2);
		System.out.println(id+" "+userEntity.getName()+" "+idioma);
		System.out.println(" ");System.out.println(" ");System.out.println(" ");
	}

}
