import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLayeredPane;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class biletSat extends JFrame {

	private JPanel contentPane;
	private JTextField notext;
	private JTextField stext;
	private JTextField ttext;
	private JTextField ftext;
     DefaultTableModel modelim = new DefaultTableModel();
	

	Object[] kolonlar = {"SeferNo","KalkisYeri","VarisYeri","Saat","Tarih","Fiyat"};
	Object[] satirlar = new Object[6];	
	
		
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs;
	

	
	private JTable table;
	private JTextField ktext;
	private JTextField vtext;
	private JTextField adtext;
	private JTextField soyadtext;
	private JTextField snotext;
	private JTextField knotext;
	private JTextField ynotext;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biletSat frame = new biletSat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public biletSat() throws ParseException {
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 508);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 161, 498, 271);
		panel_1.setBorder(new LineBorder(new Color(255, 165, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEFERNO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel_1.add(lblNewLabel);
		
		notext = new JTextField();
		notext.setBackground(Color.LIGHT_GRAY);
		notext.setBounds(10, 50, 62, 20);
		panel_1.add(notext);
		notext.setColumns(10);
		
		JLabel lblSaat = new JLabel("SAAT");
		lblSaat.setForeground(Color.WHITE);
		lblSaat.setBounds(262, 22, 36, 14);
		panel_1.add(lblSaat);
		
		stext = new JTextField();
		stext.setBackground(Color.LIGHT_GRAY);
		stext.setBounds(245, 50, 62, 20);
		panel_1.add(stext);
		stext.setColumns(10);
		
		JLabel lblTarih = new JLabel("TAR\u0130H");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setBounds(330, 22, 46, 14);
		panel_1.add(lblTarih);
		
		ttext = new JTextField();
		ttext.setBackground(Color.LIGHT_GRAY);
		ttext.setBounds(317, 50, 85, 20);
		panel_1.add(ttext);
		ttext.setColumns(10);
	
		JLabel lblGzergahSeiniz = new JLabel("SEFER NUMARALARI");
		lblGzergahSeiniz.setForeground(Color.WHITE);
		lblGzergahSeiniz.setBounds(23, 108, 135, 14);
		contentPane.add(lblGzergahSeiniz);
		
		JLabel lblFiyat = new JLabel("F\u0130YAT");
		lblFiyat.setForeground(Color.WHITE);
		lblFiyat.setBounds(425, 22, 46, 14);
		panel_1.add(lblFiyat);
		
		ftext = new JTextField();
		ftext.setBackground(Color.LIGHT_GRAY);
		ftext.setBounds(412, 50, 76, 20);
		panel_1.add(ftext);
		ftext.setColumns(10);
		
		JLabel lblKalkisyeri = new JLabel("KALK\u0130S YER\u0130");
		lblKalkisyeri.setForeground(Color.WHITE);
		lblKalkisyeri.setBounds(82, 22, 78, 14);
		panel_1.add(lblKalkisyeri);
		
		ktext = new JTextField();
		ktext.setBackground(Color.LIGHT_GRAY);
		ktext.setColumns(10);
		ktext.setBounds(82, 50, 78, 20);
		panel_1.add(ktext);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 81, 478, 179);
		panel_1.add(panel);
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		panel.setVisible(false);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 46, 179);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("icons\\konsol.jpg"));
		
		JLabel lblVarisyeri = new JLabel("VAR\u0130S YER\u0130");
		lblVarisyeri.setForeground(Color.WHITE);
		lblVarisyeri.setBounds(168, 22, 68, 14);
		panel_1.add(lblVarisyeri);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(546, 133, 248, 299);
		contentPane.add(tabbedPane);
		tabbedPane.setVisible(false);
		
		vtext = new JTextField();
		vtext.setBackground(Color.LIGHT_GRAY);
		vtext.setColumns(10);
		vtext.setBounds(168, 50, 67, 20);
		panel_1.add(vtext);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 133, 135, 22);
		
				try {
			myConn=DriverManager.getConnection(url);
			
			 myStat = (Statement) myConn.createStatement();
		      myRs = myStat.executeQuery("select * from tblSeferler");
		      
		      while(myRs.next())
		        {
		            comboBox.addItem(myRs.getString("SeferNo"));
		            
		         
		        }
		  
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contentPane.add(comboBox);
	
		JButton btnSeferAra = new JButton("biletBAK");
		btnSeferAra.setBackground(new Color(255, 165, 0));
		btnSeferAra.setBounds(163, 133, 89, 23);
		btnSeferAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 
				  int secilen=comboBox.getSelectedIndex();
					try {
						myConn=DriverManager.getConnection(url);
						//System.out.println("baðlandýnýz");
					
							  myStat = (Statement) myConn.createStatement();
							  myRs = myStat.executeQuery("select *from tblSeferler Where SeferNo='642'");
							  
						      while(myRs.next()) {
						    	 
						    	  satirlar[0]=myRs.getString("SeferNo");
						    	  satirlar[1]=myRs.getString("KalkisYeri");
						    	  satirlar[2]=myRs.getString("VarisYeri");
						    	  satirlar[3]=myRs.getString("saat");
						    	  satirlar[4]=myRs.getString("tarih");
						    	  satirlar[5]=myRs.getString("fiyat");
						    	 
						    	  modelim.addRow(satirlar);
						      }
						       if(secilen==0) {
						    	   	 notext.setText((String) satirlar[0]);
							    	 ktext.setText((String) satirlar[1]);
							    	 vtext.setText((String) satirlar[2]);
									 stext.setText((String) satirlar[3]);
									 ttext.setText((String) satirlar[4]);
									 ftext.setText((String) satirlar[5]);
									panel.setVisible(true);
									tabbedPane.setVisible(true);
									JOptionPane.showConfirmDialog(null, "COVÝD-19 SALGINI SEBEBÝYLE, MESAFEYÝ KORUMAK ÝÇÝN "
											+ "ARAÇLARIMIZ 14 KÝÞÝ ÝLE SINIRLANDIRILMIÞTIR.","BÝLGÝ",JOptionPane.YES_OPTION);

								 }
								  myRs = myStat.executeQuery("select *from tblSeferler Where SeferNo='3542'");
								  
							      while(myRs.next()) {
							    	 
							    	  satirlar[0]=myRs.getString("SeferNo");
							    	  satirlar[1]=myRs.getString("KalkisYeri");
							    	  satirlar[2]=myRs.getString("VarisYeri");
							    	  satirlar[3]=myRs.getString("saat");
							    	  satirlar[4]=myRs.getString("tarih");
							    	  satirlar[5]=myRs.getString("fiyat");
							    	 
							    	  modelim.addRow(satirlar);
							      }
							       if(secilen==4) {
							    	   	 notext.setText((String) satirlar[0]);
								    	 ktext.setText((String) satirlar[1]);
								    	 vtext.setText((String) satirlar[2]);
										 stext.setText((String) satirlar[3]);
										 ttext.setText((String) satirlar[4]);
										 ftext.setText((String) satirlar[5]);
										 panel.setVisible(false);
										 
										 
									 }
								   
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
			      
			      }
		});
		contentPane.add(btnSeferAra);
				
				
				
				JButton button_1 = new JButton("");
				button_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						knotext.setText("4");
					}
				});
				button_1.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_1.setBounds(121, 11, 45, 45);
				panel.add(button_1);
				
				JButton button_2 = new JButton("");
				button_2.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_2.setBounds(176, 11, 45, 45);
				panel.add(button_2);
				
				JButton button_3 = new JButton("");
				button_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						knotext.setText("3");
					}
				});
				button_3.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_3.setBounds(121, 134, 45, 45);
				panel.add(button_3);
				
				JButton button_4 = new JButton("");
				button_4.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_4.setBounds(176, 134, 45, 45);
				panel.add(button_4);
				

				JButton btnNewButton = new JButton("");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						knotext.setText("2");
					}
				});
				btnNewButton.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				btnNewButton.setBounds(66, 11, 45, 45);
				panel.add(btnNewButton);
				
				JButton button = new JButton("");
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						knotext.setText("1");
					}
				});
				button.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button.setBackground(Color.LIGHT_GRAY);
		
				button.setBounds(66, 134, 45, 45);
				panel.add(button);
				
				JButton button_5 = new JButton("");
				button_5.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_5.setBackground(Color.LIGHT_GRAY);
				button_5.setBounds(231, 134, 45, 45);
				panel.add(button_5);
				
				JButton button_6 = new JButton("");
				button_6.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_6.setBounds(286, 134, 45, 45);
				panel.add(button_6);
				
				JButton button_7 = new JButton("");
				button_7.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_7.setBounds(341, 134, 45, 45);
				panel.add(button_7);
				
				JButton button_8 = new JButton("");
				button_8.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_8.setBounds(231, 11, 45, 45);
				panel.add(button_8);
				
				JButton button_9 = new JButton("");
				button_9.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_9.setBounds(286, 11, 45, 45);
				panel.add(button_9);
				
				JButton button_10 = new JButton("");
				button_10.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_10.setBounds(341, 11, 45, 45);
				panel.add(button_10);
				
				JButton button_11 = new JButton("");
				button_11.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_11.setBackground(Color.LIGHT_GRAY);
				button_11.setBounds(396, 134, 45, 45);
				panel.add(button_11);
				
				JButton button_12 = new JButton("");
				button_12.setIcon(new ImageIcon("icons\\koltuk.jpg"));
				button_12.setBounds(396, 11, 45, 45);
				panel.add(button_12);
				
				JLabel lblNewLabel_3 = new JLabel("COVID-19 PANDEM\u0130S\u0130 SEBEB\u0130YLE KOLTUK SAYIMIZ D\u00DC\u015E\u00DCR\u00DCLM\u00DC\u015ET\u00DCR.");
				lblNewLabel_3.setForeground(Color.WHITE);
				lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
				lblNewLabel_3.setBounds(66, 85, 385, 14);
				panel.add(lblNewLabel_3);
				
				JLayeredPane layeredPane = new JLayeredPane();
								layeredPane.setBackground(Color.DARK_GRAY);
								layeredPane.setBorder(new LineBorder(new Color(255, 165, 0)));
								tabbedPane.addTab("MusteriBilgileri", null, layeredPane, null);
								
								adtext = new JTextField();
								adtext.setBounds(131, 11, 86, 20);
								layeredPane.add(adtext);
								adtext.setColumns(10);
								
								JLabel lblNewLabel_2 = new JLabel("AD:");
								lblNewLabel_2.setBounds(33, 14, 46, 14);
								layeredPane.add(lblNewLabel_2);
								
								JLabel lblSoyad = new JLabel("SOYAD:");
								lblSoyad.setBounds(33, 52, 46, 14);
								layeredPane.add(lblSoyad);
								
								soyadtext = new JTextField();
								soyadtext.setColumns(10);
								soyadtext.setBounds(131, 49, 86, 20);
								layeredPane.add(soyadtext);
								
								JLabel lblCinsiyet = new JLabel("C\u0130NS\u0130YET:");
								lblCinsiyet.setBounds(33, 93, 78, 14);
								layeredPane.add(lblCinsiyet);
								
								JRadioButton kradio = new JRadioButton("K");
								kradio.setBounds(131, 89, 36, 23);
								layeredPane.add(kradio);
								
								JRadioButton eradio = new JRadioButton("E");
								eradio.setBounds(181, 89, 36, 23);
								layeredPane.add(eradio);
								
								JLabel lblTelefon = new JLabel("TELEFON:");
								lblTelefon.setBounds(33, 137, 78, 14);
								layeredPane.add(lblTelefon);
								
								JLabel lblTc = new JLabel("T.C. :");
								lblTc.setBounds(33, 178, 46, 14);
								layeredPane.add(lblTc);
								ButtonGroup bg =new ButtonGroup();
								bg.add(kradio);
								bg.add(eradio);
								
								MaskFormatter mf= new MaskFormatter("(0###) ### ## ##");
								JFormattedTextField telfortext = new JFormattedTextField(mf);
								telfortext.setBounds(131, 134, 86, 20);
								layeredPane.add(telfortext);
								
								MaskFormatter mf1= new MaskFormatter("###########");
								JFormattedTextField tcfortext = new JFormattedTextField(mf1);
								tcfortext.setBounds(131, 175, 86, 20);
								layeredPane.add(tcfortext);
				
				
				JLayeredPane layeredPane_1 = new JLayeredPane();
				layeredPane_1.setBackground(Color.WHITE);
				layeredPane_1.setBorder(new LineBorder(new Color(255, 165, 0)));
				tabbedPane.addTab("OdemeBilgileri", null, layeredPane_1, null);
				
				snotext = new JTextField();
				snotext.setColumns(10);
				snotext.setBounds(125, 35, 86, 20);
				layeredPane_1.add(snotext);
				
				JLabel lblSeferno = new JLabel("SeferNo:");
				lblSeferno.setBounds(27, 38, 75, 14);
				layeredPane_1.add(lblSeferno);
				
				knotext = new JTextField();
				knotext.setColumns(10);
				knotext.setBounds(125, 77, 86, 20);
				layeredPane_1.add(knotext);
				
				JLabel lblKoltukno = new JLabel("KoltukNo:");
				lblKoltukno.setBounds(27, 80, 75, 14);
				layeredPane_1.add(lblKoltukno);
				
				JLabel lblOdemeturu = new JLabel("OdemeTuru:");
				lblOdemeturu.setBounds(27, 124, 75, 14);
				layeredPane_1.add(lblOdemeturu);
				
				
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"NAKIT", "K.KARTI", "BEDAVA"}));
				comboBox_1.setBounds(125, 120, 86, 22);
				layeredPane_1.add(comboBox_1);
				
				JButton btnNewButton_1 = new JButton("biletSAT");
				btnNewButton_1.setBackground(Color.ORANGE);
				btnNewButton_1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showConfirmDialog(null, "ÝÞLEM GERÇEKLEÞTÝRÝLDÝ","TAMAMLANDI",JOptionPane.INFORMATION_MESSAGE);
						String sno,ad,soyad,cinsiyet=null,tel,tc,kno,od,yno,sqlsorgu;
						
						if(kradio.isSelected()) cinsiyet="K";
						if(eradio.isSelected()) cinsiyet="E";
				
						sno=snotext.getText();
						ad=adtext.getText();
						soyad=soyadtext.getText();
						tel=telfortext.getText();
						tc=tcfortext.getText();
						kno=knotext.getText();
						od=(String) comboBox_1.getSelectedItem();
						yno=ynotext.getText();

							try {
								myConn=DriverManager.getConnection(url);
								sqlsorgu="INSERT INTO tblSatilanBilet(SeferNo,KoltukNo,MusteriAd,MusteriSoyad,Cinsiyet,Telefon,TC,YoneticiId,OdemeTuru) VALUES ("+ sno +", "
								  		+ ""+ kno +", "+"'"+ ad +"',"+"'"+ soyad +"',"+"'"+ cinsiyet +"',"+"'"+ tel +"',"+""+ tc +","+""+ yno +", "+"'"+od+"')";
								  System.out.println(sqlsorgu);
								  
								  myStat= (Statement) myConn.createStatement();
							      myStat.executeUpdate(sqlsorgu);
							}catch (Exception e2) {
							}
					}
				});
				btnNewButton_1.setBounds(125, 217, 89, 23);
				layeredPane_1.add(btnNewButton_1);
				
				ynotext = new JTextField();
				ynotext.setBounds(125, 163, 86, 20);
				layeredPane_1.add(ynotext);
				ynotext.setColumns(10);
				
				JLabel lblYoneticiId = new JLabel("Yonetici Id:");
				lblYoneticiId.setBounds(27, 166, 75, 14);
				layeredPane_1.add(lblYoneticiId);
				
			
				
				
				JButton btnAnasayfayaDn = new JButton("");
				btnAnasayfayaDn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						KullaniciYonetimSyf kys =new KullaniciYonetimSyf();
						kys.setVisible(true);
						setVisible(false);
					}
				});
				btnAnasayfayaDn.setIcon(new ImageIcon("icons\\geri1.jpg"));
				btnAnasayfayaDn.setBounds(0, 56, 30, 30);
				contentPane.add(btnAnasayfayaDn);
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBackground(Color.WHITE);
				panel_2.setBounds(0, 0, 804, 56);
				contentPane.add(panel_2);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("icons\\LOGO.png"));
				label.setBounds(222, 0, 100, 51);
				panel_2.add(label);
				
				JLabel label_1 = new JLabel("ULA\u015EIM");
				label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
				label_1.setBounds(487, 19, 100, 32);
				panel_2.add(label_1);
				
				JLabel label_2 = new JLabel("DA\u011ELI");
				label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
				label_2.setBounds(332, 13, 152, 30);
				panel_2.add(label_2);
	
	
				
				
		
		
				
	}
}
