
import java.util.ArrayList;

public class Or_Opt {

    public static Route apply(Route rt) {
        int n = rt.n;
        for (int chain_size = 3; chain_size >= 1; chain_size--) {
            for (int i = 0; i + chain_size < n; i++) {
                //ArrayList<Integer> chain = new ArrayList<>(rt.route.subList(i-1, i-1+chain_size-1));
                Route chain = new Route(rt);

                chain.route = new ArrayList<Integer>(rt.route.subList(i, i + chain_size ));

                //ArrayList<Integer> tmp_route=new ArrayList<>(rt.route);
                Route tmp_route = new Route(rt);
                for (int j = i, t = 0; t < chain_size; j++, t++) {
                    tmp_route.route.remove(j-t);
                }
                
                int nn = tmp_route.route.size();
                for (int j = 0; j < nn; j++) {
                    //ArrayList<Integer> new_route = new ArrayList<>(tmp_route);
                    Route new_route = new Route(tmp_route);

                    for (int x = 0, pos = j; x < chain.route.size(); x++, pos++) {
                        new_route.route.add(pos, chain.route.get(x));
                    }
                    
                    new_route.updateCost();
                    if (new_route.getCost() < rt.getCost()) {
                        return new Route(new_route);
                    }

                }

            }
        }

        return rt;
    }
}
