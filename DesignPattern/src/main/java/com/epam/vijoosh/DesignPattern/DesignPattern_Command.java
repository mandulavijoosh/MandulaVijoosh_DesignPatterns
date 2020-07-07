package com.epam.vijoosh.DesignPattern;
interface Command 
{ 
	public void execute(); 
} 
class Light 
{ 
	public void on() 
	{ 
		System.out.println("Light is on"); 
	} 
	public void off() 
	{ 
		System.out.println("Light is off"); 
	} 
} 
class LightOnCommand implements Command 
{ 
	Light light; 
	public LightOnCommand(Light light) 
	{ 
	this.light = light; 
	} 
	public void execute() 
	{ 
	light.on(); 
	} 
} 
class LightOffCommand implements Command 
{ 
	Light light; 
	public LightOffCommand(Light light) 
	{ 
		this.light = light; 
	} 
	public void execute() 
	{ 
		light.off(); 
	} 
} 
class Stereo 
{ 
	public void on() 
	{ 
		System.out.println("Stereo is on"); 
	} 
	public void off() 
	{ 
		System.out.println("Stereo is off"); 
	} 
	public void setCD() 
	{ 
		System.out.println("Stereo is set " + 
						"for CD input"); 
	} 
	public void setDVD() 
	{ 
		System.out.println("Stereo is set"+ 
						" for DVD input"); 
	} 
	public void setRadio() 
	{ 
		System.out.println("Stereo is set" + 
						" for Radio"); 
	} 
	public void setVolume(int volume) 
	{  
	System.out.println("Stereo volume set"
						+ " to " + volume); 
	} 
} 
class StereoOffCommand implements Command 
{ 
	Stereo stereo; 
	public StereoOffCommand(Stereo stereo) 
	{ 
		this.stereo = stereo; 
	} 
	public void execute() 
	{ 
	stereo.off(); 
	} 
} 
class StereoOnWithCDCommand implements Command 
{ 
	Stereo stereo; 
	public StereoOnWithCDCommand(Stereo stereo) 
	{ 
		this.stereo = stereo; 
	} 
	public void execute() 
	{ 
		stereo.on(); 
		stereo.setCD(); 
		stereo.setVolume(11); 
	} 
} 
class SimpleRemoteControl 
{ 
	Command slot; 

	public SimpleRemoteControl() 
	{ 
	} 

	public void setCommand(Command command) 
	{ 
		slot = command; 
	} 

	public void buttonWasPressed() 
	{ 
		slot.execute(); 
	} 
} 
class DesignPattern_Command 
{ 
	public static void main(String[] args) 
	{ 
		SimpleRemoteControl remote = 
				new SimpleRemoteControl(); 
		Light light = new Light(); 
		Stereo stereo = new Stereo(); 
		remote.setCommand(new
					LightOnCommand(light)); 
		remote.buttonWasPressed(); 
		remote.setCommand(new
				StereoOnWithCDCommand(stereo)); 
		remote.buttonWasPressed(); 
		remote.setCommand(new
				StereoOffCommand(stereo)); 
		remote.buttonWasPressed(); 
	} 
} 
