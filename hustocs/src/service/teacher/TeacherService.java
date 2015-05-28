package service.teacher;

import java.util.List;

import dao.TeacherDaoer;
import entity.Tear;

public class TeacherService implements TeacherServicer {
	
	private  TeacherDaoer teacherDao;
	
	public TeacherService(TeacherDaoer teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	public TeacherService() {}
	
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
    //查找教师
	@Override
	public void viewInfo() {
	}

	@Override
	public List<Tear> findTeacherByStr(Class c, List<String> strList, List<Object> value){
		return teacherDao.find(c, strList, value);
	}
}
