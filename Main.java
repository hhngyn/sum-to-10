/* 
  	Pairs that sum to 10
  	Hannah Nguyen
  	This project finds pairs that sum to 10 with three functions.
  	The first function finds all pairs including duplicates
  	The second function finds all unique pairs excluding duplicates
  	The thirst function finds all combo pairs available from the array.
 */

import java.util.*;

public class Main {

	/*
	 * pairs from array, only having combo pairs output: [1,9], [4,6], [5,5] time
	 * complexity = O(n^2 + m)
	 */
	public static void pairsFromArrayCombos(int arr[], int sum) {
		// using hash maps to put combo pairs into it
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		
		// get the first value from the array
		for (int first = 0; first < arr.length; first++) {

			// loop through the array again for the second value for the pair
			for (int second = 0; second < arr.length; second++) {
				
				// first index must not be the same as second index
				if (!pairs.containsValue(arr[first])) {

					// first index must not be the same as second index
					if (first != second) {
	
						// see if the pair of numbers are a sum of 10
						if (arr[first] + arr[second] == sum) {
							
							// add pairs to hashmap 
							pairs.put(arr[first], arr[second]);
						}	
					}
				}
			}
		}
		
		// print out hash map
		System.out.println("Pairs that are unique combos:");
		for (int i : pairs.keySet()) {
			System.out.println("[" + i + ", " + pairs.get(i) + "]");

		}

	}
	/*
	 * pairs from array, only having unique pairs output: [1,9], [4,6], [5,5],
	 * [6,4], [9,1] 
	 * time complexity = O(n^2 + m)
	 */

	public static void pairsFromArrayUnique(int arr[], int sum) {
		
		// using hash maps to put combo pairs into it
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		
		// get the first value from the array
		for (int first = 0; first < arr.length; first++) {

			// loop through the array again for the second value for the pair
			for (int second = 0; second < arr.length; second++) {
				
				// first index must not be the same as second index
				if (first != second) {

					// see if the pair of numbers are a sum of 10
					if (arr[first] + arr[second] == sum) {
						
						// add pairs to hashmap 
						pairs.put(arr[first], arr[second]);
					}	
				}
			}
		}
		
		// print out hash map
		System.out.println("Pairs that are unique pairs:");
		for (int i : pairs.keySet()) {
			System.out.println("[" + i + ", " + pairs.get(i) + "]");

		}
	}

	/*
	 * pairs from array, including duplicates output: [1,9], [1,9], [4,6], [4,6],
	 * [5,5], [5,5], [5,5], [5,5], [5,5], [5,5], [6,4], [6,4] [9,1] , [9,1] 
	 * time complexity = O(n^2)
	 */
	public static void pairsFromArrayDuplicate(int arr[], int sum) {
		System.out.println("Pairs that include duplicates:");

		// get the first value from the array
		for (int first = 0; first < arr.length; first++) {

			// loop through the array again for the second value for the pair
			for (int second = 0; second < arr.length; second++) {

				// first index must not be the same as second index
				if (first != second) {

					// see if the pair of numbers are a sum of 10
					if (arr[first] + arr[second] == sum) {

						// print pairs */
						System.out.println("[" + arr[first] + ", " + arr[second] + "]");
					}
				}
			}
		}
	}

	/*
	 *  called for when the user want to create their own array
	 */
	public static void userCreateArray() {
		Scanner input = new Scanner(System.in);
		String userNum;
		int sum = 10;
		int num;
		
		// get user input of how many numbers should be in an array
		System.out.println("Enter the number of variables you want to have in the array.");  
		userNum = input.nextLine();
		
		
		try {
			num = Integer.parseInt(userNum);
			
			// catch when user puts in an integer that is lower or equal than 0
			while (num <= 0) {
				System.out.println("The number should not be lower or equal than 0. Try again.");
				userNum = input.nextLine();
				num = Integer.parseInt(userNum);
			}
			int userArr[] = new int[num];
			
			// use inputs integers in the array 
			System.out.println("Enter the variables you want to have in the array.");  
			for(int i = 0; i < userArr.length; i++) {
				userNum = input.nextLine();
				num = Integer.parseInt(userNum);
				userArr[i] = num;
			}
			
			//call to function for array created by the user
			System.out.println("Now showing pairs in the array that sums to 10.");  
			pairsFromArrayDuplicate(userArr, sum); 
			pairsFromArrayUnique(userArr, sum);
			pairsFromArrayCombos(userArr, sum);
			input.close();

		} catch (NumberFormatException e) {
			// system catches all invalid inputs that resulted in not an integer
			System.out.println("Not a valid input. Please put a whole number in next time. System shutting down.");  
			input.close();
		}
	}
	/* main function */
	public static void main(String[] args) {
		// example given
		int exampleArr[] = {1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9};
		int exampleSum = 10;	
		
		// user input
		Scanner userInput = new Scanner(System.in);
		String answer;

		System.out.println("This program can receive integer arrays and can find pairs that sum up to 10.");    

		//gets user input of case sensitive yes or no
		System.out.println("Would you like to use example array? (yes/no) ");    
		answer = userInput.nextLine();  
		
		if (answer.equals("yes")) {
			pairsFromArrayDuplicate(exampleArr, exampleSum); 
			pairsFromArrayUnique(exampleArr, exampleSum);
			pairsFromArrayCombos(exampleArr, exampleSum);
			userInput.close();

		} else if (answer.equals("no")) {
			
			//gets user input of case sensitive yes or no
			System.out.println("Would you like to create your own array? (yes/no)");   
			answer = userInput.nextLine();  

			if (answer.equals("yes")) {
				userCreateArray();
				userInput.close();

			} else if (answer.equals("no")) {
				System.out.println("Have a great day!");
				userInput.close();
			}
			while (!answer.equals("yes") && !answer.equals("no")) {
				
				// catches odd user input that doesn't fit the criteria and loops again for user input
				System.out.println("The response should be only lowercase yes/no. Would you like to create your own array?");    
				answer = userInput.nextLine();  
				if (answer.equals("yes")) {
					userCreateArray();  
					userInput.close();

				} else if (answer.equals("no")) {
					System.out.println("Have a wonderful day!");  
					userInput.close();
				}
			}
		}
		
		while (!answer.equals("yes") && !answer.equals("no")) {
			
			// catches odd user input that doesn't fit the criteria and loops again for user input
			System.out.println("The response should be only lowercase yes/no. Would you like to use example array?");    
			answer = userInput.nextLine();  
			
			if (answer.equals("yes")) {
				pairsFromArrayDuplicate(exampleArr, exampleSum); 
				pairsFromArrayUnique(exampleArr, exampleSum);
				pairsFromArrayCombos(exampleArr, exampleSum);
				userInput.close();
				
			} else if (answer.equals("no")) {
				
				//gets user input of case sensitive yes or no
				System.out.println("Would you like to create your own array? (yes/no)"); 
				answer = userInput.nextLine();  
				if (answer.equals("yes")) {
					userCreateArray();
					userInput.close();

				} else if (answer.equals("no")) {
					System.out.println("Have a great day!");  
					userInput.close();

				}
				while (!answer.equals("yes") && !answer.equals("no")) {
					
					// catches odd user input that doesn't fit the criteria and loops again for user input
					System.out.println("The response should be only lowercase yes/no. Would you like to create your own array?");    
					answer = userInput.nextLine();  
					if (answer.equals("yes")) {
						userCreateArray();
						userInput.close();
						
					} else if (answer.equals("no")) {
						System.out.println("Have a wonderful day!");  
						userInput.close();
					}
				}
			}
		}
	}
}
