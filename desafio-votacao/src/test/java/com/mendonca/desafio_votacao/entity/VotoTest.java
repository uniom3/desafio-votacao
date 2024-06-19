package com.mendonca.desafio_votacao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class VotoTest {

	@Test
	public void testGetId() {
		
		Voto votoMock = mock(Voto.class);
		
		when(votoMock.getId()).thenReturn(1L);
		
		assertEquals(1L, votoMock.getId());
	}
	
	@Test
	public void testGetCpf() {

		Voto votoMock = mock(Voto.class);
		
		when(votoMock.getCpf()).thenReturn("12345678910");
		
		assertEquals("12345678910", votoMock.getCpf());
	}
	
}
