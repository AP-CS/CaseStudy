package com.earth2me.school.casestudy;

import java.util.Scanner;

final class TestScoresView implements Runnable
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
				"Display all of the students.",
				"Edit the current student.",
				"Add a new student.",
				"Move to the first student.",
				"Move to the last student.",
				"Move to the next student.",
				"Move to the previous student.",
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
		switch (command)
		{
		case 1:
			displayStudent();
			break;

		case 2:
			displayClassAverage();
			break;

		case 3:
			displayHighScore();
			break;

		case 4:
			displayAllStudents();
			break;

		case 5:
			editStudent();
			break;

		case 6:
			addStudent();
			break;

		case 7:
			moveToFirst();
			break;

		case 8:
			moveToLast();
			break;

		case 9:
			moveToNext();
			break;

		case 10:
			moveToPrevious();
			break;
		}
	}

	/**
	 * Outputs a list of all students.
	 * 
	 * @author Paul Buonopane
	 */
	private void displayAllStudents()
	{
		System.out.println(model);
	}

	/**
	 * Moves to the first element in the model.
	 * 
	 * @author Paul Buonopane
	 */
	private void moveToFirst()
	{
		model.first();
	}

	/**
	 * Moves to the last element in the model.
	 * 
	 * @author Paul Buonopane
	 */
	private void moveToLast()
	{
		model.last();
	}

	/**
	 * Moves to the next element in the model.
	 * 
	 * @author Paul Buonopane
	 */
	private void moveToNext()
	{
		model.next();
	}

	/**
	 * Moves to the previous element in the model.
	 * 
	 * @author Paul Buonopane
	 */
	private void moveToPrevious()
	{
		model.previous();
	}

	/**
	 * Outputs the class average to the console.
	 * 
	 * @author Paul Buonopane
	 */
	private void displayClassAverage()
	{
		System.out.println("Average Score: " + model.getClassAverage());
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

	/**
	 * Outputs the student with the highest grade, or
	 * "No students have been added yet." if students have yet to be added to
	 * the model.
	 */
	private void displayHighScore()
	{
		Student student = model.getHighScore();
		if (student == null)
		{
			System.out.println("No students have been added yet.");
		}
		else
		{
			System.out.println(student);
		}
	}

	/**
	 * Prompts the user to add a student to the model.
	 */
	private void addStudent()
	{
		final Student student = new Student();
		final Scanner reader = new Scanner(System.in);

		// Request the name of the student.
		System.out.print("Enter the name: ");
		student.setName(reader.nextLine());

		for (int i = 1; i <- student.getNumberOfTests(); i++)
		{
			System.out.printf("Score on test %d: ", i);
			final int score = reader.nextInt();
			student.setScore(i, Math.max(0, Math.min(score, 100)));
		}

		// Validate the data.  Output error if invalid.
		String error = student.validateData();
		if (error != null)
		{
			System.out.println(error);
			return;
		}

		// Attempt to add student to model.  Output error if impossible.
		error = model.add(student);
		if (error != null)
		{
			System.out.println(error);
			return;
		}

		System.out.println("Student added.");
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
			Student temp = s.memberwiseClone();
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
