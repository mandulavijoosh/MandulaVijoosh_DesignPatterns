package com.epam.vijoosh.DesignPattern;
class single
{
	private static single singleton_instance=null;
	public String s;
	private single()
	{
		s=" Singleton class";
	}
	public static single getInstance()
	{
		if(singleton_instance==null)
			singleton_instance=new single();
		return singleton_instance;
	}
}
public class singletonDesignPattern {
	public static void main(String args[])
	{
		single s1=single.getInstance();
		single s2=single.getInstance();
		System.out.println(s1.s);
		System.out.println(s2.s);
	}

}
