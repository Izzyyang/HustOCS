package service.teacher;

import java.io.Serializable;
import java.util.List;

import util.Page;

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
		return null;
	}

	@Override
	public String login(String id, String password) {
		return null;
	}

	@Override
	public boolean updateTeacherInfo(TearInfo tearInfo) {
		return teacherInfoDao.update(tearInfo);
	}

	@Override
	public boolean addTeacherInfo(TearInfo tearInfo) {
		return teacherInfoDao.insert(tearInfo);
	}

	@Override
	public boolean deleteTeacherInfoById(Serializable tearinfoID) {
		return teacherInfoDao.delete(tearinfoID);
	}

	@Override
	public boolean deleteTeacherInfo(Serializable tearinfoID) {
		return teacherInfoDao.delete(tearinfoID);
	}

	@Override
	public TearInfo viewTeacherInfo(Class c, Serializable teacherInfoID) {
		return teacherInfoDao.view(c, teacherInfoID);
	}

	@Override
	public List<TearInfo> find(Class c, List<Object> strList, List<Object> value) {
		return teacherInfoDao.list(c, strList, value);
	}

	@Override
	public List<TearInfo> findTeacherInfoByStr(Class c, String field,
			Object value) {
		return teacherInfoDao.findTeacherInfoByStr(c, field, value);
	}

	@Override
	public Page listLessons(Class c, List<Object> fQueryList,
			List<Object> value, int pageNo, int pageSize) {
		return teacherInfoDao.listPage(c, fQueryList, value, pageNo, pageSize);
	}

	@Override
	public List listLessons(Class c, String cascadeClass,
			List<Object> fQueryList, List<Object> value) {
		return null;
	}

}
