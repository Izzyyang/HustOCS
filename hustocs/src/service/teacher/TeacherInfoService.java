package service.teacher;

import dao.TeacherDaoer;

public class TeacherInfoService implements TeacherInfoServicer {
	private TeacherDaoer teacherDao;
	public TeacherInfoService(TeacherDaoer teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	public TeacherDaoer getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDaoer teacherDao) {
		this.teacherDao = teacherDao;
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
	public boolean updateInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewInfo() {
		// TODO Auto-generated method stub
		
	}	
	
}
