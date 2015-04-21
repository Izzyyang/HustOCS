package net.SunLnx.Comprer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipComprer implements Comprer{

	@Override
	public boolean compress(String srcFilePath, String desFilePath) {
		File srcFile = new File(srcFilePath);
		File desFile = new File(desFilePath);
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
			ZipOutputStream zis = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(desFile)));
			ZipEntry entry = new ZipEntry(srcFilePath);
			zis.putNextEntry(entry);
			byte[] buffer = new byte[1024];
			while ((bis.read(buffer)) > 0){
				zis.write(buffer);
			}
			bis.close();
			zis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean comress(List<String> srcpaths, String desfile) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void main(String agrs[]) {
		ZipComprer zipC = new ZipComprer();
		//zipC.c
	}

}
