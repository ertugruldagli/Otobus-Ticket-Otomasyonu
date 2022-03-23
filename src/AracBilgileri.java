import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class AracBilgileri extends JFrame {

	private JPanel contentPane;
	private JTextField ptext;
	private JTable table;
	
	   DefaultTableModel modelim = new DefaultTableModel();
		

		Object[] kolonlar = {"BusId","BusMarka","BusPlaka","BusDurumu"};
		Object[] satirlar = new Object[4];	
		
		static Connection myConn=null;
		static Statement myStat;
		static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
		static ResultSet myRs;
		private JTextField notext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AracBilgileri frame = new AracBilgileri();
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
	public AracBilgileri() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 309);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				KullaniciYonetimSyf kys =new KullaniciYonetimSyf();
				kys.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.setIcon(new ImageIcon("icons\\geri1ek.jpg"));
		menuBar.add(mnNewMenu);
		
		JMenu mnAraclarHakknda = new JMenu("ARACLAR HAKKINDA");
		menuBar.add(mnAraclarHakknda);
		
		JMenu mnMercedesGroup = new JMenu("MERCEDES GROUP");
		mnAraclarHakknda.add(mnMercedesGroup);
		
		JMenu mnSetraGroup = new JMenu("SETRA GROUP");
		mnAraclarHakknda.add(mnSetraGroup);
		
		JMenu mnNeoplanmanGroup = new JMenu("NEOPLAN/MAN GROUP");
		mnAraclarHakknda.add(mnNeoplanmanGroup);
		
		JMenu mnTemsaGroup = new JMenu("TEMSA GROUP");
		mnAraclarHakknda.add(mnTemsaGroup);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		notext = new JTextField();
		notext.setBackground(Color.LIGHT_GRAY);
		notext.setBounds(96, 100, 149, 20);
		contentPane.add(notext);
		notext.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 84, 377, 74);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(299, 129, 323, 59);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("MARKA:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 144, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPlaka = new JLabel("PLAKA:");
		lblPlaka.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPlaka.setForeground(Color.WHITE);
		lblPlaka.setBounds(10, 176, 86, 14);
		contentPane.add(lblPlaka);
		
		ptext = new JTextField();
		ptext.setBackground(Color.LIGHT_GRAY);
		ptext.setColumns(10);
		ptext.setBounds(96, 173, 149, 20);
		contentPane.add(ptext);
	
		
		JLabel lblDurumu = new JLabel("DURUMU:");
		lblDurumu.setForeground(Color.WHITE);
		lblDurumu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDurumu.setBounds(10, 210, 86, 14);
		contentPane.add(lblDurumu);
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 modelim.setRowCount(0);				
					
					try {
						myConn=DriverManager.getConnection(url);
						//System.out.println("baðlandýnýz");
						
							  myStat = (Statement) myConn.createStatement();
						      myRs = myStat.executeQuery("select * from tblAracBilgileri");
						      while(myRs.next()) {
						    	  satirlar[0]=myRs.getString("BusId");
						    	  satirlar[1]=myRs.getString("BusMarka");
						    	  satirlar[2]=myRs.getString("BusPlaka");
						    	  satirlar[3]=myRs.getString("BusDurumu");
						    	 
						    	  
						    	  modelim.addRow(satirlar);
						      }
					
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
					table.setModel(modelim);
					
				
				
			}
		});
		btnNewButton.setBounds(543, 172, 89, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AKT\u0130F", "AKT\u0130F/\u00C7ALI\u015EMIYOR", "\u00C7ALI\u015EMIYOR"}));
		comboBox.setBounds(96, 206, 149, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"M-Benz Travego 15SHD", "M-Benz Travego 17SHD", "M-Benz Torismo 15RHD", "M-Benz Torismo 16SHD", "M-Benz Torismo 17SHD", "Neoplan Toruliner", "Neoplan Starliner", "Neoplan Cityliner", "Temsa Maraton", "Temsa Safir", "Temsa SafirPlus", "Man Fortuna", "Man Lion's Coach"}));
		comboBox_2.setBounds(96, 136, 149, 22);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		String no,marka,durum,plaka,seferNo,sqlsorgu;
		        no=notext.getText();
				marka=(String) comboBox_2.getSelectedItem();
				plaka=ptext.getText();
				durum=(String) comboBox.getSelectedItem();
				
				
			
					try {
						myConn=DriverManager.getConnection(url);
						  sqlsorgu="INSERT INTO tblAracBilgileri(BusId,BusMarka,BusPlaka,BusDurumu) VALUES ('"+ no +"','"+ marka +"', "
						  		+ "'"+ plaka+"', "+"'"+ durum +"')";
						  System.out.println(sqlsorgu);
						  
						  myStat = (Statement) myConn.createStatement();
					      myStat.executeUpdate(sqlsorgu);
					}catch (Exception e2) {
					}
				
			}
		});
		btnNewButton_1.setBounds(451, 172, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("G\u00FCncelle");
		btnNewButton_2.setBackground(new Color(255, 140, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marka,id,durum,plaka,seferNo,sqlsorgu;
				
				id=notext.getText();
				marka=(String) comboBox_2.getSelectedItem();
				plaka=ptext.getText();
				durum=(String) comboBox.getSelectedItem();
			
				
					try {
						myConn=DriverManager.getConnection(url);
						sqlsorgu="UPDATE tblAracBilgileri SET BusId='"+id+"',"+
								"BusMarka='"+marka+"',BusPlaka='"+plaka+"',BusDurumu='"+durum+"' WHERE BusId="+id;
						  System.out.println(sqlsorgu);
						  
						  myStat = (Statement) myConn.createStatement();
						  myStat.executeUpdate(sqlsorgu);
						  
					}catch (Exception e2) {
					}
					
			}
		});
		btnNewButton_2.setBounds(451, 206, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sil");
		btnNewButton_3.setBackground(new Color(255, 140, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sqlsorgu;
				id=notext.getText();
				try {
					myConn=DriverManager.getConnection(url);
					  sqlsorgu="DELETE From tblAracBilgileri WHERE BusId="+id;
					  myStat = (Statement) myConn.createStatement();
					  myStat.executeUpdate(sqlsorgu);
					  
				}catch (Exception e2) {
				}
			}
		});
		btnNewButton_3.setBounds(543, 206, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblAracNo = new JLabel("ARAC NO:");
		lblAracNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAracNo.setForeground(Color.WHITE);
		lblAracNo.setBounds(10, 103, 86, 14);
		contentPane.add(lblAracNo);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(-4, 0, 642, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(150, 0, 100, 51);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("icons\\LOGO.png"));
		
		JLabel lblNewLabel_3 = new JLabel("ULA\u015EIM");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(403, 19, 100, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("DA\u011ELI");
		lblNewLabel_2.setBounds(260, 13, 152, 30);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
		
		
	
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					notext.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
					comboBox_2.setSelectedItem( modelim.getValueAt(table.getSelectedRow(),1));
					ptext.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
					comboBox.setSelectedItem( modelim.getValueAt(table.getSelectedRow(),3));
					
					
				}
			});
	
	}
}
