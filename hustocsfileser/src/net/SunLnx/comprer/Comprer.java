package net.SunLnx.comprer;

import java.util.List;

public interface Comprer {
	public boolean compress(String srcpath, String desfile);
	public boolean compress(List<String> srcpaths, String desfile);
}
