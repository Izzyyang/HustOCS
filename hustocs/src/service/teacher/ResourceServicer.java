package service.teacher;

import java.util.List;

public interface ResourceServicer {
	public boolean addResource();
	public boolean deleteResource();
	public boolean updateResource();
	public void viewResource();
	public List listLessonResource();
}
