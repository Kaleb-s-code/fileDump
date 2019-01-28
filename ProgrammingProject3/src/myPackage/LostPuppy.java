package myPackage;
import java.util.Arrays;
import java.util.Random;

public class LostPuppy {
//	These are my fields
	private char[][] myHiddingPlaces;
	private int myFloorLocation;
	private int myRoomLocation;
	private char myWinner;
	private boolean myFound;
	
//	This is my constructor 
	public LostPuppy(int totalFloors, int totalRooms) {
		this.myHiddingPlaces = new char[totalFloors][totalRooms];
		System.out.println(Arrays.deepToString(this.myHiddingPlaces));
		Random randomNumber = new Random();
//		Arrays.fill(myHiddingPlaces, '@');
//		This may not be the right number since its exclusive
		this.myFloorLocation = randomNumber.nextInt(totalFloors);
		this.myRoomLocation = randomNumber.nextInt(totalRooms);
		this.myHiddingPlaces[myFloorLocation][myRoomLocation] = 'P';
		this.myFound = false;
	}
//	Methods
	public boolean roomSearchedAlready(int floor, int room) {
		
//		I need to find a way to store the guesses so that they aren't repeated..
		
		boolean returnValue = false;
		
		returnValue = true;
		}

		
//	This method should return true if the room has already been searched

		return returnValue;
	}
	
	public boolean puppyLocation(int floor, int room) {
//	returns true if this is where the puppy was lost should NOT change any fields
		boolean puppyFound = false;
		if (floor == this.myFloorLocation) {
			if (room == this.myRoomLocation) {
				puppyFound = true;
			}
		}

		return puppyFound;
	}
	
	public boolean indicesOK(int floor, int room) {
//	This returns true if the floor and the room values are within the array indices range
		boolean dimensionsOK = false;
		if (floor <= this.myHiddingPlaces.length && room <= this.myHiddingPlaces[0].length) {
			dimensionsOK = true;
		}
		return dimensionsOK;
	}
	
	public int numberOfFloors() {
		return this.myHiddingPlaces.length;
	}
	
	public int numberOfRooms() {
		return  this.myHiddingPlaces[0].length;
	}
	
	public boolean searchRoom(int floor, int room, char currentPlayer) {
/*	returns true if the puppy is found. If not found sets myHidingPlaces array at the 
		Received floor and room location to the received player value to a '1' or '2'. if found
		sets myWinner field to current player AND sets myFound to true.
*/		return false;
	}
	
	public void toString(char[][] hidingPlaces) {
//	This is the heavylifing of the program..see instructions
	}

	
}
