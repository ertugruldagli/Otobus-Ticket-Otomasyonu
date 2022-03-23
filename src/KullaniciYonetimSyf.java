import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class KullaniciYonetimSyf extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciYonetimSyf frame = new KullaniciYonetimSyf();
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
	public KullaniciYonetimSyf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 475);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnk = new JMenu("\u00C7IKI\u015E");
		mnk.setIcon(new ImageIcon("icons\\cikis.png"));
		mnk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Kullanici k=new Kullanici();
				k.setVisible(true);
				setVisible(false);
			}
		});
		menuBar.add(mnk);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("icons\\sat.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				biletSat bs;
				try {
					bs = new biletSat();
					bs.setVisible(true);
					setVisible(false);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(204, 199, 200, 110);
		contentPane.add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ertu\\Desktop\\java proje\\kullan\u0131c\u01311.jpg"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullaniciBilgileri kb;
				try {
					kb = new kullaniciBilgileri();
					kb.setVisible(true);
					setVisible(false );
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		btnNewButton_1.setBounds(263, 140, 75, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnSeferleriGster = new JButton("");
		btnSeferleriGster.setIcon(new ImageIcon("icons\\seferara.png"));
		btnSeferleriGster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seferGoster sg=new seferGoster();
				sg.setVisible(true);
				setVisible(false);
			}
		});
		btnSeferleriGster.setBounds(103, 170, 75, 56);
		contentPane.add(btnSeferleriGster);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("icons\\satilanbilet.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				satýlanBilet sb=new satýlanBilet();
				sb.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(263, 320, 75, 75);
		contentPane.add(btnNewButton_3);
		
		JButton btnMteriler = new JButton("");
		btnMteriler.setIcon(new ImageIcon("icons\\PERSONEL.jpg"));
		btnMteriler.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AracPersonel ap = new AracPersonel ();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		
		btnMteriler.setBounds(103, 253, 75, 56);
		contentPane.add(btnMteriler);
		
		JButton btnAraclar = new JButton("");
		btnAraclar.setIcon(new ImageIcon("icons\\araclar.jpg"));
		btnAraclar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AracBilgileri ab;
				try {
					ab = new AracBilgileri();
					ab.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAraclar.setBounds(414, 246, 75, 63);
		contentPane.add(btnAraclar);
		
		JButton btnDgerSeferBlgi = new JButton("");
		btnDgerSeferBlgi.setIcon(new ImageIcon("icons\\BÝLGÝ.jpg"));
		btnDgerSeferBlgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digerSeferBilgileri dsb =new digerSeferBilgileri();
				dsb.setVisible(true);
				setVisible(false);
			}
		});
		btnDgerSeferBlgi.setBounds(414, 151, 75, 75);
		contentPane.add(btnDgerSeferBlgi);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 605, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons\\LOGO.png"));
		label.setBounds(150, 0, 100, 51);
		panel.add(label);
		
		JLabel label_1 = new JLabel("ULA\u015EIM");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_1.setBounds(403, 19, 100, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("DA\u011ELI");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 44));
		label_2.setBounds(260, 13, 152, 30);
		panel.add(label_2);
	}
}
