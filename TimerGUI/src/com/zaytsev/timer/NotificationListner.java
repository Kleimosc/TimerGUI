package com.zaytsev.timer;

import java.awt.TrayIcon;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class NotificationListner {
	
	
	
	private static JFrame frame = new JFrame("InputDialog");
	static InputStream inputStream;
	static Player player;
	static Timer timer;
	private static int minutes;
	public static boolean isStart = true;
	
public NotificationListner() {
	}
	
	public static void start() throws JavaLayerException, IOException {
		if (isStart) {
			stop();
			if (isStart) {
				minutes = Integer.parseInt(JOptionPane.showInputDialog(frame, "Input minutes:"))*60000;
			}
			inputStream = FileHelper.class.getClassLoader().getResourceAsStream("com/zaytsev/timer/i_nikolaev_-_vipem_za_ljubov.mp3");
			Main.trayIcon.setImage(Main.iconWait);
			isStart = false;
			player = new Player(inputStream);
			timer = new Timer();
			timer.t(minutes);
		    Main.trayIcon.displayMessage(Main.APPLICATION_NAME, "Timer started",
                    TrayIcon.MessageType.INFO);
		} else {
			JOptionPane.showMessageDialog(frame, "Timer was start!", "Error" ,JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void stop() throws IOException {
		if (player != null || Timer.task != null ) {
			player.close();
			Timer.task.cancel();
		}
		if (inputStream != null) {
			inputStream.close();
		}
		inputStream=null;
		player = null;
		timer = null;
		Timer.task = null;
		isStart = true;
		System.gc();
	}
}
