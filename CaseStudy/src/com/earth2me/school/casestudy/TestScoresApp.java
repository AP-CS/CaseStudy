package com.earth2me.school.casestudy;

public final class TestScoresApp
{
	/**
	 * Prevents the class from being instantiated.  Do not use.  Do not remove.
	 * @deprecated
	 */
	@Deprecated
	private TestScoresApp()
	{
		// Intentionally blank.
	}
	
	public static void main(String[] args)
	{
		TestScoresModel model = new TestScoresModel();
		TestScoresView view = new TestScoresView(model);
		view.run();
	}
}
