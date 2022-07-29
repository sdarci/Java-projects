public class Program {

	private static Long finalResult = 0L;

	public static void main (String [] args) throws Exception{

		Integer arraySize = 0;

		Integer thrdCount = 0;

		Integer tmp = 0;

		int firstIndex = 0;

		int withoutThrd = 0;

		if (args.length != 2) {
			throw new Exception("Error with args");
		}
		if (args[0].startsWith("--arraySize=")) {
			try {
				arraySize = Integer.parseInt(args[0].substring(12));
			} catch (Exception e0) {
				System.err.println("CANT PARSE T0 INT)");
				System.exit(1);
			}

			if (arraySize > 2000000) {
				throw new Exception("Maximum number of array elements is 2,000,000");
			}
		} else {
			throw new Exception("No --arraySize=");
		}

		if (args[1].startsWith("--threadsCount=")) {
			try {
				thrdCount = Integer.parseInt(args[1].substring(15));
			} catch (Exception e0) {
				System.err.println("CANT PARSE T0 INT)");
				System.exit(1);
			}

			if (thrdCount > arraySize) {
				throw new Exception("Maximum number of threads is no greater than current number of array elements");
			}
		} else {
			throw new Exception("No --threadsCount=");
		}
		if (arraySize < 1) {
			throw new Exception("Invalid args ");
		}
		if (thrdCount < 1) {
			throw new Exception("Invalid args ");
		}

		short [] arr = generateArr(arraySize);

		for (int i = 0; i < arr.length; i++) {
			withoutThrd += arr[i];
		}

		System.out.println("Sum: " + withoutThrd);

		MathThreads [] Thrds = new MathThreads[thrdCount];
		
		if (arraySize % thrdCount == 0) {
			tmp = arraySize / thrdCount;
		} else if (arraySize % (thrdCount - 1) != 0) {
			tmp = arraySize / (thrdCount - 1);
		} else if (arraySize % (thrdCount - 1) == 0) {
			tmp = (arraySize / (thrdCount - 1))- 1;
		}
		for (int i = 0; i < thrdCount - 1; ++i) {
			Thrds[i] = new MathThreads(arr, firstIndex , tmp + firstIndex - 1, i);
			firstIndex += tmp;
		}
		Thrds[thrdCount - 1] = new MathThreads(arr, firstIndex, arr.length - 1, thrdCount - 1);
		for (int counter = 0; counter < thrdCount; ++counter) {
			Thrds[counter].start();
		}

		try {
			for (int i = 0; i < thrdCount; i++) {
				Thrds[i].join();
			}
		} catch (Exception e) {
			throw new Exception("err");
		}

		for (int i = 0; i < thrdCount; i++) {
			finalResult += Thrds[i].getResult();
		}

		System.out.println("Sum by threads = " + finalResult );
	}

	private static  short [] generateArr(Integer arr) {
		short [] array = new short[arr];
		while (arr > 0) {
			array[--arr] = (short)(Math.random() * (2 * 1000) - 1000);//1 ;//(short)(Math.random() * (2 * 1000) - 1000);
		}
		return array;
	}
}
