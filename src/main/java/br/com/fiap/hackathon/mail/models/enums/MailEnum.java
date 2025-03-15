package br.com.fiap.hackathon.mail.models.enums;

public enum MailEnum {

	PROCESSED(true),

	FAILED(false);

	private final boolean success;

	MailEnum(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

}
