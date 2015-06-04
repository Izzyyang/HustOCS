package service.teacher;

import java.io.Serializable;
import java.util.List;

import entity.Lesn;
import entity.ReseSort;

public interface LessonServicer {
	public boolean openLesson(Lesn lesson);
	public boolean updateLesson(Lesn lesson);
	public boolean deleteLesson(String lessonId);
	public List listLessons(Class c, List<Object> fQueryList, List<Object> value);
	public List listLessons(Class c, String cascadeClass,List<Object> fQueryList, List<Object> value);
	public Lesn viewLesson(Class c, Serializable lessonId);
}

