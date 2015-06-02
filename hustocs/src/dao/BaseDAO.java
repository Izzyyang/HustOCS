package dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import dao.HibeSesnFacy;
import entity.Acay;
import entity.Admn;
import entity.Lesn;
import entity.Rese;
import entity.Tear;

public class BaseDAO{
 
	private Session s = null;
	
	public BaseDAO() {
		s = HibeSesnFacy.getSession();
	}
	public void Close() {
		s.close();
	}
	public Session initSession(){
		return HibeSesnFacy.getSession();
	}
	
	public List dc(DetachedCriteria dc) {
		Session s = null;
        s = initSession();
		Criteria c = dc.getExecutableCriteria(s);
		List rs = c.list();
		s.close();
		return rs;
	}
	
	/*
	 * 插入一个Object
	 */
	public boolean add(Object o){
		Session s = null;
        s = initSession();
		try{
			//s.beginTransaction();
			s.getTransaction().begin();
			s.save(o);
			s.getTransaction().commit();
			//s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 带条件的查询
	 * @param c
	 * @param strList
	 * @param value
	 * @return
	 */
	public List find(Class c, List<Object> strList, List<Object> value){
		Session s = null;
        s = initSession();
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		for(int i = 0; i < strList.size(); i++){
			dc.add(Restrictions.eq((String) strList.get(i), value.get(i)));
		}
		List ls = dc(dc);
		if (ls.size()>0) {
			return ls;
		}else{
			return null;
		}
	}
	/**
	 * 带条件的级联查询
	 * @param c
	 * @param strList
	 * @param value
	 * @return
	 */
	public List find(Class c,String cascadeClass, List<Object> strList, List<Object> value){
		Session s = null;
        s = initSession();
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		dc.createAlias(cascadeClass, cascadeClass);
		System.out.println(cascadeClass+"------------------------"+cascadeClass);
		for(int i = 0; i < strList.size(); i++){
			dc.add(Restrictions.eq((String) strList.get(i), value.get(i)));
		}
		List ls = dc(dc);
		if (ls.size()>0) {
			return ls;
		}else{
			return null;
		}
	}
	/*
	 * 通过Unique键l或外键list Objects
	 */
	public List find(Class c, String field, Object value){
		Session s = null;
        s = initSession();
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		dc.add(Restrictions.eq(field, value));
		List ls = dc(dc);
		return ls;
	}
	/*
	 * 有级联关系的查询
	 */
	public List find(Class c,String cascadeClass, String field, Object value){
		Session s = null;
        s = initSession();
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		dc.createAlias(cascadeClass, cascadeClass);
		dc.add(Restrictions.eq(field, value));
		List ls = dc(dc);
		return ls;
	}
	
	
	/*
	 * 通过主键获取一个Object
	 */
	public Object getById(Class c, Serializable id) {
		Session s = null;
        s = initSession();
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
		Session s = null;
        s = initSession();
		Object o  = s.load(c,  id);
		return o;
	}
		
	/*
	 * 删除一个Object
	 */
	public boolean deleObject(Object o){
		Session s = null;
        s = initSession();
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
		Session s = null;
        s = initSession();
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
		Session s = null;
        s = initSession();
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
		Session s = null;
        s = initSession();
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		List ls = dc(dc);
		return ls;
		
	}
	
	public static void main(String args[]) {
		//Test deleteById
//		Acay a = new Acay();
//		a.setId((short) 5);
//		a.setName("计算机学院");
//		System.out.println(new BaseDAO().add(a));
		Tear tear = (Tear) new BaseDAO().getById(Tear.class,"1");
	
		// test add lesson;
		//Lesn less = new Lesn("2", "1", "2", tear, null, "12345678", "2345678", new Timestamp(System.currentTimeMillis()), (short)1);
//		Lesn less = new Lesn();
//		less.setTear(tear);
//		less.setBrief("111");
//		less.setFclassify("1");
//		less.setSclassify("2");
//		less.setTitle("23457890-=");
//		less.setStatus((short) 0);
//		less.setTime(new Timestamp(System.currentTimeMillis()));
//		new BaseDAO().add(less);
		
		//测试查找老师课程分类；
//		List<Object> fQueryList  = new ArrayList<>();
//		List<Object> fVlueList  = new ArrayList<>();
//		fQueryList.add("tear");
//		fVlueList.add(tear);
//		fQueryList.add("fclassify");
//		fVlueList.add("1");
//		
//		List<Lesn> fLessList = new BaseDAO().find(Lesn.class, fQueryList, fVlueList);
//		System.out.println(fLessList.size());
//		Set<Lesn> lesns = new HashSet<>();
//		lesns.addAll(fLessList);
//		Iterator<Lesn>  iterator = lesns.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next().getId());
//		}
		
		List<Rese> lest = new BaseDAO().find(Rese.class, "reseSort","reseSort.name", "files");
		System.out.println(lest.size());
	}
}