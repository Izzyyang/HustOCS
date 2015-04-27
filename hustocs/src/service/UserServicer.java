package service;

public interface UserServicer {
	public abstract String regster(String id, String password);
	public abstract String login(String id, String password);
}
