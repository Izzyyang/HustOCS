package service;

import java.util.List;

import util.TimeUtil;
import util.UUIDUtil;
import dao.BaseDAO;
import entity.Lesn;
import entity.Rese;

public class TearReseSereImpl  implements ITearReseSere{
	private BaseDAO bd = null;
	public TearReseSereImpl(){
		bd = new BaseDAO();
	}
	@Override
	public boolean addRese(String lId, Rese r) {
		Lesn l = (Lesn) bd.load(Lesn.class, lId);
		if (l != null && r != null) {
			r.setId(UUIDUtil.generate32());
			r.setLesn(l);
			r.setTime(TimeUtil.getCurrTimeStamp());
			r.setStatus((short) StaticResource.ResourceStatus.UNCHECKED.ordinal());
			boolean re = bd.add(r);
			bd.Close();
			return re;
		}
		return false;
	}

	@Override
	public boolean deleRese(String rId) {
		Rese r = (Rese) bd.load(Rese.class, rId);
		r.setStatus((short) StaticResource.ResourceStatus.DELETED.ordinal());
		return updeRese(r);
	}

	@Override
	public boolean updeRese(Rese r) {
		boolean re = bd.updateObject(r);
		bd.Close();
		return re;
	}

	@Override
	public Rese getRese(String rId) {
		return (Rese) bd.getById(Rese.class, rId);
	}

	@Override
	public List listRese(String lId) {
		Lesn l = (Lesn) bd.load(Lesn.class, lId);
		List r =  bd.find(Rese.class, "lesn", l);
		bd.Close();
		return r;
	}
	@Override
	public int copyReseFile(String rId, String fUri, int count) {
		// TODO Auto-generated method stub
		return 0;
	}

}
