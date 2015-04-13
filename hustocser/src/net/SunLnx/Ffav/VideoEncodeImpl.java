
package net.SunLnx.Ffav;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.AudioInfo;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoInfo;
import it.sauronsoftware.jave.VideoSize;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VideoEncodeImpl implements IFfmpegEncoder, IVideoDealer {

	@Override
	public boolean ToFlv(String dp, String sp) {
		File sf = new File(sp);
		try {
			String t = Files.probeContentType(sf.toPath());
			System.out.println(t);
			if (!t.equals("flv")) {
				File source = new File(sp);
				File target = new File(dp);

				Encoder e = new Encoder();
				MultimediaInfo info = e.getInfo(source);
				String f = info.getFormat();
				AudioInfo ai = info.getAudio();
				
				VideoInfo vi = info.getVideo();
				
				System.out.println(f + ":" + info.getDuration());
				System.out.println(ai.getBitRate() + ":" + ai.getChannels()
						+ ":" + ai.getDecoder() + ":" + ai.getSamplingRate());
				VideoSize vs = vi.getSize();
				System.out.println(vi.getBitRate() + ":" + vi.getDecoder()
						+ ":" + vs.getHeight() + "*" + vs.getWidth() + ":"
						+ vi.getFrameRate());

				AudioAttributes audio = new AudioAttributes();
				audio.setCodec("libmp3lame");
				audio.setBitRate(new Integer(64000));
				audio.setChannels(new Integer(1));
				audio.setSamplingRate(new Integer(22050));
				VideoAttributes video = new VideoAttributes();
				video.setCodec("flv");
				video.setBitRate(new Integer(160000));
				video.setFrameRate(new Integer(15));
				video.setSize(new VideoSize(400, 300));
				
				EncodingAttributes attrs = new EncodingAttributes();
				attrs.setFormat("flv");
				attrs.setAudioAttributes(audio);
				attrs.setVideoAttributes(video);
				Encoder encoder = new Encoder();
				encoder.encode(source, target, attrs);
				return true;
			}
		} catch (IOException e) {

		} catch (EncoderException e) {

		}
		return false;
	}

	@Override
	public boolean ToMp4() {
		final Path videoIn = Paths.get("/home/sunlnx/How fast.ogg");
		final Path encodingFile = Paths.get("/home/sunlnx/output5.flv");
		final Path errorFile = Paths.get("/home/sunlnx/error.txt");
		int retCode;
		try {
			Files.deleteIfExists(encodingFile);
			Files.deleteIfExists(errorFile);
			final ProcessBuilder pb = new ProcessBuilder(
					IFfmpegLocater.ffmpegPath, "-i", videoIn.toString(),
					"-y", "-s", "480x320", // stripped the extraneous "-1"
					"-vcodec", "flv1", encodingFile.toString());
			pb.redirectError(errorFile.toFile());
			pb.redirectOutput(encodingFile.toFile());
			final Process p = pb.start();
			
			// CHECK FOR THIS!

				retCode = p.waitFor();
				System.out.println(p.exitValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
		}
		return false;
	}

	@Override
	public String deal(InputStream is, String fn) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]) {
		new VideoEncodeImpl().ToMp4();
	}

<<<<<<< HEAD
	@Override
	public boolean encode(String srcVideo, String desVideo, String desImage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean encode(String srcVideo, AbsFfmpegOption options) {
		// TODO Auto-generated method stub
		return false;
	}

=======
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
}
