/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Syed Abdullah
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    Queue<State> Q;
    HashSet<String> visited;

    LinkedList<ArrayList<String>> paths;
    ArrayList<String> shortest_path;

    public BFS() {
        Q = new LinkedList<>();
        visited = new HashSet<>();
        paths = new LinkedList<>();
    }

    public void printPath() {
        //print the shortest_path
        for (String s : shortest_path) {
            System.out.println(s);
        }
    }

    public void start(State start) {
        Q.add(start);

        //for shortest_path
        ArrayList<String> r = new ArrayList<>();
        r.add(start.toString());
        paths.add(r);
        //-----------------

        visited.add(start.toString());
        while (Q.size() != 0) {
            State u = Q.poll();				// for edge (u,v), get u
            shortest_path = paths.poll();	//get equivalent shortest_path

            if (u.toString().equals("||321")) {
                return;
            }

            ArrayList<State> v_list = u.generateNextState();

            for (Iterator<State> iterator = v_list.iterator(); iterator.hasNext();) {
            State next = iterator.next();
                if (visited.contains(next.toString())) {
                    continue;
                }
                if (next.isIllegalState()) {
                    continue;
                }

                visited.add(next.toString());
                Q.add(next);

                //for shortest_path
                ArrayList<String> r1 = new ArrayList<>(shortest_path);
                r1.add(next.toString());
                paths.add(r1);
            }
        }
    }
}
