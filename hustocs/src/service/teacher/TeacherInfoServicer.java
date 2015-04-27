package service.teacher;

import service.UserServicer;

public interface TeacherInfoServicer extends UserServicer {
	public boolean updateInfo();
	public void viewInfo();
}
