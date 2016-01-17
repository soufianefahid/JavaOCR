package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

public class FristGuI {
	String path ;
	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox = new JComboBox();
	int Format=0;
	public int getFormat(){
		return Format;
	}
	public FristGuI() {
		initialize();

	}
	JComboBox getchoice (){
		return comboBox;
	}
	private class MouseAct extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			button.setEnabled(true);
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
			            	
			            	BufferedImage image1 = new BufferedImage( 543, 426, BufferedImage.TYPE_4BYTE_ABGR);
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
							 e2.printStackTrace();
						}
			            
			        } else {
			            //log.append("Open command cancelled by user." + newline);
			        }

			}
			
		else{
				frame.setVisible(false);
				Detection detection = new Detection();
				detection.getComboBox().setSelectedIndex(comboBox.getSelectedIndex());
				int indiceLangue=comboBox.getSelectedIndex();
				//detection.comboBox.getSelectedIndex();
				Transformator transformator = new Transformator();
				detection.frame.setVisible(true);
				path=textField.getText();
				System.out.println(comboBox.toString());
				String text;
				Format=comboBox_1.getSelectedIndex();
				detection.format=getFormat();
				System.out.println("get ==="+getFormat());
				System.out.println("IDL = "+indiceLangue);
				if(indiceLangue==0)
					 text = transformator.imageToString(path ,Format,"eng");					
				else if(indiceLangue==1)
					 text = transformator.imageToString(path ,Format,"fra");
				else if(indiceLangue==2)
					 text = transformator.imageToString(path ,Format,"DEU");
				else if(indiceLangue==3)
					 text = transformator.imageToString(path ,Format,"SPA");
				else{
					text = transformator.imageToString(path,Format,"POR");
				}
					
				{
					JTextArea textpane= new JTextArea();
					textpane.setEditable(false);
					textpane.setText(text);
					JScrollPane jsp = new JScrollPane(textpane);
					jsp.setBounds(176, 16, 493, 361);
					detection.frame.add(jsp);
					detection.frame.repaint();
					detection.frame.revalidate();
				}
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
		btnLoad.setBounds(401, 493, 144, 50);
		frame.getContentPane().add(btnLoad);

		textField = new JTextField();
		textField.setBounds(146, 492, 240, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(146, 29, 543, 384);

		frame.getContentPane().add(panel);

	    button = new JButton("Detect");
		button.addMouseListener(mouseact);
		button.setEnabled(false);
		JSeparator jSeparator1 = new JSeparator();
		frame.getContentPane().add(jSeparator1);
		jSeparator1.setBounds(269, 212, 2, 201);
		jSeparator1.setOrientation(SwingConstants.VERTICAL);
		button.setBounds(557, 493, 132, 50);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Langues :");
		lblNewLabel.setBounds(76, 422, 63, 33);
		frame.getContentPane().add(lblNewLabel);
		{
		comboBox.addItem("English");
		comboBox.addItem("French");
		comboBox.addItem("German");
		comboBox.addItem("Spanich");
		comboBox.addItem("Portuguese");
		comboBox.setBounds(146, 426, 541, 27);
		frame.getContentPane().add(comboBox);				
		}		
		
		
		comboBox_1.addItem("Format txt");
		comboBox_1.addItem("Format word");
		comboBox_1.addItem("Format PDF");
		comboBox_1.setBounds(146, 463, 543, 27);
		frame.getContentPane().add(comboBox_1);
		
		JLabel label_1 = new JLabel("Format :");
		
		label_1.setBounds(76, 459, 63, 33);
		frame.getContentPane().add(label_1);
		
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
