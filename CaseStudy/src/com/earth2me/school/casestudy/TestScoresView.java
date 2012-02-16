package com.earth2me.school.casestudy;

import java.util.Scanner;

public final class TestScoresView implements Runnable
{
	private final TestScoresModel model;

	public TestScoresView(final TestScoresModel model)
	{
		this.model = model;
	}

	// Menu-driven command loop
	public void run()
	{
		for (;;)
		{
			System.out.println("start of run method");
			System.out.println("Number of students: " + model.size());
			System.out.println("Index of current student: " + model.currentPosition());
			
			final int quit = displayMenu();
			final int command = getCommand("Enter a number [1-11]: ", 1, quit);
			if (command == quit)
			{
				return;
			}
			runCommand(command);
		}
	}

	private int displayMenu()
	{
		System.out.println("MAIN MENU");
		
		final String[] menu = {
				"Display the current student.",
				"Display the class average.",
				"Display the student with the highest grade.",
				// TODO Missing menu items.
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"Quit the program",
		};
		
		// Print each menu item.
		for (int i = 1; i < menu.length + 1; i++)
		{
			System.out.println(String.format("%2d. %s", i, menu[i]));
		}
		
		return menu.length;
	}

	// Prompts the user for a command number and runs until
	// the user enters a valid command number
	// Parameters: prompt is the string to display
	// low is the smallest command number
	// high is the largest command number
	// Returns: a valid command number
	private int getCommand(String prompt, int low, int high)
	{
		Scanner reader = new Scanner(System.in);
		int command;
		for (;;)
		{
			System.out.print(prompt);
			command = reader.nextInt();
			if (command < low || command > high)
			{
				System.out.println("Error: command must be between " + low + " and " + high);
			}
			else
			{
				break;
			}
		}
		return command;
	}

	// Selects a command to run based on a command number,
	// runs the command, and asks the user to continue by
	// pressing the Enter key
	private void runCommand(int command)
	{
		if (command == 1)
		{
			displayStudent();
		}
		else if (command == 2)
		{
			System.out.println("Average score = " + model.getClassAverage());
		}

		// missing code
	}

	private void displayStudent()
	{
		Student s = model.currentStudent();
		if (s == null)
		{
			System.out.println("No student is currently available");
		}
		else
		{
			System.out.println(s);
		}
	}

	private void displayHighScore()
	{
		Student s = model.getHighScore();
		if (s == null)
		{
			return; // TODO Replace with missing code
		}
		else
		{
			return; // TODO Replace with missing code
		}
	}

	private void addStudent()
	{
		Student s = new Student();
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the name: ");
		s.setName(reader.nextLine());
		for (int i = 1; i <= s.getNumberOfTests(); i++)
		{
			// missing code
		}
		String message = s.validateData();
		if (message != null)
		{
			System.out.println(message);
		}
		else
		{
			message = model.add(s);
			if (message != null)
			{
				System.out.println(message);
			}
			else
			{
				System.out.println("Student added");
			}
		}
	}

	private void editStudent()
	{
		Student s = model.currentStudent();
		if (s == null)
		{
			System.out.println("No student is currently available");
		}
		else
		{
			// Work on a temporary copy
			Student temp = new Student(s);
			String menu = "EDIT MENU\n" +
					"1. Change the name\n" +
					"2. Change a score\n" +
					"3. View the student\n" +
					"4. Quit this menu\n";
			int command = 1;
			while (command != 4)
			{
				System.out.print(menu);
				command = getCommand("Enter a number [1-4]: ", 1, 4);
				if (command == 1)
				{
					// lots of missing code
				}
				else
				{
					// Check for valid data before writing to database
					String message = temp.validateData();
					if (message != null)
					{
						System.out.println(message);
					}
					else
					{
						model.replace(temp);
					}
				}
			}
		}
	}
}
