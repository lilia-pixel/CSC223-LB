package csc223.lb.Assignment_1;

import java.util.Scanner;

public class TicTacToe implements Game{
    private char[][] board ={{' ', '|','A', '|','B','|', 'C',},
                    {' ', '+', '-', '+', '-', '+', '-','|'},
                    {'0','|',' ', '|', ' ', '|', ' ','|'},
                    {' ', '+', '-', '+', '-', '+', '-','|'},
                    {'1','|',' ', '|', ' ', '|', ' ','|'},
                    {' ', '+', '-', '+', '-', '+', '-','|'},
                    {'2','|',' ', '|', ' ', '|', ' ','|'}};
    private boolean gameOver;
    private Scanner scan;

    public TicTacToe(){
        this.gameOver = true;

    }
    
    
    public void startGame(){
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("To play this game, make sure you have two players, a player 0 and a player X");
        this.scan = new Scanner(System.in);

    }

    public void printBoard(){
        for (char[] row: board){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private boolean invalid(String place){
        for (int i=0; i<3; i++){
            if (Character.getNumericValue(place.charAt(1)) == i){  
                if (place.charAt(0)=='a' && board[2*(i+1)][2]==' '){
                    return false;
                }
                if (place.charAt(0)=='b' && board[2*(i+1)][4]==' '){
                    return false;
                }
                if (place.charAt(0)=='c' && board[2*(i+1)][6]==' '){
                    return false;
                }
            }
        }
        return true;
    }


    public void takeTurn(){

        System.out.println("Player 0's turn.");
        System.out.println("Enter square: (e.g. A0):");
        String place = scan.next();

        String lplace = place.toLowerCase();

        while (invalid(lplace)){
            System.out.println("Your attempt is invalid, try again");
            lplace=scan.next();
            lplace = lplace.toLowerCase();

        }
        for (int i=0; i<3; i++){  
            if (Character.getNumericValue(lplace.charAt(1))==i){
                if (lplace.charAt(0)=='a'){
                    board[2*(i+1)][2]='0';
                } else if (lplace.charAt(0)=='b'){
                    board[2*(i+1)][4]='0';
                } else if (lplace.charAt(0)=='c'){
                    board[2*(i+1)][6]='0';
                }
            }
        }


        System.out.println("Player X's turn.");
        System.out.println("Enter square: (e.g. A0):");
        String placeX = scan.next();

        String lplaceX = placeX.toLowerCase();

        while (invalid(lplaceX)){
            System.out.println("Your attempt is invalid, try again");
            lplaceX=scan.next();
            lplaceX = lplaceX.toLowerCase();
        }

        for (int i = 0; i < 3; i++) {
            if (Character.getNumericValue(lplaceX.charAt(1))==i) {
                if (lplaceX.charAt(0)=='a'){
                    board[2*(i+1)][2]='X';
                } else if (lplaceX.charAt(0)=='b'){
                    board[2*(i+1)][4] = 'X';
                } else if (lplaceX.charAt(0)=='c'){
                    board[2*(i+1)][6]='X';
                }
            }
        }

    }

    private boolean checksRow(int row, char symb){
        for (int m=2; m<=6;m+=2){
            if(board[row][m]!=symb){
                return false;
            }
        }
        return true;
    }
    private boolean checksColumn(int col, char symb){
        for (int i=2; i<=6;i+=2){
            if(board[i][col]!=symb){
                return false;
            }
        }
        return true;
    }

    private boolean checksDiag(char symb){
        if(board[2][2]==symb && board[4][4]==symb && board[6][6]==symb){
            return true;
        }
        if (board[2][6]==symb && board[4][4]==symb && board[6][2]==symb){
            return true;
        }
        return false;
    }



    public boolean isGameOver(){

        for (int i=2; i<=6;i+=2){
            for(int j=2; j<=6; j+=2){
                if (board[i][j]==' '){
                    this.gameOver=false;

                }
            }
        }


        for (int j=2; j<=6; j+=2){
            if (checksRow(j,'0') || checksColumn(j,'0') || checksRow(j,'X') || 
                checksColumn(j,'X') || checksDiag('0') || checksDiag('X')){
                    this.gameOver=true;
            }
        }
        return this.gameOver;
        }


    

    public void endGame(){
        if (isGameOver()){
            for (int j=2; j<=6; j+=2){
                if (checksRow(j,'0') || checksColumn(j,'0') || checksDiag('0')){
                    System.out.println("0 wins!");
                }else if (checksRow(j,'X') || checksColumn(j,'X') || checksDiag('X')){
                    System.out.println("X wins!");
                }
            if  (!checksRow(j,'0') && !checksColumn(j,'0') && !checksRow(j,'X') && 
            !checksColumn(j,'X') && !checksDiag('0') && !checksDiag('X')){
                System.out.println("No one won");
            }
            }
            this.scan.close();
        }
    }

    public void playGame(){
        startGame();
        printBoard();
        takeTurn();
        while(!isGameOver()){
            printBoard();
            takeTurn();
        }
        printBoard();
        endGame();
    }
    public static void main(String[] arg){
        TicTacToe result = new TicTacToe();
        result.playGame();
    }

}

