package gam;
//import com.bridgelabz.utility.Utility;
import java.lang.Math;

public class Gambling {
	double betPrice,stack,goal;
	int numberOfPlay;
	Utility utility;

	//constructor to initalize variables. It input from user
	public Gambling(){
		utility=new Utility();
		System.out.println("Enter stack Price");
		stack=utility.inputDouble();

		System.out.println("Enter stack Goal");
		goal=utility.inputDouble();

		System.out.println("Enter stack bet price");
		betPrice=utility.inputDouble();
	}
	public static void main(String args[]){
		Gambling gambler=new Gambling();
		gambler.playGame();
		gambler.printResult();
	}


	//This function return true(Win) when probability is less then 0.5 else return false(loss)
	public boolean winOrloss(){
		if(Math.random()<0.5)
			return true;
		else
			return false;
	}

	//function to demonstrate glambler.
	public void playGame(){
		numberOfPlay++;	
		if(winOrloss())
			stack+=betPrice;
		else
			stack-=betPrice;
		if(stack<=0 || stack>=goal)
			return;
		else
			playGame();
	}

	//print the gambler result
	public void printResult(){
		System.out.println("Number of time Game play is:"+numberOfPlay);
		System.out.println("Stack is:"+stack);
		System.out.println("Goal is:"+goal);
		System.out.println("Bet Price is:"+betPrice);
	}
}
