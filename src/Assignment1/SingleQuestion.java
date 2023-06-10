package Assignment1;

import java.util.ArrayList;

public class SingleQuestion implements Questions
{
	private int numberOfCorrectAnswers = 1; // keeps track of number of correct answers for specific question
	private ArrayList<String> answers = new ArrayList<String>(); // keeps track of what answers are the correct answer
	private String [] choices = {"A", "B", "C", "D"};
	
	SingleQuestion()
	{
		generateAnswers();
	}
	public void generateAnswers() 
	{
		int choice = (int)((Math.random()* (5 - 1)) + 1);//choose between 1-4, to indicate answer that is correct
		addAnswer(choices[choice-1]);
	}
	
	private void addAnswer(String value)
	{
		answers.add(value);
	}

	/* For testing purposes
	 * 
	 * Prints out answers of the question
	 * 
	 * */
	public void printAnswers()
	{
		for(int i = 0; i < answers.size(); i++)
		{
			System.out.print(answers.get(i) + " ");
		}
		System.out.println("");
	}
	
	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}

	public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
	}
	
	

}
