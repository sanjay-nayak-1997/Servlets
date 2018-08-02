package com.deloitte;

public class GreetingsBO {

	public String generateMessage(String name,String loc)
	{

		String msg="Welcome " + name + ". You are living in " + loc;
		return msg;
	}
	
}
