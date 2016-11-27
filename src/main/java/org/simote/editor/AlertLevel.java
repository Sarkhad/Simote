package org.simote.editor;

public enum AlertLevel {

	SUCCESS, INFO, WARNING, DANGER;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
	
}
