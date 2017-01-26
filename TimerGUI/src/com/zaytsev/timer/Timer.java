package com.zaytsev.timer;

import java.awt.TrayIcon;
import java.util.TimerTask;

import javazoom.jl.decoder.JavaLayerException;


public class Timer {
    static java.util.Timer timer;
    static TimerTask task;
	public void t(int minutes){
		timer = new java.util.Timer();
		task = new TimerTask() {
		    public void run()
		    {
		    try {
		    	Main.trayIcon.displayMessage(Main.APPLICATION_NAME, "WAKE UP!!!",
                        TrayIcon.MessageType.INFO);
		    	NotificationListner.isStart = true;	
		    	Main.trayIcon.setImage(Main.iconNotification);
		    	NotificationListner.player.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
		    }
		  };
		  timer.schedule(task, minutes);
	}
}
