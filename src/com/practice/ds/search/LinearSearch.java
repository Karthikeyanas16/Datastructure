package com.practice.ds.search;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LinearSearch {
	
	public static void main(String args[]) {
		
		int[] arr=new int[]{12,34,94,8,37,10};
		System.out.println("Enter the element to search :: ");
		Scanner scan=new Scanner(System.in);
		int element = scan.nextInt();
		boolean found = false;
		
		//Linear Search Implementation using Java 7 Features
		for(int i=0;i<arr.length;i++) {
			if(element == arr[i]) {
				int n = element;
				System.out.println("Element : "+n+" has been found at the index : "+i);
				found=true;
				break;
			}
			
		}
		
		//Linear Search Implementation using Java 8 Features
	/*	IntStream.range(0, arr.length)
					.forEach(i -> {
						
							if(element == arr[i]) {
								int n = element;
								System.out.println("Element : "+n+" has been found at the index : "+i);
								found=true;
								break;
							}
						});*/
	
		if(!found) {
			System.out.println("Element : "+ element+" not found.");
			}
		
		//Java 9 code
		/*IntStream.range(0, arr.length)
        .filter(i -> element == arr[i]) // .equals( ??
        .findFirst()
        .ifPresentOrElse(i -> System.out.printf("Element : %s has been found at the index : %d%n", element, i),
                () -> System.out.printf("Element %s not found%n", element));*/
		
	
		OptionalInt valueOptional= Arrays.stream(arr)
		                                .filter(current -> current == element)
		                                .findFirst();
		
		System.out.println(valueOptional.isPresent());
		
		
		OptionalInt result = IntStream.range(0, arr.length)
		        .filter(i -> element == arr[i]) // .equals( ??
		        .findFirst();
		
		if (result.isPresent()) {
		  System.out.printf("Element : %s has been found at the index : %d%n", element, result.getAsInt());
		} else {
		  System.out.printf("Element %s not found%n", element);
		}

	}

}
