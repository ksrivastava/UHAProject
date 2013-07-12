package com.uha.common;

import java.awt.EventQueue;

import com.uha.client.MainScreen;
import com.uha.server.Model;

public class Main {
	
	private static Controller controller;
	private static Model model;
	
	public static void main(String[] args) {
		model = new Model();
		controller = new Controller(model);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
