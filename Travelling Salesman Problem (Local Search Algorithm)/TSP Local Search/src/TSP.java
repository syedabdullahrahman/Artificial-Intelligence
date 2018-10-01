
import java.io.File;
import java.util.Scanner;

public class TSP {

    double x[], y[];
    int n;

    public TSP(double x[], double y[], int n) {
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
        this.n = n;

    }

    private SolutionInfo solve(int sigma) {
        // TODO Auto-generated method stub
        Route route = new Route(this);
        //System.out.print("Started Route :");
        //route.print();

        FirstChoiceHillClimb fchc = new FirstChoiceHillClimb(this, sigma);
        SolutionInfo si = fchc.run();
        return si;
        //System.out.println("Cost :"+si.solution.getCost());
        //System.out.println("Count : "+si.loopCount);
        //System.out.print("Solution Route : ");
        //si.solution.print();
    }

    void print() {
        System.out.println("Dimension: " + n);
        for (int i = 0; i < n; i++) {
            System.out.println(x[i] + " " + y[i]);
        }
    }

    /**
     * Returns the distance between the node a and b
     *
     * @param a
     * @param b
     * @return
     */
    public double edgeCost(int a, int b) {
        return Math.sqrt(((x[a] - x[b]) * (x[a] - x[b])) + ((y[a] - y[b]) * (y[a] - y[b])));
    }

    public static void main(String[] args) {
        try {
//            File f = new File("test.tsp");
//            File f = new File("att48.tsp");
//            File f = new File("burma14.tsp");
//            File f = new File("st70.tsp");
//            File f = new File("ulysses16.tsp");
            File f = new File("ulysses22.tsp");
            Scanner in = new Scanner(f);

            String line = "";
            int n;

            //three comment lines
            in.nextLine();
            in.nextLine();
            in.nextLine();
            //get n
            line = in.nextLine();
            line = line.substring(11).trim();
            n = Integer.parseInt(line);

            System.out.println("" + n);

            //two comment lines
            in.nextLine();
            in.nextLine();

            double x[] = new double[n];
            double y[] = new double[n];

            for (int i = 0; i < n; i++) {
                in.nextInt();
                x[i] = in.nextDouble();
                y[i] = in.nextDouble();
            }

            TSP tsp = new TSP(x, y, n);
            //tsp.print();
            double avgcost = 0, cost = 999999999, mincost = 999999999;
            int count = 0;
            for (int i = 0, j = 2000; i < 10; i++, j += 1000) {
                SolutionInfo si = tsp.solve(j);
                avgcost += si.solution.getCost();
                mincost = Double.min(si.solution.getCost(), cost);
                count += si.loopCount;
            }
            System.out.println("Problem Instance: [" +f.getName()+ "] Avg Count: [" + count / 10 + "] Avg Cost: [" + avgcost / 10 + "] Min Cost: [" + mincost+"]");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
