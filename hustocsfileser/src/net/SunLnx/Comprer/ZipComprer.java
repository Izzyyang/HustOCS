package net.SunLnx.Comprer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipComprer implements Comprer{

	@Override
	public boolean compress(String srcpath, String desfile) {
		File f = new File(desfile);
		try {
			ZipOutputStream zis = new ZipOutputStream(new FileOutputStream(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

}
