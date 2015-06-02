package service.teacher;

import java.io.Serializable;
import java.util.List;
import entity.ReseSort;

public interface ResourceSortServicer {
	public boolean addResourceSort(ReseSort resource);
	public boolean deleteResourceSort(ReseSort reseSort);
	public boolean updateResourceSort(ReseSort resource);
	public ReseSort viewResourceSort(Class c, Serializable resId);
	public List listResourceSort(Class c, List<Object> fQueryList, List<Object> value);
	public List listResourceSort(Class c, String cascadeClass,List<Object> fQueryList, List<Object> value);
}
