package pan_cake;

import java.util.Scanner;

public class Driver {

    public static int Total_Pan_Cake = 5;

    public static void main(String[] args) {

        System.out.println("Give Input Pan Cake Order: ");
        int arr[] = new int[Total_Pan_Cake];
        int temp;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < Total_Pan_Cake; i++) {
            temp = input.nextInt();
            arr[i] = temp;
        }
        State start = new State(arr);
        System.out.println("Starting: "+ start.toString());
        for (int i = 0; i < Total_Pan_Cake; i++) {
            arr[i] =i+1;
        }
        State goal = new State(arr);
        System.out.println("Goal: "+goal.toString());
        Solver solver = new Solver();
        solver.solve(start,goal);
        System.out.println(start.toString());
    }
}
