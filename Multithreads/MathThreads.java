public class MathThreads extends Thread {
	private Integer firstInd = 0;

	private Integer lastInd = 0;

	private Integer res = 0;

	private short [] array;

	private Integer identifier = 1;

	public MathThreads(short [] array, Integer firstIndex, Integer lastIndex, int name) {
		this.array = array;
		this.firstInd = firstIndex;
		this.lastInd = lastIndex;
		this.identifier+=name;
	}

	@Override
	public void run() {
		for (int cnt = firstInd; cnt < lastInd + 1; cnt++) {
			res += array[cnt];
		}
		System.out.println("Thread " + identifier + ": from " + firstInd + " to " + lastInd + " sum is " + res);
	}

	public long getResult() {
		return res;
	}
}
