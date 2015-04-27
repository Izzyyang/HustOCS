package service.teacher;

import java.util.List;

import dao.LessonDaoer;

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
	public boolean openLesson() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean updateLesson() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteLesson() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List listLessons() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void viewLesson() {
		// TODO Auto-generated method stub
		
	}
}
