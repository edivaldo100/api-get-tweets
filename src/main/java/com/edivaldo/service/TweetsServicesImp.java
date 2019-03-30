package com.edivaldo.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Repository;

import com.edivaldo.model.HashTagEntity;
import com.edivaldo.model.TweetsEntity;
import com.edivaldo.model.UserEntity;
import com.edivaldo.repository.HashTagRepository;
import com.edivaldo.repository.TweetsRepository;
import com.edivaldo.repository.UserRepository;

@Transactional
@Repository
public class TweetsServicesImp {

	@Autowired
	private TweetsRepository tweetsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HashTagRepository hashTagRepository;

	public void getTweets() {
		System.out.println("-----------------------------------GET # ");
		// List<TweetsEntity> findAll = tweetsRepository.findAll();
		// System.out.println(findAll);
		try {
			String consumerKey = "n76YhiIrNyRnyKti5YOL3niaD"; // The application's consumer key
			String consumerSecret = "EeI8n3fi3daIPW6voLakGIzKbDail6D4uhgNNhtg2yepUQv4As"; // The application's consumer
																							// secret
			String accessToken = "852754277386690561-VY3SaYT51t9zTZ0jhjKO8c7EZHsj1f4"; // The access token granted after
																						// OAuth authorization
			String accessTokenSecret = "U4MSegltWY5PtHNgVXhFUDL3b2b7TCNkIXDcEs3odprvl"; // The access token secret
																						// granted after OAuth
																						// authorization
			Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
			System.out.println("twitter: " + twitter);

			TwitterProfile twitterProfile = twitter.userOperations().getUserProfile();

			System.out.println("twitterProfile: " + twitterProfile.getName());

			/*
			 * HashTagEntity hashTagEntity = new HashTagEntity();
			 * hashTagEntity.setTexto("#openbanking");
			 * hashTagRepository.save(hashTagEntity);
			 */

			Iterable<HashTagEntity> hashTagInte = hashTagRepository.findAll();

			/*
			 * ArrayList<String> arrayList = new ArrayList<String>();
			 * arrayList.add("#openbanking"); arrayList.add("#apifirst");
			 * arrayList.add("#devops"); arrayList.add("#cloudfirst");
			 * arrayList.add("#microservices"); arrayList.add("#apigateway");
			 * arrayList.add("#oauth"); arrayList.add("#swagger"); arrayList.add("#raml");
			 * arrayList.add("#openapis"); HashTagEntity hashTagEntity = new
			 * HashTagEntity(); hashTagEntity.setTexto("#oauth22"); HashTagEntity saveHash =
			 * hashTagRepository.save(hashTagEntity);
			 * 
			 * 
			 * TweetsEntity tweetsEntity = new TweetsEntity();
			 * tweetsEntity.setHashTagText("testeste"); tweetsEntity.setHashTag(saveHash);
			 * 
			 * TweetsEntity save = tweetsRepository.save(tweetsEntity);
			 * System.out.println(save+" OKKK"); System.out.println(tweetsEntity+" OKKK");
			 */

			/*
			 * Iterator<HashTagEntity> it = hashTagInte.iterator(); while(it.hasNext()){
			 * String texto = it.next().getTexto(); System.out.println(texto+" OKKK");
			 * SearchResults search =
			 * twitter.searchOperations().search("#microservices",1200);
			 * //printTweet(search.getTweets(), it.next()); }
			 */
			/*
			 * List<Element> list = new ArrayList<>(); iterator.forEachRemaining(list::add);
			 * 
			 * Iterable<HashTagEntity> listHashTags = new ArrayList<HashTagEntity>();
			 * hashTagInte.forEach(action->{ action.getTexto() });
			 * Lists.newArrayList(hashTagInte);
			 */
			// List<Element> myList = Lists.newArrayList(myIterator);
			hashTagInte.forEach(hashTag -> {

				SearchResults search = twitter.searchOperations().search(hashTag.getTexto(), 1200);
				printTweet(search.getTweets(), hashTag);

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================================================================    FIM");
		System.out.println("======================================================================    FIM");
		System.out.println("======================================================================    FIM");
		System.out.println("======================================================================    FIM");
		System.out.println("======================================================================    FIM");

	}

	void printTweet(List<Tweet> tweets, HashTagEntity hashTag) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		int cont = 1;
		for (Tweet tweet : tweets) {

			TwitterProfile user = tweet.getUser();
			String nameTratado = user.getName();
			int followersCount = user.getFollowersCount();

			System.out.println(cont + "  @" + user.getName() + "tweet: " + tweet.getText() + " lang: "
					+ tweet.getUser().getLanguage() + " lang cod: " + tweet.getLanguageCode());

			System.out.println("tweet: criadoem : " + tweet.getCreatedAt() + " : ");
			System.out.println("total seguidores : " + followersCount + " id-twitter: " + user.getId());
			String stringN1 = null;

			Date createdAt = tweet.getCreatedAt();
			TweetsEntity tweetsEntity = new TweetsEntity();
			if (cont < 101) {
				try {
					
					UserEntity userByIdTwitter = getUserByIdTwitter(user.getId());
					if (userByIdTwitter != null) {
						tweetsEntity.setUser(userByIdTwitter);
					} else {
						UserEntity userEntity = new UserEntity();
						userEntity.setIdTwitter(user.getId());
						userEntity.setIdioma(stringToByte(tweet.getUser().getLanguage()));
						userEntity.setPais(stringToByte(tweet.getUser().getLocation()));
						userEntity.setTimeZone(stringToByte(tweet.getUser().getTimeZone()));
						userEntity.setName(stringToByte(user.getName()));
						userEntity.setSeguidores(new Long(followersCount));

						UserEntity userEntityNew = userRepository.save(userEntity);
						tweetsEntity.setUser(userEntityNew);

					}
					tweetsEntity.setDataCriacao(createdAt);

					try {
						tweetsEntity.setHashTagText(stringToByte(limitandoTexto(tweet.getText())));
					} catch (DataIntegrityViolationException ex) {
						String text = tweet.getText();
						if (text.length() > 10)
							text = text.substring(0, 9);
						else
							text = "tweet nao e seguro!";
						tweetsEntity.setHashTagText(stringToByte(limitandoTexto(text)));
					} catch (Exception e) {
						tweetsEntity.setHashTagText(
								stringToByte("Desculpe, Mas não conseguimos, tratar alguns dos caracteres do tweet."));
					}
					tweetsEntity.setHashTag(hashTag);

					tweetsRepository.save(tweetsEntity);
				}catch (DataIntegrityViolationException ex) {
					String text = tweet.getText();
					if (text.length() > 10)
						text = text.substring(0, 9);
					else
						text = "tweet nao e seguro!";
					tweetsEntity.setHashTagText(stringToByte(limitandoTexto(text)));
					tweetsRepository.save(tweetsEntity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			cont++;
		}
		System.out.println("FOI ENCONTRADOS : " + cont + " com a " + hashTag.getTexto());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		/*
		 * Iterable<UserEntity> findAll = userRepository.findAll();
		 * findAll.forEach(action->{ Long id = action.getId(); Long idTwitter =
		 * action.getIdTwitter(); byte[] nameAr = action.getName(); String nome = new
		 * String(nameAr); System.out.println(id+" "+idTwitter+" "+nome); });
		 */

	}

	public byte[] stringToByte(String string) {
		System.out.println("------------------------stringToByte-------------------------------------");
		System.out.println(string);
		System.out.println("------------------------stringToByte-------------------------------------");
		try {
			if (string == null || string.equals(null)) {
				string = "vazio";
			}
			byte[] bytes = string.getBytes("UTF-8");
			return bytes;

		} catch (UnsupportedEncodingException e) {
			System.out.print("-------------------------------------------------------------");
			System.out.print("ERRO AO TENTAR CONVERTER A STING ABAIXO PARA ARRAY DE BYTE");
			System.out.print(string);
			System.out.print("-------------------------------------------------------------");
			e.printStackTrace();
		}
		return null;
	}

	public UserEntity getUserByIdTwitter(Long idTwitter) {
		return userRepository.findByIdTwitter(idTwitter);
	}

	public String limitandoTexto(String s) {
		if (s.length() > 50) {
			return s.substring(0, 100);
		} else {
			return s;
		}

	}
}
