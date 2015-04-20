package net.SunLnx.Ffav;

public class InputInfo extends AbstractFfmpegOption{
	private String input;
	
	public InputInfo(){}
	public InputInfo(AbstractFfmpegOption preOption) {
		this.preOptioner = preOption;
	}
	public InputInfo(AbstractFfmpegOption preOption, String input) {
		this.preOptioner = preOption;
		this.input = input;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	@Override
	public String toOption() throws InvalidOptionException {
		if ("".equals(input)) {
			throw new InvalidOptionException("Null input file");
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(" -i ").append(input);
			return sb.toString();
		}
	}
	
	public static void main(String args[]) {
		InputInfo i1 = new InputInfo(null, "D:/a.mp4");
		InputInfo i2 = new InputInfo(i1, "E:/b.ogg");
		try {
			System.out.println(i2.toOptions());
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
