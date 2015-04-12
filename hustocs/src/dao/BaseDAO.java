package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import dao.HibeSesnFacy;
import entity.Acay;

public class BaseDAO{

	private Session s = null;
	public BaseDAO() {
		s = HibeSesnFacy.getSession();
	}
	public void Close() {
		s.close();
	}
	public List dc(DetachedCriteria dc) {
		Criteria c = dc.getExecutableCriteria(s);
		List rs = c.list();
		s.close();
		return rs;
	}
	
	/*
	 * 插入一个Object
	 */
	public boolean add(Object o){
		try{
			s.beginTransaction();
			s.save(o);
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List find(Class c, List<String> strList, List<Object> value){
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		for(int i = 0; i < strList.size(); i++){
			dc.add(Restrictions.eq(strList.get(i), value.get(i)));
		}
		List ls = dc(dc);
		return ls;
	}
	
	/*
	 * 通过主键获取一个Object
	 */
	public Object getById(Class c, Serializable id) {
		Session s = HibeSesnFacy.getSession();
		s.beginTransaction();
		Object o = s.get(c, id);
		s.getTransaction().commit();
		s.close();
		return o;
	}
	/*
	 * 通过主键加载一个Object
	 */
	public Object load(Class c,  Serializable id) {
		Object o  = s.load(c,  id);
		return o;
	}
		
	/*
	 * 通过Unique键l或外键list Objects
	 */
	public List find(Class c, String field, Object value){
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		dc.add(Restrictions.eq(field, value));
		List ls = dc(dc);
		return ls;
	}
	
	/*
	 * 删除一个Object
	 */
	public boolean deleObject(Object o){
		try{
			s.beginTransaction();
			s.delete(o);
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	/*
	 * 通过ID删除一个Object
	 */
	public boolean deleteById(Class c, Serializable id) {
	    Object obj =s.load(c, id);
	    if (obj != null) {
	    	s.beginTransaction();
	        s.delete(obj);
	        s.getTransaction().commit();
	        s.close();
	        return true;
	    }
	    return false;
	}
	
	/*
	 * 更新Object
	 */
	public boolean updateObject(Object o){
		try{
			s.beginTransaction();
			s.update(o);
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	public List listAll(Class c) {
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		List ls = dc(dc);
		return ls;
		
	}
	
	public static void main(String args[]) {
		//Test deleteById
		Acay a = new Acay();
		a.setId((short) 4);
		a.setName("算法");
		System.out.println(new BaseDAO().add(a));		
	}
}