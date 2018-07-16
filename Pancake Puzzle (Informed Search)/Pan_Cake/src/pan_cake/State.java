package pan_cake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class State {
    private static int Total_Pan_Cake = 5;
    public State parent;
    public int arr[];
    
    public int f;
    public int g;
    public int h;
    

    public State() {
        parent = null;
        arr = new int[Total_Pan_Cake];
    }

    public State(int temp[]) {
        parent = null;
        arr=new int[Total_Pan_Cake];
        System.arraycopy(temp, 0, arr, 0, Total_Pan_Cake);
    }

    public int f_score() {
        return f;
    }
    public int g_score(){
        return g;
    }
    public int h_score() {
        return h;
    }

    public boolean equals(State obj) {
        for(int i=0;i<Total_Pan_Cake;i++)
            if(arr[i]!=obj.arr[i]) return false;
        return true;
    }

    public ArrayList<State> genNextStates() {
        ArrayList<State> ret = new ArrayList<>();
        for (int t = 1; t < Total_Pan_Cake; t++) {
            State tmp_state = new State(this.arr);
            for (int i = 0; i <(t+1)/ 2; i++) {
                int temp = tmp_state.arr[i];
                tmp_state.arr[i] = tmp_state.arr[(t+1) - i - 1];
                tmp_state.arr[(t+1) - i - 1] = temp;
            }
            ret.add(tmp_state);
        }
        return ret;
    }

    public void printStack() {

    }

    @Override
    public String toString(){
        String temp = new String();
        for (int i=0;i<Total_Pan_Cake;i++)
            temp+=String.valueOf(arr[i]);
       return temp;
    }
}
