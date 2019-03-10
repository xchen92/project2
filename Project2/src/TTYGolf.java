import java.util.Random;
import java.util.Scanner;
public class TTYGolf {
	
	
	public static void printIntro() {
		int choiceOfCourse;
		System.out.println("Welcome to TTY Golf!");
		System.out.println("Please select a course: ");
		System.out.println("1. Genesee Valley Park North Course ");
		System.out.println("2. The Old Course at St. Andrews ");
		System.out.print("Your choice [1-2]: ");
		System.out.println("");
	}
	
	public static int getCourse() {
		int choiceOfCourse;
		Scanner scnr = new Scanner(System.in);
		choiceOfCourse = scnr.nextInt();
		return choiceOfCourse;
	}
	
	public static double keepGoing() { // method to determine if the player wants to continue the game
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter 1 to start another game, 0 to quit: ");
		double x = scnr.nextDouble();
		return x;
	}
	
	
	private static int hitTheBall() { // method to return the distance of the ball
		Scanner scnr = new Scanner(System.in);
		Random randGen = new Random();
		int club;
		int power;
	
		System.out.print("Choose your club [1-10]: ");
		club = scnr.nextInt();
		System.out.print("Power [1-10]: ");
		power = scnr.nextInt();

		
		Hit hit = new Hit();
		int[] mean = hit.meanDist();
		int[] Stv = hit.SdDist();
		double mean_adj = mean[club-1] * power / 10.0;
		double stddev_adj = Stv[club-1] * power / 10.0;
		double val = Math.abs(randGen.nextGaussian() * stddev_adj + mean_adj);
		return (int)val;

	}
	
	public static double Putting() { //the method to put the ball
		Random randGen = new Random();
		int[] mean = {1,2,4,8,12,16,20,25,30,40};
		int[] stv = {1,1,2,2,3,3,4,4,5,5};
		int power;
		Scanner scnr = new Scanner(System.in);
	
		System.out.print("Please enter the power for putting [1-10]: ");
		power = scnr.nextInt();
		double mean_adj = mean[power-1] * power / 10.0;
		double stddev_adj = stv[power-1] * power / 10.0;
		double val = Math.abs(randGen.nextGaussian() * stddev_adj + mean_adj);
		return Math.abs(val);
	}
	
	private static void gamePlay() {
		boolean x = true;
		int i;//holeNum
		int j = 0;
		
		while(x) {
			if(getCourse() == 1) {
				
				GeneseePark gPark = new GeneseePark();
				System.out.println("");
				System.out.println("You are playing the Genesee Valley Park North Course");
				String[] GTee = gPark.getGParkTee();
				int[] GYard = gPark.getGParkDistance();
				int[] GPar = gPark.getGParkPar();
				for(i=0;i<18;++i) {
					int totalDistance = 0;
					int shotNum = 0;//number of the shot for each hole
					
					System.out.println("You are at the " + GTee[i]+" tee. " + GYard[i]+" yard, Par "+GPar[i]);
					while(j==0) {
						
						int distance = hitTheBall();
						shotNum++;
						totalDistance = totalDistance + distance;
						System.out.println(shotNum+" shot.");
						System.out.println("");
						
					
						if(Math.abs(GYard[i]-totalDistance)>=60) {
							System.out.println("you hit the ball "+distance
									+" yards, nice!");
							System.out.println("You are now "+Math.abs(GYard[i]-totalDistance)+" yards away from the hole");
							/*FIXME if hit over too this will have an error that u never reach the target*/
					}
					   if(Math.abs(GYard[i]-totalDistance)<=60) {
							int finalDistance = Math.abs(GYard[i]-totalDistance);
							double putDistance;
							/* FIXME, maybe add possibility for directly going to the hole
							 * without on green 
							 * */
							do{
								System.out.println("You are on the Green.");
								 putDistance = Putting();
								 shotNum++;
								 System.out.println("Your putting distance is " + putDistance);
								 System.out.println(shotNum+" shot.");
								 System.out.println("");
								
								
								/* FIXME, need loop for score calculation;
								 * */
								}while(putDistance>0.1);
							j=1;
							}//if
						}//while still in this hole
					
					System.out.println("Your ball went into the hole!");
					
					//extra credit for Birdie and Bogey
					if (GPar[i]-shotNum ==1 ) {//birdie
						System.out.println("Damn! You made a Birdie!");	
						}else if (GPar[i]==shotNum) {
							System.out.println("You made par on this hole");	
						}else if (GPar[i]==shotNum-1) {
							System.out.println("Eh, Bogey on this hole :(");
						}else if (GPar[i]<shotNum-1) {
							System.out.println("Eww, over par!");
						}
					System.out.println("");
					j=0;//next hole :)
					
				}//for each hole
			}//if Genesee Park
		}//while play game
		
	}





	public static void main(String[] args) {
		printIntro();
		gamePlay();
		
		

	}
}
	