package com.earth2me.school.casestudy;

// Case Study 9.1: Student class

final class Student
{
	private String name;
	private int[] tests;

	// Default: Name is "" and 3 scores are 0
	public Student()
	{
		this(null);
	}

	// Name is name and 3 scores are 0
	public Student(String name)
	{
		this(name, 3);
	}

	// Name is name and n scores are 0
	public Student(String name, int testCount)
	{
		this.name = name;
		tests = new int[testCount];
		for (int i = 0; i < tests.length; i++)
		{
			tests[i] = 0;
		}
	}
	
	/**
	 * Performs a shallow clone of the student.
	 * @return A shallow clone of the current student object.
	 */
	public Student memberwiseClone()
	{
		final Student student = new Student(null, 0);
		student.name = name;
		student.tests = tests;
		return student;
	}

	public int getNumberOfTests()
	{
		return tests.length;
	}

	public void setName(String nm)
	{
		name = nm;
	}

	public String getName()
	{
		return name;
	}

	public void setScore(int i, int score)
	{
		tests[i - 1] = score;
	}

	public int getScore(int i)
	{
		return tests[i - 1];
	}

	public int getAverage()
	{
		int sum = 0;
		for (int score : tests)
		{
			sum += score;
		}
		return sum / tests.length;
	}

	public int getHighScore()
	{
		int highScore = 0;
		for (int score : tests)
		{
			highScore = Math.max(highScore, score);
		}
		return highScore;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder("Name: " + name + "\n");
		for (int i = 0; i < tests.length; i++)
		{
			str.append("test ").append(i + 1).append(":  ").append(tests[i]).append("\n");
		}
		str.append("Average: ").append(getAverage());
		return str.toString();
	}

	// Returns null if there are no errors else returns
	// an appropriate error message.
	public String validateData()
	{
		if (name == null || "".equals(name))
		{
			return "SORRY: Name required.";
		}
		
		for (int score : tests)
		{
			if (score < 0 || score > 100)
			{
				String str = "SORRY: must have " + 0
						+ " <= test score <= " + 100;
				return str;
			}
		}
		
		return null;
	}
}
