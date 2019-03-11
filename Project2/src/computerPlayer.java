import java.util.Random;

public class computerPlayer extends TTYGolf{
	

	public static void PlayAtGenesee() {
		boolean x = true;
		int i; //holeNum
		int rI; //holeNum for robot
		int j = 0;
		int rJ = 0;
		Random randGen = new Random();
		while(x) {
			int shotCount = 0;
			int rshotCount =0;
			GeneseePark gPark = new GeneseePark();
			System.out.println("");
			System.out.println("You are playing the Genesee Valley Park North Course with a robot");
			String[] GTee = gPark.getGParkTee();
			int[] GYard = gPark.getGParkDistance();
			int[] GPar = gPark.getGParkPar();
			
			//for robot loops
			System.out.println("The robot starts first");
			for(rI=0;rI<18;++rI) {
				rshotCount = 0;//number of the shot for each hole
				rJ = 0;
				int rtotalDistance =0;
				rtotalDistance = GYard[rI];
				System.out.println("The robot if at the " + GTee[rI]+" tee. " + GYard[rI]+" yard, Par "+GPar[rI]);
				while(rJ==0) {
				
					int rDistance = randGen.nextInt(50)+200;//+distance
				
					System.out.println("robot's "+ GTee[shotCount] + " shot.");
			
					//both hit
					if( Math.abs(rtotalDistance - rDistance)>=60) {
						System.out.println("The robot hits the ball "+rDistance+" yards");
						System.out.println("The robot is now "+Math.abs(rtotalDistance-rDistance)+" yards away from the hole");
							rtotalDistance = Math.abs(rtotalDistance - rDistance);
						//robot..
						rshotCount+=1;
					}
					
					if(Math.abs(rtotalDistance - rDistance) <= 60) {
						double rfinalDistance = Math.abs(rtotalDistance - rDistance);
						while(j==0) {
							double rputDistance = 0;/*FIXME*/
							if(Math.abs(rfinalDistance-rputDistance)<=1) {
								System.out.println(GTee[shotCount] + " shot.");
								System.out.println("The robot made it in "+(shotCount+2)+" shots!");
								if (GPar[rI]-shotCount-2 ==1 ) {//birdie
									System.out.println("Damn! The robot made a Birdie!");	
									}else if (GPar[rI]==shotCount+2) {
										System.out.println("The robot made par on this hole");	
									}else if (GPar[rI]==shotCount+1) {
										System.out.println("The robot Bogey on this hole :(");
									}else if (GPar[rI]<shotCount+1) {
										System.out.println("The robot over par!");
									}
								System.out.println("");
								rJ=1;//next hole :)
						     	rtotalDistance = Math.abs(rtotalDistance - rDistance);
						     	rshotCount+=1;
					}
				
							else {
								System.out.println(GTee[shotCount] + " shot.");
								System.out.println("The robot hit the ball "+rputDistance+" yards, nice!");
								System.out.println("The robot is now"+Math.abs(rfinalDistance-rputDistance)+" yards away from the hole");
								rfinalDistance = Math.abs(rfinalDistance - rputDistance);
								rshotCount+=1;
							}		
						}
				}
				}
				}
			}
		}
	

}
