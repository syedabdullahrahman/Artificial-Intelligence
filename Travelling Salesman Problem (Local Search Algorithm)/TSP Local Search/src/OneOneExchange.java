
import java.util.Random;

public class OneOneExchange {

    private static Random random = new Random(System.currentTimeMillis());

    public static Route apply(Route rt_temp) {
        Route rt = new Route(rt_temp);

        int r1 = random.nextInt(rt.n);
        int r2 = random.nextInt(rt.n);
        if (r1 == r2) {
            r2 = random.nextInt(rt.n);
        }
        int one = rt.route.get(r1);
        int two = rt.route.get(r2);
        rt.route.set(r1, two);
        rt.route.set(r2, one);

        rt.updateCost();
        return rt;
    }

}
