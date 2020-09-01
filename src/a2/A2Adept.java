package a2;

import java.util.Scanner;
import java.util.ArrayList;
public class a2.A2Adept {

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

		int menuItems = scan.nextInt();

		String[] menuName = new String[menuItems];
		ArrayList<Double> ingredientCalories = new ArrayList<>();
		ArrayList<Double> ingredientCost = new ArrayList<>();
		ArrayList<Boolean> ingredientVeg = new ArrayList<>();
		ArrayList<Double> totalIngredientCalories = new ArrayList<>();
		ArrayList<Double> totalIngredientCost = new ArrayList<>();
		ArrayList<String> totalIngredientVeg = new ArrayList<>();

		double totalCalories = 0;
		double totalCost = 0;
		String totalVeg = null;
		double calSum = 0;
		double costSum = 0;

		for (int i = 0; i < menuItems; i++) { //for every menu item
			menuName[i] = scan.next();
			int numberOfIngredients = scan.nextInt();

			String[] ingredientName = new String[numberOfIngredients];
			double[] ounces = new double[numberOfIngredients];

			for (int j = 0; j < numberOfIngredients; j++) { //for every ingredient in every menu item
				ingredientName[j] = scan.next();
				ounces[j] = scan.nextDouble();
				for (int k = 0; k < name.length; k++) { //information for each ingredient in every menu item for output
					if (name[k].equals(ingredientName[j])) {
						totalCalories += calories[k] * ounces[j];
						ingredientCalories.add(totalCalories);
						totalCost += price[k] * ounces[j];
						ingredientCost.add(totalCost);
						ingredientVeg.add(vegOrNot[k]);
						break;
					}
				}
				totalCalories = 0;
				totalCost = 0;
				totalVeg = null;
			}
			for (int h = 0; h < ingredientCalories.size(); h++) {
				calSum += ingredientCalories.get(h);

			}
			totalIngredientCalories.add(calSum);

			for (int h = 0; h < ingredientCost.size(); h++) {
				costSum += ingredientCost.get(h);
			}
			totalIngredientCost.add(costSum);

			if(ingredientVeg.contains(false)) {
				totalIngredientVeg.add("Non-Vegetarian");
			}
			else {
				totalIngredientVeg.add("Vegetarian");
			}

			calSum = 0;
			costSum = 0;
			ingredientCalories.clear();
			ingredientCost.clear();
			ingredientVeg.clear();

		}


		//output
		for (int i = 0; i < menuItems; i++) {
			System.out.println(menuName[i] + ":");
			System.out.println("  " + (Math.round(totalIngredientCalories.get(i))) + " calories");
			System.out.println("  " + "$" + String.format("%.2f", totalIngredientCost.get(i)));
			System.out.println("  " + totalIngredientVeg.get(i));
		}

	}
}
