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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class seferGoster extends JFrame {
	
     DefaultTableModel modelim = new DefaultTableModel();
	

	Object[] kolonlar = {"SeferNo","KalkisYeri","VarisYeri","Saat","Tarih","Fiyat","SeferBilgi"};
	Object[] satirlar = new Object[7];	
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs;

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JTextField notext;
	private JTextField ktext;
	private JTextField vtext;
	private JTextField saattext;
	private JTextField tarihtext;
	private JButton btnNewButton_1;
	private JButton btnSil;
	private JButton btnGncelle;
	private JLabel lblNewLabel;
	private JLabel lblKalkisYeri;
	private JLabel lblVarisYeri;
	private JLabel lblSaat;
	private JLabel lblTarih;
	private JTextField aratext;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JButton btnNewButton_2;
	private JLabel lblDigerbilgi;
	private JTextField dtext;
	private JLabel fiyat;
	private JTextField ftext;
	private JButton button;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seferGoster frame = new seferGoster();
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
	public seferGoster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 487);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 105, 531, 123);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(10, 191, 540, 124);
		scrollPane.setViewportView(table);
		

		lblDigerbilgi = new JLabel("DigerBilgi id:");
		lblDigerbilgi.setForeground(Color.WHITE);
		lblDigerbilgi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDigerbilgi.setBounds(34, 421, 89, 14);
		contentPane.add(lblDigerbilgi);
		
		dtext = new JTextField();
		dtext.setBackground(Color.LIGHT_GRAY);
		dtext.setColumns(10);
		dtext.setBounds(133, 418, 86, 20);
		contentPane.add(dtext);
		
		fiyat = new JLabel("Fiyat:");
		fiyat.setForeground(Color.WHITE);
		fiyat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		fiyat.setBounds(52, 396, 46, 14);
		contentPane.add(fiyat);
		
		ftext = new JTextField();
		ftext.setBackground(Color.LIGHT_GRAY);
		ftext.setColumns(10);
		ftext.setBounds(133, 393, 86, 20);
		contentPane.add(ftext);
		
		btnNewButton = new JButton("Sefer Listele");
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                     modelim.setRowCount(0);				
				
				try {
					myConn=DriverManager.getConnection(url);
					//System.out.println("baðlandýnýz");
					
						  myStat = (Statement) myConn.createStatement();
					      myRs = myStat.executeQuery("select * from tblSeferler");
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("SeferNo");
					    	  satirlar[1]=myRs.getString("KalkisYeri");
					    	  satirlar[2]=myRs.getString("VarisYeri");
					    	  satirlar[3]=myRs.getString("saat");
					    	  satirlar[4]=myRs.getString("tarih");
					    	  satirlar[5]=myRs.getString("fiyat");
					    	  satirlar[6]=myRs.getString("DigerSeferBilgileri");
					    	  
					    	  modelim.addRow(satirlar);
					      }
				
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				table.setModel(modelim);
				
			}
		});
		btnNewButton.setBounds(544, 153, 114, 23);
		contentPane.add(btnNewButton);
		
		notext = new JTextField();
		notext.setBackground(Color.LIGHT_GRAY);
		notext.setBounds(133, 239, 86, 20);
		contentPane.add(notext);
		notext.setColumns(10);
		
		
		ktext = new JTextField();
		ktext.setBackground(Color.LIGHT_GRAY);
		ktext.setColumns(10);
		ktext.setBounds(133, 269, 86, 20);
		contentPane.add(ktext);
		
		vtext = new JTextField();
		vtext.setBackground(Color.LIGHT_GRAY);
		vtext.setColumns(10);
		vtext.setBounds(133, 300, 86, 20);
		contentPane.add(vtext);
		
		saattext = new JTextField();
		saattext.setBackground(Color.LIGHT_GRAY);
		saattext.setColumns(10);
		saattext.setBounds(133, 331, 86, 20);
		contentPane.add(saattext);
		
		tarihtext = new JTextField();
		tarihtext.setBackground(Color.LIGHT_GRAY);
		tarihtext.setColumns(10);
		tarihtext.setBounds(133, 362, 86, 20);
		contentPane.add(tarihtext);
		
		btnNewButton_1 = new JButton("kaydet");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String no,kalkis,varis,saat,tarih,fiyat,dsefer,sqlsorgu;
				
				no=notext.getText();
				kalkis=ktext.getText();
				varis=vtext.getText();
				saat=saattext.getText();
				tarih=tarihtext.getText();
				fiyat=ftext.getText();
				dsefer=dtext.getText();
				
			
					try {
						myConn=DriverManager.getConnection(url);
						  sqlsorgu="INSERT INTO tblSeferler(SeferNo,KalkisYeri,VarisYeri,saat,tarih,fiyat,DigerSeferBilgileri) VALUES ("+ no +", "
						  		+ "'"+ kalkis +"', "+"'"+ varis +"',"+"'"+ saat +"',"+"'"+ tarih +"',"+""+ fiyat +", "+""+dsefer +")";
						  System.out.println(sqlsorgu);
						  
						  myStat = (Statement) myConn.createStatement();
					      myStat.executeUpdate(sqlsorgu);
					}catch (Exception e2) {
					}
				
			}
		});
		btnNewButton_1.setBounds(292, 330, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnGncelle = new JButton("g\u00FCncelle");
		btnGncelle.setBackground(new Color(255, 140, 0));
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               String no,kalkis,varis,saat,tarih,fiyat,dsefer,sqlsorgu;
				
				no=notext.getText();
				kalkis=ktext.getText();
				varis=vtext.getText();
				saat=saattext.getText();
				tarih=tarihtext.getText();
				fiyat=ftext.getText();
				dsefer=dtext.getText();
				
		
					try {
						myConn=DriverManager.getConnection(url);
						  sqlsorgu="UPDATE tblSeferler SET SeferNo="+no+","+
									"KalkisYeri='"+kalkis+"',VarisYeri='"+varis+"',saat='"+saat+"',tarih='"+tarih+"',fiyat="+fiyat+",DigerSeferBilgileri="+dsefer+" WHERE SeferNo="+no;
						  System.out.println(sqlsorgu);
						  myStat = (Statement) myConn.createStatement();
						  myStat.executeUpdate(sqlsorgu);
						  
					}catch (Exception e2) {
					}
				
				
			}
		});
		btnGncelle.setBounds(490, 330, 89, 23);
		contentPane.add(btnGncelle);
		
		btnSil = new JButton("sil");
		btnSil.setBackground(new Color(255, 140, 0));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no,sqlsorgu;
				no=notext.getText();
				try {
					myConn=DriverManager.getConnection(url);
					  sqlsorgu="DELETE From tblSeferler WHERE SeferNo="+no;
					  myStat = (Statement) myConn.createStatement();
					  myStat.executeUpdate(sqlsorgu);
					  
				}catch (Exception e2) {
				}
			}
		});
		btnSil.setBounds(391, 330, 89, 23);
		contentPane.add(btnSil);
	
		lblNewLabel = new JLabel("Sefer No:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(52, 242, 65, 14);
		contentPane.add(lblNewLabel);
		
		lblKalkisYeri = new JLabel("Kalkis yeri:");
		lblKalkisYeri.setForeground(Color.WHITE);
		lblKalkisYeri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblKalkisYeri.setBounds(52, 272, 77, 14);
		contentPane.add(lblKalkisYeri);
		
		lblVarisYeri = new JLabel("Varis yeri:");
		lblVarisYeri.setForeground(Color.WHITE);
		lblVarisYeri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblVarisYeri.setBounds(52, 303, 77, 14);
		contentPane.add(lblVarisYeri);
		
		lblSaat = new JLabel("Saat:");
		lblSaat.setForeground(Color.WHITE);
		lblSaat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblSaat.setBounds(52, 334, 46, 14);
		contentPane.add(lblSaat);
		
		lblTarih = new JLabel("Tarih:");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTarih.setBounds(52, 365, 46, 14);
		contentPane.add(lblTarih);
		
		aratext = new JTextField();
		aratext.setBackground(Color.LIGHT_GRAY);
		aratext.setBounds(349, 393, 86, 20);
		contentPane.add(aratext);
		aratext.setColumns(10);
		
		lblNewLabel_1 = new JLabel("ARAMA:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(367, 365, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sefer No", "Kalkis Yeri", "Varis Yeri", "Saat", "Tarih","fiyat"," Diger Sefer"}));
		comboBox.setBounds(445, 361, 86, 22);
		contentPane.add(comboBox);
		
		btnNewButton_2 = new JButton("SORGULA");
		btnNewButton_2.setBackground(new Color(255, 140, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);	
				String alan= aratext.getText();
				
				int secilen=comboBox.getSelectedIndex();
				String sqlsorgu=null;
				if(secilen==0) {
					 sqlsorgu="Select * from tblSeferler  where SeferNo like '"+alan+"%'";
				}else if(secilen==1) {
					 sqlsorgu="Select *from tblSeferler where KalkisYeri like '"+alan+"%'";
				}else if(secilen==2) {
					 sqlsorgu="Select *from tblSeferler where VarisYeri like '"+alan+"%'";
				}else if(secilen==3) {
					 sqlsorgu="Select *from tblSeferler where saat like '"+alan+"%'";
				}else if(secilen==4) {
				 sqlsorgu="Select *from tblSeferler where tarih like '"+alan+"%'";
				}else if(secilen==5) {
					 sqlsorgu="Select *from tblSeferler where fiyat like '"+alan+"%'";
				}else if(secilen==6) {
					 sqlsorgu="Select *from tblSeferler where DigerSeferBilgileri like '"+alan+"%'";
				}
					try {
						  myConn=DriverManager.getConnection(url);
						 
						  myStat = (Statement) myConn.createStatement();
					     myRs = myStat.executeQuery(sqlsorgu);
					      
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("SeferNo");
					    	  satirlar[1]=myRs.getString("KalkisYeri");
					    	  satirlar[2]=myRs.getString("VarisYeri");
					    	  satirlar[3]=myRs.getString("saat");
					    	  satirlar[4]=myRs.getString("tarih");
					    	  satirlar[5]=myRs.getString("fiyat");
					    	  satirlar[6]=myRs.getString("DigerSeferBilgileri");
					    	  
					    	  modelim.addRow(satirlar);
					      }
					}catch (Exception e2) {
					}
			}
		});
		btnNewButton_2.setBounds(445, 392, 89, 23);
		contentPane.add(btnNewButton_2);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciYonetimSyf kys =new KullaniciYonetimSyf();
				kys.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("icons\\geri1.jpg"));
		button.setBounds(0, 56, 30, 30);
		contentPane.add(button);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 673, 56);
		contentPane.add(panel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("icons\\LOGO.png"));
		label.setBounds(150, 0, 100, 51);
		panel.add(label);
		
		label_1 = new JLabel("ULA\u015EIM");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_1.setBounds(403, 19, 100, 32);
		panel.add(label_1);
		
		label_2 = new JLabel("DA\u011ELI");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
		label_2.setBounds(260, 13, 152, 30);
		panel.add(label_2);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				notext.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				ktext.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				vtext.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				saattext.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				tarihtext.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
				ftext.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				dtext.setText((String) modelim.getValueAt(table.getSelectedRow(),6));
				
			}
		});
	}

}
