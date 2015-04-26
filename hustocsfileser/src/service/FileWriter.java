package service;

import java.io.InputStream;


public interface FileWriter {
	 boolean write(InputStream is, String fn);
}
