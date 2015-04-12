package service;

import java.util.List;

import util.TimeUtil;
import util.UUIDUtil;
import dao.BaseDAO;
import entity.Lesn;
import entity.Tear;

public class TearSereImpl implements ITearLesnSere{

	@Override
	public boolean addLesn(String tId, Lesn l) {
		BaseDAO bd  = new BaseDAO();
		Tear t = (Tear) bd.load(Tear.class, tId);
		if (t != null && l != null) {
			l.setTear(t);
			l.setId(UUIDUtil.generate32());
			l.setTime(TimeUtil.getCurrTimeStamp());
			l.setStatus((short) StaticResource.LessonStatus.UNCHECKED.ordinal());
			boolean r = bd.add(l);
			bd.Close();
			return r;
		}
		return false;
	}
	
	@Override
	public boolean deleLesn(String lId) {
		BaseDAO bd = new BaseDAO();
		boolean r = bd.deleteById(Lesn.class, lId);
		bd.Close();
		return r;
	}

	@Override
	public boolean updeLesn(Lesn l) {
		BaseDAO bd = new BaseDAO();
		boolean r = bd.updateObject(l);
		bd.Close();
		return r;
	}
	
	@Override
	public Lesn getLesn(String lId) {
		BaseDAO bd = new BaseDAO();
		bd.getById(Lesn.class, lId);
		return null;
	}
	
	@Override
	public List listLesn(String tId) {
		BaseDAO bd = new BaseDAO();
		Tear t = (Tear) bd.load(Tear.class, tId);
		return bd.find(Lesn.class, "tear", t);
	}
}
