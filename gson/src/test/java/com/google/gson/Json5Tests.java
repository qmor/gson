package com.google.gson;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Json5Tests {
	

	class Json5Cls
	{
		public int hex;
	}
	class Json5ClsArray
	{
		public List<Integer> hexarray;
	}
	@Test
	public void testJSON5hexInteger()
	{

		String json5= "{hex:0xdeadc0d}";
		GsonBuilder builder = new GsonBuilder();
		builder.setJSON5Mode(true);
		Gson gson = builder.create();
		Json5Cls result = gson.fromJson(json5, Json5Cls.class);
		assertEquals(0xdeadc0d, result.hex);

		json5= "{hexarray:[1,2,0x20,2.0]}";
		Json5ClsArray resarray = gson.fromJson(json5, Json5ClsArray.class);
		List<Integer> resultListTest = new ArrayList<>();
		resultListTest.addAll(Arrays.asList(new Integer[] {1,2,32,2}));
		Assert.assertEquals(resarray.hexarray,resultListTest);
	}
}
