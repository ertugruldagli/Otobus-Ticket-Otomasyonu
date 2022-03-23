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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AracPersonel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField batext;
	private JLabel lblSurucuSoyadi;
	private JTextField bstext;
	private JLabel lblSurucuAdi;
	private JTextField iatext;
	private JLabel lblSurucuSoyadi_1;
	private JTextField istext;
	
	  DefaultTableModel modelim = new DefaultTableModel();
		

			Object[] kolonlar = {"Id","1.SurucuAd","1.SurucuSoyad","2.SurucuAd","2.SurucuSoyad"};
			Object[] satirlar = new Object[5];	
			
			static Connection myConn=null;
			static Statement myStat;
			static String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
			static ResultSet myRs;
			private JLabel lblSurucuAdi_1;
			private JTextField idtext;
			private JButton btnNewButton;
			private JPanel panel;
			private JLabel label_1;
			private JLabel label_2;
			private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AracPersonel frame = new AracPersonel();
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
	public AracPersonel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 154, 345, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(30, 119, 380, 32);
		scrollPane.setViewportView(table);
		
		batext = new JTextField();
		batext.setBounds(144, 154, 86, 20);
		contentPane.add(batext);
		batext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("1. Surucu Adi:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(42, 157, 92, 14);
		contentPane.add(lblNewLabel);
		
		lblSurucuSoyadi = new JLabel("1. Surucu Soyadi:");
		lblSurucuSoyadi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSurucuSoyadi.setForeground(Color.WHITE);
		lblSurucuSoyadi.setBounds(24, 199, 110, 14);
		contentPane.add(lblSurucuSoyadi);
		
		bstext = new JTextField();
		bstext.setColumns(10);
		bstext.setBounds(144, 196, 86, 20);
		contentPane.add(bstext);
		
		lblSurucuAdi = new JLabel("2. Surucu Adi:");
		lblSurucuAdi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSurucuAdi.setForeground(Color.WHITE);
		lblSurucuAdi.setBounds(42, 241, 92, 14);
		contentPane.add(lblSurucuAdi);
		
		iatext = new JTextField();
		iatext.setColumns(10);
		iatext.setBounds(144, 238, 86, 20);
		contentPane.add(iatext);
		
		lblSurucuSoyadi_1 = new JLabel("2. Surucu Soyadi:");
		lblSurucuSoyadi_1.setForeground(Color.WHITE);
		lblSurucuSoyadi_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSurucuSoyadi_1.setBounds(24, 285, 110, 14);
		contentPane.add(lblSurucuSoyadi_1);
		
		istext = new JTextField();
		istext.setColumns(10);
		istext.setBounds(144, 282, 86, 20);
		contentPane.add(istext);
		
		JButton Listele = new JButton("Listele");
		Listele.setBackground(new Color(255, 140, 0));
		Listele.setBounds(42, 332, 89, 23);
		contentPane.add(Listele);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBackground(new Color(255, 140, 0));
		
		btnKaydet.setBounds(144, 332, 89, 23);
		contentPane.add(btnKaydet);
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.setBackground(new Color(255, 140, 0));
		btnGuncelle.setBounds(42, 375, 89, 23);
		contentPane.add(btnGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setBackground(new Color(255, 140, 0));
		btnSil.setBounds(144, 375, 89, 23);
		contentPane.add(btnSil);
		
		lblSurucuAdi_1 = new JLabel("Personel Id:");
		lblSurucuAdi_1.setForeground(Color.WHITE);
		lblSurucuAdi_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSurucuAdi_1.setBounds(42, 125, 92, 14);
		contentPane.add(lblSurucuAdi_1);
		
		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(144, 122, 86, 20);
		contentPane.add(idtext);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciYonetimSyf kys =new KullaniciYonetimSyf();
				kys.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ertu\\Desktop\\java proje\\geri1.jpg"));
		btnNewButton.setBounds(0, 55, 30, 30);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 595, 56);
		contentPane.add(panel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("icons\\LOGO.png"));
		label_1.setBounds(150, 0, 100, 51);
		panel.add(label_1);
		
		label_2 = new JLabel("ULA\u015EIM");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_2.setBounds(403, 19, 100, 32);
		panel.add(label_2);
		
		label_3 = new JLabel("DA\u011ELI");
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
		label_3.setBounds(260, 13, 152, 30);
		panel.add(label_3);
		
		Listele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelim.setRowCount(0);				
				
				try {
					myConn=DriverManager.getConnection(url);
					//System.out.println("baðlandýnýz");
					
						  myStat = (Statement) myConn.createStatement();
					      myRs = myStat.executeQuery("select * from tblAracPersonelleri");
					      while(myRs.next()) {
					    	  satirlar[0]=myRs.getString("APId");
					    	  satirlar[1]=myRs.getString("BirinciSurucuAd");
					    	  satirlar[2]=myRs.getString("BirinciSurucuSoyad");
					    	  satirlar[3]=myRs.getString("IkinciSurucuAd");
					    	  satirlar[4]=myRs.getString("IkinciSurucuSoyad");
					    	 
					    	  
					    	  modelim.addRow(satirlar);
					      }
				
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				table.setModel(modelim);
			}
		});
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ba,bs,ia,is,sqlsorgu;
				ba=batext.getText();
				bs=bstext.getText();
				ia=iatext.getText();
				is=istext.getText();
		  
					try {
						myConn=DriverManager.getConnection(url);
						  sqlsorgu="INSERT INTO tblAracPersonelleri(BirinciSurucuAd,BirinciSurucuSoyad,IkinciSurucuAd,IkinciSurucuSoyad) VALUES ('"+ ba+"','"+ bs +"', "
						  		+ "'"+ ia+"', "+"'"+is +"')";
						  System.out.println(sqlsorgu);
						  
						  myStat = (Statement) myConn.createStatement();
					      myStat.executeUpdate(sqlsorgu);
					}catch (Exception e2) {
					}
			}
		});
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sqlsorgu;
				id=idtext.getText();
				try {
					myConn=DriverManager.getConnection(url);
					  sqlsorgu="DELETE From tblAracPersonelleri WHERE APId="+id;
					  myStat = (Statement) myConn.createStatement();
					  myStat.executeUpdate(sqlsorgu);
					  
				}catch (Exception e2) {
				}
			}
		});
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ba,bs,ia,is,id,sqlsorgu;
				id=idtext.getText();
				ba=batext.getText();
				bs=bstext.getText();
				ia=iatext.getText();
				is=istext.getText();
				
				try {
					myConn=DriverManager.getConnection(url);
					sqlsorgu="UPDATE tblAracPersonelleri SET BirinciSurucuAd='"+ba+"',"+
							"BirinciSurucuSoyad='"+bs+"',IkinciSurucuAd='"+ia+"',IkinciSurucuSoyad='"+is+"' WHERE APId="+id;
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
				batext.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				bstext.setText((String)( modelim.getValueAt(table.getSelectedRow(),2)));
				iatext.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				istext.setText((String)( modelim.getValueAt(table.getSelectedRow(),4)));
			}
		});
	}
}
