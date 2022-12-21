/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nricgen;

/**
 *
 * @author TC
 */
import java.util.Scanner;

public class NRICGen
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);						
		
		int choice, d1, d2, d3, d4, d5, d6, d7, dCheck, uSum, uCheck, x=0;
		//declare int var choice for user input,
		//(NRIC gen)d1 to d7: 7 random ints for generated NRIC number, dCheck for Check Digit,
		//(NRIC valid check)uSum: calculation of Check Digit,
		//(NRIC valid check)uCheck: correct Check Digit indicated by the Checksum
		char y=' ', chkSum=' ';											//initialize y and chkSum(Checksum) to a blank space character
		boolean exit = false;											//set boolean var exit to false to continue loop until user selects 3 to exit program
		String nricInput=" ", input=" ";								//initialize nricInput(from the user) and input to blank space character
		
		
		while(exit!=true)													//loop repeats until user chooses 3 at selection menu
		{
			System.out.println("Welcome to my Singapore NRIC Generator/Checker! Please enter");	//Output the selection menu
			System.out.println("1 to randomly generate a valid Singapore IC number,");
			System.out.println("2 to check if an entered NRIC number is valid, or");
			System.out.println("3 to Exit this program:");
			
			input= sc.nextLine();										//Accept input from user as String
			choice = Integer.parseInt(input.charAt(0)+"");		/*parse first character of String input as int to choice,
																				program will not crash as long as the first character inputted is a numerical*/
			if(choice==1||choice==2||choice==3)						//Filter for wrong int input
			{
				switch(choice)												//User choice switch
				{
					case 1:													//User entered 1 as choice, NRIC generator start
						d1=(int)(10*Math.random());					//Generates random number from range of 0 to 9
						d2=(int)(10*Math.random());					//for the 7 numerical digits, decimals removed by limiting storage to Integer
						d3=(int)(10*Math.random());
						d4=(int)(10*Math.random());
						d5=(int)(10*Math.random());
						d6=(int)(10*Math.random());
						d7=(int)(10*Math.random());
					
						dCheck=11-(((d1*2)+(d2*7)+(d3*6)+(d4*5)+(d5*4)+(d6*3)+(d7*2))%11);	//Compute Check Digit
					
						//System.out.println(d1+" "+d2+" "+d3+" "+d4+" "+d5+" "+d6+" "+d7+" "+dCheck);
						//Debug statement. Display randomly generated d1 to d7 along with the Check Digit(dCheck)
						
						switch(dCheck)										//switch to choose Alphabetical Checksum based on Check Digit
						{
							case 1: chkSum='A'; break;					//in the case that the Check Digit is 1, assign 'A' to chkSum...
							case 2: chkSum='B'; break;					//in the case that the Check Digit is 2, assign 'B' to chkSum...
							case 3: chkSum='C'; break;					//and etc, etc...
							case 4: chkSum='D'; break;
							case 5: chkSum='E'; break;
							case 6: chkSum='F'; break;
							case 7: chkSum='G'; break;
							case 8: chkSum='H'; break;
							case 9: chkSum='I'; break;
							case 10: chkSum='J'; break;
							case 11: chkSum='K'; break;
						}
						System.out.println("\nHere is your randomly generated NRIC number for all your randomly generated NRIC number needs!");
						System.out.println("S"+d1+""+d2+""+d3+""+d4+""+d5+""+d6+""+d7+""+chkSum+"\n");		//Output generated NRIC number to screen
						
					break;													//Break case 1
					
					case 2:													//User entered 2 as choice, Singapore NRIC validity checker start
						uCheck = 0;											//reset uCheck to 0	
						uSum = 0;											//reset uSum to 0
											
						System.out.println("\nPlease enter the NRIC number you wish to verify(include the 'S' at the beginning):");
						nricInput= sc.nextLine();				//accept NRIC input from user as String
						
						for(int i=1; i<9; i++)					//runs loop 8 times, int var i value increase by 1 with each loop
						{
							
						switch(i)									//switch to next case as i increases in value as loop repeats
							{
								case 1:															//(first loop) in the case that i=1,
									x = Integer.parseInt(nricInput.charAt(i)+"");	//parse second character(character at 0, the first character is assumed to be the non changing "S") in String nricInput as Integer to x
									uSum+=(x*2);												//multiply first digit by its weight of 2, then accumulate value to uSum
									break;														//break case where i=1
								
								case 2:															//(second loop) in the case that i=2,
									x = Integer.parseInt(nricInput.charAt(i)+"");	//parse third character in String nricInput as Integer to x
									uSum+=(x*7);												//multiply second digit by its weight of 7, then accumulate value to uSum
									break;														//break case where i=2
	
								case 3:															//repeat for the next 5 loops/cases and digits
									x = Integer.parseInt(nricInput.charAt(i)+"");
									uSum+=(x*6);
									break;
									
								case 4:
									x = Integer.parseInt(nricInput.charAt(i)+"");
									uSum+=(x*5);
									break;
									
								case 5:
									x = Integer.parseInt(nricInput.charAt(i)+"");
									uSum+=(x*4);
									break;
									
								case 6:
									x = Integer.parseInt(nricInput.charAt(i)+"");
									uSum+=(x*3);
									break;
									
								case 7:
									x = Integer.parseInt(nricInput.charAt(i)+"");
									uSum+=(x*2);
									break;
																	
								case 8:															//(eighth loop) in the case that i=8,
									y = nricInput.charAt(i);								//assign 9th character in String nricInput to char y
									switch(y)													//switch based on the char in y
									{
										case 'A':												//in the case of y being 'A',
											uCheck=1;break;									//set int uCheck to 1, break switch(y)
										case 'a':												//in the case of y being 'a',
											uCheck=1;break;									//set int uCheck to 1, break switch(y)	
										case 'B':												//in the case of y being 'B',
											uCheck=2;break;									//set int uCheck to 2, break switch(y)
										case 'b':												//in the case of y being 'b',
											uCheck=2;break;									//set int uCheck to 2, break switch(y)
										case 'C':												//the rest of the cases for 'C' to 'k'
											uCheck=3;break;
										case 'c':
											uCheck=3;break;
										case 'D':
											uCheck=4;break;
										case 'd':
											uCheck=4;break;
										case 'E':
											uCheck=5;break;
										case 'e':
											uCheck=5;break;
										case 'F':
											uCheck=6;break;
										case 'f':
											uCheck=6;break;
										case 'G':
											uCheck=7;break;
										case 'g':
											uCheck=7;break;
										case 'H':
											uCheck=8;break;
										case 'h':
											uCheck=8;break;
										case 'I':
											uCheck=9;break;
										case 'i':
											uCheck=9;break;
										case 'J':
											uCheck=10;break;
										case 'j':
											uCheck=10;break;
										case 'K':
											uCheck=11;break;
										case 'k':
											uCheck=11;break;
										default:													//in all other cases,
											uCheck=999;break;									//set uCheck to 999 so uSum can never be equal to uCheck
									}//close switch(y)
									break;//Break for Case 8
							}//close switch(i)
						}//close for(i)
						
						//System.out.println(uSum);	//Debug statement, display uSum(total sum)
						uSum=(11-(uSum%11));				//Compute uSum for checking against uCheck
						//System.out.println(uSum);	//Debug stmt, display uSum computed to check digit
						//System.out.println(y);		//Debug stmt, display entered alphabet chksum
						//System.out.println(uCheck);	//Debug stmt, display check digit correct value
						
						if(uSum==uCheck)															//if the computed check digit is equal to the correct value
						{
						System.out.println("\nThis is a valid NRIC number.\n");		//output validity confirmation statement
						}
						else
						{
						System.out.println("\nThis is an invalid NRIC number.\n");	//output invalidity notification statement
						}
												
						break; 																		//Break Case 2(NRIC Validity Checker)
						
						case 3:																		//user entered 3 as input at selection menu
						System.out.println("\nThank you for using my program. Good bye!");	
						exit = true;																//set boolean var exit to true to end while loop
						break;																		//break case 3(Exit)
						}//close switch(choice)
			}//(close if(choice))
			else																						//in case of int other than 1, 2 or 3 being inputted, display error message
			{
			System.out.println("\nInvalid input. Please try again.\n");				
			}
		}//close while(exit)
	}//close main
}//close class
		  