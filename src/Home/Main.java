package Home;

public class Main {
	// main method
	public static void main(String[] args) {
		Heart[] heart = Dataset.input();
		int noOfDataset = heart.length;

		PopCount.assignPops(heart, noOfDataset); // Assigning pops
		PopCount.createBinary(noOfDataset); // Create Binary using pops
		PopCount.decimals(noOfDataset); // Convert binary to decimals
		PopCount.printPopValue(); // printing pop values


		Fuzzy.weightAssign(heart, noOfDataset); // assigning weights
		Fuzzy.FuzzyWeightAssign(heart); // Assigning fuzzy weights
		Fuzzy.printWeight(); // print weights
		PopCount.accuracy(heart); // printing accuracy by pop count method
		Fuzzy.accuracy(heart); // print accuracy by fuzzy methods

	}

}
