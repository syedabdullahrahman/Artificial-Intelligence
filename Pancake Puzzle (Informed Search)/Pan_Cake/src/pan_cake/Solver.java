package pan_cake;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solver {

    private PriorityQueue<State> open_list;
    private HashSet<String> closed_list;
    public static int Total_Pan_Cake = 5;

    public Solver() {
        open_list = new PriorityQueue<State>();
        closed_list = new HashSet<String>();
    }

    public void solve(State start, State goal) {
        PriorityQueue<State> open_list = new PriorityQueue<State>(new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                if (o1.f_score() < o2.f_score()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        );
        start.g = 0;
        start.f = 0 + heuristic_1(start, goal);

        open_list.add(start);

        while (!open_list.isEmpty()) {
            State current = open_list.poll();
            if (current.equals(goal)) {
                System.out.println("Find an Solution");
                print_path(current);
            }
            closed_list.add(current.toString());
            ArrayList<State> v_list = current.genNextStates();
            for (Iterator<State> iterator = v_list.iterator(); iterator.hasNext();) {

                State next = iterator.next();
                next.parent = current;
                if (!closed_list.contains(next.toString())) {
                    next.f = 1 + heuristic_1(next, goal);
                    if (!open_list.contains(next)) {
                        open_list.add(next);
                    }
                }
            }
        }
    }

    public static int heuristic_1(State start, State goal) {
        int number = 0;
        for (int i = Total_Pan_Cake, j = 0; i > 1; i--, j++) {
            if (start.arr[i - 1] != i && start.arr[j] != i) {
                number += 2;
            } else {
                number++;
            }
        }
        return number;
    }

    public static int heuristic_2(State start, State goal) {
        return 1;
    }

    private void print_path(State current) {
        if(current.parent!=null)
        {
            System.out.println(current.toString());
            print_path(current.parent);
        }
    }
}
