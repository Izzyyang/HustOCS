package service;

import java.util.List;

import entity.Rese;

public interface ITearReseSere {
	boolean addRese(String lId, Rese r);
	boolean deleRese(String rId);
	boolean updeRese(Rese r);
	int copyReseFile(String rId, String fUri, int count);
	Rese getRese(String rId);
	List listRese(String lId);
}
