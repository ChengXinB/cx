package com.mjs.utils;

import java.security.MessageDigest;

import Decoder.BASE64Encoder;

public class MD5Util {
	public static String encode(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] by = md.digest(message.getBytes());
			return new BASE64Encoder().encode(by);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
