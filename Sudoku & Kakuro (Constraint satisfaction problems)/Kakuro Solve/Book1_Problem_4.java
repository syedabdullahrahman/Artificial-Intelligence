/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constarint.satisfaction.problem;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class Book1_Problem_4 {

    public static void main(String[] args) {

        int i, j, k;

// 1. Create a Model
        Model model = new Model("Book 1 Problem No. 4");
// 2. Create variables

        /* kakuro board which is 6 X 6 for this problm */
 /* we assume (0, 0) is the top left position */
 /* and (5, 5) is the bottom right position */
        IntVar[][] bd = model.intVarMatrix("bd", 6, 6, 0, 9);

// 3. Post constraints
        /* posting constraints for horizontal sums */
 /* a total of 6 horizontal sum clues for this problem */
        IntVar[] r0 = model.intVarArray("r0", 3, 1, 9);
        IntVar[] r1 = model.intVarArray("r1", 4, 1, 9);
        IntVar[] r2 = model.intVarArray("r2", 2, 1, 9);
        IntVar[] r3 = model.intVarArray("r3", 2, 1, 9);
        IntVar[] r4 = model.intVarArray("r4", 4, 1, 9);
        IntVar[] r5 = model.intVarArray("r5", 3, 1, 9);

        /* posting constraints for vertical */
 /* a total of 6 vertical sum clues for this problem */
        IntVar[] c0 = model.intVarArray("c0", 3, 1, 9);
        IntVar[] c1 = model.intVarArray("c1", 4, 1, 9);
        IntVar[] c2 = model.intVarArray("c2", 2, 1, 9);
        IntVar[] c3 = model.intVarArray("c3", 2, 1, 9);
        IntVar[] c4 = model.intVarArray("c4", 4, 1, 9);
        IntVar[] c5 = model.intVarArray("c5", 3, 1, 9);

        /* initializing the kakuro board */
 /* assign zero to all null positions or black cells and also for clue cells*/
        for (j = 0; j < 6; j++) {
            model.arithm(bd[0][j], "=", 0).post();
        }

        model.arithm(bd[1][0], "=", 0).post();
        for (j = 1; j < 4; j++) {
            model.arithm(bd[1][j], ">", 0).post();
        }
        model.arithm(bd[1][4], "=", 0).post();
        model.arithm(bd[1][5], "=", 0).post();

        model.arithm(bd[2][0], "=", 0).post();
        for (j = 1; j < 5; j++) {
            model.arithm(bd[2][j], ">", 0).post();
        }
        model.arithm(bd[2][5], "=", 0).post();

        model.arithm(bd[3][0], "=", 0).post();
        for (j = 1; j < 3; j++) {
            model.arithm(bd[3][j], ">", 0).post();
        }
        model.arithm(bd[3][3], "=", 0).post();
        for (j = 4; j < 6; j++) {
            model.arithm(bd[3][j], ">", 0).post();
        }

        model.arithm(bd[4][0], "=", 0).post();
        model.arithm(bd[4][1], "=", 0).post();
        for (j = 2; j < 6; j++) {
            model.arithm(bd[4][j], ">", 0).post();
        }

        model.arithm(bd[5][0], "=", 0).post();
        model.arithm(bd[5][1], "=", 0).post();
        model.arithm(bd[5][2], "=", 0).post();
        for (j = 3; j < 6; j++) {
            model.arithm(bd[5][j], ">", 0).post();
        }

        /* posting constraints for associating the horizontal */
 /* sum variables with appropriate board positions */

 /* for example r0 [0] + r0 [1] = bd [1, 3] + bd [1, 4] = 15*/
        i = 0;
        for (j = 1; j < 4; j++) {
            model.arithm(bd[1][j], "=", r0[i]).post();
            i++;
        }

        i = 0;
        for (j = 1; j < 5; j++) {
            model.arithm(bd[2][j], "=", r1[i]).post();
            i++;
        }

        i = 0;
        for (j = 1; j < 3; j++) {
            model.arithm(bd[3][j], "=", r2[i]).post();
            i++;
        }

        i = 0;
        for (j = 4; j < 6; j++) {
            model.arithm(bd[3][j], "=", r3[i]).post();
            i++;
        }

        i = 0;
        for (j = 2; j < 6; j++) {
            model.arithm(bd[4][j], "=", r4[i]).post();
            i++;
        }

        i = 0;
        for (j = 3; j < 6; j++) {
            model.arithm(bd[5][j], "=", r5[i]).post();
            i++;
        }

        /* posting sum constraints for horizontal sums*/
        model.sum(r0, "=", 19).post();
        model.sum(r1, "=", 22).post();
        model.sum(r2, "=", 14).post();
        model.sum(r3, "=", 8).post();
        model.sum(r4, "=", 14).post();
        model.sum(r5, "=", 22).post();


        /* for second formulation */
        for (i = 0; i < 3; i++) {
            model.arithm(r0[i], ">", 1).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r2[i], ">", 4).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r3[i], "<", 8).post();
        }
        for (i = 0; i < 4; i++) {
            model.arithm(r4[i], "<", 9).post();
        }
        
        
        /* posting alldifferent constraints for horizontal sums */
        model.allDifferent(r0).post();
        model.allDifferent(r1).post();
        model.allDifferent(r2).post();
        model.allDifferent(r3).post();
        model.allDifferent(r4).post();
        model.allDifferent(r5).post();

        /* posting constraints for associating the vertical */
 /* sum variables with appropriate board positions */

 /* for example c0 [0] + c0 [1] = bd [1, 3] + bd [2, 3] = 17  */
        j = 0;
        for (i = 1; i < 4; i++) {
            model.arithm(bd[i][1], "=", c0[j]).post();
            j++;
        }

        j = 0;
        for (i = 1; i < 5; i++) {
            model.arithm(bd[i][2], "=", c1[j]).post();
            j++;
        }

        j = 0;
        for (i = 1; i < 3; i++) {
            model.arithm(bd[i][3], "=", c2[j]).post();
            j++;
        }

        j = 0;
        for (i = 4; i < 6; i++) {
            model.arithm(bd[i][3], "=", c3[j]).post();
            j++;
        }

        j = 0;
        for (i = 2; i < 6; i++) {
            model.arithm(bd[i][4], "=", c4[j]).post();
            j++;
        }

        j = 0;
        for (i = 3; i < 6; i++) {
            model.arithm(bd[i][5], "=", c5[j]).post();
            j++;
        }


        /* posting sum constraints for vertical sums*/
        model.sum(c0, "=", 24).post();
        model.sum(c1, "=", 11).post();
        model.sum(c2, "=", 12).post();
        model.sum(c3, "=", 17).post();
        model.sum(c4, "=", 27).post();
        model.sum(c5, "=", 8).post();


        /* for second formulation */
        for (i = 0; i < 3; i++) {
            model.arithm(c0[i], ">", 6).post();
        }
        for (i = 0; i < 4; i++) {
            model.arithm(c1[i], "<", 6).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c2[i], ">", 2).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c3[i], ">", 7).post();
        }
        for (i = 0; i < 4; i++) {
            model.arithm(c4[i], ">", 2).post();
        }
        for (i = 0; i < 3; i++) {
            model.arithm(c5[i], "<", 6).post();
        }
        /* posting alldifferent constraints for vertical sums */
        model.allDifferent(c0).post();
        model.allDifferent(c1).post();
        model.allDifferent(c2).post();
        model.allDifferent(c3).post();
        model.allDifferent(c4).post();
        model.allDifferent(c5).post();

// 4. Solve the problem
        Solver solver = model.getSolver();
        solver.showStatistics();
        solver.showSolutions();
        solver.findSolution();

// 5. Print the solution
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                //System.out.print(vs [i][j]); 
                System.out.print(" ");
                k = bd[i][j].getValue();
                System.out.print(k);
                // System.out.print(vs [0][1]); System.out.print(" "); 
                //System.out.print(vs [0][2]); System.out.print(" ");
            }
            System.out.println();
        }

    }

}
