package service.teacher;

import dao.TeacherDao;

public class TeacherUserServiceFactory implements TeacherServiceFactoryer{
	@Override
	public TeacherServicer produce() {
		return new TeacherService(new TeacherDao());
	}
}
