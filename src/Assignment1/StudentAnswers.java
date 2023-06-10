package Assignment1;
import java.util.ArrayList;

public class StudentAnswers extends Student
{
	private ArrayList<String> studAnswers = new ArrayList<String>();
	private String [] choices = {"A", "B", "C", "D"};
	private int [] keepTrack = {0,0,0,0};
	private Questions ques;
	
	StudentAnswers(Questions q)
	{
		super(); //generates Student ID
		ques = q;
		this.generateStudentAns();
	}
	
	/* generateStudentAns()
	 * 
	 * Purpose:
	 * - generates student answers randomly of a given question
	 * - next saves these answers by the students ID;
	 */
	protected void generateStudentAns()
	{
		int num = ques.getNumberOfCorrectAnswers(); //helps tell if the question is multiple or single answer
		
		if(num == 1) //single answer
		{
			int test = (int)((Math.random()* (5 - 1)) + 1);
			studAnswers.add(choices[test-1]);
		}
		else //multiple choice answer
		{
			
			int answersChosen = 0;
			int maxAnswersChosen = (int)((Math.random()* (5 - 1)) + 1) ; //student chooses how many answers they would like to answer
			while(answersChosen != maxAnswersChosen)
			{
				int test = (int)((Math.random()* (5 - 1)) + 1); //choose between 1-4, to indicate answer that is correct
				if(keepTrack[test-1] != 1)
				{
					studAnswers.add(choices[test-1]);
					keepTrack[test-1] = 1;
					answersChosen++;
				}
			}
			
		}
		
	}
	
	/* setStudAnswers(ArrayList <String>)
	 * 
	 * Purpose:
	 * - clears current student answers and replaces it with a given arraylist of answers
	 * - used when the student of the same id submits more then one answer
	 */
	protected void setStudAnswers(ArrayList<String> newAnswers)
	{
		studAnswers.clear();
		for(int i = 0; i < newAnswers.size();i++)
		{
			studAnswers.add(newAnswers.get(i));
		}
	}
	
	/* getAnswers()
	 * 
	 * Purpose:
	 * - When called, returns an arraylist of the answers of student.
	 */
	protected ArrayList<String> getAnswers()
	{
		ArrayList<String> studentAnswers = new ArrayList<String>();
		
		for(int i = 0; i < studAnswers.size();i++)
		{
			studentAnswers.add(studAnswers.get(i));
		}
		
		return studentAnswers;
	}
	
	/* printAnswers()
	 * 
	 * Purpose:
	 * - For testing purposes
	 * - prints out students answers
	 */
	public void printAnswers()
	{
		for(int i = 0; i < studAnswers.size();i++)
		{
			System.out.print(studAnswers.get(i) + " ");
		}
	}

}
