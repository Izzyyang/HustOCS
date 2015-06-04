package service.teacher;

import java.util.List;

import entity.Tear;
import entity.TearInfo;
import service.UserServicer;

public interface TeacherServicer extends UserServicer {
	public boolean updateInfo();
	public TearInfo viewInfo();
	public List<Tear> findTeacherByStr(Class c, List<Object> strList, List<Object> value);
}
