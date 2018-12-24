package com.thisisatest;
// This is a culmination of Udemy stuff, with methods focused on in particular
public class App 
{
    public static void main( String[] args )
    {
        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("High score is: " + highScore);
        
        calculateScore(true, 10_000, 8, 200);
        
        
        
        int position = calculateHighScorePosition(1_500);
        System.out.println("Player position: " + position);
        position = calculateHighScorePosition(900);
        System.out.println("Player position: " + position);
        position = calculateHighScorePosition(400);
        System.out.println("Player position: " + position);
        position = calculateHighScorePosition(50);
        System.out.println("Player position: " + position);

        displayHighScorePosition("Moses", position);
    }
    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalscore = score + (levelCompleted * bonus);
            finalscore += 1000;
            // System.out.println("Your final score was " + finalscore);
            return finalscore;
        }
        return -1;
    }
    public static void displayHighScorePosition(String playerName, int positionInTable) {
        System.out.println(playerName + " managed to get into position: " + positionInTable);
    }
    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore >= 1_000) {
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        }
    return 4;
    }
    // Alternative way to write the calculateHighPosition method
    
    // int position = 4;
    // if (playerScore >= 1_000) {
    //     position = 1;
    // } else if (playerScore >= 500) {
    //     position = 2;
    // } else if (playerScore >= 100) {
    //     position = 3;
    // return position;

    
}