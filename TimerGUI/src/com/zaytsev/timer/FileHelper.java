package com.zaytsev.timer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FileHelper {
		
	public URL getURLImage() throws MalformedURLException {
		File file = new File((this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + Main.ICON_STR1).substring(1));
		return file.toURI().toURL();
	}

	public URL getURLImageNotification() throws MalformedURLException {
		File file = new File((this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + Main.ICON_STR2).substring(1));
		return file.toURI().toURL();
	}
	
	public URL getURLImageWait() throws MalformedURLException {
		File file = new File((this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + Main.ICON_STR3).substring(1));
		return file.toURI().toURL();
	}
	
}
