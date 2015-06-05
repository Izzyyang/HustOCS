package service.teacher;

import java.io.Serializable;
import java.util.List;
import entity.Tear;
import entity.TearInfo;
import service.UserServicer;
import util.Page;

public interface TeacherInfoServicer extends UserServicer {
	public boolean updateTeacherInfo(TearInfo tearInfo);
	public boolean addTeacherInfo(TearInfo tearInfo);
	public boolean deleteTeacherInfoById(Class c,Serializable tearinfoID);
	public TearInfo viewTeacherInfo(Class c,Serializable teacherInfoID);
	public List<TearInfo> find(Class c, List<Object> strList, List<Object> value);
	public List<TearInfo> findTeacherInfoByStr(Class c, String field, Object value);
	public Page listLessons(Class c, List<Object> fQueryList, List<Object> value,int pageNo,int pageSize);
	public List listLessons(Class c, String cascadeClass,List<Object> fQueryList, List<Object> value);
	
}
