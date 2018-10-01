package day28;

class Test
{
	int number;
	float average;
	
	public void setNumber(int number)
	{
		//number = number;
		this.number = number;
	}
	public void setAverage(int average)
	{
		//average = average;
		this.average = average;
	}
}

public class ClassEx3 {

	public static void main(String[] args)
	{
		Test t = new Test();
		t.setNumber(5);
		t.setAverage(10);
		System.out.println("number : "+t.number);
		System.out.println("average : "+t.average);
	}
}
