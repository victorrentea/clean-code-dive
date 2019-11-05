package cleancode;

import java.util.List;

@SuppressWarnings("all")
public class BouleanParameters {

	public static void main(String[] args) {
		// The method is called from various foreign places in the codebase
		bigUglyMethod(1, 2);
		bigUglyMethod(1, 2);
		bigUglyMethod(1, 2);
		bigUglyMethod(1, 2);
		bigUglyMethod(1, 2);

		// TODO From my use-case 323, I call it too, to do more within:
		bigUglyMethod323(1, 2);

	}

	static void bigUglyMethod(int a, int b) {
		pre();
		post();
	}
	static void bigUglyMethod323(int a, int b) {
		pre();
		System.out.println("This too for US323");
		post();
	}

	private static void post() {
		System.out.println("More Complex Logic");
		System.out.println("More Complex Logic");
		System.out.println("More Complex Logic");
	}

	private static void pre() {
		System.out.println("Complex Logic");
		System.out.println("Complex Logic");
		System.out.println("Complex Logic");
	}

	// ============== "BOSS" LEVEL: Deeply nested. A lot harder to break down =================

	static int bossLevelStuffFluff323(List<Integer> tasks) {
		int i = 0;
		int j = 1;
		System.out.println("Logic1");
		System.out.println("Logic2");
		if (tasks == null) {
			return -1;
		}
		System.out.println("Logic3");
		for (int task : tasks) {
			i += task * i;
			System.out.println("Logic4 " + task);
			// TODO HERE, when call this method, I want MY own custom code to run here
			System.out.println("Logic5 " + i);
		}
		System.out.println("Logic6 " + j++);
		return i;
	}
	static int bossLevelStuffFluff(List<Integer> tasks) {
		int i = 0;
		int j = 1;
		System.out.println("Logic1");
		System.out.println("Logic2");
		if (tasks == null) {
			return -1;
		}
		System.out.println("Logic3");
		for (int task : tasks) {
			i += task * i;
			System.out.println("Logic4 " + task);
			System.out.println("Logic5 " + i);
		}
		System.out.println("Logic6 " + j++);
		return i;
	}
	static int bossLevelStuffNoFluff(List<Integer> tasks) {
		int i = 0;
		int j = 1;
		System.out.println("Logic1");
		System.out.println("Logic2");
		System.out.println("Logic7");
		return i;
	}
	static int bossLevelNoStuff(boolean fluff, List<Integer> tasks) {
		int i = 0;
		int j = 1;
		System.out.println("Logic1");
		System.out.println("Logic7");
		return i;
	}
}
