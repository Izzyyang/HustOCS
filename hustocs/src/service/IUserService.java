package service;

public interface IUserService {
	boolean regster(User user);
	boolean login(User user);
	boolean update(User user);
}
