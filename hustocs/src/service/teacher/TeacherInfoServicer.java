package service.teacher;

import java.util.List;

import entity.Tear;
import entity.TearInfo;
import service.UserServicer;

public interface TeacherInfoServicer extends UserServicer {
	public boolean updateInfo();
	public void viewInfo();
	public List<TearInfo> find(Class c, List<String> strList, List<Object> value);
	public List<TearInfo> findTeacherByStr(Class c, String field, Object value);
	
}
