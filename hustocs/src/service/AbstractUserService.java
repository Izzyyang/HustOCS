package service;

import util.Encrypter;
import util.MD5Encrypte;

public abstract class AbstractUserService implements UserServicer{
	protected Encrypter encrypter;

	public AbstractUserService() {
		this.encrypter = new MD5Encrypte();
	}
	public Encrypter getEncrypter() {
		return encrypter;
	}

	public void setEncrypter(Encrypter encrypter) {
		this.encrypter = encrypter;
	}
}
