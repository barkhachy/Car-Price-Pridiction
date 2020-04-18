import java.io.*; 
import java.util.*;
public class Snake_ladder
{  
    public static void main (String [] args) throws IOException
    {
        BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
        System.out.println ("\t\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
        System.out.println ("\t\t\t\t\t\t\tIntroduction");
        System.out.println ("\t\t\t\t It is command line game where you can play with computer as opponent");
	print_board(-1,-1);     //print game board at start
        
    
        String start = "y"; // decare variable used to ask user if user wants to play
        
        System.out.print ("Do you want to play? Y or N     >  "); 
        start = bf.readLine (); 
        System.out.print ("\n");
        // While the user says yes, go to startGame method
        // startGame is fuction type method, which start the game
        while (start.equals ("y") || start.equals ("Y"))
        {
            start = startGame(start); // give startGame a variable to work with
        }
        System.out.println ("\n\t\t\t\t\t\tEnjoy!!");
        
        
    } //end main method
    /*
	To print the board after move of user and computer
	
   */
    static void print_board(int pos1,int pos2)
	{       boolean flag=true;
		System.out.println ("-------------------------------------------------------Game Board---------------------------------------------------------------------------------");
       
		for(int i=10;i>=1;i--)
		{
			System.out.print("\t\t\t\t");
			if(flag==true){
			for(int j=0;j<=9;j++)
			{
				int temp=i*10-j;
				if(temp==pos1)
				{
					System.out.print("Y\t");
				}
				else if(temp==pos2)
				{
					System.out.print("C\t");
				}
				else
				{
					System.out.print(temp+"\t");
				}
			}
			flag=false;
			}
			else
			{
				for(int j=9;j>=0;j--)
				{
					int temp=i*10-j;
					if(temp==pos1)
					{
						System.out.print("Y\t");
					}
					else if(temp==pos2)
					{
						System.out.print("C\t");
					}
					else
					{
						System.out.print(temp+"\t");
					}
				}
				flag=true;	
			}	
			System.out.println();
		}
	}
    public static String startGame (String start) throws IOException // Recieves data from the main method
    {// start startGame method
        
        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        
        int userPosition = 1; // sets the default loaction for user's piece to 1
        int compPosition = 1; // sets the default loaction for computer's piece to 1
        int userRoll = 1; // declares what the user rolled
        int compRoll = 1; // declares what the computer rolled
        String playAgain = start; // sets the play again variable
        
        // declare all the snakes and ladders in a array
        int sl [][] = new int [6][2]; //array which contains the start end pos of snakes and ladders
	sl[0][0]=54;
	sl[0][1]=19;
	sl[1][0] = 90;
	sl[1][1]=48;
	sl[2][0] = 99;
	sl[2][1]=77;
	sl[3][0]=9;
	sl[3][1]=34;
	sl[4][0] =40;
	sl[4][1]=64;
	sl[5][0] =67;
	sl[5][1]=86;
        
        while (playAgain.equals ("y") || playAgain.equals ("Y")) // loops while the playAgaim vaiable equals "y" or "Y".
        {// start playAgain While
            
            
            // gets the dice roll for user and computer
	    Random ran =new Random();
            userRoll =  ran.nextInt(6)+1; 
            compRoll =  ran.nextInt(6)+1; 
            System.out.println ("\t\t\t\t\t---------------------------------");
            System.out.println ("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|"); // print the roll the user got
            System.out.println ("\t\t\t\t\t|\tThe Computer Rolled a " + compRoll + "\t|"); // print the roll the computer got
            System.out.println ("\t\t\t\t\t---------------------------------");
            
            // hold the user's last position for switching back if current position was greater than 100
            userPosition = userPosition + userRoll;
            compPosition = compPosition + compRoll;
            for(int i=0;i<6;i++)
	    {
		if(userPosition==sl[i][0])
		{
			userPosition=sl[i][1];
			if(i<3){System.out.println("You biten by Snake");
				}
			else
				{
					System.out.println("Hurray!!\nYou got a ladder");
				}
		}
		if(compPosition==sl[i][0])
		{
			compPosition=sl[i][1];
			
			if(i<3){System.out.println("Computer biten by Snake");
				}
			else
				{
					System.out.println("Computer got a ladder");
				}
		}
		
	    }
	    if(userPosition>100)
	    {
		userPosition=userPosition-userRoll;
		System.out.println("Move Reversed!!\t Can't jump 100th pos");
	    }
	    else if(userPosition==100)
	    {
		System.out.println("You Won");
	    }
            if(compPosition>100)
	    {
		compPosition=compPosition-compRoll;
		System.out.println("Move Reversed!!\t Can't jump 100th pos");
	    }
	    else if(compPosition==100)
	    {
		System.out.println("Computer Won");
	    }
            
            //System.out.println("*************************************************************************");
              print_board(userPosition,compPosition);   

            if (userPosition == 100 || compPosition == 100)
            {
                userPosition = 1;
                compPosition = 1;
                // asks the user if we wants to play again
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                System.out.print ("\n");
            }
            else
            {
                // asks the user if we wants to continue playing
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                
            }
            
            
        }// end playAgain While
        
        return playAgain;
    }// end startGame method
 }
