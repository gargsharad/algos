package org.guru.date;

public class DateUtil {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		{
			MyDate d1 = new MyDate(4, 3, 1988);
			MyDate d2 = new MyDate(30, 3, 1988);
			int ans = d2.noOfDaysWith(d1);
			System.out.println(" ans " + ans);
		}

		{
			MyDate d1 = new MyDate(12, 7, 1984);
			MyDate d2 = new MyDate(20, 12, 1984);
			int ans = d2.noOfDaysWith(d1);
			System.out.println(" ans2 " + ans);
		}

		{
			MyDate d1 = new MyDate(3, 1, 1989);
			MyDate d2 = new MyDate(8, 3, 1983);
			int ans = d1.noOfDaysWith(d2);
			System.out.println(" ans3 " + ans);
		}
		
		MyDate today = new MyDate(6, 3, 2012);
		
		MyDate myBirthDay = new MyDate(6,8,1982);
		MyDate asBirthDay = new MyDate(28,3,2011);
		
		System.out.println(" today is "+today.getAbsDay());
		
		System.out.println(" My Age "+today.noOfDaysWith(myBirthDay));
		System.out.println(" AS Age "+today.noOfDaysWith(asBirthDay));
	}

	public static class MyDate {

		int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		final public int day, month, year;
		final public boolean isLeap;

		public MyDate(int day, int month, int year) {
			super();
			this.day = day;
			this.month = month;
			this.year = year;
			this.isLeap = year % 4 == 0;
			if (isLeap) {
				monthDays[1] = 29;
			}
		}

		public int noOfDaysWith(MyDate myDate) {
			return getAbsDay() - myDate.getAbsDay() + 1;
		}

		public int getAbsDay() {

			if (year < 1901) {
				throw new IllegalArgumentException();
			}

			int absDays = 0;

			int dYear = year;
			int noOfLeapYears = dYear / 4;
			absDays = dYear * 365 + noOfLeapYears;

			// add months
			for (int i = 0; i < month; i++) {
				absDays += monthDays[i];
			}

			absDays += day;

			return absDays;

		}

	}

}
