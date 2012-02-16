// You need to complete this program you will 
//not be able to run this program until you do.

import java.util.Scanner;

public class TestScoresView{

   private TestScoresModel model;

   public TestScoresView(TestScoresModel m){
      model = m;
      run();
   }

   // Menu-driven command loop
   private void run(){
      while (true){
      	 System.out.println("start of run method");
         System.out.println("Number of students: " + model.size());
         System.out.println("Index of current student: " +
                            model.currentPosition());
         displayMenu();
         int command = getCommand("Enter a number [1-11]: ", 1, 11);
         if (command == 11)
            break;
         runCommand(command);
      }
   }

   private void displayMenu(){
      System.out.println("MAIN MENU");
      System.out.println(" 1. Display the current student");
      System.out.println(" 2. Display the class average");
      System.out.println(" 3. Display the student with the highest grade");
      // missing code
      
      
      System.out.println("11. Quit the program");
   }

   // Prompts the user for a command number and runs until
   // the user enters a valid command number
   // Parameters: prompt is the string to display
   //             low is the smallest command number
   //             high is the largest command number
   // Returns: a valid command number
   private int getCommand(String prompt, int low, int high){
     // errors checking
      Scanner reader = new Scanner(System.in);
      int command = low - 1;
      while (command < low || command > high){
         System.out.print(prompt);
         command = reader.nextInt();
         if (command < low || command > high)
            System.out.println("Error: command must be between " +
                               low + " and " + high);
       }
       return command;
   }

   // Selects a command to run based on a command number,
   // runs the command, and asks the user to continue by
   // pressing the Enter key
   private void runCommand(int command){
      if (command == 1)
         displayStudent();
      else if (command == 2)
         System.out.println("Average score = " + model.getClassAverage());
   
      //missing code	     
   }

   private void displayStudent(){
      Student s = model.currentStudent();
      if (s == null)
         System.out.println("No student is currently available");
      else
         System.out.println(s);
   }

   private void displayHighScore(){
      Student s = model.getHighScore();
      if (s == null)
         //missing code
      else
         //missing code
   }

   private void addStudent(){
      Student s = new Student();
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter the name: ");
      s.setName(reader.nextLine());
      for (int i = 1; i <= s.getNumberOfTests(); i++){
         //missing code
      }
      String message = s.validateData();
      if (message != null)
         System.out.println(message);
      else{
         message = model.add(s);
         if (message != null)
            System.out.println(message);
         else
            System.out.println("Student added");
      } 
   }

   private void editStudent(){
      Student s = model.currentStudent();
      if (s == null)
         System.out.println("No student is currently available");
      else{
         // Work on a temporary copy
         Student temp = new Student(s);
         String menu = "EDIT MENU\n" +
                       "1. Change the name\n" +
                       "2. Change a score\n" +
                       "3. View the student\n" +
                       "4. Quit this menu\n";
         Scanner reader = new Scanner(System.in);
         int command = 1;
         while (command != 4){
            System.out.print(menu);
            command = getCommand("Enter a number [1-4]: ", 1, 4);
            if (command == 1){         
             //lots of missing code  
            }else{
               // Check for valid data before writing to database
               String message = temp.validateData();
               if (message != null)
                  System.out.println(message);
               else
                  model.replace(temp);
             }
         }
      }
   }
}

