package Assignment1;

public interface Questions 
{
	public void generateAnswers(); //chooses A,B,C,D as an answer randomly. If multiple, chooses more than one
	public void printAnswers(); //for testing purposes, prints out answers that program chooses randomly
	public int getNumberOfCorrectAnswers();

}
