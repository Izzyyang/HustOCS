package net.SunLnx.Comprer;

import java.util.List;

public interface Comprer {
	public boolean compress(String srcpath, String desfile);
	public boolean comress(List<String> srcpaths, String desfile);
}
