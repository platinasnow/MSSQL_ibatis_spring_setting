package com.model;

public class ImageVO {

	private int imageKey;
	private byte[] imageData;
	private String imageName;

	public int getImageKey() {
		return imageKey;
	}

	public void setImageKey(int imageKey) {
		this.imageKey = imageKey;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
