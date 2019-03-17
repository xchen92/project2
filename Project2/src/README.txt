/*
 * Name: Xinyi Chen, Shengyuan Huang, Yize Jin 
 * NetID: xchen92,
 * project2
 * LAB MW 18:15-19:30 (Xinyi)
 * lab TA: 
 * Xinyi Chen and Shengyuan Huang, and Yize Jin worked together on this assignment.
 */
 


Our project creates two different courses, namely Genesee Valley Park 
North Course and The Old Course at St. Andrews. Also, we enable the user 
to play against a robot in the course of Genesee Valley Park. 
At first, the user is asked to choose one from those three options. 
For two different courses, we create two classes named GeneseePark and 
TheOldCourse storing the distances, par, and name of each among all the 
eighteen holes. Inside the class TTYGolf, we simulate the game as required 
in the instruction: There are 18 holes for each round; 

The user will first be informed of which hole they are playing, 
and then choosing the club (from 1 to 10) and the power (from 1 to 10); 
According to the club chosen, we use the class Hit, which stores the mean 
and standard deviation of each club given by the instruction, to calculate 
the distance of the shot; If the difference from the ball to the hole is 
greater than 60 feet, it indicates the ball is not on the green and should 
take another shot in order to get into the green; 
If the difference is less than 60 feet, it implies that the ball is on the 
green and needs to be putted into the hole; the user will select the power 
and be informed of whether the ball is in. After each shot, the user will 
be informed of the number of shots and scores relative to pars. And after 
each round, the user will be informed of the final score and be asked whether 
they would like to quit or continue. Besides, we create a class called 
computerPlayer, which extends from TTYGolf. 
This class simulates the situation where the user plays on the course of
 Genesee Valley Park with a robot. The rule is that the user goes first during 
 each hole, and the robot plays. The user will be informed during each hole and 
 at the end of the round of whether they win or lose. 

Extra credits are met on:
1 Add realistic terms (ex: birdie, bogey)
2 Can quit the game at any time by pressing 0
3 implement a computer opponents that make choices on clubs

All of codes are in the src folder.