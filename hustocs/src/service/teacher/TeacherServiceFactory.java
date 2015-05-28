package service.teacher;

import dao.LessonDao;
import dao.ResourceDao;
import dao.TeacherDao;
import dao.TeacherInfoDao;

public class TeacherServiceFactory {
	public static LessonServicer produceLessonService() {
		return new LessonService(new LessonDao());
	}
	public static ResourceServicer produceResourceService() {
		return new ResourceService (new ResourceDao());
	}
	public  static TeacherServicer produceTeacherService() {
		return new TeacherService(new TeacherDao());
	}
	public  static TeacherInfoServicer produceTeacherInfoService() {
		return new TeacherInfoService(new TeacherInfoDao());
	}
}
