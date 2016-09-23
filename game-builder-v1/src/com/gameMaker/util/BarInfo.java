package com.gameMaker.util;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class BarInfo {

	private String name;

	private JButton button;

	private JComponent component;

	public BarInfo(String name, JComponent component) {
		this.name = name;
		this.component = component;
		this.button = new JButton(name);
	}

	public BarInfo(String name, Icon icon, JComponent component) {
		this.name = name;
		this.component = component;
		this.button = new JButton(name, icon);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JButton getButton() {
		return this.button;
	}

	public JComponent getComponent() {
		return this.component;
	}

}