
import java.awt.event.ActionEvent;

public class MinimaxTTTAgent extends Agent {

    public MinimaxTTTAgent(String name) {
        super(name);
    }

    @Override
    public void makeMove(Game game) {

        turn.setText("Computer's turn...");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        TickTackToe tttGame = new TickTackToe((TickTackToe) game);
        TickTackToe tGame = (TickTackToe) game;

        long startTime = System.nanoTime();
        
        //Change for different minimax vs minimaxWithAlphaBeta
        
        
        //CellValueTuple best = max(tttGame);
        CellValueTuple best = maxAlphaBeta(tttGame,0, -999999, 999999);
        //CellValueTuple best = max(tttGame,0);
        
        long endTime = System.nanoTime();
        endTime = (endTime-startTime)/1000;
        if (best.col != -1) {
            tGame.board[best.row][best.col] = role;
            setaction(best,endTime);
        }
    }

    private CellValueTuple max(TickTackToe temp_game) {
        CellValueTuple maxCVT = new CellValueTuple();
        maxCVT.utility = -100;

        int winner = temp_game.checkForWin();
        //System.out.println("winner max " + winner);

        if (temp_game.isBoardFull() && winner == -1) {
            maxCVT.utility = 0;
        } else if (winner == 0) {
            maxCVT.utility = -10;
        } else if (winner == 1) {
            maxCVT.utility = +10;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TickTackToe game = new TickTackToe((TickTackToe) temp_game);
                    if (game.board[i][j] == -1) {
                        game.board[i][j] = role;
                        CellValueTuple minGame = min(game);
                        if (maxCVT.utility < minGame.utility) {
                            maxCVT.utility = minGame.utility;
                            maxCVT.set(i, j);
                        }
                    }
                }
            }
        }
        return maxCVT;
    }

    private CellValueTuple min(TickTackToe temp_game) {
        CellValueTuple minCVT = new CellValueTuple();
        minCVT.utility = 100;

        int winner = temp_game.checkForWin();
        //System.out.println("winner min " + winner);
        if (temp_game.isBoardFull() && winner == -1) {
            minCVT.utility = 0;
        } else if (winner == 0) {
            minCVT.utility = -10;
        } else if (winner == 1) {
            minCVT.utility = +10;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TickTackToe game = new TickTackToe((TickTackToe) temp_game);
                    if (game.board[i][j] == -1) {
                        game.board[i][j] = minRole();
                        CellValueTuple maxGame = max(game);
                        if (minCVT.utility > maxGame.utility) {
                            minCVT.utility = maxGame.utility;
                            minCVT.set(i, j);
                        }
                    }
                }
            }
        }
        return minCVT;
    }

    private int minRole() {
        if (role == 0) {
            return 1;
        } else {
            return 0;

        }
    }

    public void setaction(CellValueTuple temp,long Time) {
        time.setText("PC took: "+Long.toString(Time)+" micro sec.");

        if (temp.row == 0 && temp.col == 0) {
            button1.setText("X");
            button1.setEnabled(false);
        }
        if (temp.row == 0 && temp.col == 1) {
            button2.setText("X");
            button2.setEnabled(false);
        }
        if (temp.row == 0 && temp.col == 2) {
            button3.setText("X");
            button3.setEnabled(false);
        }
        if (temp.row == 1 && temp.col == 0) {
            button4.setText("X");
            button4.setEnabled(false);
        }
        if (temp.row == 1 && temp.col == 1) {
            button5.setText("X");
            button5.setEnabled(false);
        }
        if (temp.row == 1 && temp.col == 2) {
            button6.setText("X");
            button6.setEnabled(false);
        }
        if (temp.row == 2 && temp.col == 0) {
            button7.setText("X");
            button7.setEnabled(false);
        }
        if (temp.row == 2 && temp.col == 1) {
            button8.setText("X");
            button8.setEnabled(false);
        }
        if (temp.row == 2 && temp.col == 2) {
            button9.setText("X");
            button9.setEnabled(false);
        }

    }

    private CellValueTuple maxAlphaBeta(TickTackToe temp_game,int depth, int alpha, int beta) {
        CellValueTuple maxCVT = new CellValueTuple();
        maxCVT.utility = -1000000;
        maxCVT.depth = 999999999;
        boolean check = false;
        int winner = temp_game.checkForWin();
        //System.out.println("winner max " + winner);
        if (temp_game.isBoardFull() && winner == -1) {
            maxCVT.utility = 0;
            maxCVT.depth=depth;
        } else if (winner == 0) {
            maxCVT.utility = -10;
            maxCVT.depth=depth;
        } else if (winner == 1) {
            maxCVT.utility = +10;
            maxCVT.depth=depth;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TickTackToe game = new TickTackToe((TickTackToe) temp_game);
                    if (game.board[i][j] == -1) {
                        game.board[i][j] = role;
                        CellValueTuple minGame = minAlphaBeta(game,depth+1, alpha, beta);
                        if (maxCVT.utility < minGame.utility) {
                            maxCVT.utility = minGame.utility;
                            alpha = Math.max(maxCVT.utility, alpha);
                            maxCVT.set(i, j);
                            if (beta <= alpha) {
                                check = true;
                                break;
                            }
                        }
                        else if (maxCVT.utility == minGame.utility && maxCVT.depth > minGame.depth) {
                            maxCVT.utility = minGame.utility;
                            maxCVT.set(i, j);
                            maxCVT.depth = minGame.depth;
                            if (beta <= alpha) {
                                check = true;
                                break;
                            }
                        }
                    }
                }
                if (check) {
                    break;
                }
            }
        }
        return maxCVT;
    }

    private CellValueTuple minAlphaBeta(TickTackToe temp_game,int depth, int alpha, int beta) {
        CellValueTuple minCVT = new CellValueTuple();
        minCVT.utility = 1000000;
        minCVT.depth = 999999999;
        boolean check = false;
        int winner = temp_game.checkForWin();
        //System.out.println("winner min " + winner);
        if (temp_game.isBoardFull() && winner == -1) {
            minCVT.utility = 0;
            minCVT.depth = depth;
        } else if (winner == 0) {
            minCVT.utility = -10;
            minCVT.depth = depth;
        } else if (winner == 1) {
            minCVT.utility = +10;
            minCVT.depth = depth;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TickTackToe game = new TickTackToe((TickTackToe) temp_game);
                    if (game.board[i][j] == -1) {
                        game.board[i][j] = minRole();
                        CellValueTuple maxGame = maxAlphaBeta(game,depth+1, alpha, beta);
                        if (minCVT.utility > maxGame.utility) {
                            minCVT.utility = maxGame.utility;
                            beta = Math.min(beta, minCVT.utility);
                            minCVT.set(i, j);
                            if (beta <= alpha) {
                                check = true;
                                break;
                            }
                        }
                        else if (minCVT.utility == maxGame.utility && minCVT.depth > maxGame.depth) {
                            minCVT.utility = maxGame.utility;
                            minCVT.set(i, j);
                            minCVT.depth = maxGame.depth;
                            if (beta <= alpha) {
                                check = true;
                                break;
                            }
                        }                      
                    }
                }
                if (check) {
                    break;
                }
            }
        }
        return minCVT;
    }

    private CellValueTuple max(TickTackToe temp_game, int depth) {
        CellValueTuple maxCVT = new CellValueTuple();
        maxCVT.utility = -1000000000;
        maxCVT.depth = 999999999;

        int winner = temp_game.checkForWin();

        if (temp_game.isBoardFull() && winner == -1) {
            maxCVT.utility = 0;
            maxCVT.depth = depth;
        } else if (winner == 0) {
            maxCVT.utility = -10;
            maxCVT.depth = depth;
        } else if (winner == 1) {
            maxCVT.utility = +10;
            maxCVT.depth = depth;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TickTackToe game = new TickTackToe((TickTackToe) temp_game);
                    if (game.board[i][j] == -1) {
                        game.board[i][j] = role;
                        CellValueTuple minGame = min(game, depth + 1);
                        if (maxCVT.utility < minGame.utility) {
                            maxCVT.utility = minGame.utility;
                            maxCVT.set(i, j);
                            maxCVT.depth = minGame.depth;
                        } else if (maxCVT.utility == minGame.utility && maxCVT.depth > minGame.depth) {
                            maxCVT.utility = minGame.utility;
                            maxCVT.set(i, j);
                            maxCVT.depth = minGame.depth;
                        }
                    }
                }
            }
        }

        return maxCVT;
    }

    private CellValueTuple min(TickTackToe temp_game, int depth) {
        CellValueTuple minCVT = new CellValueTuple();
        minCVT.utility = 1000000000;
        minCVT.depth = 999999999;

        int winner = temp_game.checkForWin();

        if (temp_game.isBoardFull() && winner == -1) {
            minCVT.utility = 0;
            minCVT.depth = depth;
        } else if (winner == 0) {
            minCVT.utility = -10;
            minCVT.depth = depth;
        } else if (winner == 1) {
            minCVT.utility = +10;
            minCVT.depth = depth;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TickTackToe game = new TickTackToe((TickTackToe) temp_game);
                    if (game.board[i][j] == -1) {
                        game.board[i][j] = minRole();
                        CellValueTuple maxGame = max(game, depth + 1);
                        if (minCVT.utility > maxGame.utility && minCVT.depth > maxGame.depth) {
                            minCVT.utility = maxGame.utility;
                            minCVT.set(i, j);
                            minCVT.depth = maxGame.depth;
                        } else if (minCVT.utility == maxGame.utility && minCVT.depth > maxGame.depth) {
                            minCVT.utility = maxGame.utility;
                            minCVT.set(i, j);
                            minCVT.depth = maxGame.depth;
                        }
                    }
                }
            }
        }
        return minCVT;
    }
    
    class CellValueTuple {

        int row, col, utility,depth;

        public CellValueTuple() {
            row = -1;
            col = -1;
            utility = 0;
            depth=0;
        }

        public void set(int r, int c) {
            row = r;
            col = c;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
