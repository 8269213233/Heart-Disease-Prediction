package Home;

public class PopCount {
	static int[][] pops;
	static String[] binary;
	static int[] decimal;

	public static void assignPops(Heart[] heart, int n) {
		pops = new int[n][15];

		for (int i = 0; i < heart.length; i++) {
			if (heart[i].id > heart.length)
				pops[i][0] = 1;
			if (heart[i].age > 30)
				pops[i][1] = 1;
			if (heart[i].sex >= 0)
				pops[i][2] = 1;
			if (heart[i].cp < 1)
				pops[i][3] = 1;
			if (heart[i].trestbps < 80 || heart[i].trestbps > 120)
				pops[i][4] = 1;
			if (heart[i].chol > 200)
				pops[i][5] = 1;
			if (heart[i].fbs > 0)
				pops[i][6] = 1;
			if (heart[i].restecg > 0)
				pops[i][7] = 1;
			if (heart[i].thalch > (220 - heart[i].age))
				pops[i][8] = 1;
			if (heart[i].exang > 0)
				pops[i][9] = 1;
			if (heart[i].oldpeak >= 2.0)
				pops[i][10] = 1;
			if (heart[i].slope <= 1)
				pops[i][11] = 1;
			if (heart[i].ca >= 1)
				pops[i][12] = 1;
			if (heart[i].thal != 2 && heart[i].thal != 0)
				pops[i][13] = 1;

		}

	}

	public static void createBinary(int n) {
		binary = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder("");

			sb.append(pops[i][10]);
			sb.append(pops[i][9]);
			sb.append(pops[i][3]);
			sb.append(pops[i][8]);
			sb.append(pops[i][12]);
			sb.append(pops[i][11]);
			sb.append(pops[i][13]);
			sb.append(pops[i][2]);
			sb.append(pops[i][1]);
			sb.append(pops[i][7]);
			sb.append(pops[i][4]);
			sb.append(pops[i][5]);
			sb.append(pops[i][6]);
			binary[i] = sb.toString();
		}
	}

	public static void decimals(int n) {
		int i = 0;
		decimal = new int[n];
		for (String s : binary) {
			decimal[i++] = Integer.parseInt(s, 2);
		}
	}

	public static void printPopValue() {
		System.out.println("Calculated PopCount values ");
		for (int value : decimal) {
			System.out.printf("%d\t", value);
		}
	}

	public static void accuracy(Heart[] heart) {
		int count = 0;
		int val = 0;
		for (int i = 0; i < heart.length; i++) {
			val = 0;
			if (decimal[i] < 1210)
				val = 1;
			if (heart[i].num == val)
				count++;
		}
		System.out.printf("\nAccuracy using Pop Count method is %d percent\n", (count * 100) / heart.length);
	}

}
