package Program4;

public class BagCollectionDemo1 {

	public static void main(String[] args) {
		BagInterface<String> fruits = new BagSortedArrayCollection<String>();
		int score = 0, testNumber = 0;

		System.out.println("Testing BagSortedArrayCollection.java");
		// Test 1 Initial
		if (fruits.grab() == null && fruits.count("Apple") == 0 && fruits.removeAll("Apple") == 0)
			score += 10;
		else
			System.out.println("Test 1 Expected: null, Acutal: " + fruits.grab());

		nextTest(score, ++testNumber);

		// Test 2 Grab
		fruits.add("Apple");
		fruits.add("Orange");

		boolean apple = false, orange = false;
		int loop = fruits.size();
		for (int i = 0; i < loop; i++) {
			String temp = fruits.grab().toString();
			if (temp.equalsIgnoreCase("Apple"))
				apple = true;
			else if (temp.equalsIgnoreCase("Orange"))
				orange = true;
		}

		if (apple && orange && fruits.size() == 0 && fruits.grab() == null)
			score += 10;
		else
			System.out.println("Test 2 Check grab()");

		nextTest(score, ++testNumber);

		// Test 3 count(target)
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Pineapple");
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Strawberry");
		int count = fruits.count("Apple");

		if (fruits.count("Apple") == 2 && fruits.size() == 6)
			score += 10;
		else
			System.out.println("Test 3 Check count(target)");

		nextTest(score, ++testNumber);

		// Test 4 removeAll(target)
		fruits.removeAll("Apple");
		if (!fruits.contains("Apple") && fruits.size() == 4)
			score += 10;
		else
			System.out.println("Test 4 Check removeAll(target)");

		nextTest(score, ++testNumber);

		// Test 5 clear()
		fruits.clear();
		if (fruits.size() == 0 && !fruits.contains("Orange"))
			score += 10;
		else
			System.out.println("Test 5 Check clear()");

		nextTest(score, ++testNumber);

		// Test 6 toString()
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Pineapple");
		if (fruits.toString().trim().equalsIgnoreCase("Apple\nOrange\nPineapple"))
			score += 10;
		else
			System.out.println("Test 6 Check toString()");

		nextTest(score, ++testNumber);
	}

	private static void nextTest(int score, int testCaseNumber) {
		if (score / testCaseNumber == 10)
			System.out.printf("Test #%d passed. Your score is %d/60.\n", testCaseNumber, score);
		else {
			System.out.printf("Test #%d failed. Your score is %d/60.\n", testCaseNumber, score);
			System.out.printf("Check test #%d\n", testCaseNumber);
			System.exit(0);
		}
	}
}
