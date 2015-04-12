package service;

import java.io.InputStream;


public interface IFileWriter {
	 boolean write(InputStream is, String fn);
}
