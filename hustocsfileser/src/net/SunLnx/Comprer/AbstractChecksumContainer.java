package net.SunLnx.Comprer;

import java.util.zip.Checksum;

public abstract class AbstractChecksumContainer{
	
	// checksum is used for check the zip files using checksum when remote transfer
	// and default's check sum is adler32
	// you can set checksum using setChecksum function or in the ZipCompress structed method
	protected Checksum checksum;
	protected long checksumNumber;
	

	/*
	 *  get checksum, adler32, crc32 or else
	 */
	public Checksum getCheckSum() {
		return checksum;
	}

	/*
	 *  set checksum when compressing
	 */
	public void setChecksum(Checksum checksum) {
		this.checksum = checksum;
	}
	
	public long getChecksumNumber() {
		if (this.checksum == null) {
			return -1;
		}
		return checksumNumber;
	}
}
