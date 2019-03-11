import java.util.Random;

public class computerPlayer extends TTYGolf{
	

	public static void PlayAtGenesee() {
		boolean x = true;
		int i; //holeNum
		int j = 0;
		Random randGen = new Random();
		while(x) {
			int shotCount = 0;
			int rshotCount =0;
			GeneseePark gPark = new GeneseePark();
			System.out.println("");
			System.out.println("You are playing the Genesee Valley Park North Course");
			String[] GTee = gPark.getGParkTee();
			int[] GYard = gPark.getGParkDistance();
			int[] GPar = gPark.getGParkPar();
			for(i=0;i<18;++i) {
				shotCount = 0;//number of the shot for each hole
				rshotCount=0;
				j = 0;
				int totalDistance = 0;
				int rtotalDistance =0;
				totalDistance = GYard[i];
				rtotalDistance = GYard[i];
				System.out.println("You are at the " + GTee[i]+" tee. " + GYard[i]+" yard, Par "+GPar[i]);
				while(j==0) {
					int distance = hitTheBall();
					int rDistance = randGen.nextInt(100)-50;
				
					System.out.println(GTee[shotCount] + " shot.");
			
					//both hit
					if(Math.abs(totalDistance - distance)>=60 && Math.abs(rtotalDistance - rDistance)>=60) {
						System.out.println("you hit the ball "+distance+" yards, nice!");
						System.out.println("You are now "+Math.abs(totalDistance-distance)+" yards away from the hole");
						System.out.println("The robot hits the ball "+rDistance+" yards");
						System.out.println("The robot is now "+Math.abs(rtotalDistance-rDistance)+" yards away from the hole");
						
						totalDistance = Math.abs(totalDistance - distance);
						rtotalDistance = Math.abs(totalDistance - rDistance);
						//robot..
						shotCount+=1;
						rshotCount+=1;
					}
					//player hits, robot on green
					else if(Math.abs(totalDistance - distance)>=60 && Math.abs(rtotalDistance - rDistance)<60) {
						System.out.println("you hit the ball "+distance+" yards, nice!");
						System.out.println("You are now "+Math.abs(totalDistance-distance)+" yards away from the hole");
						System.out.println("The robot hits the ball "+rDistance+" yards");
						System.out.println("The robot is now on the Green "+Math.abs(rtotalDistance-rDistance)+" yards away from the hole");
						
						totalDistance = Math.abs(totalDistance - distance);
						rtotalDistance = Math.abs(totalDistance - rDistance);
						//robot..
						shotCount+=1;
					}
					//player on green, robot hits
					else if(Math.abs(totalDistance - distance)<60 && Math.abs(rtotalDistance - rDistance)>=60) {
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
								
						System.out.println("The robot hits the ball "+rDistance+" yards");
						System.out.println("The robot is "+Math.abs(rtotalDistance-rDistance)+" yards away from the hole");
						
						totalDistance = Math.abs(totalDistance - distance);
						rtotalDistance = Math.abs(totalDistance - rDistance);
						//robot..
						shotCount+=1;
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
	

}
