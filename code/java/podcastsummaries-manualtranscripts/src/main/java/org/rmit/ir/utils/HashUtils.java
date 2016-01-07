package org.rmit.ir.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

	public static String md5hash(String str) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("md5");
			m.update(str.getBytes(), 0, str.length());
			return new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
		}
		return "";
	}

}