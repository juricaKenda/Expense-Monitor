package com.expense.serviceTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.expenses.service.GroupMemberIDgenerator;

public class IDgeneratorTests {

	private static GroupMemberIDgenerator generator;
	private static final int TEST_QUANTITY = 100;
	
	@Before
	public void setup() {
		generator = new GroupMemberIDgenerator();
	}
	
	
	/**
	 * ID generator has to return unique ID 
	 * each and every time
	 */
	@Test
	public void testAllUnique() {
		
		//Prepare
		ArrayList<Integer> idStorage = new ArrayList<Integer>();
		
		//Perform
		for(int count=0; count< TEST_QUANTITY; count++) {
			idStorage.add(generator.generateId());
		}
		
		//Assert
		assertEquals(idStorage.stream().distinct().count(),TEST_QUANTITY);
	}
}
