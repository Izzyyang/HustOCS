package service.teacher;

import java.util.List;

public interface LessonServicer {
	public boolean openLesson();
	public boolean updateLesson();
	public boolean deleteLesson();
	public List listLessons();
	public void viewLesson();
}
