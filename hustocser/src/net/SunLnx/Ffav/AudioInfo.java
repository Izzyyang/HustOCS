package entity;


public class AudioInfo  extends AbsFfmpegOption{
	private int bitRate;
	private int channel;
	private int samplingRate;
	private String codec="";

	public AudioInfo(){
		
	}
	public AudioInfo(AbsFfmpegOption superOption, String output) {
		this.superOption = superOption;
		this.output = output;
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
	
	public AudioInfo clone() {
		AudioInfo audio = new AudioInfo();
		audio.setBitRate(this.bitRate);
		audio.setChannel(this.channel);
		audio.setCodec(this.codec);
		audio.setSamplingRate(this.samplingRate);
		audio.setSuperOption(this.superOption);
		return audio;
	}

	public String toOptions() throws InvalidOptionException{
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOptions());
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
	
		//bitrate 		-ab:		128k,越大音频质量越好
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
	

	public AbsFfmpegOption getSuperOption() {
		return superOption;
	}
	public void setSuperOption(AbsFfmpegOption superOption) {
		this.superOption = superOption;
	}
	
	public static void main(String args[]) {
		AudioInfo audio = new AudioInfo();
		audio.setChannel(2);
		audio.setCodec("mp3");
		try {
			System.out.println(audio.toOptions());
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
