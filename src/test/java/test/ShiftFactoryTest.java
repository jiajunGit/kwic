package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.ShiftFactory;

public class ShiftFactoryTest {

	@Test
	public void testGetInstanceForNonNullOutput() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		assertTrue( shiftFactory != null );
	}
	
	@Test
	public void testGetShifterForNonNullOuput() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		assertTrue( shiftFactory.getShifter() != null );
	}
}
