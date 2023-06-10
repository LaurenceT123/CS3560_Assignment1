package Assignment1;

import java.util.ArrayList;
/*
* VotingService: (given question type)
* 
* Purpose:
* - starts accepting answer submissions from students
* - if multiple submissions are received from the same student, only the last submission is counted
* - keep track of results
* - uses results to create a poll and print results
*/

public class VotingService 
{
	Questions givenQuestion;
	private ArrayList<StudentAnswers> studentsResponses = new ArrayList<StudentAnswers>(); //an arrayList that holds student ID and student answers
	private int [] keepTrack = {0,0,0,0};
	
	VotingService(Questions q)
	{
		givenQuestion = q;
	}
	
	/* addAnswer
	 * Purpose:
	 * - Adds students answers based on Student ID
	 */
	public void addAnswer(StudentAnswers inputedStudent, int ID)
	{
		int count = 0;
		
		//Check if student already responded based on ID
		for(int i = 0; i < studentsResponses.size();i++)
		{
			StudentAnswers currentStudent = studentsResponses.get(i);
			if(currentStudent.getID() == ID)
			{
				studentsResponses.set(i, inputedStudent);
				break;
			}
			count++;
		}
		
		//if not, add students response to studentsResponses
		if(count == studentsResponses.size())
		{
			studentsResponses.add(inputedStudent);
		}
	}
	
	/* getStudentResponses()
	 * 
	 * Purpose:
	 * - getter for student responses
	 */
	protected ArrayList<StudentAnswers> getStudentResponses()
	{
		ArrayList<StudentAnswers> newList = new ArrayList<StudentAnswers>();
		
		for(int i = 0; i < studentsResponses.size();i++)
		{
			newList.add(studentsResponses.get(i));
		}
		return newList;
	}
	
	//Poll related methods
	
	/* calculatePoll
	 * 
	 * Purpose:
	 * - based on current submitted student responses, update keepTrack[] to help with poll
	 */
	private void calculatePoll()
	{
		//Update keepTrack []
		for(int i = 0; i < studentsResponses.size();i++)
		{
			ArrayList<String> currentStudentAns = studentsResponses.get(i).getAnswers();
			if(currentStudentAns.contains("A"))
			{
				keepTrack[0]= keepTrack[0]+1;
			}
			if(currentStudentAns.contains("B"))
			{
				keepTrack[1]= keepTrack[1]+1;
			}
			if(currentStudentAns.contains("C"))
			{
				keepTrack[2]= keepTrack[2]+1;
			}
			if(currentStudentAns.contains("D"))
			{
				keepTrack[3]= keepTrack[3]+1;
			}
			
		}
	}
	
	/* printPoll()
	 * Purpose:
	 * - outputs the statistics of the submission results
	 */
	public void printPoll()
	{
		this.calculatePoll();
		
		System.out.println("----------------Poll Results-------------");
		System.out.print("A:");
		printStars(keepTrack[0]);
		System.out.print("B:");
		printStars(keepTrack[1]);
		System.out.print("C:");
		printStars(keepTrack[2]);
		System.out.print("D:");
		printStars(keepTrack[3]);
		System.out.println("------------------Summary----------------");
		System.out.println("A:" + keepTrack[0]);
		System.out.println("B:" + keepTrack[1]);
		System.out.println("C:" + keepTrack[2]);
		System.out.println("D:" + keepTrack[3]);
		System.out.println("----------------------------------------");
		
	}
	
	private void printStars(int num)
	{
		for(int i = 0; i < num;i++)
		{
			System.out.print("*");
		}
		System.out.println();
	}

}
