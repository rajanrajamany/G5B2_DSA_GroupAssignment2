package com.greatlearning.common;

import com.greatlearning.interfaces.IcommonFunctions;

public class CustomFunctions implements IcommonFunctions {
	public int maxInArray(int[] arr, int iLessthan) {
		int iTmpMax = 0;
		if (iLessthan > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > iTmpMax && arr[i] < iLessthan) {
					iTmpMax = arr[i];
				}
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > iTmpMax) {
					iTmpMax = arr[i];
				}
			}
		}
		return iTmpMax;
	}

	public boolean CheckDuplicateInArray(int[] arr, int iArrLength, int iValue) {
		for (int i = 0; i < iArrLength; i++) {
			if (arr[i] == iValue) {
				return true;
			}
		}
		return false;
	}

}
