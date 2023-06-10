package Assignment1;
import java.util.Scanner;
/*
 * Note:
 * 1. Configure the question types and candidate answers. Must support
 * 	- Multiple choice question (more than one choice can be chosen)
 *  - Single choice question (only one choice can be chosen)
 * 2. Allow students to submit answers. Every student has a unique ID
 * 	  and can submit an answer to the iVote service. A,B,C,D
 * 
 * SimulationDriver:
 * 1) create question type and configure the answers
 * 2) configure the question for iVote Service
 * 3) randomly generate a number of students and answers
 * 4) submit all the student's answers to iVote Service
 * 5) call the voting service output function to display the result
 */

public class SimulationDriver 
{

	public static void main(String[] args) 
	{
	
		System.out.println("------------Welcome to iVote Simulator------------");
		System.out.println("How many questions do you wish to simulate?");
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		//Generate pin number
		int pinNumber = generatePinAndPrint();
		int count = 1;
		
		while(count-1 != userInput)
		{
			System.out.println("+++++++++++++++Question " + count + "+++++++++++++++");
		//1. Generate Question Randomly
			Questions randomQuestion = generateRandomQuestion();
			
		//2. Randomly generate a number of students and answers
			VotingService votingServ = generateRandomStudents_Answers(randomQuestion);
			
		//3. Print poll results in real time and prints out the answers of the question
			votingServicePrintPoll(votingServ,randomQuestion);
		
		//Update variables
			count++;
			
		}

	}
	
	public static int generatePinAndPrint()
	{	
		System.out.println("|---------------------------------------|");
		System.out.println("|    Opening Lobby...Generating PIN     |");
		int pinNumber = (int)((Math.random()* (999999 - 100000)) + 100000);
		System.out.println("|            PIN number: " + pinNumber+"         |");
		System.out.println("|---------------------------------------|");
		
		return pinNumber;
	}
	
	//2) configure the question for iVote Service
	public static Questions generateRandomQuestion()
	{
		Questions randomQuestion;
		
		int random = (int)(Math.random()*2+1); //1 = single, 2 = multiple
		
		if(random == 1)
		{
			randomQuestion = new SingleQuestion();
		}
		else
		{
			randomQuestion = new MultipleQuestion();
		}
		return randomQuestion;
		
	}
	
	//3) Randomly generate a number of students and answers
	//4) Submit all the students' answers to iVote Service
	public static VotingService generateRandomStudents_Answers(Questions randomQuestion)
	{
		
		int count2 = 0; // keeps track of the number of participants that joined the lobby
		int numOfStudents = (int) (Math.random()*(36-8)+8); //max students that can join on mentimeter is 2,000
															// For simplicity, narrowed the max amount of students that can join to 35
		
		//Setting up VotingService
		VotingService votingServ = new VotingService(randomQuestion);
		while(count2 != numOfStudents)
		{
			StudentAnswers stu = new StudentAnswers(randomQuestion);
			System.out.println("Student " + (count2+1) + " joined and submitted their answers!");
			
			votingServ.addAnswer(stu,stu.getID());
			System.out.println();
			
			count2++;
		}
		
		return votingServ;
	}
	
	//5) call the Voting Service output function to display the result
	public static void votingServicePrintPoll(VotingService votingServ, Questions randomQuestion)
	{
		votingServ.printPoll();
		System.out.print("The correct answers are:");
		randomQuestion.printAnswers();
		System.out.println();
	}
	
	

}
