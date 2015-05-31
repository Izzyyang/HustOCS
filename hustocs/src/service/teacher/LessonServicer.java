package service.teacher;

import java.io.Serializable;
import java.util.List;

import entity.Lesn;

public interface LessonServicer {
	public boolean openLesson(Lesn lesson);
	public boolean updateLesson(Lesn lesson);
	public boolean deleteLesson(String lessonId);
	public List listLessons(Class c, List<String> strList, List<Object> value);
	public Lesn viewLesson(Class c, Serializable lessonId);
}
