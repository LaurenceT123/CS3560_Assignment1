package Assignment1;

public class Student 
{
	private int ID;
	
	//Constructor that generates a random ID when a student is made
	Student()
	{
		ID = (int)((Math.random()* (999999 - 100000)) + 100000);
	}

	// Getter and setter for ID
	protected int getID() 
	{
		return ID;
	}

	protected void setID(int iD) 
	{
		ID = iD;
	}

}
