import java.util.Random;
import java.util.Scanner;
public class TTYGolf {
	
	
	public static void printIntro() {
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
		return val;
	}
	
	private static void PlayAtGenesee() {
		boolean x = true;
		int i; //holeNum
		int j = 0;
		while(x) {
			int shotCount = 0;
			GeneseePark gPark = new GeneseePark();
			System.out.println("");
			System.out.println("You are playing the Genesee Valley Park North Course");
			String[] GTee = gPark.getGParkTee();
			int[] GYard = gPark.getGParkDistance();
			int[] GPar = gPark.getGParkPar();
			for(i=0;i<18;++i) {
				shotCount = 0;//number of the shot for each hole
				j = 0;
				int totalDistance = 0;
				totalDistance = GYard[i];
				System.out.println("You are at the " + GTee[i]+" tee. " + GYard[i]+" yard, Par "+GPar[i]);
				while(j==0) {
					int distance = hitTheBall();
					System.out.println(GTee[shotCount] + " shot.");
					
					if(Math.abs(totalDistance - distance)>=60) {
						System.out.println("you hit the ball "+distance+" yards, nice!");
						System.out.println("You are now "+Math.abs(totalDistance-distance)+" yards away from the hole");
						totalDistance = Math.abs(totalDistance - distance);
						shotCount+=1;
					}
					else {
						System.out.println("You are on the green!");
						System.out.println("You are now "+Math.abs(totalDistance - distance)+" yards away from the hole");
						double finalDistance = Math.abs(totalDistance - distance);
						while(j==0) {
							double putDistance = Putting();
							if(Math.abs(finalDistance-putDistance)<=1) {
								System.out.println(GTee[shotCount] + " shot.");
								System.out.println("Great! You made it in "+(shotCount+2)+" shots!");
								if (GPar[i]-shotCount-2 ==1 ) {//birdie
									System.out.println("Damn! You made a Birdie!");	
									}else if (GPar[i]==shotCount+2) {
										System.out.println("You made par on this hole");	
									}else if (GPar[i]==shotCount+1) {
										System.out.println("Eh, Bogey on this hole :(");
									}else if (GPar[i]<shotCount+1) {
										System.out.println("Eww, over par!");
									}
								System.out.println("");
								j=1;//next hole :)
							}
							else {
								System.out.println(GTee[shotCount] + " shot.");
								System.out.println("you hit the ball "+putDistance+" yards, nice!");
								System.out.println("You are now "+Math.abs(finalDistance-putDistance)+" yards away from the hole");
								finalDistance = Math.abs(finalDistance - putDistance);
								shotCount+=1;
							}		
						}
				}
				}
				}
			}
		}
	
	private static void PlayAtOldCourse(){
		/* FIXME, maybe add possibility for directly going to the hole
		 * without on green 
		 * */
			boolean x = true;
			int i;
			int j = 0;
			while(x) {
				
				int shotCount = 0;
				TheOldCourse oCourse = new TheOldCourse();
				System.out.println("");
				System.out.println("You are playing at The Old Course at St. Andrews");
				String[] OTee = oCourse.getOCourseTee();
				int[] OPar = oCourse.getOCoursePar();
				int[] OYard = oCourse.getOCourseDistance();
				
				for(i=0;i<18;++i) {
					shotCount = 0;//number of the shot for each hole
				    j = 0;
					int totalDistance = 0;
					totalDistance = OYard[i];
					System.out.println("You are at the " + OTee[i]+" tee. " + OYard[i]+" yard, Par "+OPar[i]);
					
					while(j==0) {
						int distance = hitTheBall();
						System.out.println(OTee[shotCount] + " shot.");	
						if(Math.abs(totalDistance - distance)>=60) {
							System.out.println("you hit the ball "+distance+" yards, nice!");
							System.out.println("You are now "+Math.abs(totalDistance-distance)+" yards away from the hole");
							totalDistance = Math.abs(totalDistance - distance);
							shotCount+=1;
							}
						else {
							System.out.println("You are on the green!");
							System.out.println("You are now "+Math.abs(totalDistance - distance)+" yards away from the hole");
							double finalDistance = Math.abs(totalDistance - distance);
							while(j==0) {
								double putDistance = Putting();
								if(Math.abs(finalDistance-putDistance)<=1) {
									System.out.println(OTee[shotCount] + " shot.");
									System.out.println("Great! You made it in "+(shotCount+2)+" shots!");
			
									//extra credit for Birdie and Bogey
									if (OPar[i]-shotCount-2 ==1 ) {//birdie
										System.out.println("Damn! You made a Birdie!");	
										}else if (OPar[i]==shotCount+2) {
											System.out.println("You made par on this hole");	
										}else if (OPar[i]==shotCount+1) {
											System.out.println("Eh, Bogey on this hole :(");
										}else if (OPar[i]<shotCount+1) {
											System.out.println("Eww, over par!");
										}
									System.out.println("");
									j=1;//next hole :)
								}
								else {
									System.out.println(OTee[shotCount] + " shot.");
									System.out.println("you hit the ball "+putDistance+" yards, nice!");
									System.out.println("You are now "+Math.abs(finalDistance-putDistance)+" yards away from the hole");
									finalDistance = Math.abs(finalDistance - putDistance);
									shotCount+=1;
										}		
								}
						}
						}			
				}
			}
					}
						
								/* FIXME, need loop for score calculation;
								 * */

	public static void main(String[] args) {
		printIntro();
		if(getCourse() == 1) {
			PlayAtGenesee();
		}
		else {
			PlayAtOldCourse();
		}
	}
}
	