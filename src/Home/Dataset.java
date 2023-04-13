package Home;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Dataset {

	public static Heart[] input() {
		File file = new File("heart.csv");
		Heart[] heart = new Heart[1024];
		for (int j = 0; j < heart.length; j++)
			heart[j] = new Heart();
		// reading data-set from file
		try {

			Scanner scanner = new Scanner(file);
			scanner.nextLine();

			int i = 0;
			while (i < heart.length) {
				String line = scanner.nextLine();
				String[] data = line.split("[,]", 0);

				heart[i].id = Integer.valueOf(data[0]);
				heart[i].age = Integer.valueOf(data[1]);
				heart[i].sex = Integer.valueOf(data[2]);
				heart[i].cp = Integer.valueOf(data[3]);
				heart[i].trestbps = Integer.valueOf(data[4]);
				heart[i].chol = Integer.valueOf(data[5]);
				heart[i].fbs = Integer.valueOf(data[6]);
				heart[i].restecg = Integer.valueOf(data[7]);
				heart[i].thalch = Integer.valueOf(data[8]);
				heart[i].exang = Integer.valueOf(data[9]);
				heart[i].oldpeak = Double.parseDouble(data[10]);
				heart[i].slope = Integer.valueOf(data[11]);
				heart[i].ca = Integer.valueOf(data[12]);
				heart[i].thal = Integer.valueOf(data[13]);
				heart[i].num = Integer.valueOf(data[14]);
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.getAbsolutePath());
		}
		return heart;
	}
}
