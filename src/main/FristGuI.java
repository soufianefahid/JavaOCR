package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

public class FristGuI {
	String path ;
	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JLabel label;
	private JTextPane textPane;
	private JScrollPane jsp ;
	public FristGuI() {
		initialize();

	}
	
	private class MouseAct extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton verifie = (JButton)e.getSource();
			String etiquette = verifie.getLabel();
			if(etiquette.equals("Load")){
				JFileChooser fc = new JFileChooser("/Users/moi/Desktop/java/OCR-Java project/rsc/input/");
				fc.setAcceptAllFileFilterUsed(true);
				fc.addChoosableFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub

						return null;
					}

					@Override
					public boolean accept(File f) {
						

						if (f.isDirectory()) {

							return false;
						}

						String extension = Utils.getExtension(f);
						if (extension != null) {
							if (extension.equals(Utils.tiff)
									|| extension.equals(Utils.tif)
									|| extension.equals(Utils.gif)
									|| extension.equals(Utils.jpeg)
									|| extension.equals(Utils.jpg)
									|| extension.equals(Utils.png)) {
								return true;

							} else {
								return false;
							}
						}

						return false;
					}
				});

				int returnVal = fc.showDialog(frame, "Attach");
				 if (returnVal == JFileChooser.FILES_ONLY) {
			            File file = fc.getSelectedFile();
			            //This is where a real application would open the file.
			            //log.append("Opening: " + file.getName() + "." + newline);
			            try {
							//File file = new File(path);
			            	
			            	BufferedImage image1 = new BufferedImage(423, 426, BufferedImage.TYPE_INT_ARGB);
							BufferedImage image = ImageIO.read(file);
							Graphics g = image1.createGraphics();
							Image img = new ImageIcon(image).getImage();
							g.drawImage(img,0, 0, 370, 396, null);
							label = new JLabel(new ImageIcon(image1));
							panel.removeAll();
							panel.add(label);
							frame.repaint();
							frame.revalidate();
							textField.setText(file.getAbsolutePath().toString());
						} catch (Exception e2) {
							//e2.printStackTrace();
						}
			            
			        } else {
			            //log.append("Open command cancelled by user." + newline);
			        }

			}
			
		else{
			Transformator transformator = new Transformator();
			path=textField.getText();
			String text = transformator.imageToString(path, "rsc/output/result.txt");
			textPane.setText(text);
			jsp.getVerticalScrollBar().setValue(0);
			frame.repaint();
			frame.revalidate();
		}
			

	}
}
	 public void initialize() {
		frame = new JFrame("Ocr Applications");
		frame.setBounds(100, 100, 831, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnLoad = new JButton("Load");
		MouseAct mouseact = new MouseAct();
		btnLoad.addMouseListener(mouseact);
		btnLoad.setBounds(285, 453, 121, 50);
		frame.getContentPane().add(btnLoad);

		textField = new JTextField();
		textField.setBounds(33, 449, 240, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(240, 248, 255));
		panel.setBounds(36, 6, 423, 426);

		frame.getContentPane().add(panel);

		JButton button = new JButton("Detect");
		button.addMouseListener(mouseact);
		JSeparator jSeparator1 = new JSeparator();
		frame.getContentPane().add(jSeparator1);
		jSeparator1.setBounds(269, 212, 2, 201);
		jSeparator1.setOrientation(SwingConstants.VERTICAL);
		button.setBounds(586, 458, 202, 41);
		frame.getContentPane().add(button);
		
				 textPane = new JTextPane();
				 jsp = new JScrollPane(textPane);
				 jsp.setBounds(484, 6, 325, 426);	 
				 frame.getContentPane().add(jsp);
				 
	}
   
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
}
