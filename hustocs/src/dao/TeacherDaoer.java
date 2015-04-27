package dao;

import entity.Tear;

public interface TeacherDaoer {
	public boolean insert(Tear teacher);
	public boolean update(Tear teacher);
	public Tear view(String tId);
}
