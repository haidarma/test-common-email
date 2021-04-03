package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = {"ab@a.com", "hi@hi.org", "abc@cd.com"};
	
	private static final String TEST_EMAIL = "a@b.com";
	
	private static final String TEST_HEADER = "1";
	
	private static final String TEST_NAME = "Jeff";
	
	private EmailConcrete email;
	
	@Before 
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception{
		
	}

	@Test
	public void testAddBcc() throws Exception{
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
	}
	
	@Test
	public void testAddCc() throws Exception{
		
		email.addCc(TEST_EMAIL);
		
		assertFalse(email.ccList.isEmpty());
	}
	
	@Test
	public void testAddReplyTo() throws Exception{
		email.addReplyTo(TEST_EMAIL, TEST_NAME);
		
		assertNotSame(TEST_EMAIL, TEST_NAME);
		
	}

	@Test
	public void testAddHeader() throws Exception{
		email.addHeader(TEST_NAME, TEST_HEADER);
		
		assertFalse(email.headers.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddHeaderNoName() throws Exception{
		String name = null;
		email.addHeader(name, TEST_HEADER);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddHeaderNoValue() {
		String value = null;
		email.addHeader(TEST_NAME, value);
	}


}
