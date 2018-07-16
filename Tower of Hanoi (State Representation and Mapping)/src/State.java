
public class State {
	public int[] obj;
	
	public State()
	{
		obj = new int[4];
		obj[0] = obj[1] = obj[2] = obj[3] = 0;
	}
	public State(int wolf, int cabbage, int farmer, int goat) {
		obj = new int[4];
		obj[0] = wolf;
		obj[1] = cabbage;
		obj[2] = farmer;
		obj[3] = goat;
	}
	
	public State[] generateNextState()
	{
		State ret[] = new State[4];
		
                int v;
                if (obj[2] == 1)
                    v = 0;
                else
                    v = 1;
                
                ret[0] = new State(obj[0], obj[1], v, obj[3]);
                int idx = 1;
                for (int i = 0; i<=3; i++)
                {
                    State tmp = new State(obj[0], obj[1], obj[2], obj[3]);
                    if (i == 2)
                        continue;
                    if (obj[i]==obj[2])
                    {
                        tmp.obj[2] = v;
                        tmp.obj[i] = v;
                    }
                    else
                    {
                        tmp.obj[2] = v;
                    }
                    ret[idx] = tmp;
                    idx++;
                }
                
		
		return ret;
	}
	
	public boolean isIllegalState()
	{
		if (obj[0] == 0 && obj[3] == 0 && obj[2] == 1)
                    return true;
                if (obj[0] == 1 && obj[3] == 1 && obj[2] == 0)
                    return true;
                if (obj[3] == 0 && obj[1] == 0 && obj[2] == 1)
                    return true;
                if (obj[3] == 1 && obj[1] == 1 && obj[2] == 0)
                    return true;
                
		return false;
	}
	
	@Override
	public String toString() {
		return "" + obj[0] + obj[1] + obj[2] + obj[3];
	}
	
}
