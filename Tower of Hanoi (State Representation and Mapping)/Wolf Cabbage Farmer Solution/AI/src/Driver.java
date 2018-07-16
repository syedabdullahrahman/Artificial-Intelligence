
public class Driver {
	public static void main(String[] args) {
		BFS bfs = new BFS();
		bfs.start(new State());
		bfs.printPath();
		System.out.println("Done!");
	}
}
