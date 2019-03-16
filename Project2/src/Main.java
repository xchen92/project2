
public class Main {

	public static void main(String[] args) {
		
		//add choice for play with robot in Genesee
		TTYGolf.printIntro();
		int choice = TTYGolf.getCourse();
		if(choice == 1) {
			TTYGolf.PlayAtGenesee();
		}
		if (choice == 2){
			TTYGolf.PlayAtOldCourse();
		}
		else{
			computerPlayer.PlayAtGenesee();
		}
	}
	
}
