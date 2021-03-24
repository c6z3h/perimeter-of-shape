package com.testInc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PerimeterOfShape {
	// Function 1 : Read .txt file and store the values in an array.
	public static void readFile(String fileDir, int []array) {
		try {
			File dataset = new File(fileDir);
			Scanner reader = new Scanner(dataset);
			
			int i = 0;
			
			while (reader.hasNext()){
				String data = reader.next();
				data = data.replace(",", "");
				int intData = Integer.parseInt(data);
				array[i] = intData;
				++i;
				//System.out.println(intData);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	

	public static double Perimeter(int []array, double number) {
		// Private means length is stuck within this loop, unprintable to main()
		// Calculate length of sides
		int j = 0;
		int x1 = 0; int y1 = 0;
		int x2 = 0; int y2 = 0;
		int dx = 0; int dy = 0;
		
		while (array[2*j+2] != 0) {
			x2 = array[2*j+2]; y2 = array[2*j+3];
			x1 = array[2*j]; y1 = array[2*j+1];
			dx = x2 - x1;
			dy = y2 - y1;
			number += Math.sqrt(dx*dx + dy*dy);
			System.out.println(j +"# length is " + number);
			++j;
		}
		// Final Point and Initial Point
		//System.out.println(x2 +" "+ y2);
		x1 = array[0]; y1 = array[1];
		dx = x2-x1; dy = y2-y1; number += Math.sqrt(dx*dx + dy*dy);
		System.out.println(j +"# length is " + number);
		return number;
	}
	
	public static void main(String[] args) {
		int []points = new int[30];
		PerimeterOfShape.readFile("src/resources/example3.txt", points);
		System.out.println("Array stored values are " + Arrays.toString(points));
		HashMap<String, String> troll = new HashMap<String, String>();
		double length = 0;
		System.out.println( PerimeterOfShape.Perimeter(points, length));

	}
}
