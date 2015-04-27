package service.teacher;

import dao.LessonDao;
import dao.ResourceDao;
import dao.TeacherDao;

public class TeacherServiceFactory {
	public static LessonServicer produceLessonService() {
		return new LessonService(new LessonDao());
	}
	public static ResourceServicer produceResourceService() {
		return new ResourceService (new ResourceDao());
	}
	public  static TeacherInfoServicer produceTeacherService() {
		return new TeacherInfoService(new TeacherDao());
	}
}
