package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FristGuI {

	private JFrame frame;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FristGuI window = new FristGuI();
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
	public FristGuI() {
	try {
		initialize();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		frame = new JFrame("Ocr Applications");
		frame.setBounds(100, 100, 751, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					textField.setText("Je suis en plein Act");
				}
		});
		btnLoad.setBounds(282, 414, 121, 50);
		frame.getContentPane().add(btnLoad);
		
		textField = new JTextField();
		textField.setBounds(36, 414, 240, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(240, 248, 255));
		panel.setBounds(36, 6, 370, 396);
		
		frame.getContentPane().add(panel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(502, 6, 223, 390);
		frame.getContentPane().add(textPane);
		
		String path = "rsc/input/TEST_2.JPG";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);
        
        JButton button = new JButton("Detect");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.setBounds(512, 414, 202, 41);
        frame.getContentPane().add(button);
	}
}
