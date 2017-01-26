package com.zaytsev.timer;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javazoom.jl.decoder.JavaLayerException;

public class Main {
	public static final String APPLICATION_NAME = "Notification";
	public static final String ICON_STR1 = "clock1.png";
	public static final String ICON_STR2 = "clock2.png";
	public static final String ICON_STR3 = "clock3.png";
	public static TrayIcon trayIcon;
	public static Image icon;
	public static Image iconNotification;
	public static Image iconWait; 
	NotificationListner notificationListner = new NotificationListner();

	public static void main(String[] args) throws MalformedURLException {
	    FileHelper fileHelper = new FileHelper();
		PopupMenu trayMenu = new PopupMenu();
	    MenuItem item = new MenuItem("Exit");
	    MenuItem stop = new MenuItem("Stop Music/Timer");
	    MenuItem item1 = new MenuItem("Add Timer");
	    item.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	      }
	    });
	    stop.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  try {
					NotificationListner.stop();
					Main.trayIcon.setImage(Main.icon);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		      }
	    });
	    item1.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  try {
					NotificationListner.start();
				} catch (JavaLayerException | IOException e1) {
					e1.printStackTrace();
				}
		      }
	    });
	    trayMenu.add(item1);
	    trayMenu.add(stop);
	    trayMenu.add(item);
	    iconWait = Toolkit.getDefaultToolkit().getImage(fileHelper.getURLImageWait());
	    iconNotification = Toolkit.getDefaultToolkit().getImage(fileHelper.getURLImageNotification());
	    icon = Toolkit.getDefaultToolkit().getImage(fileHelper.getURLImage());
	    trayIcon = new TrayIcon(icon, APPLICATION_NAME, trayMenu);
	    trayIcon.setImageAutoSize(true);
	    SystemTray tray = SystemTray.getSystemTray();
	    try {
	      tray.add(trayIcon);
	    } catch (AWTException e) {
	      e.printStackTrace();
	    }
	  }
}
