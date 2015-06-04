package service.teacher;

import java.io.Serializable;
import java.util.List;

import dao.TeacherDaoer;
import entity.Tear;
import entity.TearInfo;

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
		return null;
	}

	@Override
	public boolean add(Tear teacher) {
		return teacherDao.insert(teacher);
	}

	@Override
	public boolean updateTeacher(Tear teacher) {
		return teacherDao.update(teacher);
	}

	@Override
	public boolean deleteTeacherByID(Class c,Serializable teacherid) {
		return teacherDao.delete(c,teacherid);
	}

	@Override
	public List listTeacher(Class c, List<Object> fQueryList, List<Object> value) {
		return teacherDao.find(c, fQueryList, value);
	}

	@Override
	public Tear viewTeacher(Class c, Serializable TeacherId) {
		return teacherDao.view(c,TeacherId);
	}

}
