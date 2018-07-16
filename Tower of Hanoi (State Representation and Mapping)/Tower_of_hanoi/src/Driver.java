/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Syed Abdullah
 */
public class Driver {
	public static void main(String[] args) throws CloneNotSupportedException {
		BFS bfs = new BFS();
		bfs.start(new State("321","",""));
		bfs.printPath();
		System.out.println("Done!");
	}
}
