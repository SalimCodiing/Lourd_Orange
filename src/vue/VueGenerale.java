package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.LevelingLourd;
import controller.UserAdmin;

public class VueGenerale extends JFrame implements ActionListener {
	
	
	private JPanel panelMenu= new JPanel();
	private JButton btUser = new JButton("Gestion User");
	private JButton btAdmin = new JButton("Gestion Admin");
	private JButton btJeu = new JButton("Gestion Jeux");
	private JButton btGroupe = new JButton("Gestion Groupe");
	private JButton btStat = new JButton("Statistiques");
	private JButton BtProfil = new JButton("Mon Profil");
	private JButton btQuitter = new JButton("Quitter");
	
	private static PanelProfil unPanelProfil ;
	private static PanelUser unPanelUser = new PanelUser();
	private static PanelAdmin unPanelAdmin = new PanelAdmin();
	private static PanelJeu unPanelJeu = new PanelJeu();
	private static PanelGroupe unPanelGroupe = new PanelGroupe();
	private static PanelStat unPanelStat = new PanelStat();
	
	public VueGenerale(UserAdmin unUserAdmin) {
		unPanelProfil = new PanelProfil(unUserAdmin);
		this.setTitle("Gestion du site Leveling");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground( new Color(255,255,255));
		this.setBounds(250,10, 1250, 1000);
		this.setLayout(null);
		
		
		//construction du panel menu
		this.panelMenu.setBounds(150,20,1000,40);
		this.panelMenu.setBackground(new Color(255,184,51));
		this.panelMenu.setLayout(new GridLayout(1,5));
		this.panelMenu.add(btUser);
		this.panelMenu.add(btAdmin);
		this.panelMenu.add(btJeu);
		this.panelMenu.add(btGroupe);
		this.panelMenu.add(BtProfil);
		this.panelMenu.add(btStat);
		this.panelMenu.add(btQuitter);
		this.add(this.panelMenu);
		
		// rendre les boutons ecoutables
		this.btQuitter.addActionListener(this);
		this.btUser.addActionListener(this);
		this.btAdmin.addActionListener(this);
		this.btJeu.addActionListener(this);
		this.btStat.addActionListener(this);
		this.BtProfil.addActionListener(this);
		this.btGroupe.addActionListener(this);
		
		//insertions des panneaux dans la fenetre
		this.add(unPanelUser);
		this.add(unPanelAdmin);
		this.add(unPanelProfil);
		this.add(unPanelJeu);
		this.add(unPanelGroupe);
		this.add(unPanelStat);
		
		this.setVisible(false);
	}
	public static void activerPanel(int choix) {
		unPanelProfil.setVisible(false);
		unPanelUser.setVisible(false);
		unPanelAdmin.setVisible(false);
		unPanelJeu.setVisible(false);
		unPanelGroupe.setVisible(false);
		unPanelStat.setVisible(false);
		switch(choix) {
		case 1: unPanelProfil.setVisible(true);break;
		case 2: unPanelUser.setVisible(true);break;
		case 3: unPanelAdmin.setVisible(true);break;
		case 4: unPanelJeu.setVisible(true);break;
		case 5: unPanelGroupe.setVisible(true);break;
		case 6: unPanelStat.setVisible(true);break;
		}
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btQuitter){
			int retour = JOptionPane.showConfirmDialog(this,"Voulez vous vraiment quitter l'application ?",
					"Quitter l'application",JOptionPane.YES_NO_CANCEL_OPTION);
			if(retour == 0) {
				this.dispose();
				LevelingLourd.gererVueConnexion(true);
			}
			
		}
		else if(e.getSource()== this.BtProfil) {
			activerPanel(1);
		}
		else if(e.getSource()== this.btUser) {
			activerPanel(2);
		}
		else if(e.getSource()== this.btAdmin) {
			activerPanel(3);
		}
		else if(e.getSource()== this.btJeu) {
			activerPanel(4);
		}
		else if(e.getSource()== this.btGroupe) {
			activerPanel(5);
		}
		else if(e.getSource()== this.btStat) {
			activerPanel(6);
		}
		
	}

}
