import java.util.Random;

public class computerPlayer extends TTYGolf{
	

	public static void PlayAtGenesee() {
		boolean x = true;
		int i; //holeNum
		int j = 0;
		int rJ = 0;
		Random randGen = new Random();
		while(x) {
			int shotCount = 0;
			int rshotCount =0;
			GeneseePark gPark = new GeneseePark();
			System.out.println("");
			System.out.println("You are playing the Genesee Valley Park North Course with a robot");
			System.out.println("The rules are: ");
			System.out.println("You play first, and when you finish a hole, ");
			System.out.println("The robot starts play this hole, and when it finish ");
			System.out.println("You move on to the next hole...");
			System.out.println("in each hole the least shot wins");
			System.out.println("");
			/*FIXME add more score calculations*/
			
			String[] GTee = gPark.getGParkTee();
			int[] GYard = gPark.getGParkDistance();
			int[] GPar = gPark.getGParkPar();
			
			//for robot loops
			System.out.println("You start first");
			for(i=0;i<18;++i) {
			
				shotCount = 0;//number of the shot for each hole
				rshotCount=0;
				j = 0;
				rJ=0;
				int totalDistance = 0;
				totalDistance = GYard[i];
				System.out.println("You are at the " + GTee[i]+" tee. " + GYard[i]+" yard, Par "+GPar[i]);
				if(j==0) {
					
					while(j==0) {//when the robot has not finished the hole
						//remain on this whole
					int distance = hitTheBall();
					System.out.println(GTee[shotCount] + " shot.");
					
					
					if(Math.abs(totalDistance - distance)>=60) {
						System.out.println("you hit the ball "+distance+" yards, nice!");
						System.out.println("You are now "+Math.abs(totalDistance-distance)+" yards away from the hole");
						totalDistance = Math.abs(totalDistance - distance);
						shotCount+=1;
						
					}else {
						System.out.println("You are on the green!");
						System.out.println("You are now "+Math.abs(totalDistance - distance)+" yards away from the hole");
						double finalDistance = Math.abs(totalDistance - distance);
						while(j==0) {
							double putDistance = Putting();
							if(Math.abs(finalDistance-putDistance)<=1) {//if finish the hole
								System.out.println(GTee[shotCount+1] + " shot.");
								System.out.println("Great! You made it in "+(shotCount+2)+" shots!");
								if (GPar[i]-shotCount-2 ==1 ) {//birdie
									System.out.println("Damn! You made a Birdie!");	
									}else if (GPar[i]==shotCount+2) {
										System.out.println("You made par on this hole");	
									}else if (GPar[i]==shotCount+1) {
										System.out.println("Eh, Bogey on this hole :(");
									}else if (GPar[i]<shotCount+1) {
										System.out.println("Eww, over par!");
									}else {
										System.out.println("Eagle! OMG!");
									}
								System.out.println("");
								j=1;//ready for next hole :)
							
								}else {//still on green
								System.out.println(GTee[shotCount+1] + " shot.");
								System.out.println("you hit the ball "+putDistance+" yards, nice!");
								System.out.println("You are now "+Math.abs(finalDistance-putDistance)+" yards away from the hole");
								finalDistance = Math.abs(finalDistance - putDistance);
								shotCount+=1;}//else still on green	
				}//while j==0
				}//else on green
				}//while j==0
				
				}//if
				
				if (rJ==0) {//robot starts
					totalDistance = GYard[i];
					while(rJ==0) {//when the robot has not finished the hole
						//remain on this whole
					int rDistance = randGen.nextInt(50)+100;
					System.out.println(GTee[rshotCount] + " shot.");
					
					
					if(Math.abs(totalDistance - rDistance)>=60) {
						System.out.println("The robot hit the ball "+rDistance+" yards, nice!");
						System.out.println("The robot is now "+Math.abs(totalDistance-rDistance)+" yards away from the hole");
						totalDistance = Math.abs(totalDistance - rDistance);
						rshotCount+=1;
						}
					else {
						System.out.println("The robot is on the green!");
						System.out.println("The robot is now "+Math.abs(totalDistance - rDistance)+" yards away from the hole");
						double rfinalDistance = Math.abs(totalDistance - rDistance);
						while(rJ==0) {
							double rputDistance;
							if(rfinalDistance>50) {
								 rputDistance = 1.0*randGen.nextInt(10)+50;
							}else if(rfinalDistance>40) {
								 rputDistance = 1.0*randGen.nextInt(10)+40;		
							}else if(rfinalDistance>30) {
								 rputDistance = 1.0*randGen.nextInt(10)+30;		
							}else if(rfinalDistance>20) {
								 rputDistance = 1.0*randGen.nextInt(10)+20;		
							}else if(rfinalDistance>10) {
								 rputDistance = 1.0*randGen.nextInt(10)+10;		
							}else if(rfinalDistance>5) {
								 rputDistance = 1.0*randGen.nextInt(5)+5;		
							}else if(rfinalDistance>2) {
								 rputDistance = 1.0*randGen.nextInt(1)+2;		
							}else if(rfinalDistance>1) {
								 rputDistance = 1.0*randGen.nextInt(1)+1;		
							}else {
								 rputDistance = randGen.nextDouble();		
							}
					
							if(Math.abs(rfinalDistance-rputDistance)<=1) {//if finish the hole
								System.out.println(GTee[rshotCount+1] + " shot.");
								System.out.println("The robot made it in "+(rshotCount+2)+" shots!");
								if (GPar[i]-rshotCount-2 ==1 ) {//birdie
									System.out.println("Damn! The robot made a Birdie!");	
									}else if (GPar[i]==rshotCount+2) {
										System.out.println("The robot made par on this hole");	
									}else if (GPar[i]==rshotCount+1) {
										System.out.println("The robot Bogey on this hole :(");
									}else if (GPar[i]<rshotCount+1) {
										System.out.println("The robot over par!");
									}else {
										System.out.println("Eagle! OMG!");
									}
								
								System.out.println("");
								rJ=1;//move on to the next whole
								}
							else {//still on green
								System.out.println(GTee[rshotCount+1] + " shot.");
								System.out.println("The robot hits the ball "+rputDistance+" yards, nice!");
								System.out.println("The robot is now "+Math.abs(rfinalDistance-rputDistance)+" yards away from the hole");
								rfinalDistance = Math.abs(rfinalDistance - rputDistance);
								rshotCount+=1;}//else still on green	
				}//while rJ==0
				}//else on green
				}//while rJ==0
					
					
				}
				if(shotCount==rshotCount) {
					System.out.println("Neither you nor the robot wins");
				} else if(shotCount<rshotCount) {
					System.out.println("CONGRATULATIONS! You win!");
				}else{
					System.out.println("Sorry...The robot wins");
				}
				System.out.println("");
				
				
			}//for each hole
		
		
		}//while boolean
		
	}
}
