package com.fuse.oauthClient.services;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fuse.oauthClient.config.CustomOAuth2User;

@Service
public class OAuth2UserService extends DefaultOAuth2UserService{
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) {
		OAuth2User user=super.loadUser(userRequest);
		return new CustomOAuth2User(user);
	}

}
