package vue;

import java.awt.Color;
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

import controller.C_Technicien;
import controller.Orange;
import controller.Technicien;

public class VueConnexion extends JFrame implements ActionListener,KeyListener
{
		private JTextField txtEmail = new JTextField();
		private JPasswordField txtMdp = new JPasswordField();
		private JButton btAnnuler = new JButton("Annuler");
		private JButton btSeConnecter = new JButton("Se Connecter");
	
	private JPanel panelCon = new JPanel();
	
	public VueConnexion() {
		this.setTitle("Gestion des interventions");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground( new Color(20,103,240));
		this.setBounds(200,200, 700, 300);
		this.setLayout(null);
		ImageIcon logo = new ImageIcon ("src/images/Orange_logoS.png");
		JLabel monLogo = new JLabel(logo);
		monLogo.setBounds(20,20,200,200);
		this.add(monLogo);
		
		//construction du panel connexion
		this.panelCon.setBounds(250,40,380,200);
		
		this.panelCon.setBackground(new Color(20,103,240));
		this.panelCon.setLayout(new GridLayout(3,2));
		this.panelCon.add(new JLabel("Email"));
		this.panelCon.add(this.txtEmail);
		this.panelCon.add(new JLabel("MDP"));
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
			// verrification dans la bases de données : table technicien
			Technicien unTechnicien = C_Technicien.selectWhereTechnicien(email, mdp);
			if(unTechnicien == null) {
				JOptionPane.showMessageDialog(this,"Veuillez vérifie vos identifiants");
			}else {
				JOptionPane.showMessageDialog(this,"Bienvenue Mr/Mme "+unTechnicien.getNom());
				this.txtEmail.setText("");
				this.txtMdp.setText("");
				//ouverture de session
				Orange.gererVueConnexion(false);
				Orange.gererVueGenerale(true);
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource()== this.btSeConnecter) {
			this.traitement();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			this.traitement();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
