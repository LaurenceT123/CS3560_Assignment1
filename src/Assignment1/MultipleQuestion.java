package Assignment1;

import java.util.ArrayList;

public class MultipleQuestion implements Questions
{
	private int numberOfCorrectAnswers = 1; // keeps track of number of correct answers for specific question
	private ArrayList<String> answers = new ArrayList<String>(); // keeps track of what answers are the correct answer
	private String [] choices = {"A", "B", "C", "D"};
	private int [] keepTrack = {0,0,0,0}; // keeps track of which of the choices have been already chosen, here to prevent repeated answers
	
	//Constructor
	MultipleQuestion()
	{
		generateAnswers();
	}
	
	/* generateAnswers()
	 * 
	 * Purpose:
	 * - generates questions answers randomly of a given question
	 */
	@Override
	public void generateAnswers() 
	{
		int choice = (int)((Math.random()* (5 - 2)) + 2); //choose between 2-4, to randomly choose how many correct answers
		this.setNumberOfCorrectAnswers(choice);

		int answersChosen = 0;
		while(answersChosen != choice)
		{
			int test = (int)((Math.random()* (5 - 1)) + 1); //choose between 1-4, to indicate answer that is correct
			if(keepTrack[test-1] != 1)
			{
				addAnswer(choices[test-1]);
				keepTrack[test-1] = 1;
				answersChosen++;
			}
		}
		
	}

	/* addAnswer(String value)
	 * 
	 * Purpose:
	 * - adds answers that are chosen to ArrayList answers
	 */
	private void addAnswer(String value)
	{
		answers.add(value);
	}
	
	/* For testing purposes
	 * 
	 * Prints out answers of the question
	 * */
	public void printAnswers()
	{
		for(int i = 0; i < answers.size(); i++)
		{
			System.out.print(answers.get(i) + " ");
		}
		System.out.println("");
	}
	
	//Getters and Setters
	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}

	public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
	}

}
