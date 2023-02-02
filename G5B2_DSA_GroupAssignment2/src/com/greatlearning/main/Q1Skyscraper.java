package com.greatlearning.main;

import java.util.Collections;
import java.util.PriorityQueue;
import com.greatlearning.common.GetInputs;
import com.greatlearning.interfaces.IreadData;
import com.greatlearning.common.CustomFunctions;
import com.greatlearning.interfaces.IcommonFunctions;

public class Q1Skyscraper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IreadData getData = new GetInputs();
		IcommonFunctions commonFunctions = new CustomFunctions();
		System.out.println("enter the total no of floors in the building");
		int iNumOfFloors = getData.readPositiveInt();
		int iFloorSizes[] = new int[iNumOfFloors];
		boolean bDuplicate;

		for (int i = 0; i < iNumOfFloors; i++) {
			System.out.println("enter the floor size given on day :" + Integer.sum(i, 1));
			do {

				iFloorSizes[i] = getData.readPositiveInt();
				bDuplicate = commonFunctions.CheckDuplicateInArray(iFloorSizes, i, iFloorSizes[i]);
				if (bDuplicate) {
					System.out.println(
							"The value " + iFloorSizes[i] + " is already present, pls. reenter a unique value");
				}
			} while (bDuplicate);

		}

		int max = commonFunctions.maxInArray(iFloorSizes, 0);
		System.out.println("The order of construction is as follows");

		// We are using the reverse order to ensure the biggest size is in the front of
		// the queue. - G5 B2
		PriorityQueue<Integer> qFloorSizeInReverse = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < iNumOfFloors; i++) {

			System.out.println("Day: " + Integer.sum(i, 1));
			qFloorSizeInReverse.add(iFloorSizes[i]);

			while (!qFloorSizeInReverse.isEmpty() && qFloorSizeInReverse.peek() == max) {
				System.out.print(qFloorSizeInReverse.poll() + " ");

				// The statement is used to identify the max value from the list that is not
				// polled.  - G5 B2
				max = commonFunctions.maxInArray(iFloorSizes, max);
			}
			System.out.println();
		}
	}
}
