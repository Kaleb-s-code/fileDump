package com.thisisatest;
// This is a culmination of Udemy stuff, with methods focused on in particular
public class App 
{
    public static void main( String[] args )
    {
        calculateScore(true, 800, 5, 100);
        calculateScore(true, 10_000, 8, 200);
        
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
}
