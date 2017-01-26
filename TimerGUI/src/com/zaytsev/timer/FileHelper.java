package com.zaytsev.timer;

import java.net.MalformedURLException;
import java.net.URL;

public class FileHelper {
		
	public URL getURLImage() throws MalformedURLException {
		return this.getClass().getResource(Main.ICON_STR1);
	}

	public URL getURLImageNotification() throws MalformedURLException {
		return this.getClass().getResource(Main.ICON_STR2);
	}
	
	public URL getURLImageWait() throws MalformedURLException {
		return this.getClass().getResource(Main.ICON_STR3);
	}
	
}
