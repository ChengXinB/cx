package test;

import org.junit.Test;

public class SubStringTest {

	@Test
	public void Test01(){
		String uri = "/BBS/invitation/invitation_addInvitation.action";
		System.out.println(uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".")));
	}
	@Test
	public void test02(){
		String uri = "sssssssss/ssss_sss.s";
		if (uri.contains(".")) {
			System.out.println(uri.substring(uri.lastIndexOf("/") + 1,
					uri.lastIndexOf(".")));
		}
	}
}
