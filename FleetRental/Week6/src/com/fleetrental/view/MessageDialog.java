/*
 * MessageDialog.java
 *
 * Created on May 6, 2006, 12:05 PM
 */

package com.fleetrental.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * <p>
 * Title: MessageDialog.java
 * </p>
 *
 * Ideally, this class should be in a package under com.fleetrental.view
 * 
 * @version 1.0
 */
public class MessageDialog extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5669384463178310650L;
	JButton okBtn = new JButton("OK");
	JLabel label = new JLabel();

	public MessageDialog(String title, String msg) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(title);
		label.setText(msg);
		jbInit();
		okBtn.addActionListener(this);
	}

	/**
	 * Component initialization.
	 */
	private void jbInit() {
		label.setBounds(new Rectangle(56, 15, 197, 40));
		okBtn.setBounds(new Rectangle(114, 70, 68, 23));
		this.getContentPane().add(label);
		this.getContentPane().add(okBtn);
		getContentPane().setLayout(null);
		setSize(300, 150);
	}

	/**
	 * Close the dialog on a button event.
	 *
	 * @param actionEvent
	 *            ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == okBtn) {
			dispose();
		}
	}
}
