package com.billing.service.util;

public class SecurityConstants {

	private SecurityConstants() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String SECRET = "SecretKeyToGenJWTs";

	public static final long TOKEN_EXPIRATION_TIME = 1200000; // 1 day 120000

	public static final String HEADER_STRING = "x-auth-token";
	
	public static final String DB_NAME="DB_NAME";
	
	public static final String DB_USER_NAME="USER_NAME";
	
	public static final String DB_PASSWORD="PASSWORD";
	
	public static final String PROPS_LOCATION = "/opt/globe/props/system.properties";

}
