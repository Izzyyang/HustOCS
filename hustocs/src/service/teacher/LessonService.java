package service.teacher;

import java.io.Serializable;
import java.util.List;

import dao.LessonDaoer;
import entity.Lesn;

public class LessonService implements LessonServicer{
	private LessonDaoer lessonDao;
	public LessonService(LessonDaoer lessonDao) {
		this.lessonDao = lessonDao;
	}
	public LessonDaoer getLessonDao() {
		return lessonDao;
	}

	public void setLessonDao(LessonDaoer lessonDao) {
		this.lessonDao = lessonDao;
	}
	@Override
	public boolean openLesson(Lesn lesson) {
		return lessonDao.insert(lesson);
	}
	@Override
	public boolean updateLesson(Lesn lesson) {
		return lessonDao.update(lesson);
	}
	@Override
	public boolean deleteLesson(String lessonId) {
		return lessonDao.delete(lessonId);
	}
	@Override
	public List listLessons(Class c, List<Object> strList, List<Object> value) {
		return lessonDao.list(c, strList, value);
	}
	@Override
	public Lesn viewLesson(Class c,Serializable lessonId) {
		return lessonDao.view(c, lessonId);
	}
}
