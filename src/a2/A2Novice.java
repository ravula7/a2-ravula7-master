package a2;
import java.util.ArrayList;
import java.util.Scanner;
public class a2.A2Novice {

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


		/*Scanner intScan = new Scanner(System.in);
		Scanner scan = new Scanner(System.in).useDelimiter(" ");
		ArrayList<String> name = new ArrayList<>();
		ArrayList <Double> price = new ArrayList<>();
		ArrayList vegOrNot = new ArrayList();
		ArrayList <Double> calories = new ArrayList<>();

			String[] input;// = new String [ingredients*4];
			int ingredients = intScan.nextInt();

			for (int i = 0; i < ingredients; i++) {


				input = scan.nextLine().split(" ");

				for (int a = 0; a < input.length; a += 4) {
					name.add(String.valueOf(input[a]));
				}
				for (int b = 1; b < input.length; b += 4) {
					price.add(Double.valueOf(input[b]));
				}
				for (int c = 2; c < input.length; c += 4) {
					vegOrNot.add((input[c]));
				}
				for (int d = 3; d < input.length; d += 4) {
					calories.add(Double.valueOf(input[d]));
				}
			}

		int vegCount = getVeg(vegOrNot);
		System.out.println("Number of vegetarian ingredients: " + vegCount);
		//int highestIngredient = getHighestRatio(calories,price);
		//System.out.println("Highest cals/$: "+name.get(highestIngredient));
		//int lowestIngredient = getLowestRatio(calories,price);
		//System.out.println("Lowest cals/$: "+name.get(lowestIngredient));

		//String highestIngredient = getHighestRatio(calories,price);//((ArrayList)calories.clone(),(ArrayList)price.clone(),(ArrayList)name.clone());
		//System.out.println("Highest cals/$: "+highestIngredient);
		//String lowestIngredient = getLowestRatio(calories,price,name);//((ArrayList)calories.clone(),(ArrayList)price.clone(),(ArrayList)name.clone());
		//System.out.println("Lowest cals/$: ");

		/*for(int i=0; i<(input.length);i+=4){
			System.out.println(input[i]);
			name.add(input[i]);
		}
		for(int i=1; i<input.length;i+=4){
			System.out.println(input[i]);
			price.add(input[i]);
		}
		for(int i=2;i<input.length;i+=4){
			System.out.println(input[i]);
			vegOrNot.add(input[i]);
		}
		for(int i=3;i<input.length;i++){
			System.out.println(input[i]);
			calories.add(input[i]);
		}



		/*for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}

		/*do {
			input = scan.nextLine().split(" ");
			ingredients--;
		}while(ingredients>0);*/



		/*
		int vegCount = getVeg((ArrayList) vegOrNot.clone());
		System.out.print("Number of vegetarian ingredients: " + vegCount);

		/*for(int i=0; i<ingredients;i++){


			String inputs = scan.nextLine();


			name.add(inputs.split(" "));

		}


		String[] input = new String[4 * ingredients];
		do {
			String inputs = scan.nextLine();
			for (int i = 0; i < input.length; i++) {
				input[i] = Arrays.toString(inputs.split(" "));
			}


		}while(ingredients>0);


	/*	String[][] input = new String[3][4];
		int row = 0;
		do {
			String inputs = scan.nextLine();
			for (int c = 0; c < 4; c++) {
				input[row][c] = Arrays.toString(inputs.split(" ")); //String.valueOf(scan.nextLine().split(" "));
				//scan.nextLine();
			}
			row++;
		} while (row < 2);
		//Arrays.toString(input);
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 4; j++) {
				System.out.println("arr[" + i + "][" + j + "] = "
						+ input[i][j]); //Arrays.toString(new String[]{input[i][j]}));
			}
		}


			for (int k = 0; k < 2; k++) {
			name.add(input[k][0]);
			price.add(input[k][1]);
			vegOrNot.add(input[k][2]);
			calories.add(input[k][3]);
		}

		int vegCount = getVeg(vegOrNot);
		System.out.print("Number of vegetarian ingredients: " + vegCount);
	}


	/*
		//String input = scan.next();

	//


	/*	do {
			input.add(scan.next().split("\\n"));
			for(int i=0; i<input.size(); i++) {
				System.out.println(input.get(i));
			}

			ingredients--;
		} while (ingredients > 0);








		/*for(int i=0; i< name.size(); i++){
			name.add(input.get(i));
		}
		//
			// }while(input.size()>0);

		input.clear();
//price.add(input.get(i+1);
//			vegOrNot.add(input.get(i+2));
//			calories.add(input.get(i+3);


		/*;
		int numberOfIngredients = scan.nextInt();
		String [] input=new String [numberOfIngredients];
		price.add(input[1]);
			vegOrNot.add(input[2]);
			calories.add(input[3]);
		 */
		//for (int i = 0; i < input.size(); i++) {
		/*
		/*
Scanner scan = new Scanner(System.in);
		scan.useDelimiter(" ");



		String [] question = scan.next().split("\\n");
		name.add(question[0]);
		price.add(question[1]);
		vegOrNot.add(question[2]);
		calories.add(question[3]);

	//do {
	//ArrayList ingredientData = new ArrayList<>();
	//ingredientData.add(scan.nextLine().split(" "));




//
	//name.add(ingredientData[0]);price.add(ingredientData[1]);vegOrNot.add(ingredientData[2]);calories.add(ingredientData[3]);
	/*for(int i=0; i<ingredientData.length;i++) {
		System.out.println(name.get(i));
		System.out.println(price.get(i));
		System.out.println(vegOrNot.get(i));
		System.out.println(calories.get(i));
	}*/

		//Arrays.fill(ingredientData, null);

//numberOfIngredients--;
//}while(numberOfIngredients>0);


		//if(ingredientData.size()<numberOfIngredients){

		//}




	/*static int getVeg(ArrayList myList) {
		int count = 0;
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).equals("true")) {
				count++;
			}
			//	for(int i=0; i<myList.size(); i++) {
//boolean foundOrNot;
			//if(myList.get(i)== "true")

			//}
			//else{
			//	continue;
			//}
		}
		return count;
	} //veg method ends

 //highest ratio method ends

	static int getLowestRatio(ArrayList calList, ArrayList priceList) {
		ArrayList <Double> ratioList = new ArrayList<>();
		for (int i = 0; i < calList.size(); i++) {
			double ratio1 = (double) calList.get(i);
			double ratio2 = (double) priceList.get(i);
			double ratio = ratio1 / ratio2;
			ratioList.add(ratio);
		}
		double min = (double) ratioList.get(0);
		int minInt = 0;
		for (int i = 1; i < ratioList.size(); i++) {
			if (ratioList.get(i) < min) {
				min = ratioList.get(i);
				minInt = i;
			}
		}
		return minInt;
	} //lowest ratio method ends


}//class ends




		// You can define helper methods here if needed.
/*static String getHighestRatio(ArrayList calList, ArrayList priceList, ArrayList nameList) {
		ArrayList <Double> ratioList = new ArrayList<>();
		for (int i = 0; i < calList.size(); i++) {
			double ratio1 = (double) calList.get(i);
			double ratio2 = (double) priceList.get(i);
			double ratio = ratio1 / ratio2;
			ratioList.add(ratio);
		}
		double max = ratioList.get(0);
		int maxInt = 0;
		for (int i = 1; i < ratioList.size(); i++) {
			if (ratioList.get(i) > max) {
				max = ratioList.get(i);
				maxInt = i;
			}
		}
		return (String) nameList.get(maxInt);
	} //highest ratio method ends



*/
