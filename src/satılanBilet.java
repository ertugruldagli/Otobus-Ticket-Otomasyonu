import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class satýlanBilet extends JFrame {
	
DefaultTableModel modelim = new DefaultTableModel();
	

	Object[] kolonlar = {"BiletId", "SeferNo","KoltukNo","MusteriAd","MusteriSoyad","Cinsiyet","Tel","T.C.","YoneticiId","OdemeTuru"};
	Object[] satirlar = new Object[10];	

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JTextField sorgulatext;
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					satýlanBilet frame = new satýlanBilet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public satýlanBilet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 668, 139);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(10, 35, 621, 181);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("L\u0130STELE");
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					myConn=DriverManager.getConnection(url);
					//System.out.println("baðlandýnýz");
					try {
						  myStat = (Statement) myConn.createStatement();
					      myRs = myStat.executeQuery("select * from tblSatilanBilet");
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("BiletId");
					    	  satirlar[1]=myRs.getString("SeferNo");
					    	  satirlar[2]=myRs.getString("KoltukNo");
					    	  satirlar[3]=myRs.getString("MusteriAd");
					    	  satirlar[4]=myRs.getString("MusteriSoyad");
					    	  satirlar[5]=myRs.getString("Cinsiyet");
					    	  satirlar[6]=myRs.getString("Telefon");
					    	  satirlar[7]=myRs.getString("TC");
					    	  satirlar[8]=myRs.getString("YoneticiId");
					    	  satirlar[9]=myRs.getString("OdemeTuru");
					    	 
					    	 
					    	  modelim.addRow(satirlar);
					      }
					}catch (Exception e2) {
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				table.setModel(modelim);
			}
		});
		btnNewButton.setBounds(589, 252, 89, 23);
		contentPane.add(btnNewButton);
		
		sorgulatext = new JTextField();
		sorgulatext.setBackground(Color.LIGHT_GRAY);
		sorgulatext.setBounds(28, 285, 112, 20);
		contentPane.add(sorgulatext);
		sorgulatext.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BiletId", "SeferNo","KoltukNo","MusteriAd","MusteriSoyad","Cinsiyet","Tel","T.C.","YoneticiId","OdemeTuru"}));
		comboBox.setBounds(159, 252, 102, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("KISAYOL ARAMA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(28, 256, 112, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("SORGULA");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);	
             String alan= sorgulatext.getText();
				
				int secilen=comboBox.getSelectedIndex();
				String sqlsorgu=null;
				if(secilen==0) {
					 sqlsorgu="Select * from tblSatilanBilet  where BiletId like '"+alan+"%'";
				}else if(secilen==1) {
					 sqlsorgu="Select *from tblSatilanBilet where SeferNo like '"+alan+"%'";
				}else if(secilen==2) {
					 sqlsorgu="Select *from tblSatilanBilet where KoltukNo like '"+alan+"%'";
				}else if(secilen==3) {
					 sqlsorgu="Select *from tblSatilanBilet where MusteriAd like '"+alan+"%'";
				}else if(secilen==4) {
					 sqlsorgu="Select *from tblSatilanBilet where MusteriSoyad like '"+alan+"%'";
				}else if(secilen==5) {
					 sqlsorgu="Select *from tblSatilanBilet where Cinsiyet like '"+alan+"%'";
				}else if(secilen==6) {
					 sqlsorgu="Select *from tblSatilanBilet where Telefon like '"+alan+"%'";
				}else if(secilen==7) {
					 sqlsorgu="Select *from tblSatilanBilet where TC like '"+alan+"%'";
				}
				else if(secilen==8) {
					 sqlsorgu="Select *from tblSatilanBilet where YoneticiId like '"+alan+"%'";
				}
				else if(secilen==9) {
					 sqlsorgu="Select *from tblSatilanBilet where OdemeTuru like '"+alan+"%'";
				}
					try {
						  myConn=DriverManager.getConnection(url);
						 
						  myStat = (Statement) myConn.createStatement();
					     myRs = myStat.executeQuery(sqlsorgu);
					      
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("BiletId");
					    	  satirlar[1]=myRs.getString("SeferNo");
					    	  satirlar[2]=myRs.getString("KoltukNo");
					    	  satirlar[3]=myRs.getString("MusteriAd");
					    	  satirlar[4]=myRs.getString("MusteriSoyad");
					    	  satirlar[5]=myRs.getString("Cinsiyet");
					    	  satirlar[6]=myRs.getString("Telefon");
					    	  satirlar[7]=myRs.getString("TC");
					    	  satirlar[8]=myRs.getString("YoneticiId");
					    	  satirlar[9]=myRs.getString("OdemeTuru");
					    	  modelim.addRow(satirlar);
					      }
					}catch (Exception e2) {
					}
			}
		});
		btnNewButton_1.setBounds(150, 284, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciYonetimSyf kys =new KullaniciYonetimSyf();
				kys.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Ertu\\Desktop\\java proje\\geri1.jpg"));
		button.setBounds(0, 55, 30, 30);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 688, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ertu\\Desktop\\D\u00D6NEM PROJELER\u0130\\LOGO.png"));
		label.setBounds(173, 0, 100, 51);
		panel.add(label);
		
		JLabel label_1 = new JLabel("ULA\u015EIM");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_1.setBounds(423, 19, 100, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("DA\u011ELI");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
		label_2.setBounds(283, 13, 152, 30);
		panel.add(label_2);
		
		
	}
}
