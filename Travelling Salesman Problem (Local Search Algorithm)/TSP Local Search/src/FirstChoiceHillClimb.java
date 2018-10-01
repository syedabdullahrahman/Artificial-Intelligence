
import java.util.Random;

public class FirstChoiceHillClimb {

    TSP tsp;
    int sigma;

    public FirstChoiceHillClimb(TSP tsp, int sigma) {
        // TODO Auto-generated constructor stub
        this.tsp = tsp;
        this.sigma = sigma;
    }

    /**
     * Main loop of your local search algorithm. After the search is complete,
     * create a SolutionInfo Object with related information and return to the
     * caller to generate aggregated results
     *
     * @return
     */
    public SolutionInfo run() {
        //Main loop of your local search algorithm. 
        Route current = new Route(this.tsp);
        Route neighbor = new Route(this.tsp);
        int count = 0;
        while (true) {
            int i = 0;
            Random random = new Random(1);
            for (i = 0; i < sigma; i++) {
                double rnd = random.nextDouble();
                if (rnd < 0.5) {
                    neighbor = new Route(Or_Opt.apply(current));
                } else {
                    neighbor = new Route(OneOneExchange.apply(current));
                }
                if (neighbor.getCost() < current.getCost()) {
                    break;
                }
                
            }
            if (i == sigma) {
                SolutionInfo si = new SolutionInfo(current, count);
                return si;
            }
            current=neighbor;
            count++;
        }
    }
}
