package service.teacher;

import dao.LessonDao;

public class TeacherLessonServiceFactory implements TeacherServiceFactoryer {

	@Override
	public TeacherServicer produce() {
		return new TeacherService(new LessonDao());
	}

}
