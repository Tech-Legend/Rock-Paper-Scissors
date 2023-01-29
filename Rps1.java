/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SREEJITH
 */
import java.util.*;
import java.io.*;
public class Rps1 {
    enum Move {
        ROCK,
        PAPER,
        SCISSORS
    }
public  String getPlayerMove()
    {
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        String playerChoice = choice.toUpperCase();
     
        if(playerChoice.equals("ROCK") || playerChoice.equals("PAPER") || playerChoice.equals("SCISSORS")||playerChoice.equals("QUIT")||playerChoice.equals("NEWGAME")){
            return playerChoice;
        }else{
            System.out.println("This is not Valid Move, Try again!");
            return "Bad Input";
        }
 
    }
public  String getComputerMove()
    {
        String computerChoice;
        Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1) {
            computerChoice = Move.ROCK.name();
        }
        else if(input == 2) {
            computerChoice = Move.PAPER.name();
        }
        else {
            computerChoice = Move.SCISSORS.name();
        }
        return computerChoice;    
    }
int f=0;
public  void rockpaperscissors() throws FileNotFoundException, IOException ,ClassNotFoundException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name:: ");
        String s=sc.next();
        int total=0;
        
        System.out.println("Welcome to Rock Paper Game! \nYour's Game partner is Computer. \nEnter Your Move:  ");
         File fi=new File("C:\\Users\\SREEJITH\\Desktop\\checking.txt");
         
        String st;
        String b;

BufferedReader br1=new BufferedReader(new FileReader(fi));

String sp;
 
 
while((sp=br1.readLine())!=null)
    System.out.println("Highest Score: "+sp);
 
        while(true)
        {
         System.out.println("ROCK");
        System.out.println("PAPER");
        System.out.println("SCISSORS");
         System.out.println("QUIT");
          System.out.println("NEW GAME");
 
        String playerMove = getPlayerMove();
        if(playerMove.equals("QUIT"))
            System.exit(0);
        BufferedReader br=new BufferedReader(new FileReader(fi));
        String p="";
         while((st=br.readLine())!=null)
         {
            
             p+=st;
         }
    
         String[] lam=p.split(" ");
         
        if(playerMove.equals("NEWGAME")){
           
            if(total>=Integer.parseInt(lam[1])){
                 BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\SREEJITH\\Desktop\\checking.txt"));
        writer.write(s+" "+total);
         writer.flush();
            }
           
            rockpaperscissors();
            
        }
        System.out.println("Your move is: "+ playerMove);
        if(!playerMove.equals("Bad Input")) {
            String computerMove = getComputerMove();
            System.out.println("Computer move is: " + computerMove);
            if (playerMove.equals(computerMove)) {
                System.out.println("Game is Tie !!");
            }
                    
            else if (playerMove.equals(Move.ROCK.name())) {
                if(computerMove.equals(Move.PAPER.name())) {
                    System.out.println("Computer Wins");
                    System.out.println("Better Luck Next Time!");
                }else {
                    System.out.println("You Win!");
                    System.out.println("OOhhOO, Congratulations!!! ");
                    total+=5;
                }
            }
            
            else if (playerMove.equals(Move.PAPER.name())) {
                if(computerMove.equals(Move.SCISSORS.name())) { 
                    System.out.println("Computer Wins");
                    System.out.println("Better Luck Next Time!");
                }
                else { 
                    System.out.println("You Win!");
                    System.out.println("OOhhOO, Congratulations!!! ");
                    total+=5;
                }
            }
              
            else {
                if(computerMove.equals(Move.ROCK.name())) {
                    System.out.println("Computer Wins");
                    System.out.println("Better Luck Next Time!");
                }
                else { 
                    System.out.println("You Win!");
                    System.out.println("OOhhOO, Congratulations!!! ");
                    total+=5;
                }
            }
        }   
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Rps1 rp=new Rps1();
        rp.rockpaperscissors();
    }
}
