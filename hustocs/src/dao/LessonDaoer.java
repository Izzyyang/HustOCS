package dao;

import java.io.Serializable;
import java.util.List;

import entity.Lesn;

public interface LessonDaoer {
	public boolean insert(Lesn lesson);
	public boolean delete(String lessonId);
	public boolean update(Lesn lesson);
	public void view(Serializable lessonId);
	public List list(String hqlString,int lessonId);
}
