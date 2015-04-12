package entity;


public abstract class   AbsFfmpegOption {
	protected AbsFfmpegOption superOption = null;
	protected String output = null;

	public abstract String toOptions() throws InvalidOptionException;
	public abstract AbsFfmpegOption  clone();
	public AbsFfmpegOption getSuperOption() {
		return superOption;
	}
	public void setSuperOption(AbsFfmpegOption superOption) {
		this.superOption = superOption;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}
