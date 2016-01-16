package main;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class First {

	private JFrame frame;
	private JTextField textField;

	private class mouseaction extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			textField.setText("Je suis la");
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public First() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ocr Applications");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		mouseaction load = new mouseaction();
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(load);	
		btnLoad.setBounds(309, 224, 117, 29);
		frame.getContentPane().add(btnLoad);
		
		textField = new JTextField();
		textField.setBounds(39, 224, 256, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 17, 276, 191);
		frame.getContentPane().add(panel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(309, 17, 129, 191);
		frame.getContentPane().add(textPane);
	}
}
