package org.rmi.ir.podcastsearch.collection.transcripts.manual;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.rmit.ir.utils.HashUtils;

public class HashUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String expected="6465904bcaea896a541ca3067b1616f2";
		String md5 = HashUtils.md5hash("Economic growth slows to 2.7 per cent, well below forecasts");
		assertEquals(expected, md5);
	}

}
