package service.teacher;

import dao.ResourceDao;

public class TeacherResourceFactory implements TeacherServiceFactoryer {

	@Override
	public TeacherServicer produce() {
		return new TeacherService(new ResourceDao());
	}

}
