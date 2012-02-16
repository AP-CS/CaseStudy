package com.earth2me.school.casestudy;

public class TestScoresApp
{

	public static void main(String[] args)
	{
		TestScoresModel model = new TestScoresModel();
		TestScoresView view = new TestScoresView(model);
		view.run();
	}
}
