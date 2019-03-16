
public class Main {

	public static void main(String[] args) {
		
		//add choice for play with robot in Genesee
		int score = 0;
		TTYGolf.printIntro();
		int choice = TTYGolf.getCourse();
		if(choice == 1) {
			score = TTYGolf.PlayAtGenesee();
			if(score<0) {
				System.out.println("Your final score is: "+Math.abs(score)+" over");
			}else if(score>0) {
				System.out.println("Your final score is: "+Math.abs(score)+" under");
			}else {
				System.out.println("Your final score is: Par");
			}
		}
		if (choice == 2){
			score = TTYGolf.PlayAtOldCourse();
			if(score<0) {
				System.out.println("Your final score is: "+Math.abs(score)+" over");
			}else if(score>0) {
				System.out.println("Your final score is: "+Math.abs(score)+" under");
			}else {
				System.out.println("Your final score is: Par");
			}
		}
		else{
			computerPlayer.PlayAtGenesee();
		}
	}
	
}
