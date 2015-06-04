package service.teacher;

import java.io.Serializable;
import java.util.List;
import entity.Tear;
import service.UserServicer;

public interface TeacherServicer extends UserServicer {
	
	public boolean add(Tear teacher);
	public boolean updateTeacher(Tear teacher);
	public boolean deleteTeacherByID(Class c,Serializable teacherid);
	public List listTeacher(Class c, List<Object> fQueryList, List<Object> value);
	public Tear viewTeacher(Class c, Serializable lessonId);
	
}
