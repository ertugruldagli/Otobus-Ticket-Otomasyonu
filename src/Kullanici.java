import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class Kullanici extends JFrame {
	public static Connection c;
	
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField kultext;
	private JPasswordField siftpass;
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs; 
	
	static String kul;
    static String sifre;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kullanici frame = new Kullanici();
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
	public Kullanici() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 443);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		setJMenuBar(menuBar);
		
		JMenu mnk = new JMenu("Kullan\u0131c\u0131 \u0130\u015Flemleri");
		mnk.setForeground(Color.DARK_GRAY);
		menuBar.add(mnk);
		
		JMenu mnKullancEkle = new JMenu("Kullanici Ekle");
		mnKullancEkle.setIcon(new ImageIcon("icons\\kiþi ekle.png"));
		mnKullancEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				kullaniciEkle ke;
				try {
					ke = new kullaniciEkle();
					ke.setVisible(true);
					setVisible(false);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnk.add(mnKullancEkle);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JLabel lblNewLabel = new JLabel("KULLANICI ADI:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(239, 282, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSifre = new JLabel("S\u0130FRE:");
		lblSifre.setBackground(Color.GRAY);
		lblSifre.setForeground(Color.WHITE);
		lblSifre.setBounds(262, 313, 78, 14);
		contentPane.add(lblSifre);
		
		kultext = new JTextField();
		kultext.setBackground(Color.LIGHT_GRAY);
		kultext.setBounds(348, 279, 91, 20);
		contentPane.add(kultext);
		kultext.setColumns(10);
		
		siftpass = new JPasswordField();
		siftpass.setBackground(Color.LIGHT_GRAY);
		siftpass.setBounds(350, 310, 89, 20);
		contentPane.add(siftpass);
		
		JButton grsbuton = new JButton("G\u0130R\u0130\u015E");
		grsbuton.setBackground(new Color(30, 144, 255));
		grsbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kul=kultext.getText();
				sifre=siftpass.getText();
		
				String sqlsorgu="select count(id) as giris from tblYoneticiGirisi where kuladi='"+kul+
							"' and sifre='"+sifre+"'";
				    myRs = baglanti.yap();
					myRs = baglanti.sorgula(sqlsorgu);
				try {
					while(myRs.next()){
								if(myRs.getInt("giris")==1) {
									KullaniciYonetimSyf kys = new KullaniciYonetimSyf();
									kys.setVisible(true);
									setVisible(false);
								} else {JOptionPane.showConfirmDialog(null, "Girdiðiniz Kullanýcý A"
										+ "dý veya Þifre YANLIÞ","HATA!",JOptionPane.WARNING_MESSAGE); }
								
							}
				
				}catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		grsbuton.setBounds(251, 349, 89, 23);
		contentPane.add(grsbuton);
		
		JButton btnKapat = new JButton("KAPAT");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnKapat.setBackground(new Color(255, 0, 0));
		btnKapat.setBounds(350, 349, 89, 23);
		contentPane.add(btnKapat);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icons\\man yeni2.png"));
		lblNewLabel_1.setBounds(98, 22, 250, 176);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DA\u011ELI ");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_2.setBounds(137, 190, 91, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblUlam = new JLabel("ULA\u015EIM");
		lblUlam.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
		lblUlam.setBounds(219, 201, 78, 27);
		contentPane.add(lblUlam);
	
	}
}
