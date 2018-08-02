package com.deloitte;

public class SmallBigBO {
	
	public int[] getSmallBig(int num1,int num2)
	{
		int big,small;
		if(num1>num2)
		{
			big=num1;
			small=num2;
		}
		else
		{
			small=num1;
			big=num2;
		}
		int[] a= {big,small};
		return a;
	}

}
