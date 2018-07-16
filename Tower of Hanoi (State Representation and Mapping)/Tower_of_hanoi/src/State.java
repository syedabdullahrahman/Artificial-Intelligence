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

public class State {

    private StringBuilder[] stick = new StringBuilder[3];

    public State(String a, String b, String c) {
        stick[0] = new StringBuilder(a);
        stick[1] = new StringBuilder(b);
        stick[2] = new StringBuilder(c);
    }

    public ArrayList<State> generateNextState() {
        ArrayList<State> ret = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (stick[i].length() > 0) {
                for (int j = 0; j <3; j++) {
                    State tmp = new State(stick[0].toString(), stick[1].toString(), stick[2].toString());
                    if (i == j) {
                        continue;
                    } else {
                        try {
                            tmp.stick[j].append(stick[i].charAt(stick[i].length() - 1));
                            tmp.stick[i].deleteCharAt(stick[i].length() - 1);
                        } catch (Exception e) {
                        }
                        ret.add(tmp);
                    }
                }
            }
        }
        return ret;
    }

    public boolean isIllegalState() {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < stick[i].length(); j++) {
                if (stick[i].charAt(j - 1) < stick[i].charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String toString() {
        return stick[0] + "|" + stick[1] + "|" + stick[2];
    }
}