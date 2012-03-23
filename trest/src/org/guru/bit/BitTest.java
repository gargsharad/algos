package org.guru.bit;

public class BitTest extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		int n = 4 & 5;
		System.out.println(n+" :  "+count(n));
	}

	public static int count(int n)
	{
	int count=0;
	for(;n!=0;n=n>>1)
	count+=n&1;
	return count;

	}
}
