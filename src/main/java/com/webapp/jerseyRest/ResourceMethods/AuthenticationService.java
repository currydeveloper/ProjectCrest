package com.webapp.jerseyRest.ResourceMethods;

import java.util.Base64;
import java.util.StringTokenizer;

public class AuthenticationService {
	public boolean authenticate(String authCred) {
		if (null == authCred || authCred.isEmpty()) {
			return false;
		} else {
			System.out.println("Starting the authentication of data: " + authCred);
			final String encodedCred = authCred.replaceFirst("Basic" + " ", "");
			System.out.println("This is the encoded String:" + encodedCred);
			String decodeUsn = null;
			try {
				byte[] decodeByte = Base64.getDecoder().decode(encodedCred);
				System.out.println("This is the byte: " + decodeByte.length);
				decodeUsn = new String(decodeByte, "UTF-8");
				System.out.println("decode value is" + decodeUsn);
			} catch (Exception e) {
				System.out.println("Error in decoding the usn:" + e);
			}
			final StringTokenizer token = new StringTokenizer(decodeUsn, ":");
			final String usn = token.nextToken();
			final String pwd = token.nextToken();
			boolean stat = "spadmin".equalsIgnoreCase(usn) && "admin".equalsIgnoreCase(pwd);
			return stat;
		}
	}
}
