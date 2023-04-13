package Home;


public class Fuzzy {
	static double[][] weights;
	static double fuzzyWeightValue[];

	public static void weightAssign(Heart[] heart, int n) {
		weights = new double[n][15];
		for (int i = 0; i < heart.length; i++) {
			weights[i][0] = 0.0;

			weights[i][1] = heart[i].age / 100.0;

			weights[i][2] = 0.8;

			if (heart[i].cp == 0)
				weights[i][3] = 0.9;
			else if (heart[i].cp == 1)
				weights[i][3] = 0.1;
			else if (heart[i].cp == 2)
				weights[i][3] = 0.3;
			else if (heart[i].cp == 3)
				weights[i][3] = 0.2;

			weights[i][4] = (double) (heart[i].trestbps - 80) / 100.0;

			weights[i][5] = (double) (heart[i].chol - 100) / 400.0;

			weights[i][6] = (double) (heart[i].fbs) * 0.5;

			if (heart[i].restecg == 0)
				weights[i][7] = 0.2;
			else if (heart[i].restecg == 1)
				weights[i][7] = 0.8;

			weights[i][8] = (heart[i].thalch - 220 + heart[i].age) / 60;

			weights[i][9] = (double) (heart[i].exang) * 0.5;

			weights[i][10] = (double) (heart[i].oldpeak) / 6.2;

			if (heart[i].slope == 0)
				weights[i][11] = 0.9;
			else if (heart[i].thal == 1)
				weights[i][11] = 0.6;
			else if (heart[i].thal == 2) {
				weights[i][11] = 0.2;
			}

			if (heart[i].ca == 0)
				weights[i][12] = 0.2;
			else if (heart[i].ca == 1)
				weights[i][12] = 0.4;
			else if (heart[i].ca == 2)
				weights[i][12] = 0.6;
			else
				weights[i][12] = 0.8;

			if (heart[i].thal == 0 || heart[i].thal == 2)
				weights[i][13] = 0.1;
			else if (heart[i].thal == 1)
				weights[i][13] = 0.9;
			else if (heart[i].thal == 3)
				weights[i][13] = 0.8;

		}

	}

	public static void FuzzyWeightAssign(Heart[] heart) {
		double fuzzyval = 0;
		fuzzyWeightValue = new double[heart.length];
		for (int i = 0; i < heart.length; i++) {
			fuzzyval = 0;
			fuzzyval += weights[i][10] * 0.96;
			fuzzyval += weights[i][9] * 0.90;
			fuzzyval += weights[i][3] * 0.88;
			fuzzyval += weights[i][8] * 0.84;
			fuzzyval += weights[i][12] * 0.74;
			fuzzyval += weights[i][11] * 0.72;
			fuzzyval += weights[i][13] * 0.70;
			fuzzyval += weights[i][2] * 0.64;
			fuzzyval += weights[i][1] * 0.56;
			fuzzyval += weights[i][7] * 0.20;
			fuzzyval += weights[i][4] * 0.10;
			fuzzyval += weights[i][5] * 0.4;
			fuzzyval += weights[i][6] * 0.2;
			fuzzyWeightValue[i] = fuzzyval;
		}
	}

	public static void printWeight() {
		System.out.println("\nCalculated Fuzzy values ");
		for (double value : fuzzyWeightValue) {
			System.out.printf("%2f\t\t", value);
		}
	}

	public static void accuracy(Heart[] heart) {
		int count = 0;
		int val = 0;
		for (int i = 0; i < heart.length; i++) {
			val = 0;
			if (fuzzyWeightValue[i] <= 2.722)
				val = 1;
			if (heart[i].num == val)
				count++;
		}
		System.out.printf("Accuracy using fuzzy method is %d percent", (count * 100) / heart.length);
	}
}
