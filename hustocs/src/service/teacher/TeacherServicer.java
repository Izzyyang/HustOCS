package service.teacher;

import java.util.List;

import entity.Tear;
import entity.TearInfo;
import service.UserServicer;

public interface TeacherServicer extends UserServicer {
	public boolean updateInfo();
	public void viewInfo();
	public List<Tear> findTeacherByStr(Class c, List<String> strList, List<Object> value);
}
