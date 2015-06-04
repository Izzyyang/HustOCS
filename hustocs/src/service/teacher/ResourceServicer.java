package service.teacher;

import java.io.Serializable;
import java.util.List;

import util.Page;

import entity.Rese;

public interface ResourceServicer {
	public boolean addResource(Rese resource);
	public boolean deleteResource(String resourceId);
	public boolean updateResource(Rese resource);
	public Rese viewResource(Class c, Serializable resId);
	public List listLessons(Class c, List<Object> fQueryList, List<Object> value);
	public Page listLessons(Class c, List<Object> fQueryList, List<Object> value,int pageNo,int pageSize);
	public List listLessons(Class c, String cascadeClass,List<Object> fQueryList, List<Object> value);
}
