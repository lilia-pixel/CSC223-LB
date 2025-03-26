package csc223.lb.Assignment_1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class GuessWord implements Game{
    private String[] allWords= {"java", "python", "programming", "crying", "trying"};
    private String word;
    private char[] guessedWord;
    private int maxAttemptsLeft;
    private boolean gameIsWon;
    private char[] updatedVersion;
    private boolean start;
    private Scanner scan;
    boolean find;

    public GuessWord(int maxAttemptsLeft){
        this.maxAttemptsLeft = maxAttemptsLeft;
        this.gameIsWon = false;
        this.start = false;
        this.scan = new Scanner(System.in);
        this.find = false;
    }

    public void startGame(){
        Random rand= new Random();
        this.word = this.allWords[rand.nextInt(this.allWords.length)];
        // create the hidden version of the word 
        this.guessedWord = new char[this.word.length()];
        for (int i=0; i< word.length();i++){
            this.guessedWord[i] = '-';
        }
        this.updatedVersion = Arrays.copyOf(this.guessedWord, this.guessedWord.length);
        System.out.println(String.valueOf(this.guessedWord));
    }

    public void printBoard(){


        System.out.println("Do You Wanna Play(yes/No):");
        String resp = scan.next();
        

        if (resp.equals("y")|| resp.equals( "yes")){
            this.start = true;
            
        }else {
            this.start = false;
        }
    }

    public void takeTurn(){

        System.out.println("Guess the letter or the entire word:");
        String guess = scan.next();

        if (guess.length() == 1){
            char l = guess.charAt(0);
            

            for (int i=0; i< word.length(); i++){
                if (word.charAt(i)==l){
                    this.guessedWord[i] = l;
                    this.find = true;
                }
            }

                if (!find){
                    this.maxAttemptsLeft--;
                    System.out.println(guess + " is not in the word");
                    System.out.println("You have "+ this.maxAttemptsLeft+" chances remaining");
                }
                this.updatedVersion = Arrays.copyOf(this.guessedWord, this.guessedWord.length);
                
                if (this.updatedVersion.toString().equals(word)){
                    this.gameIsWon = true;

                }else if (guess.equals(word)){
                        this.gameIsWon = true;
                }
            
            }
        }       
    

    public boolean isGameOver(){
        return this.maxAttemptsLeft == 0 || this.gameIsWon;
    }

    public void endGame(){
        if (this.isGameOver()){
            if (this.gameIsWon){
                System.out.println("Congrats your guess was correct, the word was " + word);
            }else{
                System.out.println("Sorry your guesses were wrong, the word was " + word);
        } 
    }
        this.scan.close();
    }

    public void playGame(){  
        printBoard();
        if (this.start){
            startGame();
            while (!isGameOver()){
                takeTurn();
                System.out.println(String.valueOf(this.guessedWord));

        }
        endGame();
    }
    }
    public static void main(String[] arg){
        GuessWord result = new GuessWord(6);
        result.playGame();
    }

}
