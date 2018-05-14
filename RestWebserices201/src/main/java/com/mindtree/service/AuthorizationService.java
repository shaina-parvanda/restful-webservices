package com.mindtree.service;

import java.io.IOException;
import java.util.StringTokenizer;

import com.sun.jersey.core.util.Base64;

public class AuthorizationService {

	public boolean authorize(String credentials) {

		if (null == credentials)
			return false;
		final String encodedCredentials = credentials.replaceFirst("Basic"
				+ " ", "");
		String userCredential = null;
		try {
			byte[] decodedBytes = Base64.decode(encodedCredentials);
			userCredential = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				userCredential, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		boolean authenticationStatus = "admin".equals(username)
				&& "admin".equals(password);
		return authenticationStatus;
	}
}

