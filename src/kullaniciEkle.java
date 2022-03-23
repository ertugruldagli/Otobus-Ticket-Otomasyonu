import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;

public class kullaniciEkle extends JFrame {
	
	private JPanel contentPane;
	private JTextField adtext;
	private JTextField soyadtext;
	private JTextField kuladitext;
	private JPasswordField sifrepass;
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JTextField teltext;
	static String sifre ;
	 static String kuladi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullaniciEkle frame = new kullaniciEkle();
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
	public kullaniciEkle() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("\u0130S\u0130M:");
		lblNewLabel.setBounds(34, 154, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoyisim = new JLabel("SOY\u0130S\u0130M:");
		lblSoyisim.setBounds(34, 185, 67, 14);
		contentPane.add(lblSoyisim);
		
		JLabel lblKuladi = new JLabel("KULAD\u0130:");
		lblKuladi.setBounds(34, 252, 67, 14);
		contentPane.add(lblKuladi);
		
		JLabel lblSifre = new JLabel("S\u0130FRE:");
		lblSifre.setBounds(34, 296, 67, 14);
		contentPane.add(lblSifre);
		
		lblNewLabel_1 = new JLabel("TELEFON:");
		lblNewLabel_1.setBounds(34, 222, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		MaskFormatter mf= new MaskFormatter("(0###) ### ## ##");
		JFormattedTextField telfortext = new JFormattedTextField(mf);
		telfortext.setBounds(106, 219, 116, 20);
		contentPane.add(telfortext);
	
		adtext = new JTextField();
		adtext.setBounds(106, 151, 116, 20);
		contentPane.add(adtext);
		adtext.setColumns(10);
		
		soyadtext = new JTextField();
		soyadtext.setColumns(10);
		soyadtext.setBounds(106, 182, 116, 20);
		contentPane.add(soyadtext);
		
		kuladitext = new JTextField();
		kuladitext.setColumns(10);
		kuladitext.setBounds(106, 249, 116, 20);
		contentPane.add(kuladitext);
		
		sifrepass = new JPasswordField();
		sifrepass.setBounds(106, 293, 116, 20);
		contentPane.add(sifrepass);
		
		
		JButton btnNewButton = new JButton("KAYDET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad,soyad,tel,sqlsorgu;
				
				
				/*Pattern p= Pattern.compile("[a-zA-Z0-9]{6}");
				Matcher m= p.matcher(sifre);*/
				
				ad=adtext.getText();
				soyad=soyadtext.getText();
				tel=telfortext.getText();
				kuladi=kuladitext.getText();
				sifre=sifrepass.getText();
				
			
					try {
						myConn=DriverManager.getConnection(url);
						
						 sqlsorgu="INSERT INTO tblYoneticiGirisi(ad,soyad,telefon,kuladi,sifre) VALUES ('"+ ad +"', "
							  		+ "'"+ soyad+"', "+"'"+ tel +"', "+"'"+ kuladi +"', "+"'"+ sifre +"')";
						  System.out.println(sqlsorgu);
						  myStat = (Statement) myConn.createStatement();
					      myStat.executeUpdate(sqlsorgu);
					      
					}catch (Exception e2) {
					}
					JOptionPane.showConfirmDialog(null, "KAYDINIZ GERÇEKLEÞMÝÞTÝR","TEBRÝKLER!",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					
					Kullanici k=new Kullanici();
					k.setVisible(true);
			}
			
			
		});
		
		btnNewButton.setBounds(133, 337, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("icons\\ekle.png"));
		lblNewLabel_2.setBounds(67, 11, 221, 132);
		contentPane.add(lblNewLabel_2);
		
		
		
	
	
		
		
		
		
	
	}
}
