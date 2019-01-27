package myPackage;
import java.util.Arrays;

public class LostPuppy {

	public LostPuppy(int totalFloors, int totalRooms) {
		
		System.out.println("This is some code that I added from the mac");
		int[][] buildingDimensions;
		buildingDimensions = new int[totalFloors][totalRooms];
		System.out.println(Arrays.deepToString(buildingDimensions));
		
	}

	public boolean roomSearchedAlready(int floor, int room) {
		return false;
	}
	
	public boolean puppyLocation(int floor, int room) {
		System.out.println("This is a print statemt");
		return true;
	}
	
	public boolean indicesOK(int floor, int room) {
		System.out.println("THis is indiciesOK");
		return true;
	}
	
	public int numberOfFloors() {
		return 6;
	}
	
	public int numberOfRooms() {
		return 0;
	}
	
	public boolean searchRoom(int floor, int room, char player) {
/*	This is supposed to set myHidingPlaces array at the received
		and room location to the received player value 1, or 2.
		Or when found, sets myWinner field to current player, and myFount to true
*/
		return true;
	}

	public String toString() {
		
		return ("THis is going to do the heavy lifting for the prints");
	}

}
