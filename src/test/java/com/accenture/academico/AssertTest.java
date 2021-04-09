package com.accenture.academico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {
	
	@Test
	public void testAssertArrayEquals() {
		byte[] esperado = "teste".getBytes();
		byte[] atual = "teste".getBytes();
		assertArrayEquals(esperado, atual);
		
	}
	
	@Test
	public void testAssertEquals() {
		assertEquals("text", "text");
	}
	
	@Test
	public void testeAssertFalse() {
		assertFalse(false);
	}
	
	@Test
	public void testeAssertNotNull() {
		assertNotNull(new Object());
	}
	
	@Test
	public void testeAssertNotSame() {
		assertNotSame(new Object(), new Object());
	}
	
	@Test
	public void testeAssertNull() {
		assertNull(null);
	}
	
	@Test
	public void testeAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame(aNumber, aNumber);
	}
}
