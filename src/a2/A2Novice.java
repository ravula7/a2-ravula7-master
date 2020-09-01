package a2;

import java.util.Scanner;
import java.util.ArrayList;
public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ingredients = scan.nextInt();

		String[] name = new String[ingredients];
		double[] price = new double[ingredients];
		boolean[] vegOrNot = new boolean[ingredients];
		double[] calories = new double[ingredients];

		for (int i = 0; i < ingredients; i++) {
			name[i] = scan.next();
			price[i] = scan.nextDouble();
			vegOrNot[i] = scan.nextBoolean();
			calories[i] = scan.nextDouble();
		}

		int vegCount = getVeg(vegOrNot);
		System.out.println("Number of vegetarian ingredients: " + vegCount);
		int highestIngredient = getHighestRatio(calories,price);
		System.out.println("Highest cals/$: "+name[highestIngredient]);
		int lowestIngredient = getLowestRatio(calories,price);
		System.out.println("Lowest cals/$: "+name[lowestIngredient]);
	}

	static int getVeg(boolean[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == true) {
				count++;
			}
		}
		return count;
	}

	static int getLowestRatio(double[]calories, double[]price) {
		ArrayList <Double> ratioList = new ArrayList<>();
		for (int i = 0; i < calories.length; i++) {
			double ratio1 = (double) calories[i];
			double ratio2 = (double) price[i];
			double ratio = ratio1 / ratio2;
			ratioList.add(ratio);
		}
		double max = ratioList.get(0);
		int maxInt = 0;
		for (int i = 1; i < ratioList.size(); i++) {
			if (ratioList.get(i) < max) {
				max = ratioList.get(i);
				maxInt = i;
			}
		}
		return maxInt;
	}

	static int getHighestRatio(double[]calories, double[]price) {
		ArrayList <Double> ratioList = new ArrayList<>();
		for (int i = 0; i < calories.length; i++) {
			double ratio1 = (double) calories[i];
			double ratio2 = (double) price[i];
			double ratio = ratio1 / ratio2;
			ratioList.add(ratio);
		}
		double min = ratioList.get(0);
		int minInt = 0;
		for (int i = 1; i < ratioList.size(); i++) {
			if (ratioList.get(i) > min) {
				min = ratioList.get(i);
				minInt = i;
			}
		}
		return minInt;
	}


	}
	
	// You can define helper methods here if needed.
	

