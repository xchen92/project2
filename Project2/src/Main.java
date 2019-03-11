
public class Main {

	public static void main(String[] args) {
		
		//add choice for play with robot in Genesee
		TTYGolf.printIntro();
		if(TTYGolf.getCourse() == 1) {
			TTYGolf.PlayAtGenesee();
		}
		else {
			TTYGolf.PlayAtOldCourse();
		}
	}
	
}
