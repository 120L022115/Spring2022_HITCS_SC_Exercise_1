package exercise_6_6;

import java.util.Scanner;

public class HIndex {

	public static void main(String[] args) {

		//read input from keyboard
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input the citation numbers:");
		
		//deal with empty input
		String line = new String();
		line = scanner.nextLine();
		while(line.length() == 0) {
			System.out.println("Input empty, please re-input:");
			line = scanner.nextLine();
		}

		//split input string into integers
		int[] citations = new int[100];
		String[] strs;
		
		strs = line.split(",");
		for (int i = 0; i < strs.length; i++) 
			citations[i] = Integer.parseInt(strs[i]);

		//calculate h-index
		int hindex = hindex(citations);
		
		//output to console
		System.out.println("The h-index is: " + hindex);
	}
	
	public static int hindex(int[] citations) {
		//sorting
		sort(citations);

		//calculate h-index
		int hindex = 0;
		for (int j = 0; j < citations.length; j++) {
			if (citations[j] >= j + 1)
				hindex = j + 1;
			else
				break;
		}
		return hindex;
	}

	public static void sort(int[] citations) {
		int number = citations.length;
		for (int i = 0; i < number - 1; i++) {
			for (int j = 0; j < number - 1; j++) {
				if (citations[j] < citations[j + 1]) {
					int temp = citations[j + 1];
					citations[j + 1] = citations[j];
					citations[j] = temp;
				}
			}
		}
	}
}
