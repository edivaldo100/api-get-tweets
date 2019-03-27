package com.edivaldo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

import com.edivaldo.service.TweetsServices;

public class TweetsImp implements TweetsServices {

	@Override
	public void listTweets() {

		System.out.println("OKKKKKKKKKKK");

		String consumerKey = "n76YhiIrNyRnyKti5YOL3niaD"; // The application's consumer key
		String consumerSecret = "EeI8n3fi3daIPW6voLakGIzKbDail6D4uhgNNhtg2yepUQv4As"; // The application's consumer
																						// secret
		String accessToken = "852754277386690561-VY3SaYT51t9zTZ0jhjKO8c7EZHsj1f4"; // The access token granted after
																					// OAuth authorization
		String accessTokenSecret = "U4MSegltWY5PtHNgVXhFUDL3b2b7TCNkIXDcEs3odprvl"; // The access token secret granted
																					// after OAuth authorization
		Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		System.out.println("twitter: " + twitter);

		TwitterProfile twitterProfile = twitter.userOperations().getUserProfile();

		System.out.println("twitterProfile: " + twitterProfile.getName());
		String textoBuscar = "#BomDia";

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("#openbanking");
		arrayList.add("#apifirst");
		arrayList.add("#devops");
		arrayList.add("#cloudfirst");
		arrayList.add("#microservices");
		arrayList.add("#apigateway");
		arrayList.add("#oauth");
		arrayList.add("#swagger");
		arrayList.add("#raml");
		arrayList.add("#openapis");

		arrayList.forEach(action -> {

			SearchResults search = twitter.searchOperations().search(action, 1200);
			printTweet(search.getTweets(), action);

		});
	}

	public List<Tweet> printTweet(List<Tweet> tweets, String hashTag) {
		ArrayList<Tweet> listaTweet = new ArrayList<Tweet>();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		int cont = 1;
		for (Tweet tweet : tweets) {
			System.out.println(cont + "  @" + tweet.getUser().getName() + "tweet: " + tweet.getText());
			listaTweet.add(tweet);
			cont++;
		}
		System.out.println("FOI ENCONTRADOS : " + cont + " com a " + hashTag);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return listaTweet;
	}

}
