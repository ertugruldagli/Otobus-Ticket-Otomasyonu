import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class digerSeferBilgileri extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"Sefer Bilgi Id","Arac Id","Arac Personelleri Id"};
	Object[] satirlar = new Object[3];	
	
	static Connection myConn=null;
	static Statement myStat;
	static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
	static ResultSet myRs;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JMenu mnNewMenu_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					digerSeferBilgileri frame = new digerSeferBilgileri();
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
	public digerSeferBilgileri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 474);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("ARACLARA G\u0130T");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AracBilgileri ab;
				try {
					ab = new AracBilgileri();
					ab.setVisible(true);
					setVisible(false);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		mnNewMenu_2 = new JMenu("");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				KullaniciYonetimSyf kys =new KullaniciYonetimSyf();
				kys.setVisible(true);
				setVisible(false);
				
			}
		});
		mnNewMenu_2.setIcon(new ImageIcon("icons\\geri1ek.jpg"));
		menuBar.add(mnNewMenu_2);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("ARAC PERSONELLER\u0130N\u0130 G\u00D6R");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AracPersonel ap=new AracPersonel();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 130, 405, 72);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(289, 242, 273, 72);
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("Listele");
		btnListele.setBackground(new Color(255, 140, 0));
		btnListele.setBounds(268, 236, 89, 23);
		contentPane.add(btnListele);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 583, 54);
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
	
		
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);				
				
				try {
					myConn=DriverManager.getConnection(url);
					//System.out.println("baðlandýnýz");
					
						  myStat = (Statement) myConn.createStatement();
					      myRs = myStat.executeQuery("select * from tblSeferBilgileri");
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("SeferBilgiId");
					    	  satirlar[1]=myRs.getString("AracNumarasi");
					    	  satirlar[2]=myRs.getString("AracPersonelleri");
		
					    	  modelim.addRow(satirlar);
					      }
				
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				table.setModel(modelim);
			}
		});
		
	}
}
