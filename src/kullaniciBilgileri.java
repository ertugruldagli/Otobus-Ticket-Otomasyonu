import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class kullaniciBilgileri extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idtext;
	private JTextField adtext;
	private JTextField soyadtext;
	private JTextField kultext;
	private JTextField stext;
	  DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"Id","Ad","Soyad","Telefon","KullaniciAdi","Sifre"};
	Object[] satirlar = new Object[6];	
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs;
	private JTextField teltext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullaniciBilgileri frame = new kullaniciBilgileri();
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
	public kullaniciBilgileri() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 458);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("KULLAN\u0130C\u0130LAR");
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setBounds(465, 352, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("KULLAN\u0130C\u0130 EKLE");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setBounds(31, 352, 126, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnKullaniciSil = new JButton("KULLAN\u0130C\u0130 G\u00DCNCELLE");
		btnKullaniciSil.setBackground(new Color(255, 140, 0));
		btnKullaniciSil.setBounds(167, 352, 163, 23);
		contentPane.add(btnKullaniciSil);
		
		JButton btnKullaniciSil_1 = new JButton("KULLAN\u0130C\u0130 S\u0130L");
		btnKullaniciSil_1.setBackground(new Color(255, 140, 0));
		btnKullaniciSil_1.setBounds(338, 352, 116, 23);
		contentPane.add(btnKullaniciSil_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 262, 568, 79);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(31, 151, 526, 97);
		scrollPane.setViewportView(table);
		
		idtext = new JTextField();
		idtext.setBounds(31, 231, 86, 20);
		contentPane.add(idtext);
		idtext.setColumns(10);
		
		adtext = new JTextField();
		adtext.setColumns(10);
		adtext.setBounds(127, 231, 86, 20);
		contentPane.add(adtext);
		
		soyadtext = new JTextField();
		soyadtext.setColumns(10);
		soyadtext.setBounds(223, 231, 77, 20);
		contentPane.add(soyadtext);
		
		kultext = new JTextField();
		kultext.setColumns(10);
		kultext.setBounds(428, 231, 77, 20);
		contentPane.add(kultext);
		
		stext = new JTextField();
		stext.setColumns(10);
		stext.setBounds(515, 231, 86, 20);
		contentPane.add(stext);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(47, 206, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAd = new JLabel("AD");
		lblAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAd.setForeground(Color.WHITE);
		lblAd.setBounds(141, 206, 46, 14);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("SOYAD");
		lblSoyad.setForeground(Color.WHITE);
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblSoyad.setBounds(240, 206, 46, 14);
		contentPane.add(lblSoyad);
		
		JLabel lblKuladi = new JLabel("KULAD\u0130");
		lblKuladi.setForeground(Color.WHITE);
		lblKuladi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblKuladi.setBounds(434, 206, 46, 14);
		contentPane.add(lblKuladi);
		
		JLabel lblSifre = new JLabel("\u015E\u0130FRE");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblSifre.setForeground(Color.WHITE);
		lblSifre.setBounds(532, 206, 46, 14);
		contentPane.add(lblSifre);
		
		JLabel lblTelefon = new JLabel("TELEFON");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setBounds(338, 206, 59, 14);
		contentPane.add(lblTelefon);
		
	
		
		MaskFormatter mf= new MaskFormatter("(0###) ### ## ##");
		JFormattedTextField telfortext = new JFormattedTextField(mf);
		telfortext.setBounds(310, 231, 108, 20);
		contentPane.add(telfortext);
		
		JButton button = new JButton("");
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 686, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons\\LOGO.png"));
		label.setBounds(176, 0, 100, 51);
		panel.add(label);
		
		JLabel label_1 = new JLabel("ULA\u015EIM");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_1.setBounds(436, 19, 100, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("DA\u011ELI");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
		label_2.setBounds(286, 13, 152, 30);
		panel.add(label_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                        modelim.setRowCount(0);				
				
				try {
					myConn=DriverManager.getConnection(url);
					//System.out.println("baðlandýnýz");
					
						  myStat = (Statement) myConn.createStatement();
					      myRs = myStat.executeQuery("select * from tblYoneticiGirisi");
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("id");
					    	  satirlar[1]=myRs.getString("ad");
					    	  satirlar[2]=myRs.getString("soyad");
					    	  satirlar[3]=myRs.getString("telefon");
					    	  satirlar[4]=myRs.getString("kuladi");
					    	  satirlar[5]=myRs.getString("sifre");
					    	  
					    	  modelim.addRow(satirlar);
					      }
				
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				table.setModel(modelim);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	              String id,ad,soyad,kuladi,s,sqlsorgu,tel;
				
				id=idtext.getText();
				ad=adtext.getText();
				soyad=soyadtext.getText();
				tel=telfortext.getText();
				kuladi=kultext.getText();
				s=stext.getText();
			
			
					try {
						myConn=DriverManager.getConnection(url);
						  sqlsorgu="INSERT INTO tblYoneticiGirisi(ad,soyad,telefon,kuladi,sifre) VALUES ( "
						  		+ "'"+ ad+"', "+"'"+ soyad +"', "+"'"+ tel +"',"+"'"+kuladi +"', "+"'"+s+"')";
						  System.out.println(sqlsorgu);
						  
						  myStat = (Statement) myConn.createStatement();
					      myStat.executeUpdate(sqlsorgu);
					}catch (Exception e2) {
					}
			}
		});
		btnKullaniciSil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sqlsorgu;
				id=idtext.getText();
				try {
					myConn=DriverManager.getConnection(url);
					  sqlsorgu="DELETE From tblYoneticiGirisi WHERE id="+id;
					  myStat = (Statement) myConn.createStatement();
					  myStat.executeUpdate(sqlsorgu);
					  
				}catch (Exception e2) {
				}
			}
		});
		btnKullaniciSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String id,ad,soyad,tel,kuladi,s,sqlsorgu;
					
					id=idtext.getText();
					ad=adtext.getText();
					soyad=soyadtext.getText();
					tel=telfortext.getText();
					kuladi=kultext.getText();
					s=stext.getText();
					
					try {
						myConn=DriverManager.getConnection(url);
						  sqlsorgu="UPDATE tblYoneticiGirisi SET id="+id+","+
									"ad='"+ad+"',soyad='"+soyad+"',telefon='"+tel+"',kuladi='"+kuladi+"',sifre='"+s+"' WHERE id="+id;
						  System.out.println(sqlsorgu);
						  myStat = (Statement) myConn.createStatement();
						  myStat.executeUpdate(sqlsorgu);
						  
					}catch (Exception e2) {
					}
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idtext.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				adtext.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				soyadtext.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				telfortext.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				kultext.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
				stext.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				
			}
		});
	}
}
