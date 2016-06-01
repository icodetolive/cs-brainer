package com.icode.arrays.test;

import static org.junit.Assert.*;
import com.icode.arrays.MountainPeaks;

import org.junit.Test;

public class MountainPeaksTest {

	@Test
	public void testMountainPeaks() {
		assertNull("Expected null value for empty array", MountainPeaks.findWaterFilledPeaks(null));
		assertNull("Expected null value for arraysize <= 1", MountainPeaks.findWaterFilledPeaks(new int[] { 4 }));
		assertEquals("Water recedes to left with all ascending peak values", null,
				MountainPeaks.findWaterFilledPeaks(new int[] { 2, 4, 8, 9, 11 }));
		assertEquals("Water recedes to the right with all descending peaks",null,MountainPeaks.findWaterFilledPeaks(new int[] {10,8,6,4,2}));
		assertEquals(new int[]{0,1,1,0,0},MountainPeaks.findWaterFilledPeaks(new int[] {3,1,2,3,5}));
		assertEquals(new int[]{0,0,1,1,0},MountainPeaks.findWaterFilledPeaks(new int[] {4,3,1,2,3}));
		assertEquals(new int[]{0,1,1,1,0},MountainPeaks.findWaterFilledPeaks(new int[] {3,1,1,1,3}));
		assertEquals(new int[]{0,1,1,1,1,0,0},MountainPeaks.findWaterFilledPeaks(new int[] {5,3,1,2,1,4,3}));
		assertEquals(new int[]{0,1,1,0,1,0,0,0},MountainPeaks.findWaterFilledPeaks(new int[] {3,2,1,4,1,4,2,8}));
		assertEquals(new int[]{0,0,0,1,1,0,0,0},MountainPeaks.findWaterFilledPeaks(new int[] {1,2,8,2,3,7,4,1}));
		assertEquals(new int[]{0,1,1,0,1,0},MountainPeaks.findWaterFilledPeaks(new int[] {3,2,1,4,2,5}));
		assertEquals(new int[]{0,1,1,0,1,0},MountainPeaks.findWaterFilledPeaks(new int[] {3,1,2,3,1,5}));

	}

}
