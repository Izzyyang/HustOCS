package net.SunLnx.ffaver;

public class InvalidOptionException extends  Exception{

	private static final long serialVersionUID = 1L;
	public InvalidOptionException(){}
	public InvalidOptionException(String message) {
		super(message);
	}
}
