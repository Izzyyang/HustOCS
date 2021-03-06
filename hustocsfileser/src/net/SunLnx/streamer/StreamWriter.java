package net.SunLnx.streamer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public interface StreamWriter {
	boolean write(String path, String src) throws IOException;
	boolean write(OutputStream os, String src) throws IOException;
	boolean write(String fn, InputStream is) throws  IOException;
	boolean write(OutputStream os, InputStream is) throws IOException;
}
