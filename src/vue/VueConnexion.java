package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import controller.C_UserAdmin;
import controller.LevelingLourd;
import controller.UserAdmin;

public class VueConnexion extends JFrame implements ActionListener,KeyListener {
	
	private JLabel lbTitre = new JLabel("Portail Leveling");
	private JLabel lbHead = new JLabel("Seul les admins peuvent se connecter");
	private	JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	
	private JPanel panelCon = new JPanel();
	
	public VueConnexion() {
		this.setTitle("Leveling");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setBounds(500,100, 900, 900);
		this.setLayout(null);
		ImageIcon logo = new ImageIcon ("src/images/logo.png");
		JLabel monLogo = new JLabel(logo);
		monLogo.setBounds(20,20,400,400);
		this.add(monLogo);
		
		
		//construction du panel connexion
		this.lbTitre.setBounds(500,10,400,290);
		lbTitre.setFont( new Font("Bookman Old Style",Font.BOLD, 30));
		lbTitre.setForeground(Color.BLUE);
		this.add(this.lbTitre);
		this.lbHead.setBounds(470, 100, 400, 290);
		lbHead.setFont( new Font("Bookman Old Style",Font.BOLD, 20));
		this.add(this.lbHead);
		
		
		this.panelCon.setBounds(80,500,700,300);
		this.panelCon.setBackground(Color.white);
		this.panelCon.setLayout(new GridLayout(3,2));
		this.panelCon.add(new JLabel("Email"));
		this.panelCon.add(this.txtEmail);
		this.panelCon.add(new JLabel("Mot de passe"));
		this.panelCon.add(this.txtMdp);
		this.panelCon.add(this.btAnnuler);
		this.panelCon.add(this.btSeConnecter);
		this.add(panelCon);
		
		// rednre les 2 buttons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//ajout evement frappe de touche
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}
	
	public void traitement() {
		String email = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		if(email.equals("") || mdp.equals("")) {
			JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs");
		}else {
			// verrification dans la bases de données : table useradmin
			UserAdmin unUserAdmin = C_UserAdmin.selectWhereUserAdmin(email, mdp);
			if(unUserAdmin == null) {
				JOptionPane.showMessageDialog(this,"Veuillez vérifie vos identifiants");
			}else {
				JOptionPane.showMessageDialog(this,"Bienvenue Mr/Mme "+unUserAdmin.getUserPseudo());
				this.txtEmail.setText("");
				this.txtMdp.setText("");
				//ouverture de session
				LevelingLourd.gererVueConnexion(false);
				LevelingLourd.gererVueGenerale(true, unUserAdmin);
				
				//
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource()== this.btSeConnecter) {
			this.traitement();
		}
	}

}
