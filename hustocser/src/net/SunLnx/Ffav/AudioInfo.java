<<<<<<< HEAD
package net.SunLnx.Ffav;
import entity.InvalidOptionException;
/*
 * ffmpeg中的有关音频设置选项
 * 默认的音频codec为aac，其他默认相关参数匹配aac codec
 */

public class AudioInfo implements FfmpegOptioner{
	
	/*
	 * 默认的音频bitrate 128 kbps
	 */
	public static final int DEFAULT_BITRATE =  128;
	
	/*
	 * 默认音频声道2
	 */
	public static final int DEFAULT_CHANNEL = 2;
	
	/*
	 * 默认音频sample rate 44100HZ
	 */
	public static final int DEFAULT_SAMPLING_RATE = 44100;
	
	/*
	 * 默认音频codec：aac
	 */
	public static final String DEFAULT_CODEC="AAC";
	
=======
package entity;


public class AudioInfo  extends AbsFfmpegOption{
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
	private int bitRate;
	private int channel;
	private int samplingRate;
	private String codec="";
<<<<<<< HEAD
	private String output;
	private FfmpegOptioner superOption;
	public AudioInfo(){
	}
	public AudioInfo(FfmpegOptioner superOption) {
		this.superOption = superOption;
=======

	public AudioInfo(){
		
	}
	public AudioInfo(AbsFfmpegOption superOption, String output) {
		this.superOption = superOption;
		this.output = output;
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
	}
	public int getBitRate() {
		return bitRate;
	}

	public void setBitRate(int bitRate) {
		this.bitRate = bitRate;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getSamplingRate() {
		return samplingRate;
	}

	public void setSamplingRate(int samplingRate) {
		this.samplingRate = samplingRate;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}
<<<<<<< HEAD
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public FfmpegOptioner getSuperOption() {
		return superOption;
	}
	public void setSuperOption(FfmpegOptioner superOption) {
		this.superOption = superOption;
	}
	

=======
	
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
	public AudioInfo clone() {
		AudioInfo audio = new AudioInfo();
		audio.setBitRate(this.bitRate);
		audio.setChannel(this.channel);
		audio.setCodec(this.codec);
		audio.setSamplingRate(this.samplingRate);
<<<<<<< HEAD
		return audio;
	}

	
	
	@Override
	public String toOption() throws InvalidOptionException{
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOption());
=======
		audio.setSuperOption(this.superOption);
		return audio;
	}

	public String toOptions() throws InvalidOptionException{
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOptions());
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
		}
		//samplecoding		-ar
		if (this.samplingRate < 0) {
			throw new InvalidOptionException("Invalid audio sampling  rate");
		} else if (this.samplingRate > 0) {
			sb.append(" -ar ").append(this.samplingRate);
		}

		//channel	-ac:		1, 2
		if (this.channel < 0 || this.channel > 2) {
			throw new InvalidOptionException("Invalid audio channel");
		} else if (this.channel > 0) {
			sb.append(" -ac ").append(this.channel);
		}
	
<<<<<<< HEAD
		//bitrate 		-ab:		
=======
		//bitrate 		-ab:		128k,越大音频质量越好
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
		if (this.bitRate < 0) {
			throw new InvalidOptionException("Invalid audio bitrate");
		} else if (this.bitRate > 0) {
			sb.append(" -ab ").append(this.bitRate);
		}
		//codec 		-acodec
		if (!this.codec.equals("")) {
			sb.append(" -acodec ").append(this.codec);
		}
		if (output != null && !output.equals("")) {
			sb.append(output);
		}
		return sb.toString();
	}
	
<<<<<<< HEAD
=======

	public AbsFfmpegOption getSuperOption() {
		return superOption;
	}
	public void setSuperOption(AbsFfmpegOption superOption) {
		this.superOption = superOption;
	}
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
	
	public static void main(String args[]) {
		AudioInfo audio = new AudioInfo();
		audio.setChannel(2);
		audio.setCodec("mp3");
		try {
<<<<<<< HEAD
			System.out.println(audio.toOption());
=======
			System.out.println(audio.toOptions());
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
