package myPackage;

import java.util.Random;

/**
 * This class houses various fields, and a constructor which 
 * Initializes the random location of the puppy in the form of a 
 * 2D Array. This class is to be used with the driver program
 * PuppyPlay.java.
 * 
 * 
 * @author Kaleb Moreno
 * @version TCSS 143 1/29/2019
 */

public class LostPuppy {
	private char[][] myHiddingPlaces;
	private int myFloorLocation;
	private int myRoomLocation;
	private char myWinner;
	private boolean myFound;
	private int myRoomGuess;
	private int myFloorGuess;
	private int myCount;
	private int[][] myGuessArray;

	/**
	 * This is my constructor where all of my fields are created
	 * and set to certain or null default values when instantiated
	 * by the driver program.
	 * 
	 * @param theTotalFloors : total floors in the building of type int
	 * @param theTotalRooms	: total rooms in the building of type int
	 */
	public LostPuppy(int theTotalFloors, int theTotalRooms) {
		int a = 0;
		int b = 0;
		myHiddingPlaces = new char[theTotalFloors][theTotalRooms];
		while (a < theTotalFloors) {
			while (b < theTotalRooms ) {
				myHiddingPlaces[a][b] = '_';
				b ++;
			}
		b = 0;
		a ++;
		}
		Random randomNumber = new Random();
		myGuessArray = new int[theTotalFloors * theTotalRooms][2];
		myFloorLocation = randomNumber.nextInt(theTotalFloors);
		myRoomLocation = randomNumber.nextInt(theTotalRooms);
		myHiddingPlaces[myFloorLocation][myRoomLocation] = 'P';
		myFound = false;
	}

	/**
	 * This method determines if a room has already been searched at 
	 * one point in time.
	 * 
	 * @param theFloor : User input guess of the floor the puppy might be lost
	 * @param theRoom  : User input guess of the room the puppy might be lost
	 * @return returns a boolean representing a searched or un-searched 
	 * room
	 */
	public boolean roomSearchedAlready(int theFloor, int theRoom) {
		boolean returnValue = false;
		int a = 0;
		int b = 1;
		
		for (int i = 0; i < myCount; i ++) {
		if (theFloor == myGuessArray[i][a] && theRoom == myGuessArray[i][b]) {
			System.out.println("\nPosition already guessed!");
			returnValue = true;
		}
	}
		myGuessArray[myCount][a] = theFloor;
		myGuessArray[myCount][b] = theRoom;	
		myCount += 1;
		return returnValue;
	}
	
	/**
	 * This method determines if the puppy is found based on the guesses
	 * from the players.
	 * 
	 * @param theFloor : floor guess passed from the driver via user input			
	 * @param theRoom  : room guess passed from the driver via user input
	 * @return This returns a boolean representing whether or not 
	 * the guess was correct, and the puppy was found.
	 */
	public boolean puppyLocation(int theFloor, int theRoom) {
		boolean puppyFound = false;
		if (theFloor == myFloorLocation) {
			if (theRoom == myRoomLocation) {
				puppyFound = true;
			}
		}
		return puppyFound;
	}
	
	/**
	 * This method is checking to see if the indices the user input
	 * actually make sense for the building
	 * 
	 * @param theFloor : floor guess passed from the driver via user input
	 * @param theRoom : floor guess passed from the driver via user input
	 * @return this method returns a boolean if the dimensions are 
	 * within a range
	 */
	public boolean indicesOK(int theFloor, int theRoom) {
		boolean dimensionsOK = false;
		if (theFloor < myHiddingPlaces.length && theFloor >= 0 && 
				theRoom < myHiddingPlaces[0].length && theRoom >= 0) {
			dimensionsOK = true;
		}
		return dimensionsOK;
	}
	
	/**
	 * This small method sets the field myHiddenPlaces to 
	 * the number of floors.
	 * 
	 * @return This returns an int representing the length of
	 * the array.
	 */
	public int numberOfFloors() {
		return myHiddingPlaces.length;
	}
	
	/**
	 * This small method sets the field myHiddenPlaces to 
	 * the number of rooms.
	 * 
	 * @return This returns an int representing the length of
	 * the columns in the array.
	 */
	public int numberOfRooms() {
		return  myHiddingPlaces[0].length;
	}
	
	/**
	 * This method places the players in the building and determines the winner 
	 * of the game.
	 * 
	 * @param theFloor : This is the user input floor on which the 
	 * player would like to search.
	 * @param theRoom : This is the user input room on which the 
	 * player would like to search
	 * @param theCurrentPlayer : This is the current player of the game 
	 * conducting the search
	 * @return This returns a boolean representing the winner. 
	 */
	public boolean searchRoom(int theFloor, int theRoom, char theCurrentPlayer) {
		boolean returnValue = false;
		myHiddingPlaces[theFloor][theRoom] = theCurrentPlayer;
		
		if (theFloor == myFloorLocation && theRoom == myRoomLocation) {
			returnValue = true;
			myWinner = theCurrentPlayer;
			myFound = true;
		}	
		return returnValue;
	}
	
	/**
	 * This method is where the building is constructed and displayed to 
	 * the players. 
	 * 
	 * @return This method returns an empty string. 
	 */
	public String toString() {
		int a = 0;
		int b = 0;
		int c = 0;
	
		while (c != myHiddingPlaces[0].length) {
			System.out.print(" ___");
			c ++;
		}
		System.out.println();
		while (a < myHiddingPlaces.length) {
			System.out.print("|");
			while(b < myHiddingPlaces[0].length) {
				
				if (myHiddingPlaces[((myHiddingPlaces.length) - 1) - a][b] == 'P') {
					myHiddingPlaces[((myHiddingPlaces.length) - 1) - a][b] = '_';
				}
				if (myFound == true) {
						myHiddingPlaces[myFloorLocation][myRoomLocation] = 'P';
				}
				System.out.print(myHiddingPlaces[((myHiddingPlaces.length) - 1) - a][b]);
				System.out.print("__|");
				b ++;
			}
			System.out.println();
			b = 0;
			a ++;
		}
		return "";
	}
}
