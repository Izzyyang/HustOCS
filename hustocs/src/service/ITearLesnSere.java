package service;

import java.util.List;

import entity.Lesn;

public interface ITearLesnSere {
	boolean addLesn(String tId, Lesn l);
	boolean updeLesn(Lesn l);
	boolean deleLesn(String lId);
	Lesn getLesn(String lId);
	List listLesn(String tId);
}
