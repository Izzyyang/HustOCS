package dao;

import java.util.List;
import entity.Rese;

public interface ResourceDaoer {
	public boolean insert(Rese resource);
	public boolean delete(String resourceId);
	public boolean update(Rese resource);
	public void view(String resourceId);
	public List list(String lessonId, int type);
}
