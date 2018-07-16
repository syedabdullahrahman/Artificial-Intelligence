/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constarint.satisfaction.problem;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class Book2_Problem_4 {

    public static void main(String[] args) {

        int i, j, k;

// 1. Create a Model
        Model model = new Model("Book 2 Problem No. 4");
// 2. Create variables

        /* kakuro board which is 6 X 6 for this problm */
 /* we assume (0, 0) is the top left position */
 /* and (5, 5) is the bottom right position */
        IntVar[][] bd = model.intVarMatrix("bd", 9, 9, 0, 9);

// 3. Post constraints
        /* posting constraints for horizontal sums */
 /* a total of 6 horizontal sum clues for this problem */
        IntVar[] r = model.intVarArray("r", 3, 1, 9);
        IntVar[] r0 = model.intVarArray("r0", 2, 1, 9);
        IntVar[] r1 = model.intVarArray("r1", 4, 1, 9);
        IntVar[] r2 = model.intVarArray("r2", 2, 1, 9);
        IntVar[] r3 = model.intVarArray("r3", 2, 1, 9);
        IntVar[] r4 = model.intVarArray("r4", 3, 1, 9);
        IntVar[] r5 = model.intVarArray("r5", 2, 1, 9);
        IntVar[] r6 = model.intVarArray("r6", 2, 1, 9);
        IntVar[] r7 = model.intVarArray("r7", 2, 1, 9);
        IntVar[] r8 = model.intVarArray("r8", 2, 1, 9);
        IntVar[] r9 = model.intVarArray("r9", 3, 1, 9);
        IntVar[] r10 = model.intVarArray("r10", 2, 1, 9);
        IntVar[] r11 = model.intVarArray("r11", 2, 1, 9);
        IntVar[] r12 = model.intVarArray("r12", 4, 1, 9);
        IntVar[] r13 = model.intVarArray("r13", 2, 1, 9);
        IntVar[] r14 = model.intVarArray("r14", 3, 1, 9);

        /* posting constraints for vertical */
 /* a total of 6 vertical sum clues for this problem */
        IntVar[] c0 = model.intVarArray("c0", 2, 1, 9);
        IntVar[] c1 = model.intVarArray("c1", 2, 1, 9);
        IntVar[] c2 = model.intVarArray("c2", 7, 1, 9);
        IntVar[] c3 = model.intVarArray("c3", 2, 1, 9);
        IntVar[] c4 = model.intVarArray("c4", 2, 1, 9);
        IntVar[] c5 = model.intVarArray("c5", 2, 1, 9);
        IntVar[] c6 = model.intVarArray("c6", 3, 1, 9);
        IntVar[] c7 = model.intVarArray("c7", 3, 1, 9);
        IntVar[] c8 = model.intVarArray("c8", 2, 1, 9);
        IntVar[] c9 = model.intVarArray("c9", 2, 1, 9);
        IntVar[] c10 = model.intVarArray("c10", 2, 1, 9);
        IntVar[] c11 = model.intVarArray("c11", 7, 1, 9);
        IntVar[] c12 = model.intVarArray("c12", 2, 1, 9);
        IntVar[] c13 = model.intVarArray("c13", 2, 1, 9);


        /* initializing the kakuro board */
 /* assign zero to all null positions or black cells and also for clue cells*/
        for (j = 0; j < 9; j++) {
            model.arithm(bd[0][j], "=", 0).post();
        }

        for (j = 0; j < 3; j++) {
            model.arithm(bd[1][j], "=", 0).post();
        }
        for (j = 3; j < 6; j++) {
            model.arithm(bd[1][j], ">", 0).post();
        }
        model.arithm(bd[1][6], "=", 0).post();
        for (j = 7; j < 9; j++) {
            model.arithm(bd[1][j], ">", 0).post();
        }

        model.arithm(bd[2][0], "=", 0).post();
        model.arithm(bd[2][1], "=", 0).post();
        for (j = 2; j < 6; j++) {
            model.arithm(bd[2][j], ">", 0).post();
        }
        model.arithm(bd[2][6], "=", 0).post();
        for (j = 7; j < 9; j++) {
            model.arithm(bd[2][j], ">", 0).post();
        }

        model.arithm(bd[3][0], "=", 0).post();
        for (j = 1; j < 3; j++) {
            model.arithm(bd[3][j], ">", 0).post();
        }
        model.arithm(bd[3][3], "=", 0).post();
        model.arithm(bd[3][4], "=", 0).post();
        for (j = 5; j < 8; j++) {
            model.arithm(bd[3][j], ">", 0).post();
        }
        model.arithm(bd[3][8], "=", 0).post();

        model.arithm(bd[4][0], "=", 0).post();
        for (j = 1; j < 2; j++) {
            model.arithm(bd[4][j], ">", 0).post();
        }
        for (j = 3; j < 6; j++) {
            model.arithm(bd[4][j], "=", 0).post();
        }
        for (j = 6; j < 8; j++) {
            model.arithm(bd[4][j], ">", 0).post();
        }
        model.arithm(bd[4][8], "=", 0).post();

        model.arithm(bd[5][0], "=", 0).post();
        model.arithm(bd[5][1], "=", 0).post();
        for (j = 2; j < 4; j++) {
            model.arithm(bd[5][j], ">", 0).post();
        }
        for (j = 4; j < 7; j++) {
            model.arithm(bd[5][j], "=", 0).post();
        }
        for (j = 7; j < 9; j++) {
            model.arithm(bd[5][j], ">", 0).post();
        }

        model.arithm(bd[6][0], "=", 0).post();
        model.arithm(bd[6][1], "=", 0).post();
        for (j = 2; j < 5; j++) {
            model.arithm(bd[6][j], ">", 0).post();
        }
        for (j = 5; j < 7; j++) {
            model.arithm(bd[6][j], "=", 0).post();
        }
        for (j = 7; j < 9; j++) {
            model.arithm(bd[6][j], ">", 0).post();
        }


        /* posting constraints for associating the horizontal */
 /* sum variables with appropriate board positions */

 /* for example r0 [0] + r0 [1] = bd [1, 3] + bd [1, 4] = 15*/
        i = 0;
        for (j = 3; j < 6; j++) {
            model.arithm(bd[1][j], "=", r[i]).post();
            i++;
        }
        i = 0;
        for (j = 7; j < 9; j++) {
            model.arithm(bd[1][j], "=", r0[i]).post();
            i++;
        }
        i = 0;
        for (j = 2; j < 6; j++) {
            model.arithm(bd[2][j], "=", r1[i]).post();
            i++;
        }
        i = 0;
        for (j = 7; j < 9; j++) {
            model.arithm(bd[2][j], "=", r2[i]).post();
            i++;
        }
        i = 0;
        for (j = 1; j < 3; j++) {
            model.arithm(bd[3][j], "=", r3[i]).post();
            i++;
        }
        i = 0;
        for (j = 5; j < 8; j++) {
            model.arithm(bd[3][j], "=", r4[i]).post();
            i++;
        }

        i = 0;
        for (j = 1; j < 3; j++) {
            model.arithm(bd[4][j], "=", r5[i]).post();
            i++;
        }

        i = 0;
        for (j = 6; j < 8; j++) {
            model.arithm(bd[4][j], "=", r6[i]).post();
            i++;
        }

        i = 0;
        for (j = 2; j < 4; j++) {
            model.arithm(bd[5][j], "=", r7[i]).post();
            i++;
        }

        i = 0;
        for (j = 7; j < 9; j++) {
            model.arithm(bd[5][j], "=", r8[i]).post();
            i++;
        }
        i = 0;
        for (j = 2; j < 5; j++) {
            model.arithm(bd[6][j], "=", r9[i]).post();
            i++;
        }
        i = 0;
        for (j = 7; j < 9; j++) {
            model.arithm(bd[6][j], "=", r10[i]).post();
            i++;
        }
        i = 0;
        for (j = 1; j < 3; j++) {
            model.arithm(bd[7][j], "=", r11[i]).post();
            i++;
        }
        i = 0;
        for (j = 4; j < 8; j++) {
            model.arithm(bd[7][j], "=", r12[i]).post();
            i++;
        }
        i = 0;
        for (j = 1; j < 3; j++) {
            model.arithm(bd[8][j], "=", r13[i]).post();
            i++;
        }
        i = 0;
        for (j = 4; j < 7; j++) {
            model.arithm(bd[8][j], "=", r14[i]).post();
            i++;
        }

        /* posting sum constraints for horizontal sums*/
         model.sum(r, "=", 23).post();
        model.sum(r0, "=", 17).post();
        model.sum(r1, "=", 15).post();
        model.sum(r2, "=", 6).post();
        model.sum(r3, "=", 5).post();
        model.sum(r4, "=", 17).post();
        model.sum(r5, "=", 14).post();
        model.sum(r6, "=", 13).post();
        model.sum(r7, "=", 5).post();
        model.sum(r8, "=", 8).post();
        model.sum(r9, "=", 8).post();
        model.sum(r10, "=", 4).post();
        model.sum(r11, "=", 4).post();
        model.sum(r12, "=", 12).post();
        model.sum(r13, "=", 17).post();
        model.sum(r14, "=", 19).post();



        /* for second formulation */
        for (i = 0; i < 3; i++) {
            model.arithm(r[i], ">", 5).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r0[i], ">", 7).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r2[i], "<", 6).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r3[i], "<", 5).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r5[i], ">", 4).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r6[i], ">", 3).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r7[i], "<", 5).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r8[i], "<", 8).post();
        }
        for (i = 0; i < 3; i++) {
            model.arithm(r9[i], "<", 6).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r10[i], "<", 4).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r11[i], "<", 4).post();
        }
        for (i = 0; i < 4; i++) {
            model.arithm(r12[i], "<", 7).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r13[i], ">", 7).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(r14[i], ">", 2).post();
        }
        
