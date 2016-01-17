package main;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Detection {

	 JFrame frame;
	 JComboBox<String> comboBox = new JComboBox<String>();
	 int format;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detection window = new Detection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Detection() {
		initialize();
	}

	void setChoice(JComboBox<String> choi){
		this.comboBox=choi;

	}
	
	JComboBox<String> getComboBox(){
		return this.comboBox;
	}
	public void setFormat(int format){
		this.format=format;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 791, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAperu = new JButton("Aperçu");
		System.out.println("format detect ="+format);
		btnAperu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
		            try {    
		            	if(format==2) {
		                File myFile = new File( "/Users/moi/git/JavaOCR/ocr-result.pdf");
		                Desktop.getDesktop().open(myFile);
		            	}
		            	else{
		            		File myFile = new File( "/Users/moi/git/JavaOCR/ocr-result.rtf");
			                Desktop.getDesktop().open(myFile);
		            	}
		            
		            
		            
		            } catch (IOException ex) {
		                System.err.println("no application registered for PDFs");// 
		            }
		        }
				
			}
		});
		btnAperu.setBounds(334, 448, 145, 50);
		frame.getContentPane().add(btnAperu);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(511, 448, 151, 50);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblLangues = new JLabel("Langues :");
		lblLangues.setBounds(84, 389, 91, 50);
		frame.getContentPane().add(lblLangues);
		JLabel lblOptions = new JLabel("Options :");
		lblOptions.setBounds(84, 447, 91, 50);
		frame.getContentPane().add(lblOptions);
		
		
		comboBox.setBounds(173, 395, 493, 40);
		comboBox.addItem("English");
		comboBox.addItem("French");
		comboBox.addItem("German");
		comboBox.addItem("Spanich");
		comboBox.addItem("Portuguese");
		frame.getContentPane().add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox();
		comboBox_1.addItem("Traduction");
		comboBox_1.addItem("Recherche");
		comboBox_1.addItem("SendMail");
		comboBox_1.setBounds(183, 448, 137, 40);
		frame.getContentPane().add(comboBox_1);
	}
}
