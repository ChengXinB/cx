package test;

import java.security.MessageDigest;

import org.junit.Test;

import Decoder.BASE64Encoder;

public class GiveMD5 {
	@Test
	public void test01(){
		try {
			String message = "admin";
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] by = md.digest(message.getBytes());
			System.out.println(new BASE64Encoder().encode(by)) ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
