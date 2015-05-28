package service.teacher;

import java.util.List;

import dao.TeacherDaoer;
import dao.TeacherInfoDaoer;
import entity.Tear;
import entity.TearInfo;

public class TeacherInfoService implements TeacherInfoServicer{
	
	private  TeacherInfoDaoer teacherInfoDao;
	
	public TeacherInfoService(TeacherInfoDaoer teacherDao) {
		this.teacherInfoDao = teacherDao;
	}
	
	public TeacherInfoService() {}
	
	public TeacherInfoDaoer getTeacherDao() {
		return teacherInfoDao;
	}

	public void setTeacherDao(TeacherInfoDaoer teacherDao) {
		this.teacherInfoDao = teacherDao;
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
	public List<TearInfo> find(Class c, List<String> strList, List<Object> value){
		return teacherInfoDao.find(c, strList, value);
	}

	@Override
	public List<TearInfo> findTeacherByStr(Class c, String field, Object value) {
		return teacherInfoDao.findbyStr(c, field, value);
	}
}
