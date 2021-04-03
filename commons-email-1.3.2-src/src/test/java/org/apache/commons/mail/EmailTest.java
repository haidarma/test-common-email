package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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


}
