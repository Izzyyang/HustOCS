package service;

import dao.LessonDaoer;
import dao.ResourceDaoer;
import dao.TeacherDaoer;

public class TeacherService extends AbstractUserService implements TeacherServicer {
	private TeacherDaoer teacherDao;
	private LessonDaoer lessonDao;
	private ResourceDaoer resourceDao;
	public TeacherService(TeacherDaoer teacherDao) {
		this.teacherDao = teacherDao;
	}
	public TeacherService(LessonDaoer lessonDao) {
		this.lessonDao = lessonDao;
	}
	public TeacherService(ResourceDaoer resourceDao) {
		this.resourceDao = resourceDao;
	}
	public TeacherDaoer getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDaoer teacherDao) {
		this.teacherDao = teacherDao;
	}

	public LessonDaoer getLessonDao() {
		return lessonDao;
	}

	public void setLessonDao(LessonDaoer lessonDao) {
		this.lessonDao = lessonDao;
	}

	public ResourceDaoer getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDaoer resourceDao) {
		this.resourceDao = resourceDao;
	}

	
	@Override
	public String regster(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UserServicer user) {
		// TODO Auto-generated method stub
		return false;
	}
}