//        for (i = 0; i < 2; i++) {
//            model.arithm(r5[i], ">", 6).post();
//        }

        /* posting alldifferent constraints for horizontal sums */
        model.allDifferent(r).post();
        model.allDifferent(r0).post();
        model.allDifferent(r1).post();
        model.allDifferent(r2).post();
        model.allDifferent(r3).post();
        model.allDifferent(r4).post();
        model.allDifferent(r5).post();
        model.allDifferent(r6).post();
        model.allDifferent(r7).post();
        model.allDifferent(r8).post();
        model.allDifferent(r9).post();
        model.allDifferent(r10).post();
        model.allDifferent(r11).post();
        model.allDifferent(r12).post();
        model.allDifferent(r13).post();
        model.allDifferent(r14).post();

        /* posting constraints for associating the vertical */
 /* sum variables with appropriate board positions */

 /* for example c0 [0] + c0 [1] = bd [1, 3] + bd [2, 3] = 17  */
        j = 0;
        for (i = 3; i < 5; i++) {
            model.arithm(bd[i][1], "=", c0[j]).post();
            j++;
        }
        j = 0;
        for (i = 7; i < 9; i++) {
            model.arithm(bd[i][1], "=", c1[j]).post();
            j++;
        }
        j = 0;
        for (i = 2; i < 9; i++) {
            model.arithm(bd[i][2], "=", c2[j]).post();
            j++;
        }
        j = 0;
        for (i = 1; i < 3; i++) {
            model.arithm(bd[i][3], "=", c3[j]).post();
            j++;
        }
        j = 0;
        for (i = 5; i < 7; i++) {
            model.arithm(bd[i][3], "=", c4[j]).post();
            j++;
        }
        j = 0;
        for (i = 1; i < 3; i++) {
            model.arithm(bd[i][4], "=", c5[j]).post();
            j++;
        }

        j = 0;
        for (i = 6; i < 9; i++) {
            model.arithm(bd[i][4], "=", c6[j]).post();
            j++;
        }

        j = 0;
        for (i = 1; i < 4; i++) {
            model.arithm(bd[i][5], "=", c7[j]).post();
            j++;
        }

        j = 0;
        for (i = 7; i < 9; i++) {
            model.arithm(bd[i][5], "=", c8[j]).post();
            j++;
        }

        j = 0;
        for (i = 3; i < 5; i++) {
            model.arithm(bd[i][6], "=", c9[j]).post();
            j++;
        }

        j = 0;
        for (i = 7; i < 9; i++) {
            model.arithm(bd[i][6], "=", c10[j]).post();
            j++;
        }
        j = 0;
        for (i = 1; i < 8; i++) {
            model.arithm(bd[i][7], "=", c11[j]).post();
            j++;
        }
        j = 0;
        for (i = 1; i < 3; i++) {
            model.arithm(bd[i][8], "=", c12[j]).post();
            j++;
        }
        j = 0;
        for (i = 5; i < 7; i++) {
            model.arithm(bd[i][8], "=", c13[j]).post();
            j++;
        }


        /* posting sum constraints for vertical sums*/
        model.sum(c0, "=", 11).post();
        model.sum(c1, "=", 11).post();
        model.sum(c2, "=", 30).post();
        model.sum(c3, "=", 9).post();
        model.sum(c4, "=", 3).post();
        model.sum(c5, "=", 8).post();
        model.sum(c6, "=", 14).post();
        model.sum(c7, "=", 24).post();
        model.sum(c8, "=", 11).post();
        model.sum(c9, "=", 7).post();
        model.sum(c10, "=", 3).post();
        model.sum(c11, "=", 40).post();
        model.sum(c12, "=", 11).post();
        model.sum(c13, "=", 5).post();



        /* for second formulation */
        for (i = 0; i < 2; i++) {
            model.arithm(c0[i], ">", 2).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c1[i], ">", 2).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c3[i], "<", 9).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c4[i], "<", 3).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c5[i], "<", 8).post();
        }

        for (i = 0; i < 3; i++) {
            model.arithm(c7[i], ">", 6).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c8[i], ">", 1).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c9[i], "<", 7).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c10[i], "<", 3).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c12[i], ">", 1).post();
        }
        for (i = 0; i < 2; i++) {
            model.arithm(c13[i], "<", 5).post();
        }

        
        /* posting alldifferent constraints for vertical sums */
        model.allDifferent(c0).post();
        model.allDifferent(c1).post();
        model.allDifferent(c2).post();
        model.allDifferent(c3).post();
        model.allDifferent(c4).post();
        model.allDifferent(c5).post();
        model.allDifferent(c6).post();
        model.allDifferent(c7).post();
        model.allDifferent(c8).post();
        model.allDifferent(c9).post();
        model.allDifferent(c10).post();
        model.allDifferent(c11).post();
        model.allDifferent(c12).post();
        model.allDifferent(c13).post();

// 4. Solve the problem
        Solver solver = model.getSolver();
        solver.showStatistics();
        solver.showSolutions();
        solver.findSolution();

// 5. Print the solution
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
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
